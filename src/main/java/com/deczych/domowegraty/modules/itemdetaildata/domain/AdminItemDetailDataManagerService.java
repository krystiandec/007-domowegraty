package com.deczych.domowegraty.modules.itemdetaildata.domain;

import com.deczych.domowegraty.infrastructure.exception.CustomizedRuntimeException;
import com.deczych.domowegraty.modules.itemdetaildata.dto.ItemDataCreateDTO;
import com.deczych.domowegraty.modules.itemdetaildata.dto.ItemDataCreatedDTO;
import com.deczych.domowegraty.modules.itemdetaildata.dto.ItemDisplayDetailDTO;
import com.deczych.domowegraty.utils.enums.ExceptionEnum;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    public void deleteEntity(long productCode) {
        System.out.println("Przekazuje do repozytorium unikalny product code jaki ma byś usunięty...");
        ItemDetailData entity = repository.findByProductCode(productCode).orElseThrow(()->new CustomizedRuntimeException(ExceptionEnum.ITEM_NOT_FOUND_BARCODE,productCode));
        repository.delete(entity);
        System.out.println("Entity Deleted.");
    }

    public ItemDisplayDetailDTO getEntityByProductCode(long productCode) {
        ItemDetailData entity = repository.findByProductCode(productCode).orElseThrow(()->new CustomizedRuntimeException(ExceptionEnum.ITEM_NOT_FOUND_BARCODE,productCode));
        System.out.println(String.format("Jestem encją:%s", entity.toString()));
        ItemDisplayDetailDTO itemDisplayDetailDTO = itemDetailDataMapper.transformFromEntityToItemDisplayDetailDTO(entity);
        return itemDisplayDetailDTO;
    }

    public Page<ItemDisplayDetailDTO> getItemsDetailToDisplay(Pageable pageable) {
        System.out.println("Jestem z getItemsDetailToDisplay");
        Page<ItemDetailData> page = repository.findAll(pageable);
        return page.map(itemDetailDataMapper::transformFromEntityToItemDisplayDetailDTO);


    }
}
