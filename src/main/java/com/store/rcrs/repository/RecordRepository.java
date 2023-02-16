package com.store.rcrs.repository;

import com.store.rcrs.model.Records;

import java.util.List;

public interface RecordRepository {
    List<Records> getRecord();

    void addRecord(Records records);

    List<Records> searchRecords(String term);

    long findMaxRecordId();

    Records getRecordById(Long recordId);

    void editRecord(Records record, Long recordId, String recordName, String recordArtist, Double recordPrice, String recordReleaseDate, String recordGenre, Integer numberOfTRacks);

    void deleteRecord(Long recordId);
}
