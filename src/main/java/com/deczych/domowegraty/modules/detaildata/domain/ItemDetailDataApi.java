package com.deczych.domowegraty.modules.detaildata.domain;

import com.deczych.domowegraty.modules.detaildata.dto.ItemDataDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@Component
@AllArgsConstructor
@Validated
public class ItemDetailDataApi {

    ItemDetailDataService itemDetailDataService;


    public ItemDataDTO addItemToDB(ItemDataDTO itemDataDTO) {
        ItemDataDTO item = new ItemDataDTO();


        return item;
    }
}
