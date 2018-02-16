<#import "/__wrapper.ftlh" as wrapper>
<#import "/__pager.ftlh" as pager>
<#import "/__fielderror.ftlh" as fieldError>

<@wrapper.main>
<div class="row">
	<form name="searchForm" method="get" action="${selfUri!}">
		<div class="col-md-12">
			<h1>${siteTitle}</h1>
		</div>
		<div class="col-md-4 form-group form-group-sm">
				<input type="text" name="searchKeyword" class="form-control" value="${condition.searchKeyword!}" />
				<input type="hidden" name="p" value="0" />
				<input type="hidden" name="c" value="${condition.c!}" />
				<input type="hidden" name="d" value="${condition.d!}" />
				<!--<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />-->
		</div>
		<div class="col-md-8">
		</div>
	</form>
</div>
<div class="row">
</div>
<div class="row">
	<div class="col-md-1">
		選択<br />
	</div>
	<div class="col-md-3">
		名称
	</div>
	<div class="col-md-4">
		説明
	</div>
	<div class="col-md-1">
		重さ
	</div>
	<div class="col-md-3">
		操作
	</div>
</div>
<div class="row">
<!--
<#if errors?has_content>
	<#list errors as e>
		${e.field}:${e.code}:${e.defaultMessage}<br />
	</#list>
</#if>
-->
</div>
<div class="row">
<#list taxonomyHeaders as r>
	<div>
		<div class="col-md-1">
			<input type="checkbox" name="check" id="check_${r_index}" />
			<input type="hidden" name="currentId" value="${r.id!}" />
		</div>
		<div class="col-md-3">
			<span>${r.name!}</span>
		</div>
		<div class="col-md-4">
			<span>${r.description!}</span>
		</div>
		<div class="col-md-1">
			<span>${r.weight!}</span>
		</div>
		<div class="col-md-3">
			<button type="button" class="modifyData">編集</button>
			ターム
			<button type="button" class="removeData">削除</button>
		</div>
	</div>
</#list>
</div>
<div class="row">
	<form name="registForm" method="post" action="${selfUri!}/regist">
		<div class="col-md-1">
			&nbsp;
		</div>
		<div class="col-md-3">
			<input type="text" name="name" id="name_x" class="form-control" value="${condition.name!}" />
			<@fieldError.main o=errors! field="name" cssclass="text-danger" />
		</div>
		<div class="col-md-4">
			<textarea name="description" id="description_x" class="form-control">${condition.description!}</textarea>
			<@fieldError.main o=errors! field="description" cssclass="text-danger" />
		</div>
		<div class="col-md-1">
			<input type="text" name="weight" id="weight_x" class="form-control" value="${condition.weight!}" />
			<@fieldError.main o=errors! field="weight" cssclass="text-danger" />
		</div>
		<div class="col-md-3">
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			<button onClick="submit();">追加</button>
		</div>
		<!-- 検索条件 -->
		<input type="hidden" name="searchKeyword" class="form-control" value="${condition.searchKeyword!}" />
		<input type="hidden" name="p" value="${condition.p!}" />
		<input type="hidden" name="c" value="${condition.c!}" />
		<input type="hidden" name="d" value="${condition.d!}" />
	</form>
</div>
<div class="row">
<!-- ${pager_pageNumber} / ${pager_totalCount} / ${pager_limit} / ${pager_width} / ${pager_buffer} -->
<@pager.main pageNumber=pager_pageNumber totalCount=pager_totalCount limit=pager_limit width=pager_width buffer=pager_buffer />
</div>
<div class="row">
	<a href="/logout">ログアウト</a><br />
	<br />
	<form name="removeForm" id="RemoveForm" method="post" action="${selfUri!}/remove">
		<!-- 削除条件 -->
		<input type="hidden" name="id" value="" />
		<!-- 検索条件 -->
		<input type="hidden" name="searchKeyword" class="form-control" value="${condition.searchKeyword!}" />
		<input type="hidden" name="p" value="${condition.p!}" />
		<input type="hidden" name="c" value="${condition.c!}" />
		<input type="hidden" name="d" value="${condition.d!}" />
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	</form>
</div>
</@wrapper.main>