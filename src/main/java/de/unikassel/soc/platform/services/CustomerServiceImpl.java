package de.unikassel.soc.platform.services;

import de.unikassel.soc.platform.web.model.CustomerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {

    // Diese Funktion muss umgeschrieben werden, dass sie nicht
    // Max Muster zurück gibt sondern den Customer aus der Datenbank mit der
    // enstprechenden ID
    @Override
    public CustomerDto getCustomerById(UUID customerId) {
        return CustomerDto.builder()
                .id(UUID.randomUUID())
                .name("Max Muster")
                .build();
    }

    // Diese Funktion muss umgeschrieben werden, dass der customer in der
    // Datenbank abgespeichert wird
    @Override
    public CustomerDto saveNewCustomer(CustomerDto customerDto) {
        return CustomerDto.builder()
                .id(UUID.randomUUID())
                .build();
    }

    @Override
    public void updateCustomer(UUID customerId, CustomerDto customerDto) {
        //todo impl
        log.debug("Updating....");
    }

    @Override
    public void deleteById(UUID customerId) {
        log.debug("Deleting.... ");
    }
}
