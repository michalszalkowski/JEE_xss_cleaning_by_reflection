package pl.btbw.module;

import pl.btbw.module.person.PersonDto;
import pl.btbw.sanitization.XSSObjectSanitizerUtil;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

@Path("/person")
public class PersonRestController {

	@GET
	@Path("/")
	public String testGet() {
		return "test(get) person";
	}

	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	public String testPost(PersonDto personDto) {
		XSSObjectSanitizerUtil.sanitizer(personDto);
		return "test(post) person" + personDto.toString();
	}

}