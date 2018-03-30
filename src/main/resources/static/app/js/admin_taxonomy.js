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
			var id = $(this).parent().parent().find("input[name=id]").val();
			var version = $(this).parent().parent().find("input[name=version]").val();
			site.remove(id, version);
		}
	);
	// 追加画面の表示
	$(".addData").click(
		function(){
			var id = "";
			site.edit(id);
			// オーバーレイクリックでモーダル終了をさせない
			$("#DialogArea").modal({backdrop:"static"})
			$("#DialogArea").modal("show");
		}
	);
	// 編集画面の表示
	$(".modifyData").click( 
		function(){
			var id = $(this).parent().parent().find("input[name=id]").val();
			site.edit(id);
			// オーバーレイクリックでモーダル終了をさせない
			$("#DialogArea").modal({backdrop:"static"})
			$("#DialogArea").modal("show");
		}
	);
	
	// タームの表示
	$(".listTerm").click(
		function(){
			var id = $(this).parent().parent().find("input[name=id]").val();
			site.list(id);
		}	
	);
});

TaxonomyAdmin = function(){};
/**
 * 削除処理の実行
 * @returns
 */
TaxonomyAdmin.prototype.remove = function(id, version){
	$("form[name=procForm]").find("input[name=id]").val(id);
	$("form[name=procForm]").find("input[name=version]").val(version);
	$("form[name=procForm]").prop("action", "/admin/taxonomy/remove");
	$("form[name=procForm]").submit();
};
// 追加・編集ダイアログの出力
TaxonomyAdmin.prototype.edit = function(id){
	// idをmodal出力フォームに設定
	$("form[name=procForm]").find("input[name=id]").val(id);
	$("form[name=procForm]").find("input[name=version]").val(0);
	$.ajax({
		async: false,
		cache: false,
		dataType: "html",
		type: "POST",
		url: "/admin/taxonomy_detail",
		data: $("form[name=procForm]").serialize()
	})
	.done(
		function(data, textStatus, jqXHR){
			$("#DialogArea").html(data);
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
TaxonomyAdmin.prototype.list = function(id){
	var qs = new Url(location.href);
	$("form[name=nextForm]").find("input[name=parentId]").val(id);
	$("form[name=nextForm]").find("input[name=previousParams]").val(qs.getQueryString());
	$("form[name=nextForm]").submit();
};

