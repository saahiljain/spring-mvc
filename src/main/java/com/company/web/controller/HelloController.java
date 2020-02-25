package com.company.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// This is just POJO
@Controller
public class HelloController {
	@RequestMapping("/hello-mvc")
	public String sayHello() {
		//return "/WEB-INF/pages/hello.jsp";
		return "hello";
	}
	
	// URL Request is make -> http://localhost:9988/spring-mvc-works/hello-mvc
	// web.xml (i.e., missing), a class @Configuration (AppConfig)
	// Registered a Servlet called DispactherServlet(context)
	// ComponentScan -> com.company.web.controller
	// return String - which is a file name
	// The VIEW for the given name is found
	// The VIEW is shown to end-user
}
