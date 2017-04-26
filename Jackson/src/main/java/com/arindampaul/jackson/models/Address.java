package com.arindampaul.jackson.models;

import lombok.Data;

/**
 * @author: arpaul on 4/25/17.
 */
@Data
public class Address {

    private String street;
    private String city;
    private int zipcode;

}
