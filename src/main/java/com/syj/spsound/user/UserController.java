package com.syj.spsound.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
	
	@GetMapping("/user/login-view")
	public String inputLogin() {
		
		return "user/login";
	}

}
