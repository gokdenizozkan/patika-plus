package patikaplus.week2.salarycalculator;

public class Employee {
    String name;
    float salary;
    float workHours;
    int hireYear;

    public Employee(String name, int salary, int workHours, int hireYear) {
        setName(name);
        setSalary(salary);
        setWorkHours(workHours);
        setHireYear(hireYear);
    }

    public float tax() {
        if (getSalary() <= 1000) return 0.0f;
        else return getSalary() * 0.03f;
    }

    public float bonus() {
        return getWorkHours() > 40 ? getWorkHours() * 30.0f : 0.0f;
    }

    public float raiseSalary() {
        // 2021 is the current year.
        int workingYears = 2021 - getHireYear();

        if (workingYears < 10) return getSalary() * 0.05f;
        else if (workingYears < 20) return getSalary() * 0.1f;
        else return getSalary() * 0.15f;
    }

    @Override
    public String toString() {
        return "Name: " + getName() + "\nSalary: " + getSalary() + "\nWorking hours: " + getWorkHours() + "\nTax: " + tax() + "\nBonus: " + bonus() + "\nSalary raise: " + raiseSalary() + "\nNet salary: " + (getSalary() + bonus() - tax()) + "\nGross salary: " + (getSalary() + bonus());
    }

    public String getName() {
        return name;
    }

    public float getSalary() {
        return salary;
    }

    public float getWorkHours() {
        return workHours;
    }

    public int getHireYear() {
        return hireYear;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public void setWorkHours(float workHours) {
        this.workHours = workHours;
    }

    public void setHireYear(int hireYear) {
        this.hireYear = hireYear;
    }
}
