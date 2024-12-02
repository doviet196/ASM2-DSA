public class Node {
    private Student data;
    private Node next;

    // Constructor
    public Node(Student data) {
        this.data = data;
        this.next = null;
    }

    // Getter for data
    public Student getData() {
        return data;
    }

    // Setter for data
    public void setData(Student data) {
        this.data = data;
    }

    // Getter for next
    public Node getNext() {
        return next;
    }

    // Setter for next
    public void setNext(Node next) {
        this.next = next;
    }
}