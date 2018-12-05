package com.shoppingcart.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.shoppingcart.model.Cart;
import com.shoppingcart.model.User;

@Repository
@Transactional
public interface CartDao extends CrudRepository<Cart, Integer>{
	@SuppressWarnings("unchecked")
	public Cart save(Cart cart);
	public List<Cart> findByUser(User userId);
}
