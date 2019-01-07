package com.ahi.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ahi.AHCustomException;
import com.ahi.entity.AhiUser;
import com.ahi.model.UserModel;
import com.ahi.repository.UserRepository;
import com.ahi.service.UserService;
import com.ahi.util.AhiTimeSheerUtil;
import com.ahi.web.to.PasswordConfirmation;

@Service
public class UserServiceImpl implements UserService {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private UserRepository ahiUserRepository;

	@Value("${password.default}")
	private String dafaultPassword;

	@Override
	public void saveUser(String loginId, UserModel userModel) throws Exception {
		log.info("userid" + userModel.getId());
		log.info("By User: " + loginId);
		AhiUser user =  new AhiUser();
		if (userModel.getId() == null || userModel.getId() == 0) {
			user.setPassword(dafaultPassword);
			Optional<AhiUser> userInDb = ahiUserRepository.findByLoginIdIgnoreCase(userModel.getLoginId());
			if (userInDb.isPresent()) {
				throw new Exception("Login ID already exists. Please enter a different Login ID.");
			}
			user.setWhoCreated(loginId);
			user.setWhenCreated(new Date());
		}
		user.setWhoUpdated(loginId);
		user.setWhenUpdated(new Date());
		ahiUserRepository.save(user);
	}

	@Override
	public List<UserModel> getUsers() {

		Iterator<AhiUser> users = ahiUserRepository.findAll().iterator();
		List<UserModel> models = new ArrayList<UserModel>();
		while (users.hasNext()) {
			models.add(AhiTimeSheerUtil.getUserModel(users.next()));
		}
		return models;
	}

	@Override
	public UserModel getUser(String username) {
		Optional<AhiUser> user = ahiUserRepository.findByLoginIdIgnoreCase(username);

		AhiUser ahiUser = user.get();

		return AhiTimeSheerUtil.getUserModel(ahiUser);
	}

	@Override
	public void changePassword(String loginId, PasswordConfirmation passwordConfirmation) throws Exception {
		Optional<AhiUser> userInDb = ahiUserRepository.findByLoginIdIgnoreCase(loginId);
		if (!userInDb.isPresent()) {
			throw new Exception("User does not exists.");
		}
		AhiUser user = userInDb.get();

		// if (!passwordConfirmation.getPasswordCurrent().equals(user.getPassword())) {
		// 	throw new Exception("Incorrect current password.");
		// }
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		
		System.out.println(passwordEncoder.matches(passwordConfirmation.getPasswordCurrent(), user.getPassword()));

    if (!passwordEncoder.matches(passwordConfirmation.getPasswordCurrent(), user.getPassword())) {
      throw new Exception("Incorrect current password.");
    } 
		user.setPassword(passwordEncoder.encode(passwordConfirmation.getPassword()));
		user.setWhoUpdated(loginId);
		user.setWhenUpdated(new Date());
		ahiUserRepository.save(user);

	}

	@Override
	public UserModel addUser(UserModel um, String userId) throws AHCustomException {
		try {
			AhiUser user = new AhiUser();

			log.info(user.toString());
			log.info("userid is:" + user.getId());
			log.info("By User: " + userId);
			if (user.getId() == null || user.getId() == 0) {

				BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
				String hashedPassword = passwordEncoder.encode(dafaultPassword);
				System.out.println("hashedpassword:" + hashedPassword);
				user.setPassword(hashedPassword);

				Optional<AhiUser> userInDb = ahiUserRepository.findByLoginIdIgnoreCase(user.getLoginId());
				if (userInDb.isPresent()) {
					throw new Exception("Login ID already exists. Please enter a different Login ID.");
				}
				user.setWhoCreated(userId);
				user.setWhenCreated(new Date());
			}
			user.setWhoUpdated(userId);
			user.setWhenUpdated(new Date());

			user.setLoginId(um.getLoginId());
			user.setActive(true);
			System.out.println("Email" + um.getEmail());
			user.setEmail(um.getEmail());
			user.setFirstName(um.getFirstName());
			user.setLastName(um.getLastName());
			try {
				user.setDob( new SimpleDateFormat("dd-MM-yyyy").parse(um.getDob()));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			user.setDesignation(um.getDesignation());
			try {
				user.setJoiningDate( new SimpleDateFormat("dd-MM-yyyy").parse(um.getJoiningDate()));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			user.setRole(um.getRole());
			if (um.getSupervisorId() != null) {
				Optional<AhiUser> supervisor = ahiUserRepository.findById(um.getSupervisorId());
				if (supervisor != null) {
					log.debug("Supervisor details 2::" + supervisor.get().getId());
					user.setSupervisor(supervisor.get());
				}
			}
			user.setLocation(um.getLocation());
			ahiUserRepository.save(user);
			um.setId(user.getId());
			return um;
		} catch (Exception e) {
			log.error("Error while adding user" + e);
			throw new AHCustomException("Error while adding user");
		}
	}

	@Override
	public UserModel updateUser(UserModel um) throws AHCustomException {
		try {
			AhiUser user = ahiUserRepository.findById(um.getId()).get();
			if (user == null)
				throw new AHCustomException("Error wnile udpating user.. No user found for user id:::" + um.getId());
			user.setLoginId(um.getLoginId());
			// user.setPassword(um.getPassword());
			user.setActive(true);
			user.setEmail(um.getEmail());
			user.setFirstName(um.getFirstName());
			user.setLastName(um.getLastName());
			try {
				user.setDob( new SimpleDateFormat("dd-MM-yyyy").parse(um.getDob()));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			user.setDesignation(um.getDesignation());
			try {
				user.setJoiningDate( new SimpleDateFormat("dd-MM-yyyy").parse(um.getJoiningDate()));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			user.setRole(um.getRole());
			user.setLocation(um.getLocation());
			// Optional<AhiUser> userInDb =
			// ahiUserRepository.findByLoginIdIgnoreCase(um.getSupervisorId());
			if (um.getSupervisorId() != null) {
				Optional<AhiUser> supervisor = ahiUserRepository.findById(um.getSupervisorId());
				if (supervisor != null) {
					if (supervisor != null) {
						log.debug("Supervisor details 2::" + supervisor.get().getId());
						user.setSupervisor(supervisor.get());
					}
				}
			}
			ahiUserRepository.save(user);
			return um;
		} catch (Exception e) {
			log.error("Error while adding user");
			throw new AHCustomException("Error while updating user");
		}
	}
	
	@Override
  public List<UserModel> searchUsers(String searchString) {
    Iterator<AhiUser> users = ahiUserRepository.searchUsers(searchString).iterator();
    List<UserModel> models = new ArrayList<UserModel>();
    while (users.hasNext()) {
      models.add(AhiTimeSheerUtil.getUserModel(users.next()));
    }
    return models;
  }

}
