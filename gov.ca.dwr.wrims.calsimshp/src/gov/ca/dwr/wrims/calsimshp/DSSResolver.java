package gov.ca.dwr.wrims.calsimshp;

/**
 * This class is intended to contain all of the logic required to retrieve the DSS values
 * associated with a given feature.
 * 
 * @author chodgson@refractions.net
 *
 */
public class DSSResolver {
	
	public static final int NUM_DSS = 4;
	
	private final int firstDssIndex;

	// TODO Hao 
	// please add any additional members and/or constructor parameters required by the DSSResolver

	/**
	 * Create a new DSSResolver based key points of the featureType on which the Resolver is
	 * intended to operate. 
	 * @param firstDssIndex the index of the first attribute intended to contain DSS values;
	 * 						the NUM_DSS DSS attributes are contiguous from this index
	 * @param idIndex the index of the attribute which contains the identifier of the feature
	 */
	public DSSResolver(int firstDssIndex) {
		this.firstDssIndex = firstDssIndex;
	}

	/**
	 * If the specified index represents a DSS attribute, update the values array to contain the
	 * current value of said attribute.
	 * 
	 * @param values an array of the feature's attributes, to be updated with the new DSS value
	 * @param index the index of the attribute to be updated, if it is a DSS attribute
	 */
	public void resolve(Object[] values, int index) {
		if(index >= firstDssIndex && index < firstDssIndex + NUM_DSS) {
			// from 0 to (NUM_DSS - 1), this specifies which dataset to retrieve data from
			int dssIndex = index - firstDssIndex; 
			
			// TODO Hao
			// determine the DSS value for the currently selected date, for this feature
			// values[idIndex] is the value of the ID column for this feature
			values[index] = Math.round(Math.random()*10000); 
		}
	}

	/**
	 * Update all DSS attributes in the values array of this feature.
	 * 
	 * @param values an array of the feature's attributes, to be updated with the new DSS value(s)
	 */
	public void resolveAll(Object[] values) {
		// this approach simply reuses the single-value lookup from above
		// if there is a more efficient way to do this, please go ahead
		for(int index = firstDssIndex; index < firstDssIndex + NUM_DSS; index++) {
			resolve(values, index);
		}
	}

}
