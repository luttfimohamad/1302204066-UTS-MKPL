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
	private int otherMonthlyIncome;

	// Employee Salary Deduction
	private EmployeeSalaryDeduction employeeSalaryDeduction;

	// dependentInformation
	private String spouseName;
	private String spouseIdNumber;

	private List<String> childNames;
	private List<String> childIdNumbers;

	public Employee(String employeeId, String firstName, String lastName, String idNumber, String address,
			LocalDate joinDate, boolean isForeigner, EmployeePersonalInformation.Gender gender) {
		this.employeePersonalInformation = new EmployeePersonalInformation(employeeId, firstName, lastName, idNumber,
				address, joinDate, gender);
		this.employeeSalaryGrade = new EmployeeSalaryGrade();

		childNames = new LinkedList<String>();
		childIdNumbers = new LinkedList<String>();
	}

	public void setAdditionalIncome(int income) {
		this.otherMonthlyIncome = income;
	}

	public void setSpouse(String spouseName, String spouseIdNumber) {
		this.spouseName = spouseName;
		this.spouseIdNumber = idNumber;
	}

	public void addChild(String childName, String childIdNumber) {
		childNames.add(childName);
		childIdNumbers.add(childIdNumber);
	}

	public int getAnnualIncomeTax() {

		// Menghitung berapa lama pegawai bekerja dalam setahun ini, jika pegawai sudah
		// bekerja dari tahun sebelumnya maka otomatis dianggap 12 bulan.
		LocalDate currentDate = LocalDate.now();
		int monthWorkingInYear = joinDate.until(currentDate).getMonths();

		return TaxFunction.calculateTax(monthlySalary, otherMonthlyIncome, monthWorkingInYear, annualDeductible,
				spouseIdNumber.equals(""), childIdNumbers.size());
	}
}
