package com.ahi.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.ahi.entity.AhiUser;
import com.ahi.model.UserModel;

public class AhiTimeSheerUtil {

	public static UserModel getUserModel(AhiUser user) {

		UserModel model = new UserModel();
		if (user != null) {
			model.setActive(user.isActive());
			model.setDesignation(user.getDesignation());
			try {
				model.setDob( new SimpleDateFormat("dd-MM-yyyy").parse(user.getDob()));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			model.setEmail(user.getEmail());
			model.setFirstName(user.getFirstName());
			model.setId(user.getId());
			try {
				model.setJoiningDate( new SimpleDateFormat("dd-MM-yyyy").parse(user.getJoiningDate()));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			model.setLastName(user.getLastName());
			model.setLocation(user.getLocation());
			model.setLoginId(user.getLoginId());
			model.setRole(user.getRole());
			if (user.getSupervisor() != null) {
				model.setSupervisorId(user.getSupervisor().getId());
				model.setSupervisorName(String.format("%s %s", user.getSupervisor().getFirstName(), user.getSupervisor().getLastName()));
			}
			model.setWhenCreated(user.getWhenCreated());
			model.setWhenUpdated(user.getWhenUpdated());
			model.setWhoUpdated(user.getWhoUpdated());
			return model;
		}
		return null;

	}

}
