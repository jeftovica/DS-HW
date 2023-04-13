package task1;

public class Stack<Item> {
    private Queue<Item> q1;
    private Queue<Item> q2;
    static int current_size;

    public Stack() {
        q1 = new Queue<Item>();
        q2  = new Queue<Item>();
    }

    public void push(Item data) {
            q2.enqueue(data);
            while (!q1.isEmpty()) {
                q2.enqueue(q1.dequeue());
            }
            Queue<Item> q = q1;
            q1 = q2;
            q2 = q;
    }

    public Item pop() {
        if (q1.isEmpty()){
            throw new IndexOutOfBoundsException();
        }
        Item dequeue = q1.dequeue();
        return dequeue;
    }

    public Item peek() {
        if (q1.isEmpty()) {
            throw new IndexOutOfBoundsException();
        }
        return q1.peek();
    }

    public int size() {
        return q1.size();
    }

    public boolean isEmpty() {
        return q1.isEmpty();
    }
}
