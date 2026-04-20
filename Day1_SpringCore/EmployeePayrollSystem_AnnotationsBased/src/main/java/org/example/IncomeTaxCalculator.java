package org.example;

import org.springframework.stereotype.Component;

@Component
public class IncomeTaxCalculator implements TaxCalculator{
    public double calculateTax(double salary){
        return salary*0.20;
    }
}