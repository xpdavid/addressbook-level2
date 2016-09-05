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
	
	@Test
	public void isSimilar_sameWords_shouldReturnTrue() {
		try {
    	        Name name1 = new Name("john doe");
    	        Name name2 = new Name("john doe");
    	        assertEquals(name1.isSimilar(name2), true);
        } catch (IllegalValueException e) {
    	        fail("Name is not Valid");
        }
	}
	
	@Test
	public void isSimilar_sameWordsMixedCase_shouldReturnTrue() {
		try {
    	        Name name1 = new Name("joHn doE");
    	        Name name2 = new Name("jOhN dOe");
    	        assertEquals(name1.isSimilar(name2), true);
        } catch (IllegalValueException e) {
    	        fail("Name is not Valid");
        }
	}
	
	@Test
	public void isSimilar_mixedOrderOfWords_shouldReturnTrue() {
		try {
    	        Name name1 = new Name("john doe Leo");
    	        Name name2 = new Name("Leo john doe");
    	        assertEquals(name1.isSimilar(name2), true);
        } catch (IllegalValueException e) {
    	        fail("Name is not Valid");
        }
	}
	
	@Test
	public void isSimilar_subSetOfWords_shouldReturnTrue() {
		try {
	        Name name1 = new Name("john doe Leo");
	        Name name2 = new Name("Leo");
	        assertEquals(name1.isSimilar(name2), true);
        } catch (IllegalValueException e) {
	        fail("Name is not Valid");
        }
	}
	
	@Test
	public void isSimilar_superSetOfWords_shouldReturnTrue() {
		try {
	        Name name1 = new Name("Leo");
	        Name name2 = new Name("john doe Leo");
	        assertEquals(name1.isSimilar(name2), true);
        } catch (IllegalValueException e) {
	        fail("Name is not Valid");
        }
	}
	
	@Test
	public void isSimilar_differentSingleWord_shouldReturnFalse() {
		try {
	        Name name1 = new Name("Leo");
	        Name name2 = new Name("Xiao");
	        assertEquals(name1.isSimilar(name2), false);
        } catch (IllegalValueException e) {
	        fail("Name is not Valid");
        }
	}
	
	@Test
	public void isSimilar_differenceLessThanOrEqualHalfOfTheNumberOfWords_shouldReturnTrue() {
		try {
	        Name name1 = new Name("Leo John xin");
	        Name name2 = new Name("Leo John");
	        assertEquals(name1.isSimilar(name2), true);
	        assertEquals(name2.isSimilar(name1), true);
        } catch (IllegalValueException e) {
	        fail("Name is not Valid");
        }
	}
	
	@Test
	public void isSimilar_differenceMoreThanHalfOfTheNumberOfWords_shouldReturnFalse() {
		try {
	        Name name1 = new Name("Leo John xin");
	        Name name2 = new Name("Lew");
	        assertEquals(name1.isSimilar(name2), false);
	        assertEquals(name2.isSimilar(name1), false);
        } catch (IllegalValueException e) {
	        fail("Name is not Valid");
        }
	}
	
	
}
