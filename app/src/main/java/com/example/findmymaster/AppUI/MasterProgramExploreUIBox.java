package com.example.findmymaster.AppUI;


public class MasterProgramExploreUIBox {

    private String universityName;
    private String fieldOfStudy;
    private int universityImage;

    public MasterProgramExploreUIBox(String UniversityName, String FieldOfStudy, int universityImage){
        this.universityName = UniversityName;
        this.fieldOfStudy = FieldOfStudy;
        this.universityImage = universityImage;

    }

    public String getUniversityName() {
        return universityName;
    }

    public String getFieldOfStudy() {
        return fieldOfStudy;
    }

    public int getUniversityImage(){return universityImage;}


}
