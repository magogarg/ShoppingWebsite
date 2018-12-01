package com.shoppingcart.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.shoppingcart.model.User;

@Repository
@Transactional
public interface UserDao extends CrudRepository<User, Integer> {
	@SuppressWarnings("unchecked")
	public User save(User user);
	public User findByUserId(int userId);
	
	@Query("SELECT CASE WHEN COUNT(u) > 0 THEN true ELSE false END FROM User u WHERE u.email = :email")
	public boolean existsByEmail(@Param("email") String email);
	
	@Query("SELECT CASE WHEN COUNT(u) > 0 THEN true ELSE false END FROM User u WHERE u.password = :password")
	public boolean existsByPassword(@Param("password") String password);
	
	public User findByEmail(String email);
}
