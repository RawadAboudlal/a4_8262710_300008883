// Student name: Rawad Aboudlal, Ismail Ali
// Student number: 8262710, 300008883
// Course code: ITI 1121-C

// Assignment: #4

public interface List<E> {

    public abstract void add(int index, E elem);

    public abstract void add(E elem);

    public abstract E remove(int index);

    public abstract boolean remove(E o);

    public abstract E get(int index);

    public abstract int size();

    public abstract boolean isEmpty();
}
