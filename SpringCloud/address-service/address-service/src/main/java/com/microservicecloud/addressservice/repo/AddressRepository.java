package com.microservicecloud.addressservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservicecloud.addressservice.entity.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

}
