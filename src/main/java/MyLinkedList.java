import java.util.Objects;

public class MyLinkedList<E> implements MyList<E> {
    private LinkedNode<E> linkedNode;

    @Override
    public void add(int i, E e) {
        if (size() >= i) {
            if (i == 0) {
                LinkedNode<E> originalNode = linkedNode;
                linkedNode = new LinkedNode<>(e, originalNode);
                return;
            }
            int indexCount = 0;
            LinkedNode<E> currentNode = linkedNode;
            LinkedNode<E> previousNode = null;
            while (indexCount != i) {
                previousNode = currentNode;
                currentNode = currentNode.getNext();
                indexCount++;
            }
            previousNode.setNext(new LinkedNode<>(e, currentNode));
        }
    }

    @Override
    public void set(int i, E e) {
        if (size() >= i) {
            int indexCount = 0;
            LinkedNode<E> currentNode = linkedNode;
            while (indexCount != i) {
                currentNode = currentNode.getNext();
                indexCount++;
            }
            currentNode.setData(e);
        }
    }

    @Override
    public E get(int i) {
        if (size() >= i) {
            int indexCount = 0;
            LinkedNode<E> currentNode = linkedNode;
            while (indexCount < size()) {
                if (indexCount == i) {
                    return currentNode.getData();
                } else {
                    indexCount++;
                    if (null != currentNode.getNext()) {
                        currentNode = currentNode.getNext();
                    }
                }
            }
        }
        return null;
    }

    @Override
    public boolean add(E e) {
        if (null == linkedNode) {
            linkedNode = new LinkedNode<>(e, null);
        } else {
            LinkedNode<E> currentNode = linkedNode;
            while (currentNode.getNext() != null) {
                currentNode = currentNode.getNext();
            }
            currentNode.setNext(new LinkedNode<>(e, null));
        }
        return true;
    }

    @Override
    public boolean remove(E e) {
        LinkedNode<E> currentNode = linkedNode;
        LinkedNode<E> previousNode = null;
        boolean elementRemoved = false;
        if (size() > 1) {
            while (null != currentNode && null != currentNode.getNext()) {
                if (currentNode.getData().equals(e)) {
                    if (null != previousNode) {
                        previousNode.setNext(currentNode.getNext());
                        elementRemoved = true;
                    } else {
                        clear();
                    }
                }
                previousNode = currentNode;
                currentNode = currentNode.getNext();
            }
        } else {
            if (currentNode != null && currentNode.getData().equals(e)) {
                clear();
                elementRemoved = true;
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
        LinkedNode<E> currentNode = linkedNode;
        while (null != currentNode) {
            if (currentNode.getData().equals(o)) {
                return true;
            }
            currentNode = currentNode.getNext();
        }
        return false;
    }

    @Override
    public int size() {
        int size = 0;
        LinkedNode currentNode = linkedNode;
        while (null != currentNode) {
            currentNode = currentNode.getNext();
            size++;
        }
        return size;
    }
}
