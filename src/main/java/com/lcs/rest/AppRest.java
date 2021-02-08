package com.lcs.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lcs.repo.LcsAppRepo;

@RestController
@RequestMapping("/security/app")
public class AppRest {

	@Autowired
	LcsAppRepo lcsar;
	
	
	
}
