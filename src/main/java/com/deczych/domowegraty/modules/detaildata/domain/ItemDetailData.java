package com.deczych.domowegraty.modules.detaildata.domain;

import com.deczych.domowegraty.modules.pictures.domain.Photo;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ItemDetailData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    Long id;
    @Column(nullable = false)
    String productCode;
    @Column(nullable = false)
    BigDecimal price;
    @Column(nullable = false)
    BigDecimal weight;
    @Column(nullable = false)
    Instant creationDate;

    @OneToMany(cascade = CascadeType.ALL)
    List<Photo> addressesToImages;

    String shortDescription;
    String longDescription;
    Instant modyficationDate;


    //todo zrobic category jako klase i pole tutaj - kategorie moze okrteslac administrator

}
