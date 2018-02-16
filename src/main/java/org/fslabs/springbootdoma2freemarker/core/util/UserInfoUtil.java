/**
 * 
 */
package org.fslabs.springbootdoma2freemarker.core.util;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @author kitaz
 *　spring-securityの実装を利用してアカウント情報を取得する 
 */
public class UserInfoUtil {
	
	public String getUserName() {
		String userName = "";
		
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			userName = ((UserDetails)principal).getUsername();
		} else {
			userName = principal.toString();
		}
		return userName;
	}
	
	public String getUserRole() {
		String userRole = "";
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			Collection<? extends GrantedAuthority> roleList =  ((UserDetails)principal).getAuthorities();
			
			userRole = roleList.toString();
		}
		
		return userRole;
	}
}
