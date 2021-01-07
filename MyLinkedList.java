public class MyLinkedList {
    private int size;
    private Node start, end;

    public MyLinkedList() {
        size = 0;
    }

    public int size() {
        return size;
    }

    private Node getNthNode(int n) {
        if (n == 0) return start;
        if (n == size - 1) return end;

        Node curr = start;
        int i = 0;
        while (i < n) {
            curr = curr.getNext();
            i++;
        }
        return curr;
    }

    public String toString() {
        if (size == 0) return "[]";

        String out = "[";
        Node curr = start;
        while (curr.getNext() != null) {
            out += curr.getData() + ", ";
            curr = curr.getNext();
        }
        out += curr.getData() + "]";

        return out;
    }

    public String toStringReversed() {
        if (size == 0) return "[]";

        String out = "[";
        Node curr = end;
        while (curr.getPrev() != null) {
            out += curr.getData() + ", ";
            curr = curr.getPrev();
        }
        out += curr.getData() + "]";

        return out;
    }

    public boolean add(String value) {
        Node newValue = new Node(value);

        if (size == 0) {
            start = newValue;
            end = newValue;
        } else {
            end.setNext(newValue);
            newValue.setPrev(end);
            end = newValue;
        }

        size ++;
        return true;
    }

    public void add(int index, String value) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index " + index + " is not in range");
        }

        Node newValue = new Node(value);
        if (size == 0) {
            start = newValue;
            end = newValue;
        } else if (index == size) {
            end.setNext(newValue);
            newValue.setPrev(end);
            end = newValue;
        } else if (index == 0) {
            start.setPrev(newValue);
            newValue.setNext(start);
            start = newValue;
        } else {
            Node newPrev = getNthNode(index - 1);
            Node newNext = getNthNode(index);
            newValue.setPrev(newPrev);
            newValue.setNext(newNext);
            newPrev.setNext(newValue);
            newNext.setPrev(newValue);
        }
        
        size ++;
    }

    public String get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " is not in range");
        }

        return getNthNode(index).getData();
    }

    public String set(int index, String value) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " is not in range");
        }

        Node n = getNthNode(index);
        String oldString = n.getData();
        n.setValue(value);

        return oldString;
    }

    public String remove(int index) {
        String old;

        if (size == 1) {
            old = start.getData();
            start = null;
            end = null;
        } else if (index == 0) {
            old = start.getData();
            start.getNext().setPrev(null);
            start.setNext(null);
        } else if (index == size - 1) {
            old = end.getData();
            end.getPrev().setNext(null);
            end.setPrev(null);
        } else {
            Node oldNode = getNthNode(index);
            old = oldNode.getData();
            oldNode.getPrev().setNext(oldNode.getNext());
            oldNode.getNext().setPrev(oldNode.getPrev());
            oldNode.setPrev(null);
            oldNode.setNext(null);
        }

        size--;
        return old;
    }
}
