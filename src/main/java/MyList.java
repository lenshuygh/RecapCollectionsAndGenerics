public interface MyList<E> extends MyCollection<E> {
    void add(int i,E e) throws IndexOutOfBoundsException;

    void set(int i,E e) throws IndexOutOfBoundsException;

    E get(int i) throws IndexOutOfBoundsException;
}
