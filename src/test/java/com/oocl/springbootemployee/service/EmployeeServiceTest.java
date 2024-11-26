package com.oocl.springbootemployee.service;

import com.oocl.springbootemployee.Exception.EmployeeAgeNotValidException;
import com.oocl.springbootemployee.Exception.EmployeeSalaryNotValidException;
import com.oocl.springbootemployee.model.Employee;
import com.oocl.springbootemployee.model.Gender;
import com.oocl.springbootemployee.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceTest {

    public static final String INVALID_SALARY_FOR_EMPLOYEE_AGED_BELOW_18_OR_ABOVE_65 = "Invalid Salary For Employee aged 30 or above.";
    public static final String INVALID_AGE_FOR_EMPLOYEE = "Invalid Age for Employee.";

    @Mock
    EmployeeRepository  mockedEmployeeRepository;

    @InjectMocks
    EmployeeService employeeService;

    @Test
    void should_return_the_given_employees_when_getAllEmployees() {
        //given
        when(mockedEmployeeRepository.getAll()).thenReturn(List.of(new Employee(1, "Lucy", 18, Gender.FEMALE, 8000.0)));

        //when
        List<Employee> allEmployees = employeeService.getAllEmployees();

        //then
        assertEquals(1, allEmployees.size());
        assertEquals("Lucy", allEmployees.get(0).getName());
    }

    @Test
    void should_return_the_created_employee_when_create_given_a_employee() {
        //given
        Employee lucy = new Employee(1, "Lucy", 18, Gender.FEMALE, 8000.0);
        doReturn(lucy).when(mockedEmployeeRepository).addEmployee(any());

        //when
        Employee createdEmployee = employeeService.create(lucy);

        //then
        assertEquals("Lucy", createdEmployee.getName());
    }

    @Test
    void should_throw_EmployeeAgeNotValidException_when_create_employee_with_age_lower_than_18(){
        Employee tim = new Employee(10, "Peter", 9, Gender.MALE, 1.0);
        assertThrows(
                EmployeeAgeNotValidException.class,
                () -> employeeService.create(tim),
                INVALID_AGE_FOR_EMPLOYEE
        );
    }

    @Test
    void should_throw_EmployeeAgeNotValidException_when_create_employee_with_age_above_65(){
        Employee tim = new Employee(10, "Tim", 20000, Gender.MALE, 1.0);
        assertThrows(
                EmployeeAgeNotValidException.class,
                () -> employeeService.create(tim),
                INVALID_AGE_FOR_EMPLOYEE
        );
    }
}

