package com.ahi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.ahi.entity.AhiUser;

public interface UserRepository extends CrudRepository<AhiUser, Integer>{

	Optional<AhiUser> findByLoginIdIgnoreCase(String userName);
	
	@Query("SELECT au FROM AhiUser au where  lower(au.firstName) like lower(concat('%', :searchString, '%')) "
			+ " or lower(au.lastName) like lower(concat('%', :searchString, '%'))")
	public List<AhiUser> searchUsers(@Param("searchString") String searchString);
}
