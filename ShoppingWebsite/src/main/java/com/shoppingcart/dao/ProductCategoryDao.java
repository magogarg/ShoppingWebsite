package com.shoppingcart.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.shoppingcart.model.ProductCategory;

@Repository
@Transactional
public interface ProductCategoryDao extends CrudRepository<ProductCategory, Integer> {
	public List<ProductCategory> findAll();
}
