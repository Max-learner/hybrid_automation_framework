package com.epam.training.service;

import com.epam.training.model.EmailAddress;
import com.epam.training.page.EmailServicePage;

public class EmailAddressCreator {
    private static final String DEFAULT_ADDRESS = "zemautraummudei-6596@yopmail.com";

    public static EmailAddress withRequiredData(EmailServicePage emailServicePage){
        return new EmailAddress(emailServicePage.getEmail());
    }
    public static EmailAddress withNullData(){
        return new EmailAddress(null);
    }
    public static EmailAddress withEmptyData(){
        return new EmailAddress("");
    }
    public static EmailAddress withDefaultData(){
        return new EmailAddress(DEFAULT_ADDRESS);
    }
}
