package restart.lld.SOLID.S;

// SalaryCalculator class only handles salary calculation (SRP applied)
class SalaryCalculator {
    // Salary calculation logic is moved to its own class
    public double calculateSalary(Employee employee) {
        return employee.getHourlyRate() * employee.getHoursWorked();
    }
}
