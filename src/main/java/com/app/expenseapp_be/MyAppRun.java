package com.app.expenseapp_be;

//import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//import com.app.expenseapp_be.model.Work;
import com.app.expenseapp_be.service.WorkService;

@Component
public class MyAppRun implements CommandLineRunner {
    
    @Autowired
    WorkService workService;

    public void run(String... argas) throws Exception{

        //Work w1 = new Work("income", "null", "1000", "stipendio", LocalDate.of(2023, 4, 19));

        //workService.saveWork(w1);
        //Work w2 = new Work("null", "expend", "100", "divisa", LocalDate.of(2023, 4, 19));
        //workService.saveWork(w2);

        //workService.deleteWorkByDesk("Gain");
    }
}
