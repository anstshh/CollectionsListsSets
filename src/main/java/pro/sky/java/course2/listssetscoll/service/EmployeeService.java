package pro.sky.java.course2.listssetscoll.service;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import pro.sky.java.course2.listssetscoll.exception.EmployeeAlreadyAddedException;
import pro.sky.java.course2.listssetscoll.exception.EmployeeNotFoundException;
import pro.sky.java.course2.listssetscoll.exception.EmployeeStorageIsFullException;
import pro.sky.java.course2.listssetscoll.model.Employee;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeService {

    private static final int SIZE = 4;

    private final Map<String, Employee> employees;

    public EmployeeService() {
        this.employees = new HashMap<>();
    }


    public Employee add(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.containsKey(employee.getFullName())) {
            throw new EmployeeAlreadyAddedException();
        }
        employees.put(employee.getFullName(), employee);
        return employee;
    }


    public Employee remove(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.containsKey(employee.getFullName())) {
            return employees.remove(employee.getFullName());
        }
        throw new EmployeeNotFoundException();
    }


    public Employee find(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.containsKey(employee.getFullName())) {
            return employees.get(employee.getFullName());
        }
        throw new EmployeeNotFoundException();
    }
}


