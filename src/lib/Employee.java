package lib;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class Employee {

	// Employe Personal Information
	private EmployeePersonalInformation employeePersonalInformation;

	// Employee Salary Grade
	private EmployeeSalaryGrade employeeSalaryGrade;

	// Employee Additional Income
	private EmployeeAdditionalIncome employeeAdditionalIncome;

	// Employee Salary Deduction
	private EmployeeSalaryDeduction employeeSalaryDeduction;

	// dependentInformation
	private EmployeeDependent employeeDependent;

	public Employee(String employeeId, String firstName, String lastName, String idNumber, String address,
			LocalDate joinDate, boolean isForeigner, EmployeePersonalInformation.Gender gender) {
		this.employeePersonalInformation = new EmployeePersonalInformation(employeeId, firstName, lastName, idNumber,
				address, joinDate, gender);
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
