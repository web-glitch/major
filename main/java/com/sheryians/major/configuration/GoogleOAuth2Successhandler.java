package com.sheryians.major.configuration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.BeanDefinitionDsl.Role;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.sheryians.major.model.User;
import com.sheryians.major.repository.RoleRepository;
import com.sheryians.major.repository.UserRepository;
import com.sun.tools.javac.util.List;


	
	
	@Component
    public class GoogleOAuth2Successhandler implements AuthenticationSuccessHandler
    {
		@Autowired
		UserRepository userRepository;
		
		@Autowired
		RoleRepository roleRepository;
		
		private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
        
		
		
		@SuppressWarnings( { "restriction", "unchecked" })
		@Override
		public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
				Authentication authentication) throws IOException, ServletException {
			OAuth2AuthenticationToken token = (OAuth2AuthenticationToken) authentication;
			
			String email=token.getPrincipal().getAttributes().get("email").toString();
		     if(userRepository.findUserByEmail(email).isPresent())
		     {
		     }
		     else
		     {
		    	 User user= new User();
		    	 user.setFirstName(token.getPrincipal().getAttributes().get("given_name").toString());
		    	 user.setLastName(token.getPrincipal().getAttributes().get("family_name").toString());
                 user.setEmail(email);
                 
				java.util.List<com.sheryians.major.model.Role> roles= new ArrayList<>();

                 roles.add( (com.sheryians.major.model.Role) roleRepository.findById(2).get());
                 user.setRoles(roles);
                 userRepository.save(user);
                 
                 
		     }
		     
		     redirectStrategy.sendRedirect(httpServletRequest,httpServletResponse, "/");
		     }
		    	 
		}
		
    


