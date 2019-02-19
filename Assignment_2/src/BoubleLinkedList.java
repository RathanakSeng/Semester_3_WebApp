public class BoubleLinkedList
{
    Node head;

    static class Node {
        Object data;
        Node next;
        Node prev;

        Node (Object data) {this.data = data;}
    }

    public void insertFirst (Object data) {
        Node new_node = new Node(data);

        if (this.head == null) {
            new_node.next = null;
            new_node.prev = null;
            this.head = new_node;
            return;
        }

        new_node.next = this.head;
        new_node.prev = null;
        this.head.prev = new_node;
        this.head = new_node;
    }

    public void insertLast (Object data) {
        Node new_node = new Node(data);

        if (this.head == null) {
            new_node.next = null;
            new_node.prev = null;
            this.head = new_node;
            return;
        }

        Node last = this.head;
        while (last.next != null) {
            last = last.next;
        }
        last.next = new_node;
        new_node.prev = last;
        new_node.next = null;
    }

    public void insertByPosition (int position, Object data) {
        Node new_node = new Node(data);
        new_node.next = null;
        new_node.prev = null;

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
        new_node.prev = prev;
        prev.next = new_node;
    }

    public void deleteFirst () {
        this.head = this.head.next;
        this.head.prev = null;
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
            this.head.prev = null;
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

        Node next_node = current.next;
        prev.next = next_node;
        next_node.prev = prev;
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
