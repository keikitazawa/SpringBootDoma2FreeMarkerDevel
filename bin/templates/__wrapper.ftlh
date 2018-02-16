<#ftl strip_whitespace=true>
<#macro main>
<#-- @ftlvariable name="_csrf" type="org.springframework.security.web.csrf.CsrfToken" -->
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>${siteTitle}</title>
	<link rel="stylesheet" href="/bootstrap/css/bootstrap.min.css" />
<#list csss as css>
	<link rel="stylesheet" href="${css}" />
</#list>
	<script type="text/javascript" src="/common/js/jquery-3.3.1.min.js"></script>
	<script type="text/javascript" src="/bootstrap/js/bootstrap.min.js"></script>
<#list jss as js>
	<script type="text/javascript" src="${js}"></script>
</#list>
</head>
<body>
<div class="container">

<#nested />

<!-- freemarker version: ${.version} -->
</div>
</body>
</html>
</#macro>
