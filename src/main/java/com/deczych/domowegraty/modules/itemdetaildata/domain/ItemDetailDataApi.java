package com.deczych.domowegraty.modules.itemdetaildata.domain;

import com.deczych.domowegraty.modules.itemdetaildata.dto.ItemDataCreatedDTO;
import com.deczych.domowegraty.modules.itemdetaildata.dto.ItemDataCreateDTO;
import com.deczych.domowegraty.modules.itemdetaildata.dto.ItemDisplayDetailDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

@Component
@AllArgsConstructor
@Validated
public class ItemDetailDataApi {

    AdminItemDetailDataManagerService adminItemDetailDataManagerService;
    /*todo: 2 services to schecking if is something attached. and add new photos in disk.
    *   1. find many - pageable
    *   2. update item.
    */


    @Transactional
    public ItemDataCreatedDTO addItemToDB(ItemDataCreateDTO itemDataCreateDTO) {
        //todo important is that we have to check does bardoce exist. if yes 403(fobidden)
        //todo second task is check first does
        System.out.println(String.format("Jestem z %s:\n%s",this.getClass().getName(),itemDataCreateDTO.toString()));
        return adminItemDetailDataManagerService.addNewEntery(itemDataCreateDTO);
    }

    @Transactional(readOnly = true)
    public ItemDisplayDetailDTO findItemByProductCode(long productCode) {
        System.out.println(String.format("Jestem z API, szukam encji o danym kodzie.%s",productCode));
        return adminItemDetailDataManagerService.findEntityByProductCode(productCode);
    }

    @Transactional
    public void deleteItemWithProductCode(long productCode) {
        System.out.println(String.format("Jestem z API, przekazuje do serwisu jaka encja ma być usunięta.%s",productCode));
        adminItemDetailDataManagerService.deleteEntity(productCode);
    }

}
