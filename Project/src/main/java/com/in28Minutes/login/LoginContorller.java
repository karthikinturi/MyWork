package com.in28Minutes.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.in28Minutes.login.LoginService;


@Controller
@SessionAttributes("name")
public class LoginContorller {
	
	//Set Login Service-AutoWire
	@Autowired
	LoginService service ;
	
	@RequestMapping(value = "/login",method=RequestMethod.GET)
	//@ResponseBody
	public String sayHello() {
		return "login";
	}
	
	@RequestMapping(value = "/login",method=RequestMethod.POST)
	//@ResponseBody
	public String handleLoginRequest(@RequestParam String name,@RequestParam String password, ModelMap model) {
		if(!service.validateUser(name, password)) {
			model.put("errorMessage", "Invalid Credetials");
			return "login";
		}
		model.put("name", name);
		//model.put("password", password);
		//System.out.println(name);
		return "welcome";
	}

}
