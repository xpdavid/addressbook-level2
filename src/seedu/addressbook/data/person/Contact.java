package seedu.addressbook.data.person;

/**
 * Superclass to represent a Person's contact in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidValue(String)}
 */
public class Contact {

	public final String EXAMPLE = "*";
    public final String MESSAGE_CONTACT_CONSTRAINTS =
            "Any thing";
    public final String CONTACT_VALIDATION_REGEX = ".+";

    public final String value;
    protected boolean isPrivate;
    
    /**
     * Contact Constructor
     *
     */
    public Contact(String value, boolean isPrivate) {
    	    this.value = value;
    	    this.isPrivate = isPrivate;
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Contact // instanceof handles nulls
                && this.value.equals(((Contact) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }


    public boolean isPrivate() {
        return isPrivate;
    }
}
