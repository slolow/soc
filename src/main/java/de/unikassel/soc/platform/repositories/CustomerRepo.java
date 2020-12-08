package de.unikassel.soc.platform.repositories;

import de.unikassel.soc.platform.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, UUID> {

}
