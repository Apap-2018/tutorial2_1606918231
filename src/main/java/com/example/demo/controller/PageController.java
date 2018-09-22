package com.example.demo.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class PageController {
	
	@RequestMapping("/viral")
	public String index() {
		return "viral";
	}
	
	@RequestMapping(value="/challenge")
	public String challenge(@RequestParam(value="name") String name, Model model) {
		model.addAttribute("name",name);
		return "challenge";
	}
	
	@RequestMapping(value= {"/challenge/","challenge/{name}"})
	public String challengePath(@PathVariable Optional<String> name, Model model) {
		if (name.isPresent()) {
			model.addAttribute("name",name.get());
		}
		else {
			model.addAttribute("name", "KB");
		}
		return "challenge";
	}
	
	/*@RequestMapping("/challenge/{name}")
	public String challengePath(@PathVariable String name, Model model) {
		model.addAttribute("name", name);
		return "challenge";
	}*/
	
	
	
	@RequestMapping(value="/generator")
	public String generator(@RequestParam(value="a", defaultValue= "0") int a,
			@RequestParam(value="b", defaultValue= "0") int b, Model model) {
		
		
		String aa = "h";
		if (a>1) {
			for (int i=0;i<a ;i++) {
				aa+= "m";
			}
		}
		else {
			aa+= "m";
		}
		
		String temp = "";
		if(b>1) {
			for (int i=0 ; i<b;i++) {
				temp += aa+" ";
			}
		}
		else {
			temp += aa;
		}
		
		String result = temp;
		
		
		model.addAttribute("result", result);
		model.addAttribute("a", a);
		model.addAttribute("b", b);
		return "generator";
	}
}
