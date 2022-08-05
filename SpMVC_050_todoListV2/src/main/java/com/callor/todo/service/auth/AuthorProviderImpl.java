package com.callor.todo.service.auth;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.callor.todo.model.UserVO;

@Service("authenticationProvider")
public class AuthorProviderImpl implements AuthenticationProvider {

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		
		// getPrincipal().toString(), getCredentials().toString() 형식으로
		// 사용할 수 있지만 null pointer exception 이 발생할 수 있어서
		// 문자열 형변환을 사용한다.
		String username = (String) authentication.getPrincipal();
		String password = (String) authentication.getCredentials();
		
		if(username.equals("duswl") == false) {
			throw new UsernameNotFoundException("username 이 잘못되었음");
		}
		if(password.equals("1234") == false) {
			throw new BadCredentialsException("비밀번호가 잘못 되었음");
		}
		
		UserVO userVO = UserVO.builder()
							.username(username)
							.password(password)
							.email("email")
							.realname("홍길동")
							.nickname("길동이").build();
		
		List<GrantedAuthority> grantList = new ArrayList<>();
		grantList.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		grantList.add(new SimpleGrantedAuthority("ROLE_USER"));
		
		// 사용자 이름과 비번, 권한 리스트로 Token 발행
		UsernamePasswordAuthenticationToken token
			= new UsernamePasswordAuthenticationToken(userVO, null, grantList);
		
		return token;
	}
	
	/*
	 * security 에서 인증절차를 수행하기 위하여 AuthenticationProvider 를 상속받으면
	 * 반드시 supports 를 true 로 만들어주어야 한다.
	 */

	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return true;
	}

}
