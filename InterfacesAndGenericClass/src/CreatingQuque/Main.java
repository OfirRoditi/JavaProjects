package CreatingQuque;

public class Main {
    public static void main(String[] args) {
        ArrayQueue a1 = new ArrayQueue<>(6);
        a1.enqueue(7);
        a1.enqueue(12);
        a1.enqueue(8);
        a1.enqueue(102);
        a1.enqueue(12);



        System.out.println(a1.toString());
        //7,12,8,102,12

        System.out.println("deququ:");
        System.out.println(a1.dequeue());

        System.out.println("Peek");
        System.out.println(a1.peek());

        System.out.println("deququ:");
        System.out.println(a1.dequeue());

        System.out.println("Size:");
        System.out.println(a1.size());

        System.out.println("Is full");
        System.out.println(a1.isFull());

        System.out.println("Is empty?");
        System.out.println(a1.isEmpty());



        //
//        System.out.println(a1.isFull());
    }

}
