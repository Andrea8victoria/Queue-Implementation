public class QueueImpl<E> implements Queue<E>{
    private E[] data;
    private int p;
    private int max;

    public QueueImpl(int length) {
        this.data = (E[]) new Object[length];
        this.p = 0;
        this.max = length;
    }
    @Override
    public void push(E e) throws FullQueueException {
        if (isFull())
            throw new FullQueueException();
        else {
            data[p] = e;
            p+=1;
        }
    }
    @Override
    public E pop() throws EmptyQueueException {
        if (isEmpty())
            throw new EmptyQueueException();

        E poppedElement = data[0];
        reorder(data);
        p--;
        return poppedElement;

    }
    @Override
    public int size() {
        return p;
    }

    private boolean isFull() {
        return (p == max);
    }

    private boolean isEmpty() {
        return (p == 0);
    }

    private void reorder(E[] data) {
        for (int i = 0; i < data.length - 1; i++) {
            data[i] = data[i + 1];
        }


    }
}
