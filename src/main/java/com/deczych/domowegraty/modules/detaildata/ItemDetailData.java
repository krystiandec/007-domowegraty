package com.deczych.domowegraty.modules.detaildata;

import com.deczych.domowegraty.modules.ItemBO;
import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.Instant;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ItemDetailData extends ItemBO {

    String shortDescription;
    String longDescription;
    Instant modyficationDate;

    //todo zrobic category jako klase i pole tutaj - kategorie moze okrteslac administrator

}
