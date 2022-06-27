package com.company.Insurance;

import java.time.LocalDate;

public class TravelInsurance extends Insurance{
    public TravelInsurance(double price, LocalDate startDateInsurance, LocalDate endDateInsurance) {
        super(price, startDateInsurance, endDateInsurance);
        this.name = "Travel Insurance";
    }

    @Override
    public void calculate() {
        System.out.println("Travel Insurance Calculate");
    }
}
