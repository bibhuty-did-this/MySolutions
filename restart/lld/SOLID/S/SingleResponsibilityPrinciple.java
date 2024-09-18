package restart.lld.SOLID.S;

/**
 * The Single Responsibility Principle (SRP) states that a class should have only one reason to change, meaning it
 * should have only one responsibility or focus on a single part of the functionality provided by the software.
 */
public class SingleResponsibilityPrinciple {
    public static void main(String[] args) {
        Employee employee = new Employee("John", 20, 40);
        System.out.println("Salary calculated the wrong way: " + employee.calculateSalary());

        SalaryCalculator salaryCalculator = new SalaryCalculator();

        // Salary calculation is now handled by a dedicated class
        System.out.println("Salary calculated the right way: " + salaryCalculator.calculateSalary(employee));
    }
}

