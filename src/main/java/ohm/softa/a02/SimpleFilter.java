package ohm.softa.a02;

// unverändert
@FunctionalInterface
public interface SimpleFilter {

	// parameters: object ot evaluate
	// return true if object should be included
	boolean include(Object item);
}
