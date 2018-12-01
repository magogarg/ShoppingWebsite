package com.shoppingcart.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.shoppingcart.dao.ProductDao;
import com.shoppingcart.model.Product;
import com.shoppingcart.model.ProductCategory;
import com.shoppingcart.model.User;
import com.shoppingcart.service.RegistrationService;

@Component
@RestController
public class AppController {
	@Autowired 
	ProductDao  productDao;
	@Autowired 
	RegistrationService userService;
	
	@RequestMapping(value="/")
	public List<Product> getProductCategories() {
		return productDao.findAll();
	}
	
	@RequestMapping(value="/category/{id}")
	public List<Product> getProductsByCategory(@PathVariable("id") int id) {
		ProductCategory productCategory=new ProductCategory();
		productCategory.setProductCategoryId(id);
		return productDao.findByProductCategory(productCategory);
	}
	@RequestMapping(value="/product/{id}")
	public Product getProductById(@PathVariable("id") int id) {
		return productDao.findOne(id);
	}
	@RequestMapping(value="/register",method = RequestMethod.POST)
	public String addUser(@RequestBody User user) {
		return userService.addUser(user);
	}
	@RequestMapping(value="/login",method = RequestMethod.POST)
	public String loginUser(@RequestBody User user,HttpSession httpSession) {
		return userService.login(user,httpSession);
	}
	@RequestMapping(value="/addcart/{id}")
	public String addCart(@PathVariable("id") int id,HttpSession httpSession) {
		String userName="";
		if(httpSession.getAttribute("username")!=null) {
			userName=httpSession.getAttribute("username").toString();
		}
		return userService.addCart(id,userName);
	}
}
