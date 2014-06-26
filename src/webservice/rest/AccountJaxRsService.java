package webservice.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * cxf在web.xml侦听/cxf, 在applicationContext.xml里侦听/API，完整访问路径为
 * /cxf/API/user/getUserInfo/1
 * 
 */
@Path("/user")
public class AccountJaxRsService {

	private static Logger logger = LoggerFactory.getLogger(AccountJaxRsService.class);

	@GET
	@Path("/getUserInfo/{id}")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public UserDTO getUserInfo(@PathParam("id") Long id) {
		System.out.println("@PathParam" + id);
		UserDTO dto = new UserDTO();
		logger.debug("getUserInfo" + dto);
		return dto;
	}

	@GET
	@Path("/event1")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public UserDTO event1(@HeaderParam("param1") String param1, @HeaderParam("param2") String param2) {
		System.out.println("@HeaderParam" + param1);
		System.out.println("@HeaderParam" + param2);

		UserDTO dto = new UserDTO();
		logger.debug("event1" + dto);
		return dto;
	}

	@POST
	@Path("/event2")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public UserDTO event2(@HeaderParam("param1") String param1, @HeaderParam("param2") String param2) {
		System.out.println("@HeaderParam" + param1);
		System.out.println("@HeaderParam" + param2);

		UserDTO dto = new UserDTO();
		logger.debug("event2" + dto);
		return dto;
	}
}
