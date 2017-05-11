package pl.btbw.module;

import java.util.Date;

public class AddressDto {

	private String street;

	private Boolean aBoolean = Boolean.TRUE;

	private Date someDate = new Date();

	private Integer integer = new Integer(10);

	public AddressDto() {
	}

	public AddressDto(String street) {
		this.street = street;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	@Override
	public String toString() {
		return "AddressDto{" +
				"street='" + street + '\'' +
				'}';
	}
}
