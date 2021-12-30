package com.example.demo.forms;



import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


import java.io.Serializable;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import lombok.Data;

@Data
public class ItemForm implements Serializable {
	private static final long serialVersionUID = -6647247658748349084L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotBlank
	@Size(max = 10)
	private String name;

	@NotBlank
	@Size(max = 400)
	private String description;

	@NotBlank
	private String price;
	
	public void clear() {
		name = null;
		description = null;
		price = null;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}


	
}
