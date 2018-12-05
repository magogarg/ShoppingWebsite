package com.shoppingcart.service;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoppingcart.dao.CartDao;
import com.shoppingcart.dao.ProductDao;
import com.shoppingcart.dao.UserDao;
import com.shoppingcart.model.Cart;
import com.shoppingcart.model.Product;
import com.shoppingcart.model.User;

@Service
@Transactional
public class RegistrationService {
	@Autowired
	UserDao userDao;
	@Autowired
	ProductDao productDao;
	@Autowired
	CartDao cartDao;

	public String addUser(User user) {
		if (userDao.existsByEmail(user.getEmail())) {
			return "userexists";
		} else if (user.getPassword().length() < 6) {
			return "Weak Password";
		} else {
			userDao.save(user);
			return "success";
		}
	}

	public String login(User user, HttpSession httpSession) {
		if (userDao.existsByEmail(user.getEmail()) && userDao.existsByPassword(user.getPassword())) {
			httpSession.setAttribute("username", user.getEmail());
			return (String) httpSession.getAttribute("username");
		} else {
			return "failure";
		}
	}

	public String addCart(int id,String userName) {
		Product product=productDao.findOne(id);
		User user=userDao.findByEmail(userName);
		if(product.getProductStock()<1) {
			return "stocknull";
		}
		else if(userName.isEmpty()){
			return "login";
		}
		else {
			Cart cart=new Cart();
			cart.setProduct(product);
			cart.setUser(user);
			cartDao.save(cart);
			System.out.println(cart);
			return "success";
		}
	}
	public List<Cart> viewCart(String userName){
		User user=userDao.findByEmail(userName);
		if(userName.isEmpty()){
			return null;
		}
		else {
			return cartDao.findByUser(user);
		}
	}
}
