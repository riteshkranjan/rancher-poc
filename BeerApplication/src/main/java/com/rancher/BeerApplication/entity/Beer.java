package com.rancher.BeerApplication.entity;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
@Document(collection = "beers")
public class Beer {
	@NotNull
	@Id
	private String id;

	private Float abv;

	@NotNull
	private String category;

	@NotNull
	private String description;

	private Integer ibu;

	@NotNull
	private String name;

	private Integer srm;

	@NotNull
	private String style;

	private String type;

	@NotNull
	private String updated;

	private Integer upc;

}
