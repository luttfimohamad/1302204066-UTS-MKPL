package lib;

public class EmployeeSalaryGrade {
    public int monthlySalary;

    /**
     * Fungsi untuk menentukan gaji bulanan pegawai berdasarkan grade kepegawaiannya
     * (grade 1: 3.000.000 per bulan, grade 2: 5.000.000 per bulan, grade 3:
     * 7.000.000 per bulan)
     * Jika pegawai adalah warga negara asing gaji bulanan diperbesar sebanyak 50%
     */

    public int calculateMonthlySalary(int grade, boolean isForeigner) {
        if (grade == 1) {
            monthlySalary = 3000000;
            if (isForeigner) {
                monthlySalary = (int) (monthlySalary * 1.5);
            }
        } else if (grade == 2) {
            monthlySalary = 5000000;
            if (isForeigner) {
                monthlySalary = (int) (monthlySalary * 1.5);
            }
        } else if (grade == 3) {
            monthlySalary = 7000000;
            if (isForeigner) {
                monthlySalary = (int) (monthlySalary * 1.5);
            }
        }
        return monthlySalary;
    }
}
