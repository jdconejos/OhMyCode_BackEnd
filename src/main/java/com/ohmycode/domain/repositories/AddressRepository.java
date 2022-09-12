package com.ohmycode.domain.repositories;

import com.ohmycode.domain.models.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Long> {

}
