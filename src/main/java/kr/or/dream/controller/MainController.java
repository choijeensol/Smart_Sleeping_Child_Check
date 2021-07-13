package kr.or.dream.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {
	
	@RequestMapping(path="/main", method=RequestMethod.GET)
	public String main() {
		System.out.println("asdf");
		return "index";
	}
	
	@GetMapping("/test")
	public String test() {
		System.out.println("sadf");
		return "index";
	}
}
