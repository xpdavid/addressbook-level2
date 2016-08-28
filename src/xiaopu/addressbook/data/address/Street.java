package xiaopu.addressbook.data.address;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a street in the address for a person.
 * Guarantees: immutable; is valid as declared in {@link #isValidStreet(String)}
 */
public class Street {
	public static final String EXAMPLE = "Clementi Ave 3";
    public static final String MESSAGE_STREET_CONSTRAINTS = "Street name for an address can be in any format";
    public static final String STREET_VALIDATION_REGEX = ".+";
    
    public final String value;
    
    /**
     * Validates given street name.
     *
     * @throws IllegalValueException if given street name is invalid.
     */
    public Street(String street) throws IllegalValueException {
    	    street = street.trim();
        if (!isValidStreet(street)) {
            throw new IllegalValueException(MESSAGE_STREET_CONSTRAINTS);
        }
        this.value = street;
    }

    /**
     * Returns true if a given string is a valid street name.
     */
    public static boolean isValidStreet(String test) {
        return test.matches(STREET_VALIDATION_REGEX);
    }


    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Street // instanceof handles nulls
                && this.value.equals(((Street) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
