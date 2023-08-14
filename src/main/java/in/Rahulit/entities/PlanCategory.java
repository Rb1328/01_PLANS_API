package in.Rahulit.entities;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="PLAN_CATEGORY")
public class PlanCategory {
    @Id
    @GeneratedValue
    @Column(name="CATEGORY_ID")
	private Integer categoryId;
    
    @Override
	public String toString() {
		return "PlanCategory [categoryId=" + categoryId + ", categoryName=" + categoryName + ", activeSw=" + activeSw
				+ ", cratedBy=" + cratedBy + ", updatedBy=" + updatedBy + ", createdDate=" + createdDate
				+ ", updatedDate=" + updatedDate + "]";
	}

	public PlanCategory() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PlanCategory(Integer categoryId, String categoryName, String activeSw, String cratedBy, String updatedBy,
			LocalDate createdDate, LocalDate updatedDate) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.activeSw = activeSw;
		this.cratedBy = cratedBy;
		this.updatedBy = updatedBy;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
	}

	@Column(name="CATEGORY_NAME")
	private String categoryName;
    
	@Column(name="ACTIVE_SW")
    private String activeSw;
	
	@Column(name="CREATED_BY")
	private String cratedBy;
	
	@Column(name="UPDATED_BY")
	private String updatedBy;
	
	
	@Column(name="CREATED_DATE",updatable=false)
	@CreationTimestamp
	private LocalDate createdDate;
	
	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getActiveSw() {
		return activeSw;
	}

	public void setActiveSw(String activeSw) {
		this.activeSw = activeSw;
	}

	public String getCratedBy() {
		return cratedBy;
	}

	public void setCratedBy(String cratedBy) {
		this.cratedBy = cratedBy;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public LocalDate getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}

	public LocalDate getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(LocalDate updatedDate) {
		this.updatedDate = updatedDate;
	}

	@Column(name="UPDATED_DATE",insertable=false)
	@UpdateTimestamp
	private LocalDate updatedDate; 
}
