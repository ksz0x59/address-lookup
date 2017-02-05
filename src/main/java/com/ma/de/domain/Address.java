package com.ma.de.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by mariuszdekarski on 02/02/2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Address {

    private String summaryline;
    private String organisation;
    private String buildingname;
    private String number;
    private String premise;
    private String street;
    private String posttown;
    private String county;

    public Address() {
    }

    public Address(String number, String street) {
        this.number = number;
        this.street = street;
    }

    public String getSummaryline() {
        return summaryline;
    }

    public void setSummaryline(String summaryline) {
        this.summaryline = summaryline;
    }

    public String getOrganisation() {
        return organisation;
    }

    public void setOrganisation(String organisation) {
        this.organisation = organisation;
    }

    public String getBuildingname() {
        return buildingname;
    }

    public void setBuildingname(String buildingname) {
        this.buildingname = buildingname;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPremise() {
        return premise;
    }

    public void setPremise(String premise) {
        this.premise = premise;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPosttown() {
        return posttown;
    }

    public void setPosttown(String posttown) {
        this.posttown = posttown;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Address address = (Address) o;

        if (summaryline != null ? !summaryline.equals(address.summaryline) : address.summaryline != null) return false;
        if (organisation != null ? !organisation.equals(address.organisation) : address.organisation != null)
            return false;
        if (buildingname != null ? !buildingname.equals(address.buildingname) : address.buildingname != null)
            return false;
        if (number != null ? !number.equals(address.number) : address.number != null) return false;
        if (premise != null ? !premise.equals(address.premise) : address.premise != null) return false;
        if (street != null ? !street.equals(address.street) : address.street != null) return false;
        if (posttown != null ? !posttown.equals(address.posttown) : address.posttown != null) return false;
        return county != null ? county.equals(address.county) : address.county == null;
    }

    @Override
    public int hashCode() {
        int result = summaryline != null ? summaryline.hashCode() : 0;
        result = 31 * result + (organisation != null ? organisation.hashCode() : 0);
        result = 31 * result + (buildingname != null ? buildingname.hashCode() : 0);
        result = 31 * result + (number != null ? number.hashCode() : 0);
        result = 31 * result + (premise != null ? premise.hashCode() : 0);
        result = 31 * result + (street != null ? street.hashCode() : 0);
        result = 31 * result + (posttown != null ? posttown.hashCode() : 0);
        result = 31 * result + (county != null ? county.hashCode() : 0);
        return result;
    }
}
