package com.example.findmymaster.AppUI;


public class MasterProgramExploreUIBox {

    private String universityName;
    private String fieldOfStudy;
    private String price;
    private String duration;
    private String language;
    private String date;
    private String city;
    private String country;
    private int universityImage;

    public MasterProgramExploreUIBox(String universityName, String fieldOfStudy, String price, String duration, String language, String date, String city, String country, int universityImage) {
        this.universityName = universityName;
        this.fieldOfStudy = fieldOfStudy;
        this.price = price;
        this.duration = duration;
        this.language = language;
        this.date = date;
        this.city = city;
        this.country = country;
        this.universityImage = universityImage;
    }

    public String getUniversityName() {
        return universityName;
    }

    public String getFieldOfStudy() {
        return fieldOfStudy;
    }

    public String getPrice() {
        return price;
    }

    public String getDuration() {
        return duration;
    }

    public String getLanguage() {
        return language;
    }

    public String getDate() {
        return date;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public int getUniversityImage() {
        return universityImage;
    }
}
