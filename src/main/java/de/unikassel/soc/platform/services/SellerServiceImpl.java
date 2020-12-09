package de.unikassel.soc.platform.services;

import de.unikassel.soc.platform.domain.Seller;
import de.unikassel.soc.platform.repositories.SellerRepo;
import de.unikassel.soc.platform.web.mappers.SellerMapper;
import de.unikassel.soc.platform.web.model.SellerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class SellerServiceImpl implements SellerService {

    private SellerRepo sellerRepo;
    private SellerMapper sellerMapper;

    @Autowired
    public SellerServiceImpl(SellerRepo sellerRepo, SellerMapper sellerMapper) {
        this.sellerRepo = sellerRepo;
        this.sellerMapper = sellerMapper;
    }

    @Override
    public SellerDto getSellerById(UUID sellerId) {
        Seller seller = sellerRepo.findById(sellerId).get();
        return sellerMapper.sellerToSellerDto(seller);
    }

    @Override
    public SellerDto saveNewSeller(SellerDto sellerDto) {
        Seller seller = sellerMapper.sellerDtoToSeller(sellerDto);
        sellerRepo.save(seller);
        return sellerDto;
    }

    @Override
    public void updateSeller(UUID sellerId, SellerDto sellerDto) {
        log.debug("Updating....");
        Seller seller = sellerRepo.findById(sellerId).get();
        seller.setName(sellerDto.getName());
        sellerRepo.save(seller);
    }

    @Override
    public void deleteById(UUID sellerId) {
        log.debug("Deleting a seller .... ");
        sellerRepo.deleteById(sellerId);
    }
}
