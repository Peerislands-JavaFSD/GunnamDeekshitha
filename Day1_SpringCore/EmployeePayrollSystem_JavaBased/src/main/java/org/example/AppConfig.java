package org.example;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig{
    @Bean
    public TaxCalculator taxCalculator(){
        return new IncomeTaxCalculator();
    }
    @Bean
    public BonusScheme bonusScheme(){
        return new PerformanceBonus();
    }
    @Bean
    public PayrollProcessor payrollProcessor(){
        PayrollProcessor payrollProcessor=new PayrollProcessor(taxCalculator(),"TechCorp Solutions",2026);
        payrollProcessor.setBonusScheme(bonusScheme());
        return payrollProcessor;
    }
}