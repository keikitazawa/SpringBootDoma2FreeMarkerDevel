<#import "/__wrapper.ftlh" as wrapper>
<#import "/__pager.ftlh" as pager>
<#import "/__fielderror.ftlh" as fieldError>
<@wrapper.header />
<div class="row">
	<form name="searchForm" method="get" action="${selfUri!}">
		<div class="col-md-12">
			<h1>${siteTitle}</h1>
		</div>
		<div class="col-md-4 form-group form-group-sm">
			<input type="text" name="searchKeyword" value="${condition.searchKeyword!}" />
			<input type="hidden" name="parentId" value="${condition.parentId!}" />
			<input type="hidden" name="p" value="0" />
			<input type="hidden" name="c" value="${condition.c!}" />
			<input type="hidden" name="d" value="${condition.d!}" />
			<#-- taxonomyadminの検索条件 -->
			<input type="hidden" name="previousParams" value="${condition.previousParams!}" />
<#-- 			<select name="searchParentId">
<#list taxonomies as t>
				<option value="${t.id}"<#if t.id == condition.parentId> selected</#if>>${t.name}</option>
</#list>
			</select> -->
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
<#list terms as r>
	<div>
		<div class="col-md-1">
			<input type="checkbox" name="check" id="check_${r_index}" />
			<input type="hidden" name="parentId" value="${r.parentId!}" />
			<input type="hidden" name="id" value="${r.id!}" />
			<input type="hidden" name="version" value="${r.version!}" />
		</div>
		<div class="col-md-3">
			<span>${r.taxonomy_name!}</span>
		</div>
		<div class="col-md-4">
			<span>${r.name!}</span>
		</div>
		<div class="col-md-1">
			<span>${r.weight!}</span>
		</div>
		<div class="col-md-3">
			<button type="button" class="modifyData">編集</button>
			<button type="button" class="removeData">削除</button>
		</div>
	</div>
</#list>
</div>
<div class="row">
	<div class="col-md-9">
	</div>
	<div class="col-md-3">
		<input type="hidden" name="parentId" value="${condition.parentId!}" />
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		<button class="addData">追加</button>
	</div>
</div>
<div class="row">
<!-- ${pager_pageNumber} / ${pager_totalCount} / ${pager_limit} / ${pager_width} / ${pager_buffer} -->
<@pager.main pageNumber=pager_pageNumber totalCount=pager_totalCount limit=pager_limit width=pager_width buffer=pager_buffer />
</div>
<div class="row">
	<button type="button" onClick="location.href='/admin/taxonomy?${condition.previousParams!}';">&lt;&lt; 戻る</button>
	<a href="/logout">ログアウト</a><br />
	<br />
	${role!}<br />
</div>
<form name="procForm" method="post" action="${selfUri!}">
	<#-- 表示対象 -->
	<input type="hidden" name="id" value="" />
	<input type="hidden" name="version" value="" />
	<input type="hidden" name="parentId" value="${condition.parentId!}" />
	<#-- taxonomyadminの検索条件 -->
	<input type="hidden" name="previousParams" value="${condition.previousParams!}" />
	<#-- 検索条件 -->
	<input type="hidden" name="searchKeyword" value="${condition.searchKeyword!}" />
	<input type="hidden" name="p" value="${condition.p!}" />
	<input type="hidden" name="c" value="${condition.c!}" />
	<input type="hidden" name="d" value="${condition.d!}" />
	<#-- csrf for detail window -->
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
</form>
<@wrapper.footer />