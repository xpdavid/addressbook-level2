package xiaopu.addressbook.data.address;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Block in the address for a person.
 * Guarantees: immutable; is valid as declared in {@link #isValidBlock(String)}
 */
public class Block {
	public static final String EXAMPLE = "123";
    public static final String MESSAGE_BLOCK_CONSTRAINTS = "Block name for an address can be in any format";
    public static final String BLOCK_VALIDATION_REGEX = ".+";
    
    public final String value;
    
    /**
     * Validates given block.
     *
     * @throws IllegalValueException if given block name is invalid.
     */
    public Block(String block) throws IllegalValueException {
        block = block.trim();
        if (!isValidBlock(block)) {
            throw new IllegalValueException(MESSAGE_BLOCK_CONSTRAINTS);
        }
        this.value = block;
    }

    /**
     * Returns true if a given string is a valid block name.
     */
    public static boolean isValidBlock(String test) {
        return test.matches(BLOCK_VALIDATION_REGEX);
    }


    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Block // instanceof handles nulls
                && this.value.equals(((Block) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
