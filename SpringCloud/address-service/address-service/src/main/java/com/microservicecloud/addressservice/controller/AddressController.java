package com.microservicecloud.addressservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservicecloud.addressservice.request.CreateAddressRequest;
import com.microservicecloud.addressservice.response.AddressResponse;
import com.microservicecloud.addressservice.service.AddressService;

@RestController
@RequestMapping("/api/address")
public class AddressController {
	@Autowired
	AddressService studentService;
	
	@PostMapping("/create")
	public AddressResponse createStudent (@RequestBody CreateAddressRequest createStudentRequest) {
		return studentService.createStudent(createStudentRequest);
	}
	
	@GetMapping("/getById/{id}")
	public AddressResponse getById (@PathVariable long id) {
		return studentService.getById(id);
	}
}
