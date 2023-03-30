package com.deczych.domowegraty.modules.itemdetaildata.domain;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

public interface ItemDetailDataRepository extends Repository<ItemDetailData, Long>, PagingAndSortingRepository<ItemDetailData, Long> {

    void save(ItemDetailData entity);

    @Query("SELECT itemDetailData FROM ItemDetailData itemDetailData " +
            "WHERE itemDetailData.productCode=:productCode")
    ItemDetailData findByProductCode(@Param("productCode") String productCode);

    @Query("DELETE from ItemDetailData itemDetailData " +
            "WHERE itemDetailData.productCode=:productCode")
    void deleteByProductCode(@Param("productCode") String productCode);

    void delete(ItemDetailData itemDetailData);

}
