package com.aymen.form.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
public class FormController {

    @RequestMapping("/form")
    public String showOmikujiForm() {
        return "index.jsp"; 
    }
    @RequestMapping("/processForm")
    public String process(@RequestParam("number")String number,
    		                     @RequestParam("city")String city,
    		                             @RequestParam("person")String person,
    		                                 @RequestParam("hobby")String hobby,
    		                                         @RequestParam("living")String living,
    		                                              @RequestParam("nice") String nice,
    		                                              HttpSession session) {
    	
    	
    	session.setAttribute("number",number );
    	session.setAttribute("city",city );
    	session.setAttribute("person",person );
    	session.setAttribute("hobby",hobby );
    	session.setAttribute("living",living );
    	session.setAttribute("nice",nice );
    	
    	return "redirect:/result";
    }
    @RequestMapping("/result")
    public String result() {
    	return "result.jsp";
    }

    
}

