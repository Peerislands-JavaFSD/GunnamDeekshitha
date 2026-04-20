package org.example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PayrollProcessor {
    private final TaxCalculator taxCalculator;
    private final String companyName="TechCorp Solutions";
    private final int fiscalYear=2026;
    private BonusScheme bonusScheme;
    @Autowired
    public PayrollProcessor(TaxCalculator taxCalculator){
        this.taxCalculator=taxCalculator;
    }
    @Autowired
    public void setBonusScheme(BonusScheme bonusScheme){
        this.bonusScheme=bonusScheme;
    }
    public void processSalary(String employeeName, double grossSalary){
        double tax=taxCalculator.calculateTax(grossSalary);
        double netSalary=grossSalary-tax;
        System.out.println("Company: "+companyName+" | Year: "+fiscalYear);
        System.out.println("Employee: "+employeeName);
        System.out.println("Gross: "+grossSalary+" | Tax: "+tax+" | Net: "+netSalary);
    }
    public void processWithBonus(String employeeName, double grossSalary){
        processSalary(employeeName,grossSalary);
        if(bonusScheme!=null){
            double bonus=bonusScheme.calculateBonus(grossSalary);
            System.out.println("Bonus: " + bonus);
        }
        else{
            System.out.println("No bonus scheme");
        }
    }
}