package com.spring.image.galleryservice;

import java.util.List;

import lombok.Data;

@Data
public class Gallery {
	private int id;
	private List<Object> images;
}