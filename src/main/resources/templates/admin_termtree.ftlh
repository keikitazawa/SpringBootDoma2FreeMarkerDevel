<#import "/__wrapper.ftlh" as wrapper>
<#import "/__pager.ftlh" as pager>
<@wrapper.header />
<div class="row">
	<form name="searchForm" method="post" action="${selfUri!}">
		<div class="col-md-12">
			<h1>${siteTitle}</h1>
		</div>
		<div class="col-md-4 form-group form-group-sm">
				<input type="text" name="keyword" class="form-control" value="${condition.keyword!}" />
				<input type="hidden" name="p" class="form-control" value="" />
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		</div>
		<div class="col-md-8">
		</div>
	</form>
</div>
<div class="row">
	<div class="col-md-1">
		選択<br />
	</div>
	<div class="col-md-3">
		カテゴリ
	</div>
	<div class="col-md-4">
		名称
	</div>
	<div class="col-md-1">
		重さ
	</div>
	<div class="col-md-3">
		操作
	</div>
</div>
<div class="row">
<#list taxonomies as r>
	<div>
		<div class="col-md-1">
			<input type="checkbox" name="check" id="check_${r_index}" />
			<input type="hidden" name="parentId" value="${r.parent_id!}" />
			<input type="hidden" name="currentId" value="${r.id!}" />
		</div>
		<div class="col-md-3">
			<span>${r.taxonomyName!}</span>
		</div>
		<div class="col-md-4">
			<span>${r.name!}</span>
		</div>
		<div class="col-md-1">
			<span>${r.weight!}</span>
		</div>
		<div class="col-md-3">
			<button type="button" class="parentTerm">選択</button>
		</div>
	</div>
</#list>
</div>
<div class="row">
	<form name="selectTermForm" method="post" action="${selfUri!}/select">
		<input type="hidden" name="parentId" value="" />
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	</form>
	<form name="registForm" method="post" action="${selfUri!}/regist">
		<div class="col-md-1">
			&nbsp;
		</div>
		<div class="col-md-3">
			<input type="text" name="name" id="name_x" class="form-control" value="" />
		</div>
		<div class="col-md-4">
			<textarea name="description" id="description_x" class="form-control"></textarea>
		</div>
		<div class="col-md-1">
			<input type="text" name="weight" id="weight_x" class="form-control" value="" />
		</div>
		<div class="col-md-3">
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			<button onClick="submit();">追加</button>
		</div>
	</form>
</div>
<#-- sample pagenation -->
<div class="row">
<!-- ${pager_pageNumber} / ${pager_totalCount} / ${pager_limit} / ${pager_width} / ${pager_buffer} -->
<@pager.main pageNumber=pager_pageNumber totalCount=pager_totalCount limit=pager_limit width=pager_width buffer=pager_buffer />
</div>
<div class="row">
	<a href="/logout">ログアウト</a><br />
	<br />
	${role!}<br />
</div>
<@wrapper.footer />

