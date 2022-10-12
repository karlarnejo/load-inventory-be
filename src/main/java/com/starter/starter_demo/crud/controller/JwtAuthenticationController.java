package com.starter.starter_demo.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.starter.starter_demo.common.ApiResultAuth;
import com.starter.starter_demo.common.UserDetailsModel;
import com.starter.starter_demo.config.JwtTokenUtil;
import com.starter.starter_demo.crud.models.AuthenticationModel;
import com.starter.starter_demo.crud.service.JwtUserDetailsService;

@RestController
@CrossOrigin(origins="*", maxAge=3600)
public class JwtAuthenticationController {

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private JwtUserDetailsService userDetailsService;
	
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ApiResultAuth createAuthenticationToken(@RequestBody AuthenticationModel authenticationRequest) throws Exception {

		userDetailsService.authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

		final UserDetails userDetails = userDetailsService
				.loadUserByUsername(authenticationRequest.getUsername());

		final String token = jwtTokenUtil.generateToken(userDetails);
		
		UserDetailsModel userDetailsModel = new UserDetailsModel();
		userDetailsModel.setUsername(userDetails.getUsername());
		
		return ApiResultAuth.createResponse(userDetailsModel, "CUSTOM_SUCCESS_STATUS", "Message to be added later", token);
	}
}