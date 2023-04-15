package lib;

public class EmployeeSalaryDeduction {
    private int annualDeductible;

    public void calculateAnnualDeductible(int deductible) {
        this.annualDeductible = deductible;
    }

    public int getAnnualDeductible() {
        return annualDeductible;
    }
}
