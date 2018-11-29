package com.shoppingcart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.shoppingcart.dao.ProductDao;
import com.shoppingcart.model.Product;

@RestController
public class AppController {
	@Autowired 
	ProductDao  productDao;
	
	@RequestMapping(value="/")
	public List<Product> getProductCategories() {
		return productDao.findAll();
	}
}
