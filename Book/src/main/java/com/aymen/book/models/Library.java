package com.aymen.book.models;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "libraries")
public class Library {
	
	// MEMBER VARIBALES
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		@NotBlank
		@Size(min = 4, max = 20, message="you need a name!!!!")
		private String name;

		@NotBlank
		@Size(min = 2, max = 15, message="you need a location!!!!")
		private String location;



		// 1:M
		@OneToMany(mappedBy="library", fetch = FetchType.LAZY)
		private List<Book> books;
		
		
		// This will not allow the createdAt column to be updated after creation
		@Column(updatable = false)
		@DateTimeFormat(pattern = "yyyy-MM-dd")
		private Date createdAt;

		@DateTimeFormat(pattern = "yyyy-MM-dd")
		private Date updatedAt;

		// EMPTY CONSTRUCTOR
		public Library() {}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getLocation() {
			return location;
		}

		public void setLocation(String location) {
			this.location = location;
		}

		public List<Book> getBooks() {
			return books;
		}

		public void setBooks(List<Book> books) {
			this.books = books;
		}

		public Date getCreatedAt() {
			return createdAt;
		}

		public void setCreatedAt(Date createdAt) {
			this.createdAt = createdAt;
		}

		public Date getUpdatedAt() {
			return updatedAt;
		}

		public void setUpdatedAt(Date updatedAt) {
			this.updatedAt = updatedAt;
		};
		
		
		



}
