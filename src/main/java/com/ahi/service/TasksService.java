package com.ahi.service;

import java.security.Principal;
import java.util.List;

import com.ahi.AHCustomException;
import com.ahi.model.TasksModel;

public interface TasksService {

	TasksModel addTask(TasksModel tm, Principal principal) throws AHCustomException;

	boolean deleteTask(Integer taskId) throws AHCustomException;

	TasksModel updateTask(TasksModel tm, Principal principal) throws AHCustomException;

	List<TasksModel> getAllTasks() throws AHCustomException;

	List<TasksModel> getTasksForUser(Integer userId) throws AHCustomException;

	List<TasksModel> getAllTasks(Integer empId) throws AHCustomException;

}
