package com.deczych.domowegraty.modules.detaildata.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ItemDetailDataRepository extends JpaRepository<ItemDetailData,Long>, PagingAndSortingRepository<ItemDetailData,Long> {
    
}
