package com.company.Insurance;

import java.time.LocalDate;

public class CarInsurance extends Insurance{

    public CarInsurance(double price, LocalDate startDateInsurance, LocalDate endDateInsurance) {
        super(price, startDateInsurance, endDateInsurance);
        this.name = "Car Insurance";
    }

    @Override
    public void calculate() {
        System.out.println("Car Insurance Calculate");
    }
}
