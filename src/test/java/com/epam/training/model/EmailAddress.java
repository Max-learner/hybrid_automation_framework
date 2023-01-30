package com.epam.training.model;

import java.util.Objects;

public class EmailAddress {
    private String recepientEmailAddress;

    public EmailAddress(String recepientEmailAddress) {
        this.recepientEmailAddress = recepientEmailAddress;
    }

    public String getRecepientEmailAddress() {
        return recepientEmailAddress;
    }

    public void setRecepientEmailAddress(String recepientEmailAddress) {
        this.recepientEmailAddress = recepientEmailAddress;
    }

    @Override
    public String toString() {
        return "EmailAddress{" +
                "recepientEmailAddress='" + recepientEmailAddress + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmailAddress that = (EmailAddress) o;
        return Objects.equals(recepientEmailAddress, that.recepientEmailAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(recepientEmailAddress);
    }
}
