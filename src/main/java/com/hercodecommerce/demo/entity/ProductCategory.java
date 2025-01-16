package com.hercodecommerce.demo.entity;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "product_category")
@Getter
@Setter
public class ProductCategory {

	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id")
	    private Long id;
	 
	    @Column(name="category_name")
	    private String categoryName;
	 
	    @OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
	    private Set<Product> products;

		public ProductCategory() {
			super();
			// TODO Auto-generated constructor stub
		}

		public ProductCategory(Long id, String categoryName, Set<Product> products) {
			super();
			this.id = id;
			this.categoryName = categoryName;
			this.products = products;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getCategoryName() {
			return categoryName;
		}

		public void setCategoryName(String categoryName) {
			this.categoryName = categoryName;
		}

		public Set<Product> getProducts() {
			return products;
		}

		public void setProducts(Set<Product> products) {
			this.products = products;
		}

		
		public String toString() {
			return "ProductCategory [id=" + id + ", categoryName=" + categoryName + ", products=" + products + "]";
		}

	    
	
}
