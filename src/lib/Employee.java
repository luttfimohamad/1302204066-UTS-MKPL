package lib;

import java.time.LocalDate;

public class Employee {

	private EmployeePersonalInformation employeePersonalInformation;
	private EmployeeSalaryGrade employeeSalaryGrade;
	private EmployeeDependent employeeDependent;
	private EmployeeAdditionalIncome employeeAdditionalIncome;
	private EmployeeSalaryDeduction employeeSalaryDeduction;

	public Employee(EmployeePersonalInformation personalInformation, boolean isForeigner) {
		this.employeePersonalInformation = personalInformation;
		this.employeeSalaryGrade = new EmployeeSalaryGrade();
		this.employeeDependent = new EmployeeDependent();
	}

	public int getAnnualIncomeTax() {
		// Menghitung berapa lama pegawai bekerja dalam setahun ini, jika pegawai sudah
		// bekerja dari tahun sebelumnya maka otomatis dianggap 12 bulan.
		LocalDate currentDate = LocalDate.now();
		int monthWorkingInYear = employeePersonalInformation.joinDate.until(currentDate).getMonths();

		return TaxFunction.calculateTax(employeeSalaryGrade.monthlySalary, employeeAdditionalIncome.otherMonthlyIncome,
				monthWorkingInYear, employeeSalaryDeduction.annualDeductible,
				employeeDependent.spouseIdNumber.equals(""), employeeDependent.childIdNumbers.size());
	}
}
