package Dao;

import Model.Employee;

public class CompanyImpl implements Company {
    private Employee[] employees;
    private int size;

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
}
