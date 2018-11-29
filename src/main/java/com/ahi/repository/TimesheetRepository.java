package com.ahi.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.ahi.entity.AhiTimesheet;

public interface TimesheetRepository extends CrudRepository<AhiTimesheet, Integer> {

//	Iterable<AhiTimesheet> findAllByempIdAndDateBetweenOrderByDate(Integer empId, Date fromDate, Date toDate);
//
//	Iterable<AhiTimesheet> findAllByempIdGroupByProjectNameAndDateBetweenOrderByDateAsc(Integer empId, Date fromDate,
//			Date toDate);

	@Query("SELECT ahi from AhiTimesheet ahi  where ahi.empId=:empId and ahi.date between :fromDate  and :toDate "
			+ "ORDER BY ahi.project.projectName Asc, ahi.task.taskName Asc, ahi.date Asc")
	Iterable<AhiTimesheet> findAllByempId(Integer empId, Date fromDate, Date toDate);

}
