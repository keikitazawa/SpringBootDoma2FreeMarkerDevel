/**
 * 
 */
$(function() {
	var modalSite = new TermAdminDetail();
	modalSite.ready();
});

TermAdminDetail = function(){};
/**
 * 追加処理の実行
 * @returns
 */
TermAdminDetail.prototype.ready = function(){
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
TermAdminDetail.prototype.save = function(){
	$.ajax({
		async: false,
		cache: false,
		dataType: "json",
		type: "POST",
		url: "/admin/term_detail/regist",
		data: $("form[name=modalRegistForm]").serialize()
	})
	// TODO 正常・異常の処理を統一する
	.done(
			function(data, textStatus, jqXHR){
				// ErrorListを空にする
				$("#ErrorList").hide();
				$("#ErrorList p").not("#ErrorList-1").remove();
				// エラー表示を空にする
				$("p.text-danger").remove();
				$("div.has-error").removeClass("has-error");
				if (data == undefined){
					alert("null");
				}else {
					if (data.result == 0){
						location.href = location.href;
					} else{
						for(var i = 0; i < data.errors.length; i++){
							$("#ErrorList").show();
							$("#ErrorList #ErrorList-1")
								.clone(true)
								.insertAfter("#ErrorList #ErrorList-1")
								.prop("id", "ErrorList" + i)
								.text(data.errors[i].field + ":" + data.errors[i].defaultMessage)
								.show();
							$("[name=" + data.errors[i].field + "]")
								.parent()
								.append('<p class="text-danger">' + data.errors[i].defaultMessage + '</p>');
							$("[name=" + data.errors[i].field + "]")
								.parent()
								.parent()
								.addClass("has-error");
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
