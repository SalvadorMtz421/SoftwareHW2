package crm;
import java.util.function.Predicate;

// Potential customer

public class Lead {
	public Lead(String nm, String em, String ctry, String ind) {
		name = nm;
		email = em;
		country = ctry;
		industry = ind;
	}

	protected String name, email, country, industry;
	protected User assigned;
	
	public void setAssigned(User status) {
		assigned = status;
	}
	public User getAssigned() {
		return assigned;
	}
	
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder(name);
		result.append('\t')
			  .append(country)
			  .append('\t')
			  .append(email).append('\t').append(industry);

		if (assigned != null)
			result.append('\t')
				  .append(assigned.getName());
		return result.toString();
	}
}

