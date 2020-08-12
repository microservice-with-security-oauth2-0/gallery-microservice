package com.project.microservice.galary.entity;

import java.util.List;

import com.project.microservice.galary.modal.Image;

public class Galary {

	private Integer id;

	private List<Image> images;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Image> getImages() {
		return images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}

}
