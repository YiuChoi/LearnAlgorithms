/**
 * 单向链表操作
 *
 * Created by 蔡小木 on 2017/1/7 0007.
 */
public class ListNodeUtil {

    public static void main(String[] args) {


    }
    /**
     * 获取链表长度 时间复杂度O(n),空间复杂度O(1)
     *
     * @param headNode 头结点
     * @return 长度
     */
    int listNodeLength(ListNode headNode) {
        int length = 0;
        ListNode currentNode = headNode;
        while (currentNode != null) {
            length++;
            currentNode = currentNode.getNext();
        }
        return length;
    }

    /**
     * 插入节点 时间复杂度O(n),空间复杂度O(1)
     *
     * @param headNode     头结点
     * @param nodeToInsert 要插入的节点
     * @param position     插入位置
     * @return 头结点
     */
    ListNode insertInLinkedList(ListNode headNode, ListNode nodeToInsert, int position) {
        if (headNode == null) {
            return nodeToInsert;
        }
        int size = listNodeLength(headNode);
        if (position > size + 1 || position < 1) {
            throw new IndexOutOfBoundsException("Position of node to insert is invalid");
        }
        if (position == 1) {//在链表开头插入
            nodeToInsert.setNext(headNode);
            return nodeToInsert;
        } else {//在链表中间或末尾插入
            ListNode previousNode = headNode;
            int count = 1;
            while (count < position - 1) {
                previousNode = previousNode.getNext();
                count++;
            }
            ListNode currentNode = previousNode.getNext();
            nodeToInsert.setNext(currentNode);
            previousNode.setNext(nodeToInsert);
        }
        return headNode;
    }
}
