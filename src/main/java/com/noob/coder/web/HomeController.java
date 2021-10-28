package com.noob.coder.web;

import java.lang.reflect.InvocationTargetException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.noob.coder.dto.HomeDto;
import com.noob.coder.response.MarsRoverApiResponse;
import com.noob.coder.service.MarsRoverApiService;

@Controller
public class HomeController {

	@Autowired
	private MarsRoverApiService roverService;

	@GetMapping("/")
	public String getHomeView(ModelMap model, HomeDto homeDto) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		if (ObjectUtils.isEmpty(homeDto.getMarsApiRoverData())) {
			homeDto.setMarsApiRoverData("Opportunity");
		}
		if (ObjectUtils.isEmpty(homeDto.getMarsSol())) {
			homeDto.setMarsSol(1);
		} 
		MarsRoverApiResponse roverData = roverService.getRoverData(homeDto);
		model.put("roverData", roverData);
		model.put("homeDto", homeDto);
		model.put("validCameras", roverService.getValidCameras().get(homeDto.getMarsApiRoverData()));
		return "index";
	}
	
	@PostMapping("/")
	public String postHomeView(HomeDto homeDto) {
		System.out.println(homeDto);
		return "redirect:/";
	}
}
