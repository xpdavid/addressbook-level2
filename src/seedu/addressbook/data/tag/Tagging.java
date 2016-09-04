package seedu.addressbook.data.tag;

import seedu.addressbook.data.person.Person;

/**
 * Record the addition and deletion of a person's tags
 * Guarantees: immutable;
 */
public class Tagging {
	public static enum Operation  {DELETION, ADDITION};
	
	
	private final Person person;
	private final Tag tag;
	private final Operation operation;
	
	/**
	 * Construction: create tagging history
	 * 
	 * @param person
	 * @param tag
	 * @param opertaion
	 */
    public Tagging(Person person, Tag tag, Operation opertaion) {
    	    this.person = person;
    	    this.tag = tag;
    	    this.operation = opertaion;
    }
    
}
