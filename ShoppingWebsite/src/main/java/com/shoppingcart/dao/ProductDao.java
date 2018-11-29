package com.shoppingcart.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.shoppingcart.model.Product;

@Repository
@Transactional
public interface ProductDao extends CrudRepository<Product, Integer> {
	@Query("select distinct p.productId,p.productName,p.productDescription,p.productPrice,p.productStock,p.productImage,p.deliveryDuration,pc.productCategoryName from Product p LEFT JOIN p.productCategory pc")
	public List<Product> findAll();
}