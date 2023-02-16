package com.store.rcrs.repository.impl;

import com.store.rcrs.model.Records;
import com.store.rcrs.repository.RecordRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.stream.Collectors;


@Repository
public class RecordRepositoryImpl implements RecordRepository {


    //
    // instance data
    private List<Records> records;

    public RecordRepositoryImpl() {

        //
        // developer managed instance
        records = new ArrayList<>();
    }

    @Override
    public List<Records> getRecord() {

        return records;
    }

    @Override
    public void addRecord(Records record) {
        records.add(record);

    }

    @Override
    public List<Records> searchRecords(String term) {
        return records.stream().filter(
                g -> g.getRecordName().toLowerCase(Locale.ROOT).contains(term.toLowerCase(Locale.ROOT))
        ).collect(Collectors.toList());



    }

    @Override
    public long findMaxRecordId() {
        var recordIdList = records.stream().map(Records::getRecordId).collect(Collectors.toList());
        long max = Integer.MIN_VALUE;
        for(long i: recordIdList){
            max = Math.max(max, i);
        }
        return max;

    }

    @Override
    public Records getRecordById(Long recordId) {
        var filtered = records.stream().filter(r -> Objects.equals(r.getRecordId(), recordId)).collect(Collectors.toList());
        if(filtered.size() > 0){
            return filtered.get(0);
        }
        throw new IllegalStateException("Game not found with ID" + recordId);






    }

    @Override
    public void editRecord(Records record, Long recordId, String recordName, String recordArtist, Double recordPrice, String recordReleaseDate, String recordGenre, Integer numberOfTracks) {
        record.setRecordName(recordName);
        record.setRecordId(recordId);
        record.setRecordArtist(recordArtist);
        record.setRecordPrice(recordPrice);
        record.setRecordGenre(recordGenre);
        record.setNumberOfTracks(numberOfTracks);
        record.setRecordReleaseDate(recordReleaseDate);
    }

    @Override
    public void deleteRecord(Long recordId) {
        this.records = this.records.stream().filter(r -> !Objects.equals(r.getRecordId(), recordId)).collect(Collectors.toList());

    }
}




































