<#ftl strip_whitespace=true>
<#macro main>
<#-- @ftlvariable name="_csrf" type="org.springframework.security.web.csrf.CsrfToken" -->
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>${siteTitle}</title>
<#list csss as css>
	<link rel="stylesheet" href="${css}" />
</#list>
<#list jss as js>
	<script type="text/javascript" src="${js}"></script>
</#list>
</head>
<body>
<div class="container">
<#if exception?has_content>
<div class="row">
	${exception}
</div>
</#if>

<#nested />

<!-- freemarker version: ${.version} -->
</div>
<!-- for Dialog -->
<div id="DialogArea" class="" style="display: none;"></div>
</body>
</html>
</#macro>
