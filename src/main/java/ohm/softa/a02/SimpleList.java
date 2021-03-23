package ohm.softa.a02;

// unverändert
public interface SimpleList {
	// Add object to the list end
	void add(Object o);

	// return list length
	int length();

	// Generate new list using the given filter instance and return a new, filtered list
	SimpleList filter(SimpleFilter filter);
}
