package car.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import car.Util.DBUtil;
import car.model.carModel;

public class CarService {
	
	 public List<carModel> searchCar(String query) {
	        List<carModel> cars = new ArrayList<>();
	        String sql = "SELECT * FROM CAR WHERE name LIKE ? OR position LIKE ?";

	        try (Connection conn = DBUtil.getConnection();
	             PreparedStatement stmt = conn.prepareStatement(sql)) {
	            
	            stmt.setString(1, "%" + query + "%");
	            stmt.setString(2, "%" + query + "%");
	            
	            try (ResultSet rs = stmt.executeQuery()) {
	                while (rs.next()) {
	                	carModel cr = new carModel(
	                        rs.getInt("id"),
	                        rs.getString("Brand"),
	                        rs.getString("Length"),
	                        rs.getString("Weight"),
	                        rs.getString("velocity"),
	                        rs.getString("color")
	                    );
	                	cars.add(cr);
	                }
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return cars;
	    }

}
