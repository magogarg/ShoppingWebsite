package com.shoppingcart.dao;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.shoppingcart.model.Cart;

@Repository
@Transactional
public interface CartDao {
	public Cart save(Cart cart);
}
