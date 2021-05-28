package com.begers.northwind.entities.concoretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="categories")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","products"})
public class Category {

	@Id
	@Column(name="category_id")
	private int categoryId;
	
	@Column(name="category_name")
	private String categryName;
	
	@OneToMany(mappedBy = "category")
	private List<Product> products;
}
