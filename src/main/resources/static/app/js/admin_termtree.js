/**
 * 
 */
$(function() {
	var site = new TaxonomyAdmin();
	
	
	// 親選択
	$(".parentTerm").click(
		function(){
			var targetId = $(this).parent().parent().find("input[name=currentId]").val();
			site.searchTerms(targetId);
		}
	);
});

TaxonomyAdmin = function(){};
/**
 * 削除処理の実行
 * @returns
 */
TaxonomyAdmin.prototype.searchTerms = function(id){
	$("form[name=selectTermForm]").find("input[name=parentId]").val(id);
	$("form[name=selectTermForm]").submit();
};

