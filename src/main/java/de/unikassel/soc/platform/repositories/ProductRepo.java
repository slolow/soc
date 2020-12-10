package de.unikassel.soc.platform.repositories;

import de.unikassel.soc.platform.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProductRepo extends JpaRepository<Product, UUID> {
    List<Product> findByPriceBetween(Double from, Double to);
}
