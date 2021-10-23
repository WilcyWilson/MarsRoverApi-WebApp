package com.noob.coder.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.noob.coder.response.MarsRoverApiResponse;
import com.noob.coder.service.MarsRoverApiService;

@Controller
public class HomeController {

	@Autowired
	private MarsRoverApiService roverService;

	@GetMapping("/")
	public String getHomeView(ModelMap model, @RequestParam(required = false) String marsApiRoverData) {
		if (ObjectUtils.isEmpty(marsApiRoverData)) {
			marsApiRoverData = "opportunity";
		}
		MarsRoverApiResponse roverData = roverService.getRoverData(marsApiRoverData);
		model.put("roverData", roverData);
		return "index";
	}
}
