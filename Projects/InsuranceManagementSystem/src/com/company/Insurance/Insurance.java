package com.company.Insurance;

import java.time.LocalDate;

public abstract class Insurance {
    String name;
    double price;
    LocalDate startDateInsurance, endDateInsurance;

    public Insurance(double price, LocalDate startDateInsurance, LocalDate endDateInsurance){
        this.price = price;
        this.startDateInsurance = startDateInsurance;
        this.endDateInsurance = endDateInsurance;
    }

    public abstract void calculate();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDate getStartDateInsurance() {
        return startDateInsurance;
    }

    public void setStartDateInsurance(LocalDate startDateInsurance) {
        this.startDateInsurance = startDateInsurance;
    }

    public LocalDate getEndDateInsurance() {
        return endDateInsurance;
    }

    public void setEndDateInsurance(LocalDate endDateInsurance) {
        this.endDateInsurance = endDateInsurance;
    }
}
