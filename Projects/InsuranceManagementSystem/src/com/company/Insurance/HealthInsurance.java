package com.company.Insurance;

import java.time.LocalDate;

public class HealthInsurance extends Insurance{
    public HealthInsurance(double price, LocalDate startDateInsurance, LocalDate endDateInsurance) {
        super(price, startDateInsurance, endDateInsurance);
        this.name = "Health Insurance";
    }

    @Override
    public void calculate() {
        System.out.println("Health Insurance Calculate");
    }
}
