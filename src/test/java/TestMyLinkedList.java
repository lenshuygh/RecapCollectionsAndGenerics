import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestMyLinkedList {
    @Test
    public final void canCreateInstance() {
        MyLinkedList myLinkedList = new MyLinkedList<>();
    }

    @Test
    public final void canAddElement() {
        MyLinkedList<String> myLinkedList = new MyLinkedList<>();

        final boolean addingSucceeded = myLinkedList.add("test");

        assertEquals(true, addingSucceeded);
    }

    @Test
    public final void canAdd2elements() {
        MyLinkedList<String> myLinkedList = new MyLinkedList<>();

        final boolean addFirstSucceeded = myLinkedList.add("test");
        final boolean addSecondSucceeded = myLinkedList.add("test2");

        assertEquals(true, addFirstSucceeded);
        assertEquals(true, addSecondSucceeded);
    }

    @Test
    public final void canGetSize() {
        MyLinkedList<String> myLinkedList = new MyLinkedList<>();
        myLinkedList.add("test");
        myLinkedList.add("test");

        final int listSize = myLinkedList.size();

        assertEquals(2, listSize);
    }

    @Test
    public final void canClear() {
        MyLinkedList<String> myLinkedList = new MyLinkedList<>();
        myLinkedList.add("test");

        myLinkedList.clear();

        assertEquals(0, myLinkedList.size());
    }

    @Test
    public final void canRemoveObject() {
        MyLinkedList<String> myLinkedList = new MyLinkedList<>();
        myLinkedList.add("test");

        myLinkedList.remove("test");

        assertEquals(0, myLinkedList.size());
    }

    @Test
    public final void canRemoveObjectFromSize3() {
        MyLinkedList<String> myLinkedList = new MyLinkedList<>();
        myLinkedList.add("test");
        myLinkedList.add("testX");
        myLinkedList.add("test");

        myLinkedList.remove("testX");

        assertEquals(2, myLinkedList.size());
    }

    @Test
    public final void tryRemoveObjectNotInList() {
        MyLinkedList<String> myLinkedList = new MyLinkedList<>();
        myLinkedList.add("test");
        myLinkedList.add("testX");

        final boolean removalResult = myLinkedList.remove("nothing");
        final int listSize = myLinkedList.size();

        assertEquals(false, removalResult);
        assertEquals(2, listSize);
    }

    @Test
    public final void cannotGetFromEmptyList() {
        MyLinkedList<String> myLinkedList = new MyLinkedList<>();

        assertThrows(IndexOutOfBoundsException.class, () -> myLinkedList.get(1));
    }

    @Test
    public final void canGetItemFromList() {
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
        myLinkedList.add(5);

        final Integer receivedElement = myLinkedList.get(0);

        assertEquals(Integer.valueOf(5), receivedElement);
    }

    @Test
    public final void canGetItemFromBiggerList() {
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
        myLinkedList.add(5);
        myLinkedList.add(5);
        myLinkedList.add(10);
        myLinkedList.add(11);
        myLinkedList.add(5);

        final Integer receivedElement = myLinkedList.get(3);

        assertEquals(Integer.valueOf(11), receivedElement);
    }

    @Test
    public final void canAddAtPosition0() {
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
        myLinkedList.add(1);
        myLinkedList.add(2);
        myLinkedList.add(3);
        myLinkedList.add(4);

        myLinkedList.add(0, 0);

        assertEquals(5, myLinkedList.size());
        assertEquals(Integer.valueOf(0), myLinkedList.get(0));
    }

    @Test
    public final void canAddAtPositionOtherThan0() {
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
        myLinkedList.add(1);
        myLinkedList.add(2);
        myLinkedList.add(3);
        myLinkedList.add(4);

        myLinkedList.add(2, 0);

        assertEquals(5, myLinkedList.size());
        assertEquals(Integer.valueOf(0), myLinkedList.get(2));
    }

    @Test
    public final void canAddAtLastPosition() {
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
        myLinkedList.add(1);
        myLinkedList.add(2);
        myLinkedList.add(3);
        myLinkedList.add(4);

        myLinkedList.add(3, 0);

        assertEquals(5, myLinkedList.size());
        assertEquals(Integer.valueOf(0), myLinkedList.get(3));
    }

    @Test
    public final void canSetData() {
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
        myLinkedList.add(1);
        myLinkedList.add(2);

        myLinkedList.set(1, 10);

        assertEquals(Integer.valueOf(10), myLinkedList.get(1));
    }

    @Test
    public final void canSetDataFirstPosition() {
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
        myLinkedList.add(1);
        myLinkedList.add(2);

        myLinkedList.set(0, 10);

        assertEquals(Integer.valueOf(10), myLinkedList.get(0));
    }

    @Test
    public final void testContainsKnownObject() {
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
        myLinkedList.add(1);
        myLinkedList.add(2);

        final boolean listContainsObject = myLinkedList.contains(2);

        assertEquals(true, listContainsObject);
    }

    @Test
    public final void testDoesntContainsObject() {
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
        myLinkedList.add(1);
        myLinkedList.add(2);

        final boolean listContainsStringObject = myLinkedList.contains("test");
        final boolean listContainsIntObject = myLinkedList.contains(10);

        assertEquals(false, listContainsStringObject);
        assertEquals(false, listContainsIntObject);
    }

    @Test
    public final void testAddWithTooLargeIndexThrowsIndexOutOfBoundsException(){
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
        myLinkedList.add(1);
        myLinkedList.add(2);

        assertThrows(IndexOutOfBoundsException.class,() -> myLinkedList.add(10,10));
    }

    @Test
    public final void testSetWithTooLargeIndexThrowsIndexOutOfBoundException(){
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
        myLinkedList.add(1);
        myLinkedList.add(2);

        assertThrows(IndexOutOfBoundsException.class,() -> myLinkedList.set(10,10));
    }

    @Test
    public final void testGetWithTooLargeIndexThrowsIndexOutOfBoundException(){
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
        myLinkedList.add(1);
        myLinkedList.add(2);

        assertThrows(IndexOutOfBoundsException.class,() -> myLinkedList.get(10));
    }
}
