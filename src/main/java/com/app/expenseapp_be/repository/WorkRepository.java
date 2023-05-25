package com.app.expenseapp_be.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.app.expenseapp_be.model.Work;





public interface WorkRepository extends JpaRepository<Work,Long> {

    public Work findByDescription(String description);

}
