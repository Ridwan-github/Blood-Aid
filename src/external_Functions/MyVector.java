package external_Functions;

public class MyVector {
    private String[] vector;
    private int size;
    private int capacity;

    public MyVector() {
        this.vector = new String[1];
        this.size = 0;
        this.capacity = 1;
    }

    public void add(String str) {
        if (this.size == this.capacity) {
            String[] temp = new String[this.capacity * 2];
            for (int i = 0; i < this.size; i++) {
                temp[i] = this.vector[i];
            }
            this.vector = temp;
            this.capacity *= 2;
        }
        this.vector[this.size] = str;
        this.size++;
    }

    public String get(int index) {
        if (index < 0 || index >= this.size) {
            return null;
        }
        return this.vector[index];
    }

    public int size() {
        return this.size;
    }

    public void remove(int index) {
        if (index < 0 || index >= this.size) {
            return;
        }
        for (int i = index; i < this.size - 1; i++) {
            this.vector[i] = this.vector[i + 1];
        }
        this.size--;
    }

    public void clear() {
        this.vector = new String[1];
        this.size = 0;
        this.capacity = 1;
    }

    public boolean contains(String str) {
        for (int i = 0; i < this.size; i++) {
            if (this.vector[i].equals(str)) {
                return true;
            }
        }
        return false;
    }
}
