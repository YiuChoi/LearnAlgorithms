/**
 * 双向链表操作
 * <p>
 * Created by 蔡小木 on 2017/1/7 0007.
 */
public class DDLNodeUtil {
    public static void main(String[] args) {

    }

    /**
     * 双向链表长度
     *
     * @param headNode
     * @return
     */
    int DDLlength(DDLNode headNode) {
        int length = 0;
        DDLNode currentNode = headNode;
        while (currentNode != null) {
            length++;
            currentNode = currentNode.getNext();
        }
        return length;
    }

    /**
     * 双向链表插入
     *
     * @param headNode
     * @param nodeToInsert
     * @param position
     * @return
     */
    DDLNode DDLinsert(DDLNode headNode, DDLNode nodeToInsert, int position) {
        if (headNode == null) {
            return nodeToInsert;
        }
        int size = DDLlength(headNode);
        if (position > size + 1 || position < 1) {
            throw new IndexOutOfBoundsException("Position of nodeToInsert is invalid");
        }
        if (position == 1) {//链表开头插入
            nodeToInsert.setNext(headNode);
            headNode.setPrevious(nodeToInsert);
            return nodeToInsert;
        } else {//在链表中间或末尾插入
            DDLNode previousNode = headNode;
            int count = 1;
            while (count < position - 1) {
                previousNode = previousNode.getNext();
                count++;
            }
            DDLNode currentNode = previousNode.getNext();
            nodeToInsert.setNext(currentNode);
            if (currentNode != null) {
                currentNode.setPrevious(nodeToInsert);
            }
            previousNode.setNext(nodeToInsert);
            nodeToInsert.setPrevious(previousNode);
        }
        return headNode;
    }
}
