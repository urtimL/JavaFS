package Interfaces;

import Model.Emplyee;

public abstract interface Company {
    boolean hireEmployee(Emplyee emplyee);
    Emplyee fireEmployee(int id);
    Emplyee findEmployee(int id);
    int numberOfEmployees();
    void printEmployees();
}
