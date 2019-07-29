package Apache.POI;

public class StudentModel {

    private String name;
    private String city;
    private String company;
    
    
	public StudentModel() {
		super();
	}
	public StudentModel(String name, String city, String company) {
		super();
		this.name = name;
		this.city = city;
		this.company = company;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	@Override
	public String toString() {
		return "StudentModel [name=" + name + ", city=" + city + ", company=" + company + "]";
	}
    
    
}
