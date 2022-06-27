package com.company.Insurance;

import java.time.LocalDate;

public class ResidenceInsurance extends Insurance{
    public ResidenceInsurance(double price, LocalDate startDateInsurance, LocalDate endDateInsurance) {
        super(price, startDateInsurance, endDateInsurance);
        this.name = "Residence Insurance";
    }

    @Override
    public void calculate() {
        System.out.println("Residence Insurance Calculate");
    }
}
