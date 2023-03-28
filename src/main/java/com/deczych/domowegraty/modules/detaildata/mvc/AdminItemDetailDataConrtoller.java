package com.deczych.domowegraty.modules.detaildata.mvc;

import com.deczych.domowegraty.modules.detaildata.domain.ItemDetailDataApi;
import com.deczych.domowegraty.modules.detaildata.dto.ItemDataCreateDTO;
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

    @PostMapping("getAllItems")
        //todo: swagger do zrobienia
    ResponseEntity<?> saveItem(
//            Pageable pageable,
            @RequestParam(name = "item") @Valid @RequestBody @NotNull ItemDataCreateDTO item
    ) {
        return ResponseEntity.ok(itemDetailDataApi.addItemToDB(item));
    }

}
