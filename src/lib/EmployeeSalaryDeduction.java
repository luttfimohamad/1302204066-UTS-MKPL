package lib;

public class EmployeeSalaryDeduction {
    public int annualDeductible;

    public void calculateAnnualDeductible(int deductible) {
        this.annualDeductible = deductible;
    }

    public int getAnnualDeductible() {
        return annualDeductible;
    }
}
