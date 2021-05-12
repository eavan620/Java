package work;

public class RandomQueue<T> implements Queue<T> {
    private T[] _items;           // generic array used for storage
    private int _front;           // the index of the item at the front
    private int _rear;            // the index of the item at the rear
    private int _numItems;        // the number of items in the queue

    public RandomQueue(int maxSize) {
        _items = (T[])new Object[maxSize];
        _front = 0;
        _rear = -1;
        _numItems = 0;
    }
    public RandomQueue() {
        _items = (T[])new Object[100];
        _front = 0;
        _rear = -1;
        _numItems = 0;
    }
    public T front() {
        if (_numItems== 0) return null;
        return _items[_front];
    }

    public boolean isEmpty() {
        return (_numItems == 0);
    }


    public void enqueue(T item) {
        System.out.println("Inserting " + item);
        _rear = (_rear + 1) % _items.length;    // increment rear before adding the item
        _items[_rear] = item;                   // store new item
        _numItems++;
    }

    public T dequeue() {
        if (isEmpty()) {
          return  null;
        }
        System.out.println("Removing " + _items[_front]);

        T removed = _items[_front];
        _items[_front] = null;     // dereferencing allows the garbage collector to free memory
        _front = (_front + 1) % _items.length;  // increment front
        _numItems--;
        return removed;
    }

    @Override
    public int size() {
        return this._numItems;
    }


    public static void main (String[] args)
    {
        // create a queue of capacity 5
        RandomQueue<Integer> q = new RandomQueue<>() ;

        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);

        System.out.println("Front element is: " + q.front());
        q.dequeue();
        System.out.println("Front element is: " + q.front());

        System.out.println("Queue size is " + q.size());

        q.dequeue();
        q.dequeue();

        if (q.isEmpty())
            System.out.println("Queue Is Empty");
        else
            System.out.println("Queue Is Not Empty");
    }
}
