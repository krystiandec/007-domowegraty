package com.deczych.domowegraty.modules;

import com.deczych.domowegraty.modules.pictures.Photo;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import java.util.List;


@Entity
@Getter
@Setter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public abstract class ItemBO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    String description;

    @OneToMany(cascade = CascadeType.ALL)
    List<Photo> addressesToImages;

}
