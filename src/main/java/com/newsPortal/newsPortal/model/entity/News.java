package com.newsPortal.newsPortal.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "news")
public class News {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "headline")
	private String headline;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "body")
	private String body;

	@Column(name = "category")
	private String category;

	@Column(name = "author")
	private String author;

	@Column(name = "cover_image")
	private String coverImage;

	@Column(name = "date")
	private LocalDate date;

//	@OneToMany(mappedBy = "owner")
//	private List<Car> cars;

}
