package pl.btbw.sanitization;

import org.junit.Test;
import pl.btbw.module.AddressDto;
import pl.btbw.module.PersonDto;

import java.util.ArrayList;

public class XSSObjectSanitizerUtilTest {

	@Test
	// this is not true test!
	public void name() {
		String name = "<h1>michal</h1>";
		String surname = "<h2>szalek</h2>";
		AddressDto address = new AddressDto("<h3>Miaszka</h3>");
		ArrayList<AddressDto> addressDtoList = new ArrayList<>();
		addressDtoList.add(new AddressDto("<h2>Bolesława</h3>"));
		addressDtoList.add(new AddressDto("<b>Kościuszki</a>"));
		addressDtoList.add(new AddressDto("<b><h1>Kościuszki</h1></a>"));

		PersonDto dto = new PersonDto(name, surname, address, addressDtoList);


		XSSObjectSanitizerUtil.sanitizer(dto);

		System.out.println(dto.toString());
	}
}