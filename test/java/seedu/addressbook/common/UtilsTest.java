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
	public void check_isAnyNull_emptyInput() {
		assertEquals(Utils.isAnyNull(), false);
	}
	
	@Test
	public void check_isAnyNull_noNullInputs() {
		assertEquals(Utils.isAnyNull((new Object()),
				                     (new Object()),
				                     (new Object()),
				                     (new Object())), false);
	}
	
	@Test
	public void check_isAnyNull_hasNullInputs() {
		assertEquals(Utils.isAnyNull((new Object()),
				                     (new Object()),
				                     nullObject,
				                     (new Object())), true);
	}
	
	@Test
	public void check_isAnyNull_allNullInput_1() {
		Object test = null;
		assertEquals(Utils.isAnyNull(test), true);
	}
	
	@Test
	public void check_isAnyNull_allNullInput_2() {
		assertEquals(Utils.isAnyNull(nullObject, nullObject), true);
	}
	
	/*
     * Tests for Utils.elementsAreUnique ===============================================================
     */
	
	@Test
	public void check_isElementsUnique_emptyCollection() {
		collection.clear();
		assertEquals(Utils.elementsAreUnique(collection), true);
	}
	
	@Test
	public void check_isElementsUnique_oneElement() {
		collection.clear();
		collection.add("test");
		assertEquals(Utils.elementsAreUnique(collection), true);
	}
	
	@Test
	public void check_isElementsUnique_uniqueElements() {
		collection.clear();
		collection.add("a");
		collection.add("b");
		collection.add("c");
		collection.add("d");
		assertEquals(Utils.elementsAreUnique(collection), true);
	}
	
	@Test
	public void check_isElementsUnique_oneDuplicatedElement() {
		collection.clear();
		collection.add("a");
		collection.add("a");
		collection.add("c");
		assertEquals(Utils.elementsAreUnique(collection), false);
	}
	
	@Test
	public void check_isElementsUnique_allDuplicatedElements() {
		collection.clear();
		collection.add("a");
		collection.add("a");
		collection.add("a");
		assertEquals(Utils.elementsAreUnique(collection), false);
	}
}
