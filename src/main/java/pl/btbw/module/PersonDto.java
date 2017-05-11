package pl.btbw.module;

import javax.ws.rs.FormParam;
import java.util.List;

public class PersonDto {

	@FormParam("name")
	private String name;

	@FormParam("surname")
	private String surname;

	private AddressDto address;

	private List<AddressDto> addressDtos;

	public PersonDto() {
	}

	public PersonDto(String name, String surname, AddressDto address, List<AddressDto> addressDtos) {
		this.name = name;
		this.surname = surname;
		this.address = address;
		this.addressDtos = addressDtos;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public AddressDto getAddress() {
		return address;
	}

	public void setAddress(AddressDto address) {
		this.address = address;
	}

	public List<AddressDto> getAddressDtos() {
		return addressDtos;
	}

	public void setAddressDtos(List<AddressDto> addressDtos) {
		this.addressDtos = addressDtos;
	}

	@Override
	public String toString() {
		return "PersonDto{" +
				"name='" + name + '\'' +
				", surname='" + surname + '\'' +
				", address=" + address +
				", addressDtos=" + addressDtos +
				'}';
	}
}
