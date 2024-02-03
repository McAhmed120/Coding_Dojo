package com.ahmed.SaveTravels.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="expenses")
public class Expense {
	// member variables
			@Id
		    @GeneratedValue(strategy = GenerationType.IDENTITY)
		    private Long id;
		    @NotEmpty
		    private String expenseName;
		    @NotEmpty
		    private String vendor;
		    @NotEmpty
		    private String description;
		    @NotNull
		    @Min(0)
		    private Double amount; 
		    // This will not allow the createdAt column to be updated after creation
		    @Column(updatable=false)
		    @DateTimeFormat(pattern="yyyy-MM-dd")
		    private Date createdAt;
		    @DateTimeFormat(pattern="yyyy-MM-dd")
		    private Date updatedAt;
		    
		    public Expense() {}
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
			public String getExpenseName() {
				return expenseName;
			}
			public void setExpenseName(String expenseName) {
				this.expenseName = expenseName;
			}
			public String getVendor() {
				return vendor;
			}
			public void setVendor(String vendor) {
				this.vendor = vendor;
			}
			public String getDescription() {
				return description;
			}
			public void setDescription(String description) {
				this.description = description;
			}
			public Double getAmount() {
				return amount;
			}
			public void setAmount(Double amount) {
				this.amount = amount;
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
		    

}