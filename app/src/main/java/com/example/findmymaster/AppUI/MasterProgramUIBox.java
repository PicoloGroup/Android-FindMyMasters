package com.example.findmymaster.AppUI;

public class MasterProgramUIBox {

    private String UniversityName;
    private String FieldOfStudy;

    public MasterProgramUIBox (String UniversityName,String FieldOfStudy){
        this.UniversityName = UniversityName;
        this.FieldOfStudy = FieldOfStudy;
    }

    public String getUniversityName() {
        return UniversityName;
    }

    public void setUniversityName(String universityName) {
        UniversityName = universityName;
    }

    public String getFieldOfStudy() {
        return FieldOfStudy;
    }

    public void setFieldOfStudy(String fieldOfStudy) {
        FieldOfStudy = fieldOfStudy;
    }
}

