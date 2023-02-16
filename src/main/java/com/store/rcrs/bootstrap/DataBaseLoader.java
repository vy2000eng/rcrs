package com.store.rcrs.bootstrap;

import com.store.rcrs.model.Records;
import com.store.rcrs.repository.RecordRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;


@Component
public class DataBaseLoader implements ApplicationListener <ContextRefreshedEvent> {


    private final RecordRepository recordRepository;

    public DataBaseLoader(RecordRepository recordRepository) {

        //spring managed
        this.recordRepository = recordRepository;
        //recordRepository = new RecordRepositoryImpl();
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("SPRING APPLICATION IS STARTING");


        //
        // add games to the db


        recordRepository.addRecord(new Records(1L, "Dark Side of the Moon", "PinkFloyd", 49.99, "1969", "Rock", 12));
        recordRepository.addRecord(new Records(2L, "Tranquility Base Hotel and Casino", "Arctic Monkeys", 49.99, "2018", "Rock", 12));
        recordRepository.addRecord(new Records(3L, "Stadium Arcadium", "RHCP", 69.69, "2006", "Rock", 12));

    }
}
