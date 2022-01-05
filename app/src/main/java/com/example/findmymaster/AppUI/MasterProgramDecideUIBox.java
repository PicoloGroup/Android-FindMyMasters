package com.example.findmymaster.AppUI;

public class MasterProgramDecideUIBox {

    private String CountryName;
    private String UniversityName;
    private String FieldOfStudy;
    private String ProgramRank;
    private String ProgramCost;
    private String ProgramDuration;
    private String ProgramLanguage;

    public MasterProgramDecideUIBox(String countryName, String universityName, String fieldOfStudy,
                                    String programRank, String programCost, String programDuration, String programLanguage) {
        CountryName = countryName;
        UniversityName = universityName;
        FieldOfStudy = fieldOfStudy;
        ProgramRank = programRank;
        ProgramCost = programCost;
        ProgramDuration = programDuration;
        ProgramLanguage = programLanguage;
    }

    public String getCountryName() {
        return CountryName;
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

    public String getProgramDuration() {
        return ProgramDuration;
    }

    public String getProgramLanguage() {
        return ProgramLanguage;
    }
}
