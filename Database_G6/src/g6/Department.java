package g6;

public class Department {
 
	private String deptCode;
	private String deptName;
	private String officeNum;
	private String officePhone;
	private String college;
	
	public Department(String deptCode, String deptName, String officeNum, String officePhone, String college) {
		this.deptCode = deptCode;
		this.deptName = deptName;
		this.officeNum = officeNum;
		this.officePhone = officePhone;
		this.college = college;
	}

    public void setDeptCode(String deptCode) {
    	this.deptCode = deptCode;
	}
	
	public String getDeptCode() {
		return this.deptCode;
	}
	
    public void setDeptName(String deptName) {
    	this.deptName = deptName;
	}
    public String getDeptName() {
		return this.deptName;
	}
    public void setOfficeNum(String officeNum) {
    	this.officeNum = officeNum;
	}
    public String getOfficeNum() {
    	return this.officeNum;
	}
    public void setOfficePhone(String officePhone) {
    	this.officePhone = officePhone;
	}
    public String getOfficePhone() {
		return this.officePhone;
	}
    public void setCollege(String college) {
    	this.college = college;
	}
    public String getCollege() {
    	return this.college;
	}
}
