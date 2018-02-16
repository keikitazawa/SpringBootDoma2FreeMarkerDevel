package org.fslabs.springbootdoma2freemarker.core.service;

import java.util.Objects;

import org.fslabs.springbootdoma2freemarker.core.dao.AuthenticationDao;
import org.fslabs.springbootdoma2freemarker.core.entity.AuthenticationEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * Spring-Securityの認証処理
 * @author kitaz
 *
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	AuthenticationDao userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		 
		if (StringUtils.isEmpty(email)) {
			throw new UsernameNotFoundException("!!! User Not Found... !!!");
		}
		AuthenticationEntity ret = userRepository.findOneByEmailAndDeletedIsNull(email);
		if (Objects.isNull(ret)) {
			throw new UsernameNotFoundException("!!! User Not Found : " + email + " !!!");
		}
		return ret;
	}
}