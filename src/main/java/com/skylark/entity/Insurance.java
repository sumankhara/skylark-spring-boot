package com.skylark.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "insurance")
public class Insurance {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "policy_number", nullable = false, length = 20)
	private String policyNumber;
	
	@Column(name = "policy_name", nullable = false, length = 80)
	private String policyName;
	
	private int premium;
	
	@Column(name = "premium_mode", nullable = false)
	private PremiumMode premiumMode;
	
	@Column(name = "sum_assured", nullable = false)
	private int sumAssured;
	
	@Column(name = "bonus_accrued", nullable = true)
	private int bonusAccrued;
	
	@Column(name = "policy_start_date", nullable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date startDate;
	
	@Column(name = "policy_end_date", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date endDate;
	
	@Column(name = "policy_term")
	private int policyTerm;
	
	@ManyToOne
	@JoinColumn(name = "provider_id", nullable = false)
	private Provider provider;
	
	public Insurance() {
		
	}

	public Insurance(String policyNumber, String policyName, int premium, PremiumMode premiumMode, int sumAssured,
			int bonusAccrued, Date startDate, Date endDate, int policyTerm, Provider provider) {
		super();
		this.policyNumber = policyNumber;
		this.policyName = policyName;
		this.premium = premium;
		this.premiumMode = premiumMode;
		this.sumAssured = sumAssured;
		this.bonusAccrued = bonusAccrued;
		this.startDate = startDate;
		this.endDate = endDate;
		this.policyTerm = policyTerm;
		this.provider = provider;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPolicyNumber() {
		return policyNumber;
	}

	public void setPolicyNumber(String policyNumber) {
		this.policyNumber = policyNumber;
	}

	public String getPolicyName() {
		return policyName;
	}

	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}

	public int getPremium() {
		return premium;
	}

	public void setPremium(int premium) {
		this.premium = premium;
	}

	public PremiumMode getPremiumMode() {
		return premiumMode;
	}

	public void setPremiumMode(PremiumMode premiumMode) {
		this.premiumMode = premiumMode;
	}

	public int getSumAssured() {
		return sumAssured;
	}

	public void setSumAssured(int sumAssured) {
		this.sumAssured = sumAssured;
	}

	public int getBonusAccrued() {
		return bonusAccrued;
	}

	public void setBonusAccrued(int bonusAccrued) {
		this.bonusAccrued = bonusAccrued;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public int getPolicyTerm() {
		return policyTerm;
	}

	public void setPolicyTerm(int policyTerm) {
		this.policyTerm = policyTerm;
	}

	public Provider getProvider() {
		return provider;
	}

	public void setProvider(Provider provider) {
		this.provider = provider;
	}

	@Override
	public String toString() {
		return "Insurance [id=" + id + ", policyNumber=" + policyNumber + ", policyName=" + policyName + ", premium="
				+ premium + ", premiumMode=" + premiumMode + ", sumAssured=" + sumAssured + ", bonusAccrued="
				+ bonusAccrued + ", startDate=" + startDate + ", endDate=" + endDate + ", policyTerm=" + policyTerm
				+ ", provider=" + provider + "]";
	}
	
	
}
