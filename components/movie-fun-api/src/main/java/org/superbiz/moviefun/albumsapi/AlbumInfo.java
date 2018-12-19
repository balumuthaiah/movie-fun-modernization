package org.superbiz.moviefun.albumsapi;

public class AlbumInfo {
    private Long id;
    private String artist;
    private String title;
    private int year;
    private int rating;

    public AlbumInfo(String artist, String title, int year, int rating) {
        this.artist = artist;
        this.title = title;
        this.year = year;
        this.rating = rating;
    }

    public AlbumInfo() {
    }

    public Long getId() {
        return id;
    }

    public String getArtist() {
        return artist;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public int getRating() {
        return rating;
    }
}
