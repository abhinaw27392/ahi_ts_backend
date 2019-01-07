package com.ahi.service;

import java.security.Principal;
import java.util.Date;
import java.util.List;

import com.ahi.AHCustomException;
import com.ahi.model.ProjectsModel;
import com.ahi.model.TasksModel;
import com.ahi.model.TimesheetModel;

public interface TimesheetService {

	TimesheetModel addTimesheet(TimesheetModel tm, Principal principal) throws AHCustomException;

	TimesheetModel updateTimesheet(TimesheetModel tm, Principal principal) throws AHCustomException;

	List<TimesheetModel> getAllDatas(Integer empId, Date fromDate, Date toDate) throws AHCustomException;

	List<ProjectsModel> getProjectData() throws AHCustomException;

	List<TasksModel> getTaskData(Integer empId) throws AHCustomException;
}
