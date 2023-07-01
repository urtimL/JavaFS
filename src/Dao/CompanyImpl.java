package Dao;

import Model.Employee;
import Model.Engineer;
import Model.Worker;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Predicate;

public class CompanyImpl implements Company {
    private Employee[] employees;
    private int size;

    public CompanyImpl(int capacity) {
        this.employees = new Employee[capacity];
        this.size = 0;
    }

    public Employee[] getEmployees() {
        return employees;
    }

    public int getSize() {
        return size;
    }

    @Override
    public boolean hireEmployee(Employee employee) {
        //проверка на null
        if(employee == null) {
            return false;
        }

        //проверка на заполненность массива employees
        if(employees.length < size + 1){
            return false;
        }

        //проверка на повтор (если в массиве уже есть элемент с таким id
        //то его нельзя добавлять)
        if(findEmployee(employee.getId()) != null){
            return false;
        }

        //добавим сотрудника в массив
        employees[size++] = employee;

        return true;
    }

    @Override
    public Employee fireEmployee(int id) {
        Employee emp = findEmployee(id);

        if(emp == null){
            return null;
        }

        boolean needToMove = false;
        for (int i = 0; i < size; i++) {
            if(needToMove){
                employees[i] = employees[i + 1];
            }
            if(employees[i].getId() == id) {
                employees[i] = employees[i + 1];
                needToMove = true;
                size--;
            }
        }

        return emp;
    }

    @Override
    public Employee findEmployee(int id) {
        if(size == 0) {
            return null;
        }

        for (int i = 0; i < size; i++) {
            if(employees[i].getId() == id) {
                return employees[i];
            }
        }
        return null;
    }

    @Override
    public int numberOfEmployees() {
        return size;
    }

    @Override
    public void printEmployees() {
        for (int i = 0; i < size; i++) {
            System.out.println(employees[i]);
        }
    }

    public Employee[] findCarByPredicate(Predicate<Employee> predicate){
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (predicate.test(employees[i])) {
                count++;
            }
        }

        if(count == 0){
            return null;
        }

        Employee[] res = new Employee[count];
        for (int i = 0, j = 0; j < res.length; i++) {
            if (predicate.test(employees[i])) {
                res[j++] = employees[i];
            }
        }

        return res;
    }



    public Employee[] findEmployeeByExperience(int minExp, int maxExp) {
        return findCarByPredicate(e -> (e.getExperience() >= minExp && e.getExperience() <= maxExp));
    }

    public Employee[] findEmployeeBySalary(int minSalary, int maxSalary) {
        Predicate<Employee> predicate = new Predicate<>() {
            @Override
            public boolean test(Employee employee) {
                double sel = getSalary(employee);

                return sel >= minSalary && sel <= maxSalary;
            }
        };

        return findCarByPredicate(predicate);
    }

    public Employee[] findEmployeeByHigherEducation() {
        return findCarByPredicate(e -> !e.isHigherEducation());
    }

    public void sortStringByAge(){
        Arrays.sort(employees, (s1, s2) -> (s1 == null || s2 == null) ? 0 : s1.getYearOfBirth() - s2.getYearOfBirth());
    }

    public void sortStringByExperience(){
        Arrays.sort(employees, (s1, s2) -> (s1 == null || s2 == null) ? 0 : s1.getExperience() - s2.getExperience());
    }

    public void sortStringByEducation(){
        Arrays.sort(employees, (s1, s2) -> (s1 == null || s2 == null) ? 0 :
                ((s1.isHigherEducation() ? 0 : 1) - ((s2.isHigherEducation() ? 0 : 1))));
    }

    public void sortStringBySalary(){
        Arrays.sort(employees, (s1, s2) -> (s1 == null || s2 == null) ? 0 : (int) (getSalary(s1) - getSalary(s2)));
    }

    private double getSalary (Employee e){
        double res = 0.0;

        if(e instanceof Worker){
            res = ((Worker) e).getSalary();
        } else if (e instanceof Engineer) {
            res = ((Engineer) e).getSalary();
        }

        return res;
    }
}
