package car.model;

public class carModel {
	
	private int id;
    private String Brand;
    private String Length;
    private String Weight;
    private String velocity;
    private String color;

    public carModel() {}
    
    public carModel(int id, String Brand, String Length, String Weight, String velocity, String color) {
    	this.id = id;
    	this.Brand = Brand; 
    	this.Length = Length; 
    	this.Weight = Weight; 
    	this.velocity = velocity; 
    	this.color = color; 
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBrand() {
		return Brand;
	}

	public void setBrand(String brand) {
		Brand = brand;
	}

	public String getLength() {
		return Length;
	}

	public void setLength(String length) {
		Length = length;
	}

	public String getWeight() {
		return Weight;
	}

	public void setWeight(String weight) {
		Weight = weight;
	}

	public String getVelocity() {
		return velocity;
	}

	public void setVelocity(String velocity) {
		this.velocity = velocity;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
    
    
}
