package Dao;

import Model.Employee;

public abstract interface Company {
    boolean hireEmployee(Employee emplyee);
    Employee fireEmployee(int id);
    Employee findEmployee(int id);
    int numberOfEmployees();
    void printEmployees();
}
