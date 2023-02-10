package crm;
// System user who may be assigned to help potential customers

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class User {
	protected String name;
	protected List<Lead> assigned;
	protected boolean online;
	
	public User(String _name) {
		name = _name;
		assigned = new ArrayList<>();
		online = false;
	}
	
	public boolean getOnline() {
		return online;
	}

	public void assign(Lead lead) {
		assigned.add(lead);
		
	}
	
	public List<Lead> getAssigned() {
		return assigned;
	}
	
	public void setOnline(boolean status) {
		online = status;
	}

	public String getName() {
		return name;
	}
}
