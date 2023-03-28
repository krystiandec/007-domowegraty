package com.deczych.domowegraty.bootstramp;

import com.deczych.domowegraty.modules.detaildata.domain.ItemDetailData;
import com.deczych.domowegraty.modules.detaildata.domain.ItemDetailDataRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.Instant;

@Component
public class DataInitioalizer implements CommandLineRunner {

    private ItemDetailDataRepository repository;

    public DataInitioalizer(ItemDetailDataRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {


        ItemDetailData item1 = ItemDetailData.builder()
                .price(new BigDecimal(123.24))
                .creationDate(Instant.now())
                .weight(new BigDecimal(21))
                .productCode("598741231564")
                .build();
        System.out.println("Data item1:\n" + item1.toString());
        ItemDetailData itemSaved= repository.save(item1);
        System.out.println("Data itemSaved:\n"+itemSaved.toString());
    }
}
