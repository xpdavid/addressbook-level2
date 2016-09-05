package seedu.addressbook.person;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;

import seedu.addressbook.data.exception.IllegalValueException;
import seedu.addressbook.data.person.Name;

public class NameTest {
	
	@Test
	public void isSimilar_nullInput_shouldReturnFalse() {
		try {
    	        Name name1 = new Name("john");
    	        assertEquals(name1.isSimilar(null), false);
        } catch (IllegalValueException e) {
    	        fail("Name is not Valid");
        }
	}


}
