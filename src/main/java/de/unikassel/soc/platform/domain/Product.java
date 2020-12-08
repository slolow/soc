package de.unikassel.soc.platform.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.sql.Timestamp;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {
    private UUID id;
    private String productName;
    private String description;
    private Double price;
    private String currency;

    private Timestamp createdDate;
    private Timestamp lastUpdatedDate;
}
