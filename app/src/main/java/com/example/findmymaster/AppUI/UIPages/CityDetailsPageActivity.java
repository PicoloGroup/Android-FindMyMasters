package com.example.findmymaster.AppUI.UIPages;

import android.os.Bundle;
import android.widget.TextView;

import com.example.findmymaster.AppUI.UIBase;
import com.example.findmymaster.EventSystem.EventDispatcher;
import com.example.findmymaster.R;

public class CityDetailsPageActivity extends UIBase {

    private TextView countryName;
    private TextView cityName;
    private TextView qualityLifeIndex;
    private TextView purchasingPowerIndex;
    private TextView safetyIndex;
    private TextView healthCareIndex;
    private TextView costOfLivingIndex;
    private TextView propertyPriceToIncomeRatio;
    private TextView trafficCommuteTimeIndex;
    private TextView pollutionIndex;
    private TextView climateIndex;

    public CityDetailsPageActivity() {
        super(EventDispatcher.getInstance());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_details_page);

        //Hooks
        countryName = findViewById(R.id.CityDetailsPage_countryName);
        cityName = findViewById(R.id.CityDetailsPage_cityName);
        qualityLifeIndex = findViewById(R.id.CityDetailsPage_qualityOfLifeIndexValue);
        purchasingPowerIndex = findViewById(R.id.CityDetailsPage_purchasingPowerIndexValue);
        safetyIndex = findViewById(R.id.CityDetailsPage_safetyIndexValue);
        healthCareIndex = findViewById(R.id.CityDetailsPage_healthCareIndexValue);
        costOfLivingIndex = findViewById(R.id.CityDetailsPage_costOfLivingIndexValue);
        propertyPriceToIncomeRatio = findViewById(R.id.CityDetailsPage_propertyPriceToIncomeRatioIndexValue);
        trafficCommuteTimeIndex = findViewById(R.id.CityDetailsPage_trafficCommuteTimeIndexValue);
        pollutionIndex = findViewById(R.id.CityDetailsPage_pollutionIndexValue);
        climateIndex = findViewById(R.id.CityDetailsPage_climateIndexValue);

    }
}