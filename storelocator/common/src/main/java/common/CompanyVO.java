package common;

import java.util.Date;

import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Company")
public class CompanyVO {
	@Id
	private String companyId;
	@NotNull
	@Min(3)
	private String companyName;
	@NotNull
	@Max(10)
	private long companyPhoneNo;
	private String companyCEO;
	private int foundedYear;
	private Date createdTime;
	private Date EndTime;
	private boolean isActive;
	private String status;
	
	public CompanyVO(String companyName,String status,String companyId ) {
		this.companyId=companyName;
		this.status=status;
		this.companyId=companyId;
	}
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public long getCompanyPhoneNo() {
		return companyPhoneNo;
	}
	public void setCompanyPhoneNo(long companyPhoneNo) {
		this.companyPhoneNo = companyPhoneNo;
	}
	public String getCompanyCEO() {
		return companyCEO;
	}
	public void setCompanyCEO(String companyCEO) {
		this.companyCEO = companyCEO;
	}
	
	public int getFoundedYear() {
		return foundedYear;
	}
	public void setFoundedYear(int foundedYear) {
		this.foundedYear = foundedYear;
	}
	public Date getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	public Date getEndTime() {
		return EndTime;
	}
	public void setEndTime(Date endTime) {
		EndTime = endTime;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	

}
