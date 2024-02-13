public class MyGenList<T> {
    private int size = 0;
    private int capacity = 5;
    private T array[];


    public MyGenList() {
        array = (T[]) new Object[capacity];
    }

    public void add(T value) throws ArrayFullException {
        try {
            array[size++] = value;
        } catch (IndexOutOfBoundsException e) {
            size = 5;
            throw new ArrayFullException(value);
        }
    }

    public void addAt(int pos, T value) throws ArrayFullException {
        if (size == capacity) {
            throw new ArrayFullException(value);
        }
        if (pos > size + 1) {
            throw new InvalidPositionException(size + 1);
        }
        size++;
        for (int i = size - 1; i >= pos; i--) {
            array[i] = array[i - 1];
        }
        array[pos - 1] = value;
    }

    public boolean remove(Object value) {
        boolean isFound = false;
        for (int i = 0; i < size; i++) {
            if (array[i].toString().equals(value.toString())) {
                isFound = true;
                for (int j = i; j < size - 1; j++) {
                    array[j] = array[j + 1];
                }
                size--;
                break;
            }
        }
        return isFound;
    }

    public T removeAt(int pos) {
        if (pos > size) {
            throw new InvalidPositionException(size);
        }
        T removed = array[pos - 1];

        for (int i = pos - 1; i < size; i++) {
            array[i] = array[i + 1];
        }
        size--;
        return removed;
    }

    public boolean contains(Object value) {
        boolean isFound = false;
        for (int i = 0; i < size; i++) {
            if (array[i].toString().equals(value.toString())) {
                isFound = true;
                break;
            }
        }
        return isFound;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public T get(int pos) {
        if (pos > size || pos == 0) {
            throw new InvalidPositionException(size);
        }
        return array[pos - 1];
    }

    public T set(int pos, T value) {
        if (pos > size) {
            throw new InvalidPositionException(size);
        }
        T replaced = array[pos - 1];
        array[pos - 1] = value;
        return replaced;
    }

}
