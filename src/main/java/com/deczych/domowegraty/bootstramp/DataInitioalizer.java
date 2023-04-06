package com.deczych.domowegraty.bootstramp;

import com.deczych.domowegraty.modules.itemdetaildata.domain.ItemDetailData;
import com.deczych.domowegraty.modules.itemdetaildata.domain.ItemDetailDataRepository;
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
                .weight(new BigDecimal(2.1))
                .productCode(598741231564l)
                .build();
        System.out.println("Data item2:\n" + item1.toString());
        repository.save(item1);
        ItemDetailData item2 = ItemDetailData.builder()
                .price(new BigDecimal(223.24))
                .creationDate(Instant.now())
                .weight(new BigDecimal(1.05))
                .productCode(5987412315642l)
                .build();
        System.out.println("Data item3:\n" + item1.toString());
        repository.save(item2);
        ItemDetailData item3 = ItemDetailData.builder()
                .price(new BigDecimal(323.24))
                .creationDate(Instant.now())
                .weight(new BigDecimal(0.85))
                .productCode(5987412315643l)
                .build();
        System.out.println("Data item1:\n" + item1.toString());

//        ItemDetailData itemSaved= repository.save(item1);
//        System.out.println("Data itemSaved:\n"+itemSaved.toString());
    }
}
