package com.deczych.domowegraty.modules.itemdetaildata.domain;

import com.deczych.domowegraty.modules.itemdetaildata.dto.ItemDataCreateDTO;
import com.deczych.domowegraty.modules.itemdetaildata.dto.ItemDataCreatedDTO;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AdminItemDetailDataManagerService {

    ItemDetailDataRepository repository;
    ItemDetailDataMapper itemDetailDataMapper;

    public ItemDataCreatedDTO addNewEntery(ItemDataCreateDTO itemDataCreateDTO) {
        ItemDetailData entity = itemDetailDataMapper.transformToEntity(itemDataCreateDTO);
        entity.setCreationDate(Instant.now());
        entity.setShortDescription("lalalala test");
        System.out.println(String.format("Jestem encją:%s",entity.toString()));
        repository.save(entity);
        ItemDataCreatedDTO savedEntity = itemDetailDataMapper.transformFromEntity(entity);
        return savedEntity;
    }
}
