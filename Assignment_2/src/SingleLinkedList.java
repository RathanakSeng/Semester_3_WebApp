public class SingleLinkedList {

    Node head;

    static class Node {
        Object data;
        Node next;

        Node (Object data) {this.data = data;}
    }

    public void insertFirst (Object data) {
        Node new_node = new Node(data);
        new_node.next = this.head;
        this.head = new_node;
    }

    public void insertLast (Object data) {
        Node new_node = new Node(data);
        Node p = this.head;

        while (p.next != null) p = p.next;
        p.next = new_node;
        new_node.next = null;
    }

    public void insertByPosition (int position, Object data) {
        Node new_node = new Node(data);
        new_node.next = null;

        if (this.head == null) {
            if (position == 0) this.head = new_node;
            else throw new NullPointerException();
        }

        if (position == 0) {
            new_node.next = this.head;
            this.head = new_node;
            return;
        }

        Node current = this.head;
        Node prev = null;
        int i = 0;

        while (i < position) {
            prev = current;
            current = current.next;
            if (current == null) break;
            i++;
        }

        new_node.next = current;
        prev.next = new_node;
    }

    public void deleteFirst () {
        this.head = this.head.next;
    }

    public void deleteLast () {
        Node node = this.head;
        Node delete_node = node.next;
        while (delete_node.next != null) {
            node = node.next;
            delete_node = delete_node.next;
        }
        node.next = null;
    }

    public void deleteByPosition (int position) {
        if (position == 0) {
            this.head = this.head.next;
            return;
        }
        int i = 0;
        Node prev = null;
        Node current = this.head;

        while (i < position) {
            prev = current;
            current = current.next;
            i++;
        }

        prev.next = current.next;
    }

    @Override
    public String toString() {
        Node node_data = this.head;
        String return_data = "[ ";
        while (node_data != null) {
            return_data += node_data.data + " ";
            node_data = node_data.next;
        }
        return_data += "]";
        return return_data;
    }
}
