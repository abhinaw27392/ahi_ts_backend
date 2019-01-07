package com.ahi.service;

import java.security.Principal;
import java.util.List;

import com.ahi.AHCustomException;
import com.ahi.model.DepartmentsModel;

public interface DepartmentService {

	DepartmentsModel addDepartment(DepartmentsModel dm, Principal principal) throws AHCustomException;

	boolean deleteDepartment(Integer DepartmentId) throws AHCustomException;

	DepartmentsModel updateDepartment(DepartmentsModel dm, Principal principal) throws AHCustomException;

	List<DepartmentsModel> getAllDepartments() throws AHCustomException;


}
