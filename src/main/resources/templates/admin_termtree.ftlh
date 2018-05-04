<#import "/__wrapper.ftlh" as wrapper>
<#import "/__pager.ftlh" as pager>
<#import "/__fielderror.ftlh" as fieldError>

<@wrapper.header />

<div class="row">
	<div class="page-header">
		<h1>${siteTitle}</h1>
	</div>
</div>
<div class="row">
	<form name="changeForm" method="get" action="${selfUri!}">
		<input type="hidden" name="targetId" value="" />
		<input type="hidden" name="previousParams" value="${condition.previousParams!}" />
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
	</form>
</div>
<div class="row table-responsive">
	<table class="table table-striped table-condensed">
	<thead>
		<tr>
			<th>名称</th>
			<th>階層</th>
			<th>操作</th>
		</tr>
	</thead>
	<tbody>
<#list termTrees as r>
		<tr>
			<td>${r.name!}</td>
			<td>${r.level!}</td>
			<td>
				<input type="hidden" name="id" value="${r.id!}" />
				<input type="hidden" name="version" value="${r.version!}" />
				<!-- data-toggle等があるとメソッドでダイアログを動かせない -->
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
	<a href="/logout">ログアウト</a><br />
</div>

<@wrapper.footer />

