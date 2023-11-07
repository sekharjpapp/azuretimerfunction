package com.pixel;

import java.time.*;
import java.util.ArrayList;
import java.util.List;

import com.microsoft.azure.functions.annotation.*;
import com.microsoft.azure.functions.*;
import com.pixel.config.AppConfig;
import com.pixel.dao.EmployeeDAO;
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
        try {
            context.getLogger().info("Java Timer trigger function executed at: " + LocalDateTime.now());
            AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
            EmployeeDAO personDAO = ctx.getBean(EmployeeDAO.class);
            for (Employee p : personDAO.getAllPersons()) {
                System.out.println(p);
            }
        } catch (Exception ex) {
            context.getLogger().info("timerInfo Function failed.Error:  " + ex.getMessage());
        }
    }
}
