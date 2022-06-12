package com.sheryians.major.model;

import java.util.List;


import javax.persistence.*;
import javax.validation.constraints.*;


@Entity(name="users")
@Table
public class User 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	
	private Integer id;
	
	
	@Column(nullable=false,unique=true)
	private String firstName;
	
	private String lastName;
	
	
	
	@Column(nullable=false,unique=true)
	@Email(message ="{errors,invalid_email}")
	private String email;
	
	
	
	private String password;
	
	@ManyToMany(cascade=CascadeType.MERGE , fetch=FetchType.EAGER)
	@JoinTable(
			name="user_role",
			joinColumns= {@JoinColumn(name="USER_ID",referencedColumnName="ID")},
			inverseJoinColumns= {@JoinColumn(name="ROLE_ID",referencedColumnName="ID")}
			)
	private List<Role> roles;

	public User(User user) {
		
		this.firstName = user.getFirstName();
		this.lastName = user.getLastName();
		this.email =user.getEmail();
		this.password = user.getPassword();
		this.roles = user.getRoles();
	}
	
	
	
	
	public Integer getId() {
		return id;
	}




	public void setId(Integer id) {
		this.id = id;
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




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public String getPassword() {
		return password;
	}




	public void setPassword(String password) {
		this.password = password;
	}




	public List<Role> getRoles() {
		return roles;
	}




	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}




	public User()
	{
		
	}
}
