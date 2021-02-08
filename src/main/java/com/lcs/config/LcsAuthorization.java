package com.lcs.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
@EnableAuthorizationServer
public class LcsAuthorization extends AuthorizationServerConfigurerAdapter {

	@Autowired
	AuthenticationManager authenticationManager;
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Bean
	TokenStore tokenStore() {
		return new JwtTokenStore(jwtTokenEnhancer());
	}
	
	@Bean
	JwtAccessTokenConverter jwtTokenEnhancer() {
		JwtAccessTokenConverter converter=new JwtAccessTokenConverter();
		converter.setSigningKey("be$$em001");
		return converter;
	}
	
	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		// TODO Auto-generated method stub
		clients.inMemory().withClient("wanted").secret(passwordEncoder.encode("wanted")).authorizedGrantTypes("password","refresh_token").scopes("READ");
		
	}
	
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		// TODO Auto-generated method stub
	endpoints.authenticationManager(authenticationManager);
	endpoints.tokenStore(tokenStore());
	endpoints.accessTokenConverter(jwtTokenEnhancer());
	}
	
}
