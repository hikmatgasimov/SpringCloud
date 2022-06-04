package com.cloud.studentservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.cloud.studentservice.entity.Student;
import com.cloud.studentservice.feignclients.AddressFeignClients;
import com.cloud.studentservice.repository.StudentRepository;
import com.cloud.studentservice.request.CreateStudentRequest;
import com.cloud.studentservice.response.AddressResponse;
import com.cloud.studentservice.response.StudentResponse;

import reactor.core.publisher.Mono;

@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepository;
	@Autowired
	WebClient webClient;
	@Autowired
	AddressFeignClients addressFeignClients;

	public StudentResponse createStudent(CreateStudentRequest createStudentRequest) {

		Student student = new Student();
		student.setFirstName(createStudentRequest.getFirstName());
		student.setLastName(createStudentRequest.getLastName());
		student.setEmail(createStudentRequest.getEmail());
		
		student.setAddressId(createStudentRequest.getAdressId());
		student = studentRepository.save(student);

		StudentResponse studentResponse=new StudentResponse(student);
		//studentResponse.setAddressResponse(getAddressById(student.getAddressId()));
		studentResponse.setAddressResponse(addressFeignClients.getById(student.getAddressId()));
		return studentResponse;
	}
	
	public StudentResponse getById (long id) {
		Student student=studentRepository.findById(id).get();
		StudentResponse studentResponse=new StudentResponse(student);
		
		//studentResponse.setAddressResponse(getAddressById(student.getAddressId()));
		studentResponse.setAddressResponse(addressFeignClients.getById(student.getAddressId()));
		return  studentResponse;
	}
	

	public AddressResponse getAddressById(long addressId) {
		Mono<AddressResponse > addressResponse=
				webClient.get().uri("/getById/"+ addressId)
		.retrieve().bodyToMono(AddressResponse.class);
		
		return addressResponse.block();
	}
}
