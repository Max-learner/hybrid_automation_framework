package com.epam.training.service;

import com.epam.training.model.DataForPricing;
import com.epam.training.model.SearchQuery;

public class DataForPricingCreator {
//    public static final String MACHINES_AMOUNT = "4";
    public static final String TESTDATA_MACHINES_AMOUNT = "testdata.machines.amount";
    public static final String NEGATIVE_MACHINES_AMOUNT = "-1";
    public static final String ZERO_MACHINES_AMOUNT = "0";

//    public static DataForPricing withRequiredData(){
//        return new DataForPricing(MACHINES_AMOUNT);
//    }
    public static DataForPricing withRequiredData(){
        return new DataForPricing(TestDataReader.getTestData(TESTDATA_MACHINES_AMOUNT));
    }
    public static DataForPricing withNegativeData(){
        return new DataForPricing(NEGATIVE_MACHINES_AMOUNT);
    }
    public static DataForPricing withEmptyData(){
        return new DataForPricing(ZERO_MACHINES_AMOUNT);
    }
}

