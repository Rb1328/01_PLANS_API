package in.Rahulit.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@jakarta.persistence.Entity
@Table(name="PLAN_MASTER")
public class Plan {
	
	@Override
	public String toString() {
		return "Plan [planId=" + planId + ", planName=" + planName + ", planStartDate=" + planStartDate
				+ ", planEndDate=" + planEndDate + ", activeSw=" + activeSw + ", planCategoryId=" + planCategoryId
				+ "]";
	}

	public Plan() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Plan(Integer planId, String planName, LocalDate planStartDate, LocalDate planEndDate, String activeSw,
			Integer planCategoryId) {
		super();
		this.planId = planId;
		this.planName = planName;
		this.planStartDate = planStartDate;
		this.planEndDate = planEndDate;
		this.activeSw = activeSw;
		this.planCategoryId = planCategoryId;
	}

	public Integer getPlanId() {
		return planId;
	}

	public void setPlanId(Integer planId) {
		this.planId = planId;
	}

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public LocalDate getPlanStartDate() {
		return planStartDate;
	}

	public void setPlanStartDate(LocalDate planStartDate) {
		this.planStartDate = planStartDate;
	}

	public LocalDate getPlanEndDate() {
		return planEndDate;
	}

	public void setPlanEndDate(LocalDate planEndDate) {
		this.planEndDate = planEndDate;
	}

	public String getActiveSw() {
		return activeSw;
	}

	public void setActiveSw(String activeSw) {
		this.activeSw = activeSw;
	}

	public Integer getPlanCategoryId() {
		return planCategoryId;
	}

	public void setPlanCategoryId(Integer planCategoryId) {
		this.planCategoryId = planCategoryId;
	}

	@Id
	@GeneratedValue
	@Column(name="PLAN_ID")
    private Integer planId;
	
	@Column(name="PLAN_NAME")
	private String planName;
	
	@Column(name="PLAN_START_DATE")
	private LocalDate planStartDate;
	
	@Column(name="PLAN_END_DATE")
	private LocalDate planEndDate;
	
	@Column(name="ACTIVE_SW")
	private String activeSw;
	
	@Column(name="PLAN_CATEGORY_ID")
	private Integer planCategoryId;
	
}
