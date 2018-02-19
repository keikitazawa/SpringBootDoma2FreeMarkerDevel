/**
 * 
 */
$(function() {
	// Pager
	var defaultPager = new Pager($("#DefaultPager"), $("form[name=searchForm]"));
	
	var site = new TaxonomyAdmin();
	// 削除処理
	$(".removeData").click(
		function(){
			var targetId = $(this).parent().parent().find("input[name=currentId]").val();
			site.remove(targetId);
		}
	);
	// 追加処理
	$(".addData").click(
		function(){
			var targetId = "";
			site.edit(targetId);
		}
	);
	// 編集処理
	$(".modifyData").click(
		function(){
			var targetId = $(this).parent().parent().find("input[name=currentId]").val();
			site.edit(targetId);
		}
	);
});

TaxonomyAdmin = function(){};
/**
 * 削除処理の実行
 * @returns
 */
TaxonomyAdmin.prototype.remove = function(id){
	$("#RemoveForm").find("input[name=id]").val(id);
	$("#RemoveForm").submit();
};
TaxonomyAdmin.prototype.edit = function(id){
	$.ajax({
		async: false,
		cache: false,
		dataType: "html",
		type: "POST",
		url: "/admin/taxonomy_detail",
		data: {
			"_csrf" : $("form[name=detailForm] input[name=_csrf]").val(),
			"id"    : id,
			"p"     : $("form[name=detailForm] input[name=p]").val(),
			"c"     : $("form[name=detailForm] input[name=c]").val(),
			"d"     : $("form[name=detailForm] input[name=d]").val(),
			"searchKeyword" : $("form[name=detailForm] input[name=searchKeyword]").val()
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
				var modalSite = new TaxonomyAdminDetail();
				modalSite.save();
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
