<#import "/__wrapper.ftlh" as wrapper>
<#import "/__pager.ftlh" as pager>
<#import "/__fielderror.ftlh" as fieldError>

<@wrapper.header />

<div class="row">
<!--
<#if errors?has_content>
	<#list errors as e>
		${e.field!}:${e.code!}:${e.defaultMessage!}<br />
	</#list>
</#if>
-->
</div>
<div class="row">
	<div class="page-header">
		<h1>${siteTitle}</h1>
	</div>
</div>
<div class="row">
	<form name="searchForm" method="get" action="${selfUri!}">
		<div class="col-md-4 form-group form-group-sm">
			<input type="text" name="searchKeyword" class="form-control" value="${condition.searchKeyword!}" />
			<input type="hidden" name="p" value="0" />
			<input type="hidden" name="c" value="${condition.c!}" />
			<input type="hidden" name="d" value="${condition.d!}" />
		</div>
		<div class="col-md-8">
		</div>
	</form>
</div>
<div class="row table-responsive">
	<table class="table table-striped table-condensed">
	<thead>
		<tr>
			<th>名称</th>
			<th>説明</th>
			<th>重さ</th>
			<th>操作</th>
		</tr>
	</thead>
	<tbody>
<#list taxonomies as r>
		<tr>
			<td>${r.name!}</td>
			<td>${r.description!}</td>
			<td>${r.weight!}</td>
			<td>
				<input type="hidden" name="id" value="${r.id!}" />
				<input type="hidden" name="version" value="${r.version!}" />
				<!-- data-toggle等があるとメソッドでダイアログを動かせない -->
				<button type="button" class="btn btn-sm btn-primary modifyData">編集</button>
				<button type="button" class="btn btn-sm btn-primary listTerm">ターム</button>
				<button type="button" class="btn btn-sm btn-primary removeData">削除</button>
			</td>
		</tr>
</#list>
	</tbody>
	</table>
</div>
<div class="row">
	<div class="col-md-9">
	</div>
	<div class="col-md-3">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		<button class="btn btn-primary addData">追加</button>
	</div>
</div>
<div class="row">
<!-- ${pager_pageNumber} / ${pager_totalCount} / ${pager_limit} / ${pager_width} / ${pager_buffer} -->
<@pager.main pageNumber=pager_pageNumber totalCount=pager_totalCount limit=pager_limit width=pager_width buffer=pager_buffer />
</div>
<div class="row">
	<a href="/logout">ログアウト</a><br />
</div>
<#-- データ操作系処理のフォーム -->
<form name="procForm" method="post" action="${selfUri!}">
	<#-- 表示対象 -->
	<input type="hidden" name="id" value="" />
	<input type="hidden" name="version" value="" />
	<#-- 検索条件 -->
	<input type="hidden" name="searchKeyword" value="${condition.searchKeyword!}" />
	<input type="hidden" name="p" value="${condition.p!}" />
	<input type="hidden" name="c" value="${condition.c!}" />
	<input type="hidden" name="d" value="${condition.d!}" />
	<#-- csrf for detail window -->
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
</form>
<#-- term管理 -->
<form name="nextForm" method="get" action="${termUri!}">
	<#-- 表示対象 -->
	<input type="hidden" name="parentId" />
	<#-- 検索条件 -->
	<input type="hidden" name="previousParams" />
	<#-- csrf for detail window
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
	 -->
</form>

<@wrapper.footer />