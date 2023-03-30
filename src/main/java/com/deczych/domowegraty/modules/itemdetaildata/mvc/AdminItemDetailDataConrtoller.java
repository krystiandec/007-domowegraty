package com.deczych.domowegraty.modules.itemdetaildata.mvc;

import com.deczych.domowegraty.modules.itemdetaildata.domain.ItemDetailDataApi;
import com.deczych.domowegraty.modules.itemdetaildata.dto.ItemDataCreateDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("admin/item")
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AdminItemDetailDataConrtoller {

    ItemDetailDataApi itemDetailDataApi;

    @PostMapping("saveItem")
        //todo: swagger do zrobienia
    ResponseEntity<?> saveItem(
//            Pageable pageable,
            @Valid @RequestBody @NotNull ItemDataCreateDTO item
    ) {
        System.out.println(String.format("Jestem z %s:\n%s",this.getClass().getName(),item.toString()));
        return ResponseEntity.ok(itemDetailDataApi.addItemToDB(item));
    }

    @GetMapping("findByCode")
    ResponseEntity<?> findItemDetailsByProductCode(@Valid @RequestParam String productCode){
        System.out.println("Znajduję encje z bazy jak jest. kod:" + productCode);
        return ResponseEntity.ok(itemDetailDataApi.findItemByProductCode(productCode));
    }

    @DeleteMapping("deleteBycode")
    ResponseEntity<?> deleteItem(@Valid @RequestParam String productCode){
        System.out.println("Usuwam encje z bazy jak jest. kod:" + productCode);
        itemDetailDataApi.deleteItemWithProductCode(productCode);
        return ResponseEntity.ok(String.format("done, item o numerze:%s usunięty",productCode));
    }

}
