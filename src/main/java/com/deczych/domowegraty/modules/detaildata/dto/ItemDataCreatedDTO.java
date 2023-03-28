package com.deczych.domowegraty.modules.detaildata.dto;

import lombok.*;

import java.math.BigDecimal;
import java.time.Instant;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ItemDataCreatedDTO {
    long id;
    String productCode;
    BigDecimal price;
    BigDecimal weight;
    Instant creationDate;
    Instant modyficationDate;

    String shortDescription;
    String longDescription;


}
