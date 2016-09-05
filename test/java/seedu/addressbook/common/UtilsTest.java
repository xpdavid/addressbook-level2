package seedu.addressbook.common;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;

import seedu.addressbook.parser.Parser;


public class UtilsTest {

	private Object nullObject;
	private Collection<String> collection;

    @Before
    public void setup() {
    	     nullObject = null;
    	     collection = new ArrayList<String>();
    }
	
    /*
     * Tests for Utils.isAnyNull ===============================================================
     */
    
	@Test
	public void isAnyNull_emptyInput_shouldReturnFalse() {
		assertEquals(Utils.isAnyNull(), false);
	}
	
	@Test
	public void isAnyNull_noNullInputs_shouldReturnFalse() {
		assertEquals(Utils.isAnyNull((new Object()),
				                     (new Object()),
				                     (new Object()),
				                     (new Object())), false);
	}
	
	@Test
	public void isAnyNull_hasNullInputs_shouldReturnTrue() {
		assertEquals(Utils.isAnyNull((new Object()),
				                     (new Object()),
				                     nullObject,
				                     (new Object())), true);
	}
	
	@Test
	public void isAnyNull_allNullInput_shouldReturnTrue() {
		Object test = null;
		assertEquals(Utils.isAnyNull(test), true);
	}
	
	@Test
	public void isAnyNull_allNullInputs_shouldReturnTrue() {
		assertEquals(Utils.isAnyNull(nullObject, nullObject), true);
	}
	
	/*
     * Tests for Utils.elementsAreUnique ===============================================================
     */
	
	@Test
	public void isElementsUnique_emptyCollection_shouldReturnTrue() {
		collection.clear();
		assertEquals(Utils.elementsAreUnique(collection), true);
	}
	
	@Test
	public void isElementsUnique_oneElement_shouldReturnTrue() {
		collection.clear();
		collection.add("test");
		assertEquals(Utils.elementsAreUnique(collection), true);
	}
	
	@Test
	public void isElementsUnique_uniqueElements_shouldReturnTrue() {
		collection.clear();
		collection.add("a");
		collection.add("b");
		collection.add("c");
		collection.add("d");
		assertEquals(Utils.elementsAreUnique(collection), true);
	}
	
	@Test
	public void isElementsUnique_oneDuplicatedElement_shouldReturnFalse() {
		collection.clear();
		collection.add("a");
		collection.add("a");
		collection.add("c");
		assertEquals(Utils.elementsAreUnique(collection), false);
	}
	
	@Test
	public void isElementsUnique_allDuplicatedElements_shouldReturnFalse() {
		collection.clear();
		collection.add("a");
		collection.add("a");
		collection.add("a");
		assertEquals(Utils.elementsAreUnique(collection), false);
	}
}
