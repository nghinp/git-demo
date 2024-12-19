import java.util.Random;

// Employee class
abstract class Employee {
    private String name;
    private int id;

    public Employee() {
        // Default constructor
    }

    public Employee(String empName, int empId) {
        this.name = empName;
        this.id = empId;
    }

    public abstract boolean work();

    @Override
    public String toString() {
        return "Employee Name: " + name + ", Employee ID: " + id;
    }
}

// SoftwareEngineer class
class SoftwareEngineer extends Employee {
    public SoftwareEngineer() {
        super();
    }

    public SoftwareEngineer(String empName, int empId) {
        super(empName, empId);
    }

    @Override
    public boolean work() {
        Random crisisGen = new Random();
        if (crisisGen.nextInt(10) == 0) {
            System.out.println(toString() + " is programming...");
            return false; // Crisis occurred
        } else {
            System.out.println(toString() + " is programming...");
            return true; // No crisis
        }
    }

    @Override
    public String toString() {
        return "SoftwareEngineer: " + super.toString();
    }
}

// Manager interface
interface Manager {
    void handleCrisis();
}

// SoftwareManager class
class SoftwareManager extends SoftwareEngineer implements Manager {
    public SoftwareManager() {
        super();
    }

    public SoftwareManager(String empName, int empId) {
        super(empName, empId);
    }

    @Override
    public boolean work() {
        Random crisisGen = new Random();
        if (crisisGen.nextInt(10) == 0) {
            System.out.println(toString() + " is handling a crisis...");
            return false; // Crisis occurred
        } else {
            System.out.println(toString() + " is programming...");
            return true; // No crisis
        }
    }

    @Override
    public void handleCrisis() {
        System.out.println(toString() + " is handling a crisis...");
    }

    @Override
    public String toString() {
        return "SoftwareManager: " + super.toString();
    }
}

// Executive class
class Executive extends Employee implements Manager {
    public Executive() {
        super();
    }

    public Executive(String empName, int empId) {
        super(empName, empId);
    }

    @Override
    public boolean work() {
        System.out.println(toString() + " is playing golf...");
        return true; // Executives cannot cause a crisis
    }

    @Override
    public void handleCrisis() {
        System.out.println(toString() + " is handling a crisis...");
    }

    @Override
    public String toString() {
        return "Executive: " + super.toString();
    }
}

// CompanySimulator class
public class CompanySimulator {
    private Employee[] employees;

    public CompanySimulator(Employee[] employees) {
        this.employees = employees;
    }

    public void simulateWorkDay() {
        for (Employee emp : employees) {
            boolean result = emp.work();
            if (!result) {
                manageCrisis(emp);
            }
        }
    }

    public void manageCrisis(Employee emp) {
        int index = -1;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == emp) {
                index = i;
                break;
            }
        }

        if (index > 0) {
            Employee manager = employees[index - 1];
            if (manager instanceof Manager) {
                ((Manager) manager).handleCrisis();
            } else if (manager instanceof SoftwareManager) {
                for (int i = index - 1; i >= 0; i--) {
                    if (employees[i] instanceof Executive) {
                        ((Executive) employees[i]).handleCrisis();
                        break;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Employee[] employees = new Employee[5];
        employees[0] = new Executive("John Doe", 1001);
        employees[1] = new SoftwareManager("Alice Smith", 2001);
        employees[2] = new SoftwareEngineer("Bob Johnson", 3001);
        employees[3] = new SoftwareEngineer("Eva Williams", 3002);
        employees[4] = new SoftwareEngineer("Charlie Brown", 3003);

        CompanySimulator simulator = new CompanySimulator(employees);
        simulator.simulateWorkDay();
    }
}

