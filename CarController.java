package car.controller;

import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import car.DAO.CarService;
import car.model.carModel;

@Path("/car")
public class CarController {

	private CarService CarService = new CarService();

	@GET

	@Path("/search")

	@Produces(MediaType.APPLICATION_XML)
	public List<carModel> searchCar(@QueryParam("query") String query) {
		return CarService.searchCar(query);
	}

	@GET

	@Path("/download")

	@Produces(MediaType.APPLICATION_XML)
	public Response downloadCar(@QueryParam("query") String query) {
		List<carModel> cars = CarService.searchCar(query);
		StringBuilder xml = new StringBuilder("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<Cars>\n");
		for (carModel car : cars) {
			xml.append("  <Car>\n").append("    <Id>").append(car.getId()).append("</Id>\n").append("    <Brand>")
					.append(car.getBrand()).append("</Brand>\n").append("    <Length>").append(car.getLength())
					.append("</Length>\n").append("    <Weight>").append(car.getWeight()).append("</Weight>\n")
					.append("    <Velocity>").append(car.getVelocity()).append("</Velocity>\n")
					.append("    <Color>").append(car.getColor()).append("</Color>\n").append("  </Car>\n");
		}
		xml.append("</Cars>");

		return Response.ok(xml.toString()).header("Content-Disposition", "attachment; filename=Cars.xml").build();
	}

}
