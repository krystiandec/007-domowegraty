package com.deczych.domowegraty.modules.itemdetaildata.domain;

import com.deczych.domowegraty.modules.itemdetaildata.dto.ItemDataCreateDTO;
import com.deczych.domowegraty.modules.itemdetaildata.dto.ItemDataCreatedDTO;
import org.springframework.stereotype.Service;

@Service
public class ItemDetailDataMapper {

    public ItemDetailData transformToEntity(ItemDataCreateDTO itemDataCreateDTO) {
        return ItemDetailData.builder()
                .productCode(itemDataCreateDTO.getProductCode())
                .price(itemDataCreateDTO.getPrice())
                .weight(itemDataCreateDTO.getWeight())
                .shortDescription(itemDataCreateDTO.getShortDescription())
                .longDescription(itemDataCreateDTO.getLongDescription())
                .build();
    }

    public ItemDataCreatedDTO transformFromEntity(ItemDetailData entity) {
        return ItemDataCreatedDTO.builder()
                .id(entity.getId())
                .productCode(entity.getProductCode())
                .price(entity.getPrice())
                .weight(entity.getWeight())
                .creationDate(entity.getCreationDate())
                .modyficationDate(entity.getModyficationDate())
                .shortDescription(entity.getShortDescription())
                .longDescription(entity.getLongDescription())
                .build();
    }
}
