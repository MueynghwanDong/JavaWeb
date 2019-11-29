package com.ssafy.bms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {

	String isbn;
	String title;
	Integer authourno;
	Integer price;
	String publisher;
	String description;
}
