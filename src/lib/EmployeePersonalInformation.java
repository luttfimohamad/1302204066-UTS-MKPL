package lib;

import java.time.LocalDate;

public class EmployeePersonalInformation {
    public enum Gender {
        Man,
        Woman
    }

    private String employeeId;
    private String firstName;
    private String lastName;
    private String idNumber;
    private String address;
    private LocalDate joinDate;
    private Gender gender;

    public EmployeePersonalInformation() {
    }

    public EmployeePersonalInformation(String employeeId, String firstName, String lastName, String idNumber,
            String address, LocalDate joinDate, Gender gender) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.idNumber = idNumber;
        this.address = address;
        this.joinDate = joinDate;
        this.gender = gender;
    }
}
