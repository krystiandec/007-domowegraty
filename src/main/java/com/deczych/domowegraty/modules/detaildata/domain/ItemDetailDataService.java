package com.deczych.domowegraty.modules.detaildata.domain;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ItemDetailDataService {

    ItemDetailDataRepository repository;
    ItemDetailDataMapper itemDetailDataMapper;
}
