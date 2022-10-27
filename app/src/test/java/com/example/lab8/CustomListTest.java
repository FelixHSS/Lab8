package com.example.lab8;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


//import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {
    private CustomList list;
    /**
     * create a mocklist for my citylist
     * @return
     */
    public CustomList MockCityList(){
        list = new CustomList(null,new ArrayList<>());
        return list;
    }

    /**
     * get the size of the list
     * increase the list by adding a new city
     * check if our current size matches the initial size plus
     one
     */
    @Test
    public void addCityTest(){
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(),listSize + 1);
    }

    @Test
    public void hasCityTest() {
        list = MockCityList();
        list.addCity(new City("Edmonton", "AB"));
        assertTrue(list.hasCity(new City("Edmonton", "AB")));
    }

    @Test
    public void deleteCityTest() {
        list = MockCityList();
        int listSize = list.getCount();
        City city = new City("Estevan", "SK");
        list.addCity(city);
        assertEquals(list.getCount(),listSize + 1);
        list.deleteCity(city);
        assertEquals(list.getCount(),listSize);
    }

    @Test
    public void countCityTest() {
        list = MockCityList();
        assertEquals(list.countCities(), 0);
        list.addCity(new City("Edmonton", "AB"));
        assertEquals(list.countCities(), 1);
    }
}
