<#import "/__wrapper.ftlh" as wrapper>
<@wrapper.main>
<div class="row">
	<div class="col-md-12">
		<h1>テストページ </h1>
	</div>
	<div class="col-md-12">
		<a href="/admin/taxonomy">タクソノミー管理</a>
	</div>
</div>
<div class="row">
	<div class="col-md-12">
		<a href="/login">ログイン</a>
	</div>
</div>
<div class="row">
	<div class="col-md-12">
		テスト表示<br />
		[${teststring}]<br />
	</div>
</div>
<div class="row">
	<div class="col-md-12">
		<form action="/login" method="post">
			<input type="submit" />
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		</form>
		UUID:${uuid}<br />
	</div>
</div>
</@wrapper.main>