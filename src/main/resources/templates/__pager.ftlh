<#ftl strip_whitespace=true>
<#-- 
main macro
	param pageNumber：表示ページ数（０スタート）
	param totalCount：検索結果の件数
	param limit：１ページの表示件数
	param width：ページャーが表示するページ数
	param buffer：前方ページの表示ページ数
-->
<#macro main pageNumber totalCount limit width buffer pagerId="DefaultPager">

<#-- ページ総数 -->
<#assign totalPage = (totalCount / limit)?ceiling>
<#-- 最低でも１ページ -->
<#if totalPage <= 0>
	<#assign totalPage = 1>
</#if>

<#-- 表示ページ番号:0スタート -->
<#assign beginPageLink = 0>
<#-- リンクページ数 -->
<#assign pageLinkWidth = totalPage>

<#-- 表示ページが合計ページ数を超える場合は表示をwidthまでに制限 -->
<#if (totalPage > width)>
	<#-- ページリンクはwidthまで -->
	<#assign pageLinkWidth = width>

	<#-- 前方ページが２ページ目以降になる場合 -->
	<#if pageNumber gt (buffer +1)>
		<#assign beginPageLink = pageNumber - buffer>
	</#if>
	<#-- ページネーションが最終ページを表示する場合 -->
	<#if (beginPageLink + width) gt totalPage>
		<#assign beginPageLink = totalPage - width +1>
	</#if>
</#if>

<#assign goToStartDisableClass = "">
<#assign goToEndDisableClass = "">
<#assign goToPreviousPage = "">
<#assign goToNextPage = "">
<#assign activeClass = "active">
<#if pageNumber == 0>
	<#assign goToStartDisableClass = "disabled ">
	<#assign goToPreviousPage = "disabled ">
</#if>
<#if pageNumber gte (totalPage -1)>
	<#assign goToEndDisableClass = "disabled ">
	<#assign goToNextPage = "disabled ">
</#if>


<#--  ページネーション表示部分 -->
<#if totalPage gt 0>
<div class="text-center">
	<ul id="${pagerId}" class="pagination">
		<li class="${goToStartDisableClass}changePage"><a href="#"><input type="hidden" class="page" value="0" />&laquo;</a></li>
		<li class="${goToPreviousPage}changePage"><a href="#"><input type="hidden" class="page" value="${pageNumber -1}" />&lt;</a></li>
<#list beginPageLink..(beginPageLink + pageLinkWidth -1) as page>
		<li class="changePage<#if page == pageNumber> active</#if>"><input type="hidden" class="page" value="${page}" /><a href="#">${page +1}</a></li>
</#list>
		<li class="${goToNextPage}changePage"><a href="#"><input type="hidden" class="page" value="${pageNumber +1}" />&gt;</a></li>
		<li class="${goToEndDisableClass}changePage"><a href="#"><input type="hidden" class="page" value="${totalPage -1}" />&raquo;</a></li>
	</ul>
	<!-- pagenumber=${pageNumber!}, resultCount=${totalCount!}, limit=${limit!}, width=${width!}, buffer=${buffer!} -->
</div>
</#if>
</#macro>
