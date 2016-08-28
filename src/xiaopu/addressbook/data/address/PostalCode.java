package xiaopu.addressbook.data.address;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Postal Code in the address for a person.
 * Guarantees: immutable; is valid as declared in {@link #isValidPostalCode(String)}
 */
public class PostalCode {
	public static final String EXAMPLE = "231534";
    public static final String MESSAGE_POSTAL_CODE_CONSTRAINTS = "Postcode for an address can only be combination of letters and numbers";
    public static final String POSTAL_CODE_VALIDATION_REGEX = "[A-Za-z0-9]+";
    
    public final String value;
    
    /**
     * Validates given postalCode.
     *
     * @throws IllegalValueException if given postalCode is invalid.
     */
    public PostalCode(String postalCode) throws IllegalValueException {
    	    postalCode = postalCode.trim();
        if (!isValidPostalCode(postalCode)) {
            throw new IllegalValueException(MESSAGE_POSTAL_CODE_CONSTRAINTS);
        }
        this.value = postalCode;
    }

    /**
     * Returns true if a given string is a valid postalCode.
     */
    public static boolean isValidPostalCode(String test) {
        return test.matches(POSTAL_CODE_VALIDATION_REGEX);
    }


    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof PostalCode // instanceof handles nulls
                && this.value.equals(((PostalCode) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
