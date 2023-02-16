package com.store.rcrs.model;

public class Records {
    //
    //instnace data
    private Long recordId;
    private String recordName;
    private String recordArtist;
    private Double recordPrice;
    private String recordReleaseDate;
    private String recordGenre;
    private Integer numberOfTracks;

    public Records(Long recordId, String recordName, String recordArtist, Double recordPrice, String recordReleaseDate, String recordGenre, Integer numberOfTracks) {
        this.recordId = recordId;
        this.recordName = recordName;
        this.recordArtist = recordArtist;
        this.recordPrice = recordPrice;
        this.recordReleaseDate = recordReleaseDate;
        this.recordGenre = recordGenre;
        this.numberOfTracks = numberOfTracks;
    }

    /* public Records(Long recordId, String recordName, String recordArtist, Double recordPrice) {
        this.recordId = recordId;
        this.recordName = recordName;
        this.recordArtist = recordArtist;
        this.recordPrice = recordPrice;
    }*/

    public Long getRecordId() {
        return recordId;
    }

    public void setRecordId(Long recordId) {
        this.recordId = recordId;
    }

    public String getRecordName() {
        return recordName;
    }

    public void setRecordName(String recordName) {
        this.recordName = recordName;
    }

    public String getRecordArtist() {
        return recordArtist;
    }

    public void setRecordArtist(String recordArtist) {
        this.recordArtist = recordArtist;
    }

    public Double getRecordPrice() {
        return recordPrice;
    }

    public void setRecordPrice(Double recordPrice) {
        this.recordPrice = recordPrice;
    }

    public String getRecordReleaseDate() {
        return recordReleaseDate;
    }

    public void setRecordReleaseDate(String recordReleaseDate) {
        this.recordReleaseDate = recordReleaseDate;
    }

    public String getRecordGenre() {
        return recordGenre;
    }

    public void setRecordGenre(String recordGenre) {
        this.recordGenre = recordGenre;
    }

    public Integer getNumberOfTracks() {
        return numberOfTracks;
    }

    public void setNumberOfTracks(Integer numberOfTracks) {
        this.numberOfTracks = numberOfTracks;
    }
}
