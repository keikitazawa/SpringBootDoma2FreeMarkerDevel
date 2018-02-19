<#import "/__wrapper.ftlh" as wrapper>
<#import "/__fielderror.ftlh" as fieldError>

<@wrapper.main>
<div class="">
<!--
<#if errors?has_content>
	<#list errors as e>
		${e.field}:${e.code}:${e.defaultMessage}<br />
	</#list>
</#if>
-->
</div>
<form name="modalRegistForm" method="get" action="${selfUri!}">
	<div class="row">
		<div class="col-md-3">
			<span onClick="alert($('form[name=searchForm]').find('input[name=searchKeyword]').val());">カテゴリー名</span>
		</div>
		<div class="col-md-9">
			<input type="text" name="name" id="name_x" class="form-control" value="${taxonomy.name!}" />
			<@fieldError.main o=errors! field="name" cssclass="text-danger" />
		</div>
		<div class="col-md-3">
			説明
		</div>
		<div class="col-md-9">
			<textarea name="description" id="description_x" class="">${taxonomy.description!}</textarea>
			<@fieldError.main o=errors! field="description" cssclass="text-danger" />
		</div>
		<div class="col-md-3">
			重さ
		</div>
		<div class="col-md-9">
			<input type="text" name="weight" id="weight_x" class="" value="${taxonomy.weight!}" />
			<@fieldError.main o=errors! field="weight" cssclass="text-danger" />
		</div>
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			<!-- キー情報 -->
			<input type="hidden" name="id" value="${taxonomy.id!}" />
			<input type="hidden" name="version" value="${taxonomy.version!0}" />
			<!-- 検索条件 -->
			<input type="hidden" name="searchKeyword" class="form-control" value="${condition.searchKeyword!}" />
			<input type="hidden" name="p" value="${condition.p!}" />
			<input type="hidden" name="c" value="${condition.c!}" />
			<input type="hidden" name="d" value="${condition.d!}" />
	</div>
</form>
</@wrapper.main>