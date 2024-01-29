package ru.netology.entity;

import java.util.Objects;

public class Location {
    private final String city;
    private final Country country;
    private final String street;
    private final int building;

    public Location(String city, Country country, String street, int building) {
        this.city = city;
        this.country = country;
        this.street = street;
        this.building = building;
    }

    public String getCity() {
        return city;
    }

    public Country getCountry() {
        return country;
    }

    public String getStreet() {
        return street;
    }

    public int getBuilding() {
        return building;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return Objects.equals(city, location.city)
                && country == location.country
                && Objects.equals(street, location.street)
                && building == location.building;
    }

    @Override
    public String toString() {
        return "Location{" +
                "city='" + city + '\'' +
                ", country=" + country +
                ", street='" + street + '\'' +
                ", building=" + building +
                '}';
    }
}
