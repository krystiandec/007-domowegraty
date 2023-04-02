package com.deczych.domowegraty.modules.itemdetaildata.domain;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ItemDetailDataRepository extends Repository<ItemDetailData, Long>, PagingAndSortingRepository<ItemDetailData, Long> {

    void save(ItemDetailData entity);

    @Query("SELECT itemDetailData FROM ItemDetailData itemDetailData " +
            "WHERE itemDetailData.productCode=:productCode")
    Optional<ItemDetailData> findByProductCode(@Param("productCode") long productCode);

    void delete(ItemDetailData itemDetailData);

}
