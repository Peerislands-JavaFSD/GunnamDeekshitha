package org.example;
import org.springframework.stereotype.Component;

@Component
public class PerformanceBonus implements BonusScheme{
    public double calculateBonus(double salary){
        return salary*0.10;
    }
}