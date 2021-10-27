package com.noob.coder.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.noob.coder.dto.HomeDto;
import com.noob.coder.response.MarsPhoto;
import com.noob.coder.response.MarsRoverApiResponse;

@Service
public class MarsRoverApiService {
	private static final String API_KEY = "4xGnh9vzNw9G2kvBP8Q0Gt61IlXDk9C5JKhWmnq0";

	public MarsRoverApiResponse getRoverData(HomeDto homeDto) {
		RestTemplate rt = new RestTemplate();
		List<String> apiUrlEndpoints = getApiUrlEndpoints(homeDto);
		List<MarsPhoto> photos = new ArrayList<>();
		MarsRoverApiResponse response = new MarsRoverApiResponse();

		apiUrlEndpoints.stream().forEach(url -> {
			MarsRoverApiResponse apiResponse = rt.getForObject(url, MarsRoverApiResponse.class);
			photos.addAll(apiResponse.getPhotos());
		});

		response.setPhotos(photos);
		return response;
	}

	public List<String> getApiUrlEndpoints(HomeDto homeDto) {
		List<String> urls = new ArrayList<>();
		if (Boolean.TRUE.equals(homeDto.getCameraFhaz())) {
			urls.add("https://api.nasa.gov/mars-photos/api/v1/rovers/" + homeDto.getMarsApiRoverData() + "/photos?sol="
					+ homeDto.getMarsSol() + "&camera=Fhaz" + "&api_key=" + API_KEY);
		}
		if (Boolean.TRUE.equals(homeDto.getCameraRhaz())) {
			urls.add("https://api.nasa.gov/mars-photos/api/v1/rovers/" + homeDto.getMarsApiRoverData() + "/photos?sol="
					+ homeDto.getMarsSol() + "&camera=Rhaz" + "&api_key=" + API_KEY);
		}
		if (Boolean.TRUE.equals(homeDto.getCameraMast())
				&& "curiosity".equalsIgnoreCase(homeDto.getMarsApiRoverData())) {
			urls.add("https://api.nasa.gov/mars-photos/api/v1/rovers/" + homeDto.getMarsApiRoverData() + "/photos?sol="
					+ homeDto.getMarsSol() + "&camera=Mast" + "&api_key=" + API_KEY);
		}
		if (Boolean.TRUE.equals(homeDto.getCameraChemcam())
				&& "curiosity".equalsIgnoreCase(homeDto.getMarsApiRoverData())) {
			urls.add("https://api.nasa.gov/mars-photos/api/v1/rovers/" + homeDto.getMarsApiRoverData() + "/photos?sol="
					+ homeDto.getMarsSol() + "&camera=Chemcam" + "&api_key=" + API_KEY);
		}
		if (Boolean.TRUE.equals(homeDto.getCameraMahli())
				&& "curiosity".equalsIgnoreCase(homeDto.getMarsApiRoverData())) {
			urls.add("https://api.nasa.gov/mars-photos/api/v1/rovers/" + homeDto.getMarsApiRoverData() + "/photos?sol="
					+ homeDto.getMarsSol() + "&camera=Mahli" + "&api_key=" + API_KEY);
		}
		if (Boolean.TRUE.equals(homeDto.getCameraMardi())
				&& "curiosity".equalsIgnoreCase(homeDto.getMarsApiRoverData())) {
			urls.add("https://api.nasa.gov/mars-photos/api/v1/rovers/" + homeDto.getMarsApiRoverData() + "/photos?sol="
					+ homeDto.getMarsSol() + "&camera=Mardi" + "&api_key=" + API_KEY);
		}
		if (Boolean.TRUE.equals(homeDto.getCameraNavcam())) {
			urls.add("https://api.nasa.gov/mars-photos/api/v1/rovers/" + homeDto.getMarsApiRoverData() + "/photos?sol="
					+ homeDto.getMarsSol() + "&camera=Navcam" + "&api_key=" + API_KEY);
		}
		if (Boolean.TRUE.equals(homeDto.getCameraPancam())
				&& !"curiosity".equalsIgnoreCase(homeDto.getMarsApiRoverData())) {
			urls.add("https://api.nasa.gov/mars-photos/api/v1/rovers/" + homeDto.getMarsApiRoverData() + "/photos?sol="
					+ homeDto.getMarsSol() + "&camera=Pancam" + "&api_key=" + API_KEY);
		}
		if (Boolean.TRUE.equals(homeDto.getCameraMinites())
				&& !"curiosity".equalsIgnoreCase(homeDto.getMarsApiRoverData())) {
			urls.add("https://api.nasa.gov/mars-photos/api/v1/rovers/" + homeDto.getMarsApiRoverData() + "/photos?sol="
					+ homeDto.getMarsSol() + "&camera=Minites" + "&api_key=" + API_KEY);
		}
		return urls;
	}
}
