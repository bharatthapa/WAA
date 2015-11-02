package app06b.domain;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class Address {

	
	private String street;
	@NotEmpty(message="String.empty")
	private String city;
	
	@Size(min=2, max=2, message="Size.state")
	private String state;

	@Pattern(regexp="^\\d{5}(-\\d{4})?$",message="{Pattern.zipcode}")
 	private String zipCode;
	
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
}
