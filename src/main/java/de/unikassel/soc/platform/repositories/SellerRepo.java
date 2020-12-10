package de.unikassel.soc.platform.repositories;

import de.unikassel.soc.platform.domain.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface SellerRepo extends JpaRepository<Seller, UUID> {
    List<Seller> findByName(String name);
}
