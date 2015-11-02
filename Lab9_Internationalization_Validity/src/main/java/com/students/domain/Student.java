package com.students.domain;

import java.util.Date;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.web.multipart.MultipartFile;

public class Student {

	private int id;

	@Pattern(regexp = "^[a-zA-z]{4,50}", message = "{SIZE}")
	private String firstName = null;

	@Pattern(regexp = "^[a-zA-z]{4,50}", message = "{SIZE}")
	private String lastName = null;

	@NotNull
	@Pattern(regexp = "^\\S+@\\S+\\.\\S+$", message = "{Email}")
	private String email = null;

	@NotNull(message = "Gender is required")
	private String gender = null;

	@NotNull(message = "Birthday is not valid")
	private Date birthday;

	@Valid
	private Phone phone;
	@NotNull
	private MultipartFile file;

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Phone getPhone() {
		return phone;
	}

	public void setPhone(Phone phone) {
		this.phone = phone;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

}
