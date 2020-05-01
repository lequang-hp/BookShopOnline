package com.laptrinhjavaweb.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "book")
public class BookEntity extends BaseEntity{
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "shortdescription",columnDefinition = "TEXT")
	private String shortDescription;
	
	@Column(name = "img")
	private String img;
	
	@Column(name = "price")
	private float price;
	
	@Column(name = "discount")
	private float discount;

	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "categoryid")
	private CategoryEntity category;

	
	@OneToMany(mappedBy = "bookEntity")
	private List<CommentEntity> comments = new ArrayList<>();
	
	@OneToMany(mappedBy = "bookEntity")
	private List<CartEntity> carts = new ArrayList<>();
	
	@OneToMany(mappedBy = "bookEntity")
	private List<HistoryEntity> histories = new ArrayList<>();
	
	
	public List<HistoryEntity> getHistories() {
		return histories;
	}

	public void setHistories(List<HistoryEntity> histories) {
		this.histories = histories;
	}

	public List<CartEntity> getCarts() {
		return carts;
	}

	public void setCarts(List<CartEntity> carts) {
		this.carts = carts;
	}

	public List<CommentEntity> getComments() {
		return comments;
	}

	public void setComments(List<CommentEntity> comments) {
		this.comments = comments;
	}

	public CategoryEntity getCategory() {
		return category;
	}

	public void setCategory(CategoryEntity category) {
		this.category = category;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public float getDiscount() {
		return discount;
	}

	public void setDiscount(float discount) {
		this.discount = discount;
	}
}
