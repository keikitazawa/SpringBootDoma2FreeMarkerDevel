// pagerId default : defaultPager
// TODO Comment作成
var Pager = function(pager, searchForm){
//	this.pagerObject = $("#DefaultPager");
//	this.searchForm = $("form[name=searchForm]");
	this.pagerObject = pager;
	this.searchForm = searchForm;
	this.ready(this.pagerObject, this.searchForm);
}

Pager.prototype.ready = function(pager, form) {
	this.pagerObject.find(".changePage").not(".active").not(".disabled").find("a").click(
		function(){
			var p = $(this).parent().find("input.page").val();
			$(searchForm).find("input[name=p]").val(p);
			form.submit();
		}
	);
};
