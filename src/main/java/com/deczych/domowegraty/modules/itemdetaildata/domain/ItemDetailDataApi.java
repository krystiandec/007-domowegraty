package com.deczych.domowegraty.modules.itemdetaildata.domain;

import com.deczych.domowegraty.modules.itemdetaildata.dto.ItemDataCreatedDTO;
import com.deczych.domowegraty.modules.itemdetaildata.dto.ItemDataCreateDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@Component
@AllArgsConstructor
@Validated
public class ItemDetailDataApi {

    AdminItemDetailDataManagerService adminItemDetailDataManagerService;
    //todo 2 servis to schecking if is something attached. and add new photos in disk.


    public ItemDataCreatedDTO addItemToDB(ItemDataCreateDTO itemDataCreateDTO) {
        //todo important is that we have to check does bardoce exist. if yes 403(fobidden)
        //todo second task is check first does
        System.out.println(String.format("Jestem z %s:\n%s",this.getClass().getName(),itemDataCreateDTO.toString()));
        return adminItemDetailDataManagerService.addNewEntery(itemDataCreateDTO);
    }
}
