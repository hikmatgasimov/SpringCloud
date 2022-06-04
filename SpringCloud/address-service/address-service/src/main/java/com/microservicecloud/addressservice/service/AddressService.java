package com.microservicecloud.addressservice.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservicecloud.addressservice.entity.Address;
import com.microservicecloud.addressservice.repo.AddressRepository;
import com.microservicecloud.addressservice.request.CreateAddressRequest;
import com.microservicecloud.addressservice.response.AddressResponse;

@Service
public class AddressService {
	//@Autowired
	//StudentRepository studentRepository;
    Logger logger=LoggerFactory.getLogger(AddressService.class);
	@Autowired
	AddressRepository addressRepository;

	public AddressResponse createStudent(CreateAddressRequest createAddressRequest) {

		Address address = new Address();
		address.setStreet( createAddressRequest.getStreet());
		address.setCity( createAddressRequest.getCity());

		addressRepository.save(address);
        return new AddressResponse(address);
        
		/*Student student = new Student();
		student.setFirstName(createStudentRequest.getFirstName());
		student.setLastName(createStudentRequest.getLastName());
		student.setEmail(createStudentRequest.getEmail());
		
		student.setAddress(address);
		student = studentRepository.save(student);

		return new StudentResponse(student);*/
	}
	
	public AddressResponse  getById (long id) {
		logger.info("Inside GetById"+id);
		Address address=addressRepository.findById(id).get();
		
		return new AddressResponse (address);
	}
}
