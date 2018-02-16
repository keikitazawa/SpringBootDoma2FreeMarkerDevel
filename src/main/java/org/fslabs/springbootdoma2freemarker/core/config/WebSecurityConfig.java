package org.fslabs.springbootdoma2freemarker.core.config;

import org.fslabs.springbootdoma2freemarker.core.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	private UserDetailsServiceImpl userDetailsService;
	
	/**
	 * UserDetailsServiceの実装を呼び出す
	 * @param userDetailsService
	 */
    @Autowired
    public void setUserDetailsService(UserDetailsServiceImpl userDetailsService){
        this.userDetailsService = userDetailsService;
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	
		// 全アクセス許可・認証を要求するパス
    	http
    		.authorizeRequests()
	    		.antMatchers("/", "/index", "/console").permitAll()
	    		.anyRequest().fullyAuthenticated()
        ;

        // ログインフォームの規定
        http
        	.formLogin()
		    	.loginPage("/login")
		    	.loginProcessingUrl("/login_auth")
		    	.defaultSuccessUrl("/menu")
		    	.failureUrl("/login?loginError=1")
		        .usernameParameter("email")
	            .passwordParameter("password")
	            .permitAll()
        ;
	    
	    // 403エラー
	    http
	    	.exceptionHandling()
	    		.accessDeniedPage("/access-denied.html")
        ;
	    
	    // ログアウト
        http
        	.logout()
	        	.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
	        	.logoutSuccessUrl("/")
	            .deleteCookies("JSESSIONID")
	            .invalidateHttpSession(true)
	            .permitAll()
        ;
    }
    
    /**
     * spring-security
	 * CSRFの判定を行わない
	 **/
    @Override
	public void configure(WebSecurity web) throws Exception {
    	web.ignoring().antMatchers("/app/**", "/bootstrap/**", "/common/**", "/*.html", "/console/**");
    }
    
    /**
     * 認証
     * @author kitaz
     *
     */
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
//       		 .inMemoryAuthentication()
//       		 .withUser("a@a.com").password("default_password").roles("USER")
        	.authenticationProvider(createAuthProvider())
        ;
    }
    
    /**
     * 認証プロバイダーの設定
     * @return
     */
    private AuthenticationProvider createAuthProvider() {
    	DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
    	
    	authProvider.setUserDetailsService(this.userDetailsService);
    	authProvider.setPasswordEncoder(new BCryptPasswordEncoder());
    	
    	return authProvider;
    }
}
