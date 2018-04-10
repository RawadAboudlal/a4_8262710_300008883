// Student name: Rawad Aboudlal, Ismail Ali
// Student number: 8262710, 300008883
// Course code: ITI 1121-C

// Assignment: #4

public interface List<E> {
    void addFirst(E elem);

    int size();

    E get(int index);

    Iterator<E> iterator();
    
    Iterator<E> iterator(Iterator<E> other);
}
