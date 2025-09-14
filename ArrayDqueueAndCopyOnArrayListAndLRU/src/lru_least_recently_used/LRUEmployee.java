package lru_least_recently_used;

import array_dqueue.DequeEmployee;

public class LRUEmployee {
	private int id;
	private String name;
	private String designation;
	
	public LRUEmployee(int id, String name, String designation) {
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
		return "LRUEmployee [id=" + id + ", name=" + name + ", designation=" + designation + "]";
	}

	@Override
	public int hashCode() {
		return this.id + this.name.hashCode() + this.designation.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		LRUEmployee l = (LRUEmployee) obj;
		if (this.id == l.id && this.name.equals(l.name) && this.designation.equals(l.designation))
			return true;

		return false;
	}
	

	
	
}
