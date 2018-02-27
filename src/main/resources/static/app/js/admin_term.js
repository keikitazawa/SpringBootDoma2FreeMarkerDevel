/**
 * 
 */
$(function() {
	// Pager
	var defaultPager = new Pager($("#DefaultPager"), $("form[name=searchForm]"));
	
	var site = new TermAdmin();
	// 削除処理
	$(".removeData").click(
		function(){
			var id = $(this).parent().parent().find("input[name=id]").val();
			var version = $(this).parent().parent().find("input[name=version]").val();
			site.remove(id, version);
		}
	);
	// 追加画面の表示
	$(".addData").click(
		function(){
			var id = "";
			var parentId = $(this).parent().find("input[name=parentId]").val();
			site.edit(id, parentId);		
		}
	);
	// 編集画面の表示
	$(".modifyData").click(
		function(){
			var id = $(this).parent().parent().find("input[name=id]").val();
			var parentId = $(this).parent().parent().find("input[name=parentId]").val();
			site.edit(id, parentId);
		}
	);
	
	// 戻る
	$(".goToPrevions").click(
		function(){
			
		}
	);
});

TermAdmin = function(){};
/**
 * 削除処理の実行
 * @returns
 */
TermAdmin.prototype.remove = function(id, version){
	$("form[name=procForm]").find("input[name=id]").val(id);
	$("form[name=procForm]").find("input[name=version]").val(version);
	$("form[name=procForm]").prop("action", "/admin/term/remove");
	$("form[name=procForm]").submit();
};
// 追加・編集ダイアログの出力
TermAdmin.prototype.edit = function(id, parentId){
	// idをmodal出力フォームに設定
	$("form[name=procForm]").find("input[name=id]").val(id);
	$("form[name=procForm]").find("input[name=parentId]").val(parentId);
	$.ajax({
		async: false,
		cache: false,
		dataType: "html",
		type: "POST",
		url: "/admin/term_detail",
		data: $("form[name=procForm]").serialize()
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
};
/**
 * htmlをモーダルダイアログ領域に出力
 */
function openDialog(data){
	$("#DialogArea").html(data);
	$("#DialogArea").dialog({
		height: 400,
		width: 700,
		modal : true,
		buttons:{
			"保存": function(){
				// submit処理をajaxで行い、正常終了の場合は画面全体の更新
//				$("#DialogArea form[name=modalRegistForm]").submit();
				var modalSite = new TermAdminDetail();
				modalSite.save();
		    },
		    "閉じる": function(){
				$(this).dialog("close");
		    }
		}
	});
};
