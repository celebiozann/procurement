package com.example.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import io.swagger.annotations.ApiModel;


@ApiModel(description = "Class representing a Activity in the application.")
@Entity
public class Activity implements Serializable{
	
	private static final long serialVersionUID = 9090219604628894232L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String header;
	
	private String name;
	
	private String shortDescription;
	
	private String procurementChannel;
	
	private Date dateOfCreation;
	
	private String author;
	
	private Integer quantity;
	
	private BigDecimal price;
	
	private Integer status;
	
	

	public Activity() {
	}
	
	public Activity(Long id, String header, String name, String shortDescription, String procurementChannel,
			Date dateOfCreation, String author, Integer quantity, BigDecimal price, Integer status) {
		super();
		this.id = id;
		this.header = header;
		this.name = name;
		this.shortDescription = shortDescription;
		this.procurementChannel = procurementChannel;
		this.dateOfCreation = dateOfCreation;
		this.author = author;
		this.quantity = quantity;
		this.price = price;
		this.status = status;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getProcurementChannel() {
		return procurementChannel;
	}

	public void setProcurementChannel(String procurementChannel) {
		this.procurementChannel = procurementChannel;
	}

	public Date getDateOfCreation() {
		return dateOfCreation;
	}

	public void setDateOfCreation(Date dateOfCreation) {
		this.dateOfCreation = dateOfCreation;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Activity [id=" + id + ", header=" + header + ", name=" + name + ", shortDescription=" + shortDescription
				+ ", procurementChannel=" + procurementChannel + ", dateOfCreation=" + dateOfCreation + ", author="
				+ author + ", quantity=" + quantity + ", price=" + price + ", status=" + status + "]";
	}
	
	public String concateableFields() {
		StringBuilder sb = new StringBuilder().append(this.author).append(this.header)
				.append(this.name).append(id).append(shortDescription).append(procurementChannel);
				
		return sb.toString() ;				
	}
	

}
