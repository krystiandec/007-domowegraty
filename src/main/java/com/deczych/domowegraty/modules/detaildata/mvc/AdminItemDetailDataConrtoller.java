package com.deczych.domowegraty.modules.detaildata.mvc;

import com.deczych.domowegraty.modules.detaildata.domain.ItemDetailDataApi;
import com.deczych.domowegraty.modules.detaildata.dto.ItemDataDTO;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("admin/item")
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AdminItemDetailDataConrtoller {

    ItemDetailDataApi itemDetailDataApi;

    @PostMapping("getAllItems")
        //todo: swagger do zrobienia
    ResponseEntity<?> saveItem(
//            Pageable pageable,
            @RequestParam(name = "name") ItemDataDTO itemDataDTO,
//            @RequestParam(name = "item") @RequestBody @Non
            ) {
        return ResponseEntity.ok(itemDetailDataApi.addItemToDB(itemDataDTO));
    }

    ;

}
