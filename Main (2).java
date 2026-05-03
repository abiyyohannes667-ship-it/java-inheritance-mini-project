class Person {

    protected String name;

    Person(String name) {
        this.name = name; 
        System.out.println("Person constructor");
    }

    void show() {
        System.out.println("Name: " + name);
    }

    final void info() { 
        System.out.println("Final Method");
    }

    static void type() { 
        System.out.println("Person Type");
    }
}
class Employee extends Person {

    int salary;

    Employee(String name, int salary) {

        super(name); 

        this.salary = salary;

        System.out.println("Employee constructor");
    }

    @Override 
    void show() {

        super.show(); 

        System.out.println("Salary: " + salary);
    }

    static void type() { 
        System.out.println("Employee Type");
    }
}

class Manager extends Employee {

    String department;

    Manager(String name, int salary, String department) {

        super(name, salary);

        this.department = department;

        System.out.println("Manager constructor");
    }

    @Override
    void show() {
        super.show();
        System.out.println("Department: " + department);
    }
}

class Intern extends Person {

    Intern(String name) {

        super(name);

        System.out.println("Intern constructor");
    }
}


final class Boss extends Manager {

    Boss(String name, int salary, String department) {
        super(name, salary, department);
    }
}


public class Main {

    public static void main(String[] args) {

        Manager m = new Manager("Yohannes", 5000, "IT");

        System.out.println("\n--- Manager Info ---");
        m.show();

        m.info();

        // method hiding
        Person.type();
        Employee.type();

        System.out.println("\n--- Intern Info ---");

        Intern i = new Intern("Abel");
        i.show();
    }
}