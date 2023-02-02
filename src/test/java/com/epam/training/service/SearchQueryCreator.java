package com.epam.training.service;

import com.epam.training.model.SearchQuery;

public class SearchQueryCreator {

    public static final String TESTDATA_SEARCH_QUERY = "testdata.search.query";

    public static SearchQuery withRequiredData(){
        return new SearchQuery(TestDataReader.getTestData(TESTDATA_SEARCH_QUERY));
    }

    public static SearchQuery withEmptyData(){
        return new SearchQuery("");
    }
}
