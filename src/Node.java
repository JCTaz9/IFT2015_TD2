public class Node {
    private int value;
    private Node next = null;

    public Node(int value){
        this.value = value;
    }

    public Node(int value, Node next){
        this.value = value;
        this.next = next;
    }

    public void addValue(int value){
        if (this.next == null) {
            this.next = new Node(value);
        } else {
            this.next.addValue(value);
        }
    }

    public void addNode(Node next){
        if (this.next == null) {
            this.next = next;
        } else {
            this.next.addNode(next);
        }
    }

    public void removeLast(){
        if (this.next == null) {
            return;
        } else if (this.next.next == null) {
            this.next = null;
        } else {
            this.next.removeLast();
        }
    }

    public void removeValue(int value){
        if (this.next == null) {
            return;
        }
        while (this.value == value) {
            this.value = this.next.value;
            this.next = this.next.next;
            if (this.next == null) {
                return;
            }
        }
        this.next.removeValue(value);
    }

    public int length_iteratif(){
        int length = 0;
        Node current = this;
        while (current != null) {
            length++;
            current = current.next;
        }
        return length;
    }

    public int length_recurssion(){
        if (this.next == null) {
            return 1;
        } else {
            return 1 + this.next.length_recurssion();
        }
    }

    public int returnNlast(int nLast){

        if (nLast <= 0) {
            throw new IllegalArgumentException("nLast doit etre positif");
        }
        Node current = this;
        int length = 0;
        while (current != null) {
            current = current.next;
            length++;
        }
        if (nLast > length) {
            throw new IllegalArgumentException("nLast doit etre moins ou egal a la taille de la liste");
        }
        current = this;
        for (int i = 0; i < length - nLast; i++) {
            current = current.next;
        }
        return current.value;

    }

    public void addValue_ordered(int value){
        // TODO
    }

    public void insertSort(){
        // TODO
    }
}
