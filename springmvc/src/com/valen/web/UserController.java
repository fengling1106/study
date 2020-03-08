package com.valen.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.valen.domain.*;

import com.valen.service.*;

@Controller
@RequestMapping("/user")
public class UserController {
	@RequestMapping("/register")
	public String register() 
	{
		return "user/register"; 
	}
	
	@Autowired
	private UserService userSerice;
	
	
	@RequestMapping(path="/subinfo",method=RequestMethod.POST)
	public ModelAndView createUser(User user)
	{
		userSerice.createUser(user);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("user/CreateSuccess");
		mav.addObject("user",user);
		return mav;
	}
}
