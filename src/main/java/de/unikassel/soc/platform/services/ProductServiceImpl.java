package de.unikassel.soc.platform.services;

import de.unikassel.soc.platform.domain.Product;
import de.unikassel.soc.platform.repositories.ProductRepo;
import de.unikassel.soc.platform.web.mappers.ProductMapper;
import de.unikassel.soc.platform.web.model.ProductDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

@Slf4j
@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepo productRepo;
    private ProductMapper productMapper;

    @Autowired
    public ProductServiceImpl(ProductRepo productRepo, ProductMapper productMapper) {
        this.productRepo = productRepo;
        this.productMapper = productMapper;
    }

    @Override
    public ProductDto getProductById(UUID productId) {
        Product product = productRepo.findById(productId).get();
        return productMapper.productToProductDto(product);
    }

    @Override
    public ProductDto saveNewProduct(ProductDto productDto) {
        Product product = productMapper.productDtoToProduct(productDto);

        Date date = new Date();
        long time = date.getTime();
        Timestamp ts = new Timestamp(time);
        product.setCreatedDate(ts);
        product.setLastUpdatedDate(ts);
        productRepo.save(product);
        return productDto;
    }

    @Override
    public void updateProduct(UUID productId, ProductDto productDto) {
        log.debug("Updating....");
        Product product = productRepo.findById(productId).get();
        product.setProductName(productDto.getProductName());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        product.setCurrency(productDto.getCurrency());

        Date date = new Date();
        long time = date.getTime();
        Timestamp ts = new Timestamp(time);
        product.setLastUpdatedDate(ts);

        productRepo.save(product);
    }

    @Override
    public void deleteById(UUID productId) {

        log.debug("Deleting a product...");
        Product product = productRepo.findById(productId).get();
        productRepo.delete(product);
        log.debug("Deleted" + product);

    }
}
