package com.deczych.domowegraty.modules.itemdetaildata.domain;

import com.deczych.domowegraty.modules.itemdetaildata.dto.ItemDataCreateDTO;
import com.deczych.domowegraty.modules.itemdetaildata.dto.ItemDataCreatedDTO;
import com.deczych.domowegraty.modules.itemdetaildata.dto.ItemDisplayDetailDTO;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AdminItemDetailDataManagerService {

    /*todo: 1. new service for deleting
        first:for move from active to archive
        second: for permanent erse from activeItem or archive.
        2. error handle -> when entity not found to find or to delete/erse
        3. Error handle when is attempt add something with unique column.
     */

    ItemDetailDataRepository repository;
    ItemDetailDataMapper itemDetailDataMapper;

    public ItemDataCreatedDTO addNewEntery(ItemDataCreateDTO itemDataCreateDTO) {
        ItemDetailData entity = itemDetailDataMapper.transformToEntity(itemDataCreateDTO);
        entity.setCreationDate(Instant.now());
        entity.setShortDescription("lalalala test1");
        System.out.println(String.format("Jestem encją:%s", entity.toString()));
        repository.save(entity);
        ItemDataCreatedDTO savedEntity = itemDetailDataMapper.transformFromEntity(entity);
        return savedEntity;
    }

    public void deleteEntity(String productCode) {
        System.out.println("Przekazuje do repozytorium unikalny product code jaki ma byś usunięty...");
        ItemDetailData entity = repository.findByProductCode(productCode).orElseThrow(()->new RuntimeException("Item Not Found"));
        repository.delete(entity);
        System.out.println("Entity Deleted.");
    }

    public ItemDisplayDetailDTO findEntityByProductCode(String productCode) {
        ItemDetailData entity = repository.findByProductCode(productCode).orElseThrow(()->new RuntimeException("Item Not Found"));
        System.out.println(String.format("Jestem encją:%s", entity.toString()));
        ItemDisplayDetailDTO itemDisplayDetailDTO = itemDetailDataMapper.transformFromEntityToItemDisplayDetailDTO(entity);
        return itemDisplayDetailDTO;
    }
}
