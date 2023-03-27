package com.deczych.domowegraty.modules.detaildata.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
public class ItemDataDTO {
    String productCode;
    BigDecimal price;
    BigDecimal weight;
//    Instant creationDate;

}
