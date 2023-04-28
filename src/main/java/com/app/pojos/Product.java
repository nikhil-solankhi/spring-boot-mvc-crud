package com.app.pojos;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="productdata")
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Product{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(length = 100)
	private String name;
	@Column(length = 100)
	private String details;
	@Column
	private double price;
	@Column
	private double discount;
	
	
	
}
