package com.aymen.exam.models;

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
@Table(name="shows")
public class TvShow {
	
	// MEMBER VARIABLES
		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;

		@NotBlank
		@Size(min = 5, max = 200, message="you need a Title!!!!")
		private String title;

		@NotBlank
		@Size(min = 2, max = 200, message="you need a Network!!!!")
		private String network;

		@NotBlank
		@Size(min = 5, max = 200, message="you need Description!!!!")
		private String description;


		// M:1
		@ManyToOne(fetch=FetchType.LAZY)
		@JoinColumn(name="user_id")
		private User user;
		
		

			// This will not allow the createdAt column to be updated after creation
		    @Column(updatable=false)
		    @DateTimeFormat(pattern="yyyy-MM-dd")
			private Date createdAt;

		    @DateTimeFormat(pattern="yyyy-MM-dd")
			private Date updatedAt;



			// EMPTY CONSTRUCTOR
			public TvShow() {
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

			public String getTitle() {
				return title;
			}

			public void setTitle(String title) {
				this.title = title;
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

			

			public String getNetwork() {
				return network;
			}

			public void setNetwork(String network) {
				this.network = network;
			}

			public String getDescription() {
				return description;
			}

			public void setDescription(String description) {
				this.description = description;
			}

			public User getUser() {
				return user;
			}

			public void setUser(User user) {
				this.user = user;
			}

		
		    
		    


	}


		


