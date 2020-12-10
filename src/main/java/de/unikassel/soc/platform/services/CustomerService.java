package de.unikassel.soc.platform.services;

import de.unikassel.soc.platform.web.model.CustomerDto;

import java.util.List;
import java.util.UUID;

public interface CustomerService {

    CustomerDto getCustomerById(UUID customerId);

    List<CustomerDto> getCustomerByName(String name);

    //CustomerDto[] getAllCustomer();

    CustomerDto saveNewCustomer(CustomerDto customerDto);

    void updateCustomer(UUID customerId, CustomerDto customerDto);

    void deleteById(UUID customerId);

}
