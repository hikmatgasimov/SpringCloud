package com.cloud.studentservice.feignclients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cloud.studentservice.response.AddressResponse;



/*@FeignClient(url="${address.service.url}",value="address-service-url",
path="/api/address")*/
@FeignClient(value="address-service",
path="/api/address")

public interface AddressFeignClients {
	@GetMapping("/getById/{id}")
	public AddressResponse getById (@PathVariable long id) ;
}
