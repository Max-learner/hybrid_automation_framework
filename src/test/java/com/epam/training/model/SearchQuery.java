package com.epam.training.model;

import java.util.Objects;

public class SearchQuery {
    private String searchQuery;

    public SearchQuery(String textToSearch){
        this.searchQuery = textToSearch;
    }

    public String getSearchQuery() {
        return searchQuery;
    }

    public void setSearchQuery(String searchQuery) {
        this.searchQuery = searchQuery;
    }

    @Override
    public String toString() {
        return "GoogleCloudPlatformSearchQuery{" +
                "searchQuery='" + searchQuery + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!(o instanceof SearchQuery)) {return false;}
        SearchQuery query = (SearchQuery) o;
        return Objects.equals(query.getSearchQuery(), searchQuery);
    }

    @Override
    public int hashCode() {
        return Objects.hash(searchQuery);
    }
}
