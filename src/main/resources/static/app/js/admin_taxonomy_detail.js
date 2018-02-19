/**
 * 
 */
$(function() {
	var modalSite = new TaxonomyAdminDetail();
	
	
});

TaxonomyAdminDetail = function(){};
/**
 * 追加処理の実行
 * @returns
 */
TaxonomyAdminDetail.prototype.ready = function(id){
//	$("#RemoveForm").find("input[name=id]").val(id);
//	$("#RemoveForm").submit();
};
TaxonomyAdminDetail.prototype.save = function(){
	$.ajax({
		async: false,
		cache: false,
		dataType: "json",
		type: "POST",
		url: "/admin/taxonomy_detail/regist",
		data: $("form[name=modalRegistForm]").serialize()
	})
	.done(
		function(data, textStatus, jqXHR){
//			alert(data);
			if (data == undefined){
				alert("null");
			}else {
				if (data.result == 0){
					location.reload();
				} else{
					for(var i = 0; i < data.errors.length; i++){
						alert(data.errors[i].field + ":" + data.errors[i].defaultMessage);
					}
				}
			}
		}
	)
	.fail(
		function(jqXHR, textStatus, errorThrown){
			alert(jqXHR.status + "\n" + textStatus + "\n" + errorThrown);
		}
	)
	.always(
		function(jqXHR, textStatus){
			
		}
	);
};
