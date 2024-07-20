package CreatingQuque;

/**
 *
 * @param <T> interface class that has many abstract methods
 */
public interface Queue<T> {

    public void enqueue(T o);
    public T dequeue();
    public T peek();
    public int size();
    public boolean isEmpty();
    public boolean isFull() throws Exception;
}