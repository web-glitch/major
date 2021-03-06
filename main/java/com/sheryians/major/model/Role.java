package com.sheryians.major.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;



@Entity
@Table(name="roles")
public class Role {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	@NotNull
	private Integer id;
	
	@NotEmpty
	@Column(nullable=false,unique=true)
	private String name;
	
	@ManyToMany(mappedBy="roles")
	private List<User> users;

	
}
