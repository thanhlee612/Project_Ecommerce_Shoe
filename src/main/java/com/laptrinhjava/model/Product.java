package com.laptrinhjava.model;

public class Product extends AbstractModel<Product> {
	private Integer id;
	private String pname;
	private String image;
	private float price;
	private String title;
	private String pdescription;
	private int cateID;

	public Product() {}

	public Product(Integer id, String pname, String image, float price, String title, String pdescription, int cateID) {
		this.id = id;
		this.pname = pname;
		this.image = image;
		this.price = price;
		this.title = title;
		this.pdescription = pdescription;
		this.cateID = cateID;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPdescription() {
		return pdescription;
	}

	public void setPdescription(String pdescription) {
		this.pdescription = pdescription;
	}

	public int getCateID() {
		return cateID;
	}

	public void setCateID(int cateID) {
		this.cateID = cateID;
	}
	
	
}
