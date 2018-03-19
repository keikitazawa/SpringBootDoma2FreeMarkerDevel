<#import "/__wrapper.ftlh" as wrapper>
<@wrapper.header />
<div class="row">
	<div class="col-md-12">
		<h1>ログイン画面 </h1>
	</div>
	<form name="loginForm" action="${topuri!}/login_auth" method="post">
		<div class="col-md-2">
			UserName 
		</div>
		<div class="col-md-10">
			<input type="text" name="email" value="${username!}" />
		</div>
		<div class="col-md-2">
			Password
		</div>
		<div class="col-md-10">
			<input type="password" name="password" value="" />
		</div>
		<div class="col-md-12">
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			<input type="submit" value="ログイン" />
		</div>
	</form>
</div>
<div class="row">
	<div class="col-md-12">
		default_password [${default_password}]<br />
		demo password [${demo_password}]<br />
	</div>
</div>
<@wrapper.footer />