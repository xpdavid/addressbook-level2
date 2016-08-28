package seedu.addressbook.data.person;

import static seedu.addressbook.common.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import seedu.addressbook.commands.AddCommand;
import seedu.addressbook.commands.HelpCommand;
import seedu.addressbook.commands.IncorrectCommand;
import seedu.addressbook.data.exception.IllegalValueException;
import xiaopu.addressbook.data.address.*;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    public static final String EXAMPLE = "123, Clementi Ave 3, #12-34, 231534";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person addresses must be entered in the format: BLOCK, STREET, UNIT, POSTAL_CODE";
    public static final String MESSAGE_FULL_ADDRESS = "%1$s, %2$s, %3$s, %4$s";
    public static final Pattern ADDRESS_DATA_FORMAT = Pattern.compile("(?<block>.+?),(?<street>.+?),(?<unit>.+?),(?<postalCode>[^,]+)");

    public final Block block;
    public final Street street;
    public final Unit unit;
    public final PostalCode postalCode;
    
    private boolean isPrivate;

    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Address(String address, boolean isPrivate) throws IllegalValueException {
    	    final Matcher matcher = ADDRESS_DATA_FORMAT.matcher(address.trim());
    	    // Validate address string format
        if (!matcher.matches()) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
        try {
        	    this.block = new Block(matcher.group("block"));
        	    this.street = new Street(matcher.group("street"));
        	    this.unit = new Unit(matcher.group("unit"));
        	    this.postalCode = new PostalCode(matcher.group("postalCode"));
        	    this.isPrivate = isPrivate;
        } catch (IllegalValueException ive) {
            	throw ive;
        }
    }

    @Override
    public String toString() {
        return String.format(MESSAGE_FULL_ADDRESS, block.toString(), street.toString(), unit.toString(), postalCode.toString());
    }

    @Override
    public boolean equals(Object other) {
    	    if (other == this) {
    	    		return true;
    	    } else if (other instanceof Address) {
    	    	    Address other_address = (Address) other;
    	    	    return this.block.equals(other_address.block) && this.street.equals(other_address.street)
    	    	    		     && this.unit.equals(other_address.unit) && this.postalCode.equals(other_address.postalCode);
    	    } else {
    	    	    return super.equals(other);
    	    }
    }

    @Override
    public int hashCode() {
    	    // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(block, street, unit, postalCode);
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}