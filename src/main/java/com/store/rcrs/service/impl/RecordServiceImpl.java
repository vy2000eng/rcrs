package com.store.rcrs.service.impl;

import com.store.rcrs.model.Records;
import com.store.rcrs.repository.RecordRepository;
import com.store.rcrs.service.RecordService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class RecordServiceImpl implements RecordService {
    //@Autowired // spring managed instance
    // field injection(not recommended

    private final RecordRepository recordRepository;

    public RecordServiceImpl(RecordRepository recordRepository) {

        this.recordRepository = recordRepository;
        //
        // developer managed instance

        //recordRepository = new RecordRepositoryImpl();

    }

    @Override
    public List<Records> getRecord() {
       return recordRepository.getRecord();
    }



    @Override
    public List<Records> searchRecords(String term) {
        if(!StringUtils.hasText(term)){
            throw new IllegalArgumentException("terms can't be empty");

        }
        return recordRepository.searchRecords(term);

    }





/*
    @Override
    public void addRecord(Long recordId, String recordName, String recordArtist, Double recordPrice, String recordReleaseDate, String recordGenre, Integer numberOfTRacks) {
        if(!StringUtils.hasText(recordName)){
            throw new IllegalArgumentException("Record Name is required");


        }
        if(!StringUtils.hasText(recordArtist)){
            throw new IllegalArgumentException("Record Artist is required");


        }
        if(!StringUtils.hasText(String.valueOf(recordPrice))){
            throw new IllegalArgumentException("Record Price is required");


        }
        if(!StringUtils.hasText(recordReleaseDate)){
            throw new IllegalArgumentException("Record Price is required");


        }
        if(!StringUtils.hasText(recordGenre)){
            throw new IllegalArgumentException("Record Price is required");


        }
        if(!StringUtils.hasText(String.valueOf(numberOfTRacks))){
            throw new IllegalArgumentException("Record Price is required");


        }


        //try/ parse game price

        double price;
        try{
            price = Double.parseDouble(recordPrice);
        }catch (Exception exception){
            throw new IllegalArgumentException("unable to parse the game price");

        }

        // save into db

        //find the max game ID(TODO)

        long recordid = recordRepository.findMaxRecordId();


        var record = new Records(recordid, recordName, recordArtist, recordPrice,  recordReleaseDate, recordGenre,  numberOfTRacks);
        recordRepository.addRecord(record);


    }*/

/*    @Override
    public void addRecord(String recordName, String recordArtist, String recordPrice) {

        //
        // validate
        if(!StringUtils.hasText(recordName)){
            throw new IllegalArgumentException("Record Name is required");


        }
        if(!StringUtils.hasText(recordArtist)){
            throw new IllegalArgumentException("Record Artist is required");


        }
        if(!StringUtils.hasText(recordPrice)){
            throw new IllegalArgumentException("Record Price is required");


        }

        //try/ parse game price

        double price;
        try{
            price = Double.parseDouble(recordPrice);
        }catch (Exception exception){
            throw new IllegalArgumentException("unable to parse the game price");

        }

        // save into db

        //find the max game ID(TODO)

        long recordId = recordRepository.findMaxRecordId();


        var record = new Records(Long recordId, String recordName, String recordArtist, Double recordPrice, String recordReleaseDate, String recordGenre, Integer numberOfTRacks);
        recordRepository.addRecord(record);


    }*/









    @Override
    public Records getRecordById(Long recordId) {
        if(recordId == null || recordId <= 0){
            throw new IllegalArgumentException("Game Id is required");
        }
        return recordRepository.getRecordById(recordId);

    }

    @Override
    public void editRecord(Long recordId, String recordName, String recordArtist, Double recordPrice, String recordReleaseDate, String recordGenre, Integer numberOfTracks) {
        var record = recordRepository.getRecordById(recordId);
        if(record == null){
            throw new IllegalArgumentException("Game not found");
        }
        recordRepository.editRecord(
                record,
                recordId,
                recordName,
                recordArtist,
                recordPrice,
                recordReleaseDate,
                recordGenre,
                numberOfTracks);

    }

/*    @Override
    public void editRecord(Long recordId, String recordName, String recordArtist, String recordPrice) {
        var record = recordRepository.getRecordById(recordId);
        if(record == null){
            throw new IllegalArgumentException("Game not found");
        }
        recordRepository.editGame(record, recordId, recordArtist, recordName, recordPrice);

    }*/

    @Override
    public void deleteRecord(Long recordId) {
        recordRepository.deleteRecord(recordId);


    }

    @Override
    public void addRecord( String recordName, String recordArtist, Double recordPrice, String recordReleaseDate, String recordGenre, Integer numberOfTracks) {
        if(!StringUtils.hasText(recordName)){
            throw new IllegalArgumentException("Record Name is required");


        }
        if(!StringUtils.hasText(recordArtist)){
            throw new IllegalArgumentException("Record Artist is required");


        }
        if(!StringUtils.hasText(String.valueOf(recordPrice))){
            throw new IllegalArgumentException("Record Price is required");


        }
        if(!StringUtils.hasText(recordReleaseDate)){
            throw new IllegalArgumentException("Record Price is required");


        }
        if(!StringUtils.hasText(recordGenre)){
            throw new IllegalArgumentException("Record Price is required");


        }
        if(!StringUtils.hasText(String.valueOf(numberOfTracks))){
            throw new IllegalArgumentException("Record Price is required");


        }


        //try/ parse game price

        double price;
        try{
            price = Double.parseDouble(String.valueOf(recordPrice));
        }catch (Exception exception){
            throw new IllegalArgumentException("unable to parse the game price");

        }

        // save into db

        //find the max game ID(TODO)

        long recordid = recordRepository.findMaxRecordId();


        var record = new Records(recordid +1, recordName, recordArtist, recordPrice,  recordReleaseDate, recordGenre,  numberOfTracks);
        recordRepository.addRecord(record);


    }
}
