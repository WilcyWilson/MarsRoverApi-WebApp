package com.noob.coder.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.noob.coder.response.MarsRoverApiResponse;
import com.noob.coder.service.MarsRoverApiService;

@Controller
public class HomeController {
	
	@Autowired
	private MarsRoverApiService roverSevice;
	@GetMapping("/")
	public String getHomeView(ModelMap model) {
		MarsRoverApiResponse roverData = roverSevice.getRoverData("opportunity");
		model.put("roverData", roverData);
		return "index";
	}
}
