/**
 * 
 */
$(function() {
	var modalSite = new TaxonomyAdminDetail();
	modalSite.ready();
});


TaxonomyAdminDetail = function(){};
/**
 * 追加処理の実行
 * @returns
 */
TaxonomyAdminDetail.prototype.ready = function(){
	var root = this;
	$(".btnClose").click(
		function(){
			$("#DialogArea").modal("hide");
		}
	);
	$(".btnSave").click(
		function(){
			root.save();
		}
	);
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
	// TODO 正常・異常の処理を統一する
	.done(
		function(data, textStatus, jqXHR){
			// ErrorListを空にする
			$("#ErrorList li").not("#ErrorList-1").remove();
			
			if (data == undefined){
				alert("null");
			}else {
				if (data.result == 0){
					location.href = location.href;
				} else{
					for(var i = 0; i < data.errors.length; i++){
//						alert(data.errors[i].field + ":" + data.errors[i].defaultMessage);
						$("#ErrorList li#ErrorList-1")
							.clone(true)
							.insertAfter("#ErrorList li#ErrorList-1")
							.prop("id", "ErrorList" + i)
							.text(data.errors[i].field + ":" + data.errors[i].defaultMessage)
							.show();
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
