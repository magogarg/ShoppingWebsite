package com.shoppingcart.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id")
	private int productId;

	@Column(name = "product_name")
	private String productName;

	@Column(name = "product_description")
	private String productDescription;

	@Column(name = "product_price")
	private int productPrice;

	@Column(name = "product_stock")
	private int productStock;

	@Column(name = "product_image")
	private String productImage;

	@Column(name = "delivery_duration")
	private String deliveryDuration;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_category")
	private ProductCategory productCategory;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "product_category")
	public ProductCategory getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(ProductCategory productCategory) {
		this.productCategory = productCategory;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	public int getProductStock() {
		return productStock;
	}

	public void setProductStock(int productStock) {
		this.productStock = productStock;
	}

	public String getProductImage() {
		return productImage;
	}

	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}

	public String getDeliveryDuration() {
		return deliveryDuration;
	}

	public void setDeliveryDuration(String deliveryDuration) {
		this.deliveryDuration = deliveryDuration;
	}

}
