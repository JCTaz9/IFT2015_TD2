public class File {
    public int[] elements;
    public int start;
    public int end;

    public File(){
        elements = new int[100];
        start = 0;
        end = 0;
    }

    public void push(int element){
        if (length() == 100) {
            System.out.println("La file circulaire est pleine");
            return;
        }
        elements[end] = element;
        end = (end + 1) % 100;
    }

    public int pop(){
        if (length() == 0) {
            System.out.println("La file circulaire est vide");
            return -1;
        }
        int elementEnleve = elements[start];
        start = (start + 1) % 100;
        return elementEnleve;
    }

    public int length(){
        if (end >= start) {
            return end - start;
        } else {
            return end + 100 - start;
        }
    }

    public void print(){
        if (start == end) {
            System.out.println("File circulaire vide");
            return;
        }
        System.out.print("(");
        if (end > start) {
            for (int i = start; i < end - 1; i++) {
                System.out.print(elements[i] + ", ");
            }
            System.out.print(elements[end - 1]);
        } else {
            for (int i = start; i < 100; i++) {
                System.out.print(elements[i] + ", ");
            }
            for (int i = 0; i < end - 1; i++) {
                System.out.print(elements[i] + ", ");
            }
            System.out.print(elements[end - 1]);
        }
        System.out.println(")");
    }

    public boolean search(int value){
        if (start == end) {
            System.out.println("File circulaire vide");
            return false;
        }
        if (end > start) {
            for (int i = start; i < end; i++) {
                if (elements[i] == value) {
                    return true;
                }
            }
        } else {
            for (int i = start; i < 100; i++) {
                if (elements[i] == value) {
                    return true;
                }
            }
            for (int i = 0; i < end; i++) {
                if (elements[i] == value) {
                    return true;
                }
            }
        }
        return false;
    }

    public void remove(int value){
        if (start == end) {
            System.out.println("File circulaire vide");

            return;
        }
        for (int i = start; i != end; i = (i + 1) % 100) {
            if (elements[i] == value) {

                for (int j = i; j != end - 1; j = (j + 1) % 100) {
                    elements[j] = elements[(j + 1) % 100];
                }

                end = (end - 1 + 100) % 100;
                return;
            }
        }
    }
}
