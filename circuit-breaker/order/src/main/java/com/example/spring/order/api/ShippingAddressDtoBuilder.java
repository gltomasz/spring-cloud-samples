package com.example.spring.order.api;

class ShippingAddressDtoBuilder {
    private String street;
    private String city;
    private String address;

    ShippingAddressDtoBuilder setStreet(String street) {
        this.street = street;
        return this;
    }

    ShippingAddressDtoBuilder setCity(String city) {
        this.city = city;
        return this;
    }

    ShippingAddressDtoBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    ShippingAddressDto createShippingAddress() {
        return new ShippingAddressDto(street, city, address);
    }
}