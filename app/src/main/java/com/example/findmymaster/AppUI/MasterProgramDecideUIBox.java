package com.example.findmymaster.AppUI;

public class MasterProgramDecideUIBox {

    private String CountryName;
    private String UniversityName;
    private String FieldOfStudy;
    private String ProgramRank;
    private String ProgramCost;
    private String ProgramDuration;
    private String ProgramLanguage;
    private String CityName;
    private String Date;
    private int UniversityImage;

    public MasterProgramDecideUIBox(String countryName,String cityName, String universityName, String fieldOfStudy,
                                    String programRank, String programCost, String programDuration, String date, String programLanguage,int universityImage) {
        CountryName = countryName;
        CityName = cityName;
        UniversityName = universityName;
        FieldOfStudy = fieldOfStudy;
        ProgramRank = programRank;
        ProgramCost = programCost;
        ProgramDuration = programDuration;
        Date = date;
        ProgramLanguage = programLanguage;
        UniversityImage = universityImage;
    }

    public String getCountryName() {
        return CountryName;
    }

    public String getCityName() {
        return CityName;
    }

    public String getUniversityName() {
        return UniversityName;
    }

    public String getFieldOfStudy() {
        return FieldOfStudy;
    }

    public String getProgramRank() {
        return ProgramRank;
    }

    public String getProgramCost() {
        return ProgramCost;
    }

    public String getDate(){return Date;}

    public String getProgramDuration() {
        return ProgramDuration;
    }

    public String getProgramLanguage() {
        return ProgramLanguage;
    }

    public int getUniversityImage() { return UniversityImage; }
}
