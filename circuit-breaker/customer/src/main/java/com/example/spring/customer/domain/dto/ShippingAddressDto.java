package com.example.spring.customer.domain.dto;

public class ShippingAddressDto {

    private String street;
    private String city;
    private String address;

    ShippingAddressDto(String street, String city, String address) {
        this.street = street;
        this.city = city;
        this.address = address;
    }

    public ShippingAddressDto() {
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
