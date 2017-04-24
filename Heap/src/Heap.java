/**
 * Created by xiaomu on 2017/4/24.
 */
public class Heap {
    public int[] array;
    public int count;
    public int capacity;
    public int heap_type;

    public Heap(int capacity, int heap_type) {
        this.capacity = capacity;
        this.heap_type = heap_type;
        this.count = 0;
        this.array = new int[capacity];
    }

    public int Parent(int i) {
        if (i <= 0 || i >= this.count)
            return -1;
        return (i - 1) / 2;
    }

    public int LeftChild(int i) {
        int left = 2 * i + 1;
        if (left >= this.count)
            return -1;
        return left;
    }

    public int RightChild(int i) {
        int left = 2 * i + 2;
        if (left >= this.count)
            return -1;
        return left;
    }

    public int getMaximum() {
        if (this.count == 0)
            return -1;
        return this.array[0];
    }

    public void PercolateDown(int i) {
        int l, r, max, temp;
        l = LeftChild(i);
        r = RightChild(i);
        if (l != -1 && this.array[l] > this.array[i]) {
            max = l;
        } else {
            max = i;
        }
        if (r != -1 && this.array[r] > this.array[max]) {
            max = r;
        }
        if (max != i) {
            temp = this.array[i];
            this.array[i] = this.array[max];
            this.array[max] = temp;
        }
        PercolateDown(max);
    }
}
