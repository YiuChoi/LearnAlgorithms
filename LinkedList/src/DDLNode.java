/**
 * 双向链表
 *
 * Created by 蔡小木 on 2017/1/7 0007.
 */
public class DDLNode {
    private int data;
    private DDLNode next;
    private DDLNode previous;

    public DDLNode(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public DDLNode getNext() {
        return next;
    }

    public void setNext(DDLNode next) {
        this.next = next;
    }

    public DDLNode getPrevious() {
        return previous;
    }

    public void setPrevious(DDLNode previous) {
        this.previous = previous;
    }
}
