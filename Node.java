public class Node {
    private String data;
    private Node next, prev;

    public Node(String value) {
        data = value;
    }

    public String getData() {
        return data;
    }

    public void setData(String value) {
        data = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node value) {
        next = value;
    }

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node value) {
        prev = value;
    }
}
