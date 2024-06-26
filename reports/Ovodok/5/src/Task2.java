import java.util.ArrayList;
import java.util.List;

class Employee{
    private String name;
    private int id;
    private double salary;
    private double finalSalary;
    private double bonus = 0;

    public Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBaseSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public double getSalary() {
        return salary;
    }

    public double getFinalSalary() {
        return finalSalary;
    }

    public void setFinalSalary(double finalSalary) {
        this.finalSalary = finalSalary;
    }
    public void doWork(){}
}
class Manager extends Employee {

    public Manager(String name, int employeeId, double baseSalary) {
        super(name, employeeId, baseSalary);
    }

    @Override
    public void doWork() {
        System.out.println("Я " + this.getName() + " менеджер, и я разделяю и властвую");
    }

    public void awarding(Employee employee, double bonus) {
        employee.setBonus(employee.getBonus() + bonus);
        System.out.println("Менеджер " + this.getName() + " награждает сотрудника " + employee.getName());
    }
}
class Booker extends Employee {

    public Booker(String name, int employeeId, double baseSalary) {
        super(name, employeeId, baseSalary);
    }

    @Override
    public void doWork() {
        System.out.println("Я " + this.getName() + " бухгалтер, и я устал заполнять бумажки");
    }

    public void calculateSalary(Employee employee) {
        employee.setFinalSalary(employee.getBonus() + employee.getBaseSalary());
        employee.setBonus(0.0);
        System.out.println("Бухгалтер " + this.getName() + " расчитал зп сотрудника " + employee.getName());
        System.out.println("Его зарплата = " + employee.getFinalSalary());
    }
}
class Programmer extends Employee {

    public Programmer(String name, int employeeId, double baseSalary) {
        super(name, employeeId, baseSalary);
    }
    @Override
    public void doWork() {
        System.out.println("Я " + this.getName() + " программист, и я кроКОДИЛ, кроКОЖУ и буду кроКОДИТЬ");
    }

}
class Tester extends Employee {

    public Tester(String name, int employeeId, double baseSalary) {
        super(name, employeeId, baseSalary);
    }
    @Override
    public void doWork() {
        System.out.println("Я " + this.getName() + " тестировщик, и я... яяя...эхх ладно....");
    }
}
class Designer extends Employee {

    public Designer(String name, int employeeId, double baseSalary) {
        super(name, employeeId, baseSalary);
    }
    @Override
    public void doWork() {
        System.out.println("Я " + this.getName() + " дизайнер, и программист меня любит");
    }

}

class Analyst extends Employee {

    public Analyst(String name, int employeeId, double baseSalary) {
        super(name, employeeId, baseSalary);
    }
    @Override
    public void doWork() {
        System.out.println("Я " + this.getName() + " аналитик, и я хочу домой");
    }

}

public class Task2 {
    public static void main(String[] args) {

        Manager manager = new Manager("Vadim", 1, 1000);
        Booker booker = new Booker("Vlad", 2, 700);
        Programmer programmer = new Programmer("Dima", 3, 900);
        Tester tester = new Tester("Maxim", 4, 700);
        Analyst analyst = new Analyst("Roma", 5, 800);
        Designer designer = new Designer("Mike", 6, 800);

        List<Employee> employees = new ArrayList<>();

        employees.add(manager);
        employees.add(booker);
        employees.add(programmer);
        employees.add(tester);
        employees.add(analyst);
        employees.add(designer);

        for (Employee employee:employees){
            employee.doWork();
            booker.calculateSalary(employee);
        }
        manager.awarding(booker, 100);
        manager.awarding(designer, 200);

        booker.calculateSalary(booker);
        booker.calculateSalary(designer);

    }
}
