package com.example.sb_online_shop.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity
public class Car {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    private String brand, model, color, registeredNumber;
    
    @Column(name = "annee")
    private int year;
    private double price;

    public Car(){}

    public Car(String brand, String model, String color, String registeredNumber, int year, double price, Owner owner) {
        super();
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.registeredNumber = registeredNumber;
        this.year = year;
        this.price = price;
        this.owner = owner;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner")
    private Owner owner;

    public long getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public String getRegisteredNumber() {
        return registeredNumber;
    }

    public int getYear() {
        return year;
    }

    public double getPrice() {
        return price;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setRegisteredNumber(String registeredNumber) {
        this.registeredNumber = registeredNumber;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }



}
