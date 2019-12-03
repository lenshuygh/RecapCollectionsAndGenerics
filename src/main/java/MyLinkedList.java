import java.util.Objects;

public class MyLinkedList<E> implements MyList {
    private LinkedNode<E> linkedNode;

    @Override
    public void add(int i, Object o) {
        if (size() >= i && inputTypeMatchesNodeType(o)) {
            if (i == 0) {
                LinkedNode originalNode = linkedNode;
                linkedNode = new LinkedNode<>((E) o, originalNode);
                return;
            }
            int indexCount = 0;
            LinkedNode currentNode = linkedNode;
            LinkedNode previousNode = null;
            while (indexCount != i) {
                previousNode = currentNode;
                currentNode = currentNode.next;
                indexCount++;
            }
            previousNode.next = new LinkedNode((E) o, currentNode);
        }
    }

    @Override
    public void set(int i, Object o) {
        if (size() >= i && inputTypeMatchesNodeType(o)) {
            int indexCount = 0;
            LinkedNode currentNode = linkedNode;
            while (indexCount != i) {
                currentNode = currentNode.next;
                indexCount++;
            }
            currentNode.data = (E) o;
        }
    }

    @Override
    public Object get(int i) {
        if (size() >= i) {
            int indexCount = 0;
            LinkedNode currentNode = linkedNode;
            while (indexCount < size()) {
                if (indexCount == i) {
                    return currentNode.data;
                } else {
                    indexCount++;
                    if (null != currentNode.next) {
                        currentNode = currentNode.next;
                    }
                }
            }
        }
        return null;
    }

    @Override
    public boolean add(Object o) {
        if (null == linkedNode) {
            linkedNode = new LinkedNode<>((E) o, null);
            return true;
        }
        if (inputTypeMatchesNodeType(o)) {
            LinkedNode currentNode = linkedNode;
            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }
            currentNode.next = new LinkedNode<>((E) o, null);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean remove(Object o) {
        if (!inputTypeMatchesNodeType(o)) {
            return false;
        }
        LinkedNode currentNode = linkedNode;
        LinkedNode previousNode = null;
        boolean elementRemoved = false;
        if (size() > 1) {
            while (null != currentNode && null != currentNode.next) {
                if (currentNode.data.equals((E) o)) {
                    if (null != previousNode) {
                        previousNode.next = currentNode.next;
                        elementRemoved = true;
                    } else {
                        clear();
                    }
                }
                previousNode = currentNode;
                currentNode = currentNode.next;
            }
        } else {
            if (currentNode != null) {
                if (currentNode.data.equals(o)) {
                    clear();
                    elementRemoved = true;
                }
            }
        }
        return elementRemoved;
    }

    @Override
    public void clear() {
        linkedNode = null;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public int size() {
        int size = 0;
        LinkedNode currentNode = linkedNode;
        while (null != currentNode) {
            currentNode = currentNode.next;
            size++;
        }
        return size;
    }

    private boolean inputTypeMatchesNodeType(Object o) {
        return o.getClass().equals(linkedNode.data.getClass());
    }
}
