package com.pixel;

import java.time.*;
import java.util.List;
import java.util.stream.Collectors;

import com.microsoft.azure.functions.annotation.*;
import com.microsoft.azure.functions.*;
import com.pixel.config.AppConfig;
import com.pixel.dao.EmployeeDaoImpl;
import com.pixel.model.Employee;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Azure Functions with Timer trigger.
 */
public class TimerTriggerJava {

    /**
     * This function will be invoked periodically according to the specified schedule.
     */
    @FunctionName("TimerTriggerJava")
    public void run(
        @TimerTrigger(name = "timerInfo", schedule = "0/5 0/1 * * * *") String timerInfo,
        final ExecutionContext context) {
        AnnotationConfigApplicationContext ctx = null;
        try {
            context.getLogger().info("Java Timer trigger function executed at: " + LocalDateTime.now());
            ctx = new AnnotationConfigApplicationContext(AppConfig.class);
            EmployeeDaoImpl employeeDAO = ctx.getBean(EmployeeDaoImpl.class);

            /*for (Employee p : personDAO.getAllPersons()) {
                System.out.println(p);
            }*/
            //personDAO.getAllPersons().forEach(System.out::println);
            /*List<Employee> employees = personDAO.getAllPersons().stream()
                    .collect(Collectors.toList());
            System.out.println(employees);*/

            fetchAllEmployeesInfo(employeeDAO);

             employeeDAO.getListOfEmp();
        } catch (Exception ex) {
            context.getLogger().info("timerInfo Function failed.Error:  " + ex.getMessage());
        }
    }
    private static void fetchAllEmployeesInfo(EmployeeDaoImpl employeeService) {
        List<Employee> employees = employeeService.getAllPersons().stream().collect(Collectors.toList());
        System.out.println(employees);
        //employeeService.getAllPersons().forEach(System.out::println);
    }
}
