package Test;

import Dao.CompanyImpl;
import Model.Employee;
import Model.Engineer;
import Model.Worker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class CompanyImplTest {

    CompanyImpl company;
    Employee[] employees;

    @BeforeEach
    void setUp() {
        company = new CompanyImpl(5);

        employees = new Employee[4];
        employees[0] = new Engineer(1,"Eva", 1990, 10, true, 50, 80);
        employees[1] = new Worker(2,"Tom", 1995, 5, false, 30, 100);
        employees[2] = new Engineer(3,"John", 2000, 2, true, 30, 50);
        employees[3] = new Worker(4,"Bob", 2001, 1, false, 15, 100);

        for (int i = 0; i < employees.length; i++) {
            company.hireEmployee(employees[i]);
        }
    }

    @Test
    void hireEmployee() {
        System.out.println("================ hireEmployee ==================");
        System.out.println("пытаемся добавить null, и двух сотрудников:");
        System.out.println("1. Engineer(5,\"Den\", 1998, 4, true, 40, 50)");
        System.out.println("2. Engineer(6,\"Nick\", 1999, 3, true, 35, 50)");
        System.out.println("получаем результат:");
        company.hireEmployee(null);
        company.hireEmployee(new Engineer(5,"Den", 1998, 4, true, 40, 50));
        company.hireEmployee(new Engineer(6,"Nick", 1999, 3, true, 35, 50));
        company.printEmployees();
        System.out.println("null и 2-й сотрудник не добавились:");
        System.out.println("- программой предусмотрен запрет на добовление null");
        System.out.println("- 2 сотрудник не добавился из за переполнения массива (этот массив максимум на 5 сотрудников)");
    }

    @Test
    void fireEmployee() {
        System.out.println("================ fireEmployee ==================");
        System.out.println("пробуем уволить сотрудников с id: 3 и 5");
        System.out.println("получаем результат:");
        company.fireEmployee(3);
        company.fireEmployee(5);
        company.printEmployees();
    }

    @Test
    void findEmployee() {
        System.out.println("================ findEmployee ==================");
        System.out.println("пробуем найти сотрудников с id: 3 и 5");
        System.out.println("получаем результат:");
        System.out.println(company.findEmployee(3));
        System.out.println(company.findEmployee(5));
    }

    @Test
    void numberOfEmployees() {
        System.out.println("================ numberOfEmployees ==================");
        System.out.println("количество сотрудников - " + company.numberOfEmployees());
    }

    @Test
    void printEmployees() {
        System.out.println("=================== printEmployees ====================");
        company.printEmployees();
    }

    @Test
    void findEmployeeByExperience() {
        System.out.println("=================== findEmployeeByExperience ====================");
        System.out.println("Выборка сотрудников: имеющих стаж более 5 лет");
        Employee[] emp = company.findEmployeeByExperience(5, 50);
        printArray(emp);
    }

    @Test
    void findEmployeeBySalary() {
        System.out.println("=================== findEmployeeBySalary ====================");
        System.out.println("Выборка сотрудников: имеющих зарплату менее 2000 евро");
        Employee[] emp = company.findEmployeeBySalary(0, 2000);
        printArray(emp);
    }

    @Test
    void findEmployeeByHigherEducation() {
        System.out.println("=================== findEmployeeByHigherEducation ====================");
        System.out.println("Выборка сотрудников: не имеющих высшее образование");
        Employee[] emp = company.findEmployeeByHigherEducation();
        printArray(emp);
    }

    @Test
    void testSortStringByAge() {
        System.out.println("================= testSortStringByAge =================");
        System.out.println("Сортировка сотрудников: по возрасту");
        company.sortStringByAge();
        company.printEmployees();
    }

    @Test
    void testSortStringByExperience() {
        System.out.println("================= testSortStringByExperience =================");
        System.out.println("Сортировка сотрудников: по стажу работы в компании");
        company.sortStringByExperience();
        company.printEmployees();
    }

    @Test
    void testSortStringBySalary() {
        System.out.println("================= testSortStringBySalary =================");
        System.out.println("Сортировка сотрудников: по величине зарплаты");
        Employee[] emp = company.getEmployees();
        company.sortStringBySalary();
        company.printEmployees();
    }

    @Test
    void testSortStringByEducation() {
        System.out.println("================= testSortStringByEducation =================");
        System.out.println("Сортировка сотрудников: по образованию");
        company.sortStringByEducation();
        company.printEmployees();
    }

    public void printArray(Object[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] != null){
                System.out.println(arr[i]);
            }
        }
    }
}