package com.store.rcrs.service;

import com.store.rcrs.model.Records;

import java.util.List;

public interface RecordService {

    List<Records> getRecord();

    List<Records> searchRecords(String term);


    //void addRecord( String recordName, String recordArtist, Double recordPrice, String recordReleaseDate, String recordGenre, Integer numberOfTRacks);

    Records getRecordById(Long recordId);

    void editRecord(Long recordId, String recordName, String recordArtist, Double recordPrice, String recordReleaseDate, String recordGenre, Integer numberOfTracks);

    void deleteRecord(Long recordId);

    void addRecord(String recordName, String recordArtist, Double recordPrice, String recordReleaseDate, String recordGenre, Integer numberOfTracks);
}
