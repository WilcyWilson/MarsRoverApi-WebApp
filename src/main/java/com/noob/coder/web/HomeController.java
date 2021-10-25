package com.noob.coder.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;

import com.noob.coder.dto.HomeDto;
import com.noob.coder.response.MarsRoverApiResponse;
import com.noob.coder.service.MarsRoverApiService;

@Controller
public class HomeController {

	@Autowired
	private MarsRoverApiService roverService;

	@GetMapping("/")
	public String getHomeView(ModelMap model, HomeDto homeDto) {
		if (ObjectUtils.isEmpty(homeDto.getMarsApiRoverData())) {
			homeDto.setMarsApiRoverData("opportunity");
		}
		if (ObjectUtils.isEmpty(homeDto.getMarsSol())) {
			homeDto.setMarsSol(1);
		}
		MarsRoverApiResponse roverData = roverService.getRoverData(homeDto.getMarsApiRoverData(), homeDto.getMarsSol());
		model.put("roverData", roverData);
		model.put("homeDto", homeDto);
		return "index";
	}
}
