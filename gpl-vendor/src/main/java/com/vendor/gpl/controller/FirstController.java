package com.vendor.gpl.controller;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vendor.gpl.bean.FirstTestBean;

@RestController
@RequestMapping("/firstController")
public class FirstController {
	@InitBinder
	public void binderMethod(WebDataBinder dataBinder){
		StringTrimmerEditor stringTrimmerEditor=new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
	
	@GetMapping(path="/first")
	public String firstMethod(){
		return "first method";
	}
	
	@GetMapping(path="/testPathVariables/{name1},{name2}",produces = MediaType.APPLICATION_JSON_VALUE)
	public String testPathVariables(@PathVariable String name1,@PathVariable String name2){
		return String.format("%s is smart but %s is dumb",name1,name2);
	}
	
	@GetMapping(path="/testPathVariableswithBean/{name1},{name2}",produces = MediaType.APPLICATION_JSON_VALUE)
	public FirstTestBean testPathVariableswithBean(@PathVariable String name1,@PathVariable String name2){
		return new FirstTestBean(name1);
	}
}
