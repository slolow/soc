package de.unikassel.soc.platform.services;

import de.unikassel.soc.platform.web.model.ProductDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class ProductServiceImpl implements ProductService {

    @Override
    public ProductDto getProductById(UUID productId) {
        return ProductDto.builder().id(UUID.randomUUID())
                .productName("Ein Produkt")
                .description("")
                .price(10.20)
                .currency("EUR")
                .build();
    }

    @Override
    public ProductDto saveNewProduct(ProductDto productDto) {
        return ProductDto.builder()
                .id(UUID.randomUUID())
                .build();
    }

    @Override
    public void updateProduct(UUID productId, ProductDto productDto) {
        //TODO
    }

    @Override
    public void deleteById(UUID productId) {
        log.debug("Deleting a product...");
    }
}
