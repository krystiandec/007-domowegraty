package com.deczych.domowegraty.modules.detaildata.dto;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ItemDataCreateDTO {
    String productCode;
    BigDecimal price;
    BigDecimal weight;

    String shortDescription;
    String longDescription;

}
