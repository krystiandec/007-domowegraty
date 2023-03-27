package com.deczych.domowegraty.modules;

import com.deczych.domowegraty.modules.pictures.Photo;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;



@Getter
@Setter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@MappedSuperclass
public abstract class ItemBO {
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

}
