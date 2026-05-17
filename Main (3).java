import java.util.ArrayList;
import java.util.Scanner;

abstract class Person {

    private String name;
    protected int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("Person constructor");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    abstract void showDetails();

    final void info() {
        System.out.println("This is a final method");
    }

    static void type() {
        System.out.println("Person Type");
    }
}

class Employee extends Person {

    private int salary;

    Employee(String name, int age, int salary) {

        super(name, age);

        this.salary = salary;

        System.out.println("Employee constructor");
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    void showDetails() {

        System.out.println("Name: " + getName());
        System.out.println("Age: " + age);
        System.out.println("Salary: " + salary);
    }

    static void type() {
        System.out.println("Employee Type");
    }
}

class Manager extends Employee {

    private String department;

    Manager(String name, int age, int salary, String department) {

        super(name, age, salary);

        this.department = department;

        System.out.println("Manager constructor");
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    void showDetails() {

        super.showDetails();

        System.out.println("Department: " + department);
    }
}

class Intern extends Person {

    private int duration;

    Intern(String name, int age, int duration) {

        super(name, age);

        this.duration = duration;

        System.out.println("Intern constructor");
    }

    @Override
    void showDetails() {

        System.out.println("Intern Name: " + getName());
        System.out.println("Age: " + age);
        System.out.println("Internship Duration: " + duration + " months");
    }
}

final class Boss extends Manager {

    Boss(String name, int age, int salary, String department) {

        super(name, age, salary, department);
    }
}

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Person> people = new ArrayList<>();

        try {

            System.out.print("Enter Manager Name: ");
            String managerName = sc.nextLine();

            System.out.print("Enter Age: ");
            int managerAge = sc.nextInt();

            System.out.print("Enter Salary: ");
            int salary = sc.nextInt();

            sc.nextLine();

            System.out.print("Enter Department: ");
            String department = sc.nextLine();

            Manager m = new Manager(managerName, managerAge, salary, department);

            System.out.println("\n--- Manager Details ---");

            Person p = m;

            p.showDetails();

            p.info();

            people.add(m);

            System.out.println("\n--- Intern Details ---");

            Intern i = new Intern("Abel", 20, 6);

            people.add(i);

            for (Person person : people) {

                System.out.println("\nDisplaying Information:");

                person.showDetails();
            }

            System.out.println("\n--- Static Methods ---");

            Person.type();
            Employee.type();

        }

        catch (Exception e) {

            System.out.println("Invalid Input! Please enter correct data.");
        }

        sc.close();
    }
}