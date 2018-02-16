/**
 * modalテンプレ
 */
$(document).ready(
	function(){
		// ボタン・クリック時の処理
		$("#ModalButton").click(
			function(){
				$.ajax({
					async: false,
					cache: false,
					dataType: "html",
					type: "POST",
					url: "/admin/taxonomygroup/html",
					data: {
						"_csrf" : $("#ModalForm input[name=_csrf]").val()
					}
				})
				.done(
					function(data, textStatus, jqXHR){
						openDialog(data);
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
			}
		);
	}
);
/**
 * htmlをモーダルダイアログ領域に出力
 */
function openDialog(data){
	$("#SearchTaxonomyGroup").html(data);
	$("#SearchTaxonomyGroup").dialog({
		modal : true,
		width : 500,
		height : 500,
		buttons:{
			"保存": function(){
				alert("セーブなう");
				relayParam("セーブなぅ");
				$(this).dialog("close");
		    },
		    "閉じる": function(){
				$(this).dialog("close");
		    }
		}
	});
}
/**
 * データを元画面に渡す
 */
function relayParam(result){
	$("#ModalResult").val(result);
}
