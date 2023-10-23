package com.example.matkalasku.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MatkalaskuController {

	
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	@ResponseBody
	public String lasku() {
		return "matkalasku";
	}
}
