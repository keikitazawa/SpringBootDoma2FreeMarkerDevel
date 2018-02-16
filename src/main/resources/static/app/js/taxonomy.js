/**
 * 
 */
$(function() {
	// Pager
	var defaultPager = new Pager();
	
	var site = new TaxonomyAdmin();
	// 削除処理
	$(".removeData").click(
		function(){
			var targetId = $(this).parent().parent().find("input[name=currentId]").val();
			site.remove(targetId);
		}
	);
	
	// 編集処理
	$(".modifyData").click(
		function(){
			var position = $(this).parent().parent().find("input[name=position]").val();
			site.edit(position);
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
	
};
