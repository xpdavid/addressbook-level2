package xiaopu.addressbook.data.address;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a unit in the address for a person.
 * Guarantees: immutable; is valid as declared in {@link #isValidUnit(String)}
 */
public class Unit {
	public static final String EXAMPLE = "#12-34";
    public static final String MESSAGE_UNIT_CONSTRAINTS = "Unit name for an address can be in any format";
    public static final String UNIT_VALIDATION_REGEX = ".+";
    
    public final String value;
    
    /**
     * Validates given unit.
     *
     * @throws IllegalValueException if given unit name is invalid.
     */
    public Unit(String unit) throws IllegalValueException {
    	    String theUnit = unit.trim();
        if (!isValidUnit(theUnit)) {
            throw new IllegalValueException(MESSAGE_UNIT_CONSTRAINTS);
        }
        this.value = theUnit;
    }

    /**
     * Returns true if a given string is a valid unit name.
     */
    public static boolean isValidUnit(String test) {
        return test.matches(UNIT_VALIDATION_REGEX);
    }


    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Unit // instanceof handles nulls
                && this.value.equals(((Unit) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
