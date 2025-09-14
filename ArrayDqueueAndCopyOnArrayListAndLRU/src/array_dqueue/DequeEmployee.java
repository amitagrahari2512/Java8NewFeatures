package array_dqueue;

public class DequeEmployee {
	private int id;
	private String name;
	private String designation;
	
	public DequeEmployee(int id, String name, String designation) {
		super();
		this.id = id;
		this.name = name;
		this.designation = designation;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	@Override
	public String toString() {
		return "DequeEmployee [id=" + id + ", name=" + name + ", designation=" + designation + "]";
	}

	@Override
	public boolean equals(Object obj) {
		DequeEmployee d = (DequeEmployee)obj;
		if(this.name == d.name)
		return true;
		
		return false;
	}
	
	
}
