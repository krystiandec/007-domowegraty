package com.deczych.domowegraty.modules.detaildata.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ItemDataCreateDTO {
    @NotNull
    String productCode;
    @NotNull
    BigDecimal price;
    @NotNull
    BigDecimal weight;

    String shortDescription;
    String longDescription;

}
