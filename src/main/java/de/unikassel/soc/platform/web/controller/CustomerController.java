package de.unikassel.soc.platform.web.controller;

import de.unikassel.soc.platform.services.CustomerService;
import de.unikassel.soc.platform.web.model.CustomerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/customer")
@RestController
public class CustomerController {

    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerDto> getCustomer(@PathVariable("customerId")  UUID customerId){

        return new ResponseEntity<>(customerService.getCustomerById(customerId), HttpStatus.OK);
    }

    @GetMapping("/name/{customerName}")
    public ResponseEntity<List<CustomerDto>> getCustomerByName(@PathVariable("customerName") String name) {

        return new ResponseEntity<>(customerService.getCustomerByName(name), HttpStatus.OK);
    }

/*    @GetMapping
    public ResponseEntity<CustomerDto[]> getAllCustomer() {

        return new ResponseEntity<CustomerDto>(customerService.getAllCustomerById(), HttpStatus.OK);
    }*/

    @PostMapping
    public ResponseEntity handlePost(@RequestBody @Validated CustomerDto customerDto){
        CustomerDto savedDto = customerService.saveNewCustomer(customerDto);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Location", "/api/v1/customer/" + savedDto.getId().toString());

        return new ResponseEntity(httpHeaders, HttpStatus.CREATED);
    }

    @PutMapping("/{customerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void handleUpdate(@PathVariable("customerId") UUID customerId, @Validated @RequestBody CustomerDto customerDto){
        customerService.updateCustomer(customerId, customerDto);
    }

    @DeleteMapping("/{customerId}")
    public void deleteById(@PathVariable("customerId")  UUID customerId){
        customerService.deleteById(customerId);
    }

}
