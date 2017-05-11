package pl.btbw.sanitization;

import org.junit.Test;
import pl.btbw.module.article.ArticleDto;
import pl.btbw.module.person.AddressDto;
import pl.btbw.module.person.PersonDto;

import java.util.ArrayList;

// this is not true test!
public class XSSObjectSanitizerUtilTest {

	@Test
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

	@Test
	public void name2() {
		ArticleDto dto = new ArticleDto();
		dto.getBlogs().add("Lorem 1<h1>test</h1>");
		dto.getBlogs().add("Lorem 2");
		dto.getBlogs().add("Lorem 3");

		XSSObjectSanitizerUtil.sanitizer(dto);


		System.out.println("!! = " + dto.getBlogs().get(0));
		System.out.println("!! = " + dto.getBlogs().get(1));
		System.out.println("!! = " + dto.getBlogs().get(2));
	}
}