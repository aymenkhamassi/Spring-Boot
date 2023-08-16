package com.aymen.car.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="cars")
public class Car {
// MEMBER VARIABLES
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Size(min = 2, max = 15, message="you need a model!!!!")
	private String model;

	@NotBlank
	@Size(min = 2, max = 15, message="you need a Color!!!!")
	private String color;
	
	
	// M:1
		@ManyToOne(fetch=FetchType.LAZY)
		@JoinColumn(name="driver_id")
		private User driver;
		
		
		// This will not allow the createdAt column to be updated after creation
	    @Column(updatable=false)
	    @DateTimeFormat(pattern="yyyy-MM-dd")
		private Date createdAt;

	    @DateTimeFormat(pattern="yyyy-MM-dd")
		private Date updatedAt;
	    
	    
	 // EMPTY CONSTRUCTOR
	 		public Car() {
	 		}
	 		
//			----- methods ---
		    // other getters and setters removed for brevity
		    @PrePersist
		    protected void onCreate(){
		        this.createdAt = new Date();
		    }
		    @PreUpdate
		    protected void onUpdate(){
		        this.updatedAt = new Date();
		    }

			public Long getId() {
				return id;
			}

			public void setId(Long id) {
				this.id = id;
			}

			public String getModel() {
				return model;
			}

			public void setModel(String model) {
				this.model = model;
			}

			public String getColor() {
				return color;
			}

			public void setColor(String color) {
				this.color = color;
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
			}

			public User getDriver() {
				return driver;
			}

			public void setDriver(User driver) {
				this.driver = driver;
			}
		    
		    


	
}