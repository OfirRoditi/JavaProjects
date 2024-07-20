package CreatingQuque;

public class ArrayQueue<T> implements Queue<T> {
    private T[] queue;
    private int size;

    public ArrayQueue(int capacity) {
        queue = (T[]) new Object[capacity];
        size = 0;
    }

    /**
     * @param object added to the queue array
     */
    @Override
    public void enqueue(T object) {
        try {
            if (isFull() == true) {
                throw new Exception("Stock is full\nfalse");
            }
            queue[size++] = object;


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public T dequeue() {
        T variable = null;
        try {
            if (isEmpty() == true) {
                throw new Exception("null");
            }

            variable = queue[0];
            //queue[0]=queue[1];
            for (int i = 1; i < queue.length; i++) {
                queue[i - 1] = queue[i];
                if (i + 1 == queue.length && queue[i] != null) {
                    queue[i] = null;
                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return variable;
    }

    @Override
    public T peek() {
        T variable = null;
        try {
            if (isEmpty() == true)
                throw new Exception("null");
            variable = queue[0];
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
        return variable;
    }

    @Override
    public int size() {
        int counter = 0;
        int i = 0;
        while (queue[i] != null&&i != queue.length-1) {
            counter += 1;
            i++;
        }
        if (counter == 0)
            return 0;
        return counter;
    }

    @Override
    public boolean isEmpty() {

        if (size != 0) {
            return false;
        } else return true;
    }

    @Override
    public boolean isFull()  {
        if (size == queue.length) {
            return true;
        } else return false;
    }

//    public String toString() {
//        {
//            if (isEmpty())
//                return "[]";
//            else {
//                String s = "[";
//                for (int i = 0; i < size; i++) {
//                    s += queue[i];
//
//                    if (i < size) {
//                        s += ", ";
//                    }
//                }
//                return s + "]";
//            }
//        }
//    }
}