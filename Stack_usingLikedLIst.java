
class Node {
    int data;
    Node next;

    Node(int new_data) {
        this.data = new_data;
        this.next = null;
    }
}

class Stack {
    Node head;

    Stack() {
        this.head = null;
    }

    boolean isEmpty() {
        return head == null;
    }

    void push(int new_data) {
        Node new_node = new Node(new_data);
        new_node.next = head;
        head = new_node;
    }
    void pop() {
        if (isEmpty()) return;
        head = head.next;
    }
    int peek() {
        if (!isEmpty()) return head.data;
        return Integer.MIN_VALUE;
    }
}



public class Stack_usingLikedLIst {
    public static void main(String[] args) {
        Stack st = new Stack();

        st.push(11);
        st.push(22);
        st.push(33);
        st.push(44);

        System.out.println(st.peek());

        st.pop();
        st.pop();

        System.out.println(st.peek());
    }
}


