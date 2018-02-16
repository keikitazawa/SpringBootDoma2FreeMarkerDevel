<#ftl strip_whitespace=true>
<#-- 
main macro
	param error :object
	paeam field :fieldName
	param css class :ｃｓｓ class for error message
-->
<#macro main o field cssclass>
	<#if o?has_content>
		<#list o as e>
			<#if e.field == field>
				<div class="${cssclass}">${e.defaultMessage}</div>
			</#if>
		</#list>
	</#if>
</#macro>
