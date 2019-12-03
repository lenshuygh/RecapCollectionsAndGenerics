import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestMyLinkedList {
    @Test
    public final void canCreateInstance() {
        MyLinkedList myLinkedList = new MyLinkedList<>();
    }

    @Test
    public final void canAddElement() {
        MyLinkedList myLinkedList = new MyLinkedList<>();
        assertEquals(true, myLinkedList.add("test"));
    }

    @Test
    public final void cannotAddOtherObject() {
        MyLinkedList myLinkedList = new MyLinkedList<>();
        myLinkedList.add("test");
        assertEquals(false, myLinkedList.add(10));
    }

    @Test
    public final void canAdd2elements() {
        MyLinkedList myLinkedList = new MyLinkedList<>();
        assertEquals(true, myLinkedList.add("test"));
        assertEquals(true, myLinkedList.add("test2"));
    }

    @Test
    public final void canGetSize() {
        MyLinkedList myLinkedList = new MyLinkedList<>();
        assertEquals(0, myLinkedList.size());
        myLinkedList.add("test");
        assertEquals(1, myLinkedList.size());
        myLinkedList.add("test");
        assertEquals(2, myLinkedList.size());
    }

    @Test
    public final void canClear() {
        MyLinkedList myLinkedList = new MyLinkedList<>();
        myLinkedList.add("test");
        assertEquals(1, myLinkedList.size());
        myLinkedList.clear();
        assertEquals(0, myLinkedList.size());
    }

    @Test
    public final void canRemoveObject() {
        MyLinkedList myLinkedList = new MyLinkedList<>();
        myLinkedList.add("test");
        assertEquals(1, myLinkedList.size());
        myLinkedList.remove("test");
        assertEquals(0, myLinkedList.size());
    }

    @Test
    public final void canRemoveObjectFromSize3() {
        MyLinkedList myLinkedList = new MyLinkedList<>();
        myLinkedList.add("test");
        myLinkedList.add("testX");
        myLinkedList.add("test");
        myLinkedList.remove("testX");
        assertEquals(2, myLinkedList.size());
    }

    @Test
    public final void tryRemoveObjectNotInList() {
        MyLinkedList myLinkedList = new MyLinkedList<>();
        myLinkedList.add("test");
        myLinkedList.add("testX");
        assertEquals(false, myLinkedList.remove("nothing"));
        assertEquals(2, myLinkedList.size());
    }

    @Test
    public final void cannotRemoveOtherObject() {
        MyLinkedList myLinkedList = new MyLinkedList<>();
        myLinkedList.add("test");
        assertEquals(false, myLinkedList.remove(10));
    }

    @Test
    public final void cannotGetFromEmptyList() {
        MyLinkedList myLinkedList = new MyLinkedList<>();
        assertEquals(null, myLinkedList.get(1));
    }

    @Test
    public final void cannotGetHigherIndexThanElementsInList() {
        MyLinkedList myLinkedList = new MyLinkedList<>();
        myLinkedList.add(5);
        myLinkedList.add(10);
        assertEquals(null, myLinkedList.get(10));
    }

    @Test
    public final void canGetItemFromList() {
        MyLinkedList myLinkedList = new MyLinkedList<>();
        myLinkedList.add(5);
        assertEquals(5, myLinkedList.get(0));
    }

    @Test
    public final void canGetItemFromBiggerList() {
        MyLinkedList myLinkedList = new MyLinkedList<>();
        myLinkedList.add(5);
        myLinkedList.add(5);
        myLinkedList.add(10);
        myLinkedList.add(11);
        myLinkedList.add(5);
        assertEquals(11, myLinkedList.get(3));
    }

    @Test
    public final void canAddAtPosition0() {
        MyLinkedList myLinkedList = new MyLinkedList<>();
        myLinkedList.add(1);
        myLinkedList.add(2);
        myLinkedList.add(3);
        myLinkedList.add(4);
        assertEquals(4, myLinkedList.size());
        myLinkedList.add(0, 0);
        assertEquals(5, myLinkedList.size());
        assertEquals(0, myLinkedList.get(0));
    }

    @Test
    public final void canAddAtPositionOtherThan0() {
        MyLinkedList myLinkedList = new MyLinkedList<>();
        myLinkedList.add(1);
        myLinkedList.add(2);
        myLinkedList.add(3);
        myLinkedList.add(4);
        assertEquals(4, myLinkedList.size());
        myLinkedList.add(2, 0);
        assertEquals(5, myLinkedList.size());
        assertEquals(0, myLinkedList.get(2));
    }

    @Test
    public final void canAddAtLastPosition() {
        MyLinkedList myLinkedList = new MyLinkedList<>();
        myLinkedList.add(1);
        myLinkedList.add(2);
        myLinkedList.add(3);
        myLinkedList.add(4);
        assertEquals(4, myLinkedList.size());
        myLinkedList.add(3, 0);
        assertEquals(5, myLinkedList.size());
        assertEquals(0, myLinkedList.get(3));
    }

    @Test
    public final void cannotAddAtTooLargePosition() {
        MyLinkedList myLinkedList = new MyLinkedList<>();
        myLinkedList.add(1);
        myLinkedList.add(2);
        myLinkedList.add(3);
        myLinkedList.add(4);
        assertEquals(4, myLinkedList.size());
        myLinkedList.add(5, 0);
        assertEquals(4, myLinkedList.size());
    }

    @Test
    public final void canSetData() {
        MyLinkedList myLinkedList = new MyLinkedList<>();
        myLinkedList.add(1);
        myLinkedList.add(2);
        assertEquals(2, myLinkedList.get(1));
        myLinkedList.set(1, 10);
        assertEquals(10, myLinkedList.get(1));
    }

    @Test
    public final void canSetDataFirstPosition() {
        MyLinkedList myLinkedList = new MyLinkedList<>();
        myLinkedList.add(1);
        myLinkedList.add(2);
        assertEquals(1, myLinkedList.get(0));
        myLinkedList.set(0, 10);
        assertEquals(10, myLinkedList.get(0));
    }
}
