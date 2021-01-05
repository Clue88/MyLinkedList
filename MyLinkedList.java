public class MyLinkedList {
    private int size;
    private Node start, end;

    public MyLinkedList() {
        size = 0;
    }

    public int size() {
        return size;
    }

    public String toString() {
        if (size == 0) return "[]";

        String out = "[";
        Node curr = start;
        while (curr.getNext() != null) {
            out += curr.getValue() + ", ";
            curr = curr.getNext();
        }
        out += curr.getValue() + "]";

        return out;
    }

    public boolean add(String value) {
        Node newValue = new Node(value);

        if (size == 0) {
            start = newValue;
            end = newValue;
            size ++;
        } else {
            end.setNext(newValue);
            newValue.setPrev(end);
            end = newValue;
        }

        return true;
    }

    public String get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " is not in range");
        }

        Node curr = start;
        int i = 0;
        while (i < index) curr = curr.getNext();
        return curr.getValue();
    }
}
