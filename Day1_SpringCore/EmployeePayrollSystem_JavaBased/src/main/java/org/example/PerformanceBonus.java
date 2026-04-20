package org.example;

public class PerformanceBonus implements BonusScheme {
    public double calculateBonus(double salary){
        return salary*0.10;
    }
}
