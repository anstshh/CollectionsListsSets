package pro.sky.java.course2.listssetscoll.service;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import pro.sky.java.course2.listssetscoll.exception.EmployeeAlreadyAddedException;
import pro.sky.java.course2.listssetscoll.exception.EmployeeNotFoundException;
import pro.sky.java.course2.listssetscoll.exception.EmployeeStorageIsFullException;
import pro.sky.java.course2.listssetscoll.model.Employee;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    private static final int SIZE = 4;

    private final List<Employee> employees = new ArrayList<>(SIZE);
    public List<Employee> list;

    @PostConstruct
    public void init() {
        employees.add(new Employee("Иван", "Иванов"));
        employees.add(new Employee("Саша", "Сашова"));
        employees.add(new Employee("Паша", "Павлов"));
    }

    public Employee add(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.size() < SIZE) {
            for (Employee emp : employees) {
                if (emp.equals(employee)) {
                    throw new EmployeeAlreadyAddedException();
                }
            }
            employees.add(employee);
            return employee;
        }
        throw new EmployeeStorageIsFullException();

    }

    public Employee find(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        for (Employee emp : employees) {
            if (employee.equals(emp)) {
                return employee;
            }
        }
        throw new EmployeeNotFoundException();
    }

    public Employee remove(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.remove(employee)) {
            return employee;
        }
        throw new EmployeeNotFoundException();
    }
}

