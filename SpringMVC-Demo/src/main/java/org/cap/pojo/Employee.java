package org.cap.pojo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Future;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;


@Entity
@Table(name="Cap_FLP_Employee")
public class Employee {
	@Id
	@GeneratedValue
	private int empId;
	
	@NotEmpty(message="* Please Enter FirstName.")
	private String firstName;
	@NotEmpty(message="* Please Enter FirstName.")
	private String lastName;
	
	@Pattern(regexp="(^$|[0-9]{10})",message= "* enter only 10 digit number.")
	private String phno;
	
	@Past(message="* Date of Birth must be past date.")
	private Date empDob;
	
	@Future(message="* Date of Joining must be future date.")
	private Date empDoj;
	
	private String department;
	private String project;
	private String role;
	
	@NotEmpty(message="* Please enter email_id")
	@Email(message="* Please enter valid email_id")
	private String email;
	
	
	private String address;
	
	public Employee(){}
	
	public Employee(int empId, String firstName, String lastName, String phno, Date empDob, Date empDoj, String email,String address) {
		super();
		this.empId = empId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phno=phno;
		this.empDob = empDob;
		this.empDoj = empDoj;
		this.email=email;
		this.address=address;
	}
	
	
	public Employee(int empId, String firstName, String lastName, String phno, Date empDob, Date empDoj,
			String department,String project,String role, String email,String address) {
		super();
		this.empId = empId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phno = phno;
		this.empDob = empDob;
		this.empDoj = empDoj;
		this.department = department;
		this.project=project;
		this.role=role;
		this.email=email;
		this.address=address;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getPhno() {
		return phno;
	}

	public void setPhno(String phno) {
		this.phno = phno;
	}

	public Date getEmpDob() {
		return empDob;
	}
	public void setEmpDob(Date empDob) {
		this.empDob = empDob;
	}
	public Date getEmpDoj() {
		return empDoj;
	}
	public void setEmpDoj(Date empDoj) {
		this.empDoj = empDoj;
	}
	
	
	
	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", firstName=" + firstName + ", lastName=" + lastName + ", phno=" + phno
				+ ", empDob=" + empDob + ", empDoj=" + empDoj + ", department=" + department + ", project=" + project
				+ ", role=" + role + ", email=" + email + ", address=" + address + "]";
	}

	

	

}
