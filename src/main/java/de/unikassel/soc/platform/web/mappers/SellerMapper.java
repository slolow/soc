package de.unikassel.soc.platform.web.mappers;

import de.unikassel.soc.platform.domain.Seller;
import de.unikassel.soc.platform.web.model.SellerDto;
import org.mapstruct.Mapper;

@Mapper
public interface SellerMapper {

    Seller sellerDtoToSeller(SellerDto dto);

    SellerDto sellerToSellerDto(Seller seller);
}
