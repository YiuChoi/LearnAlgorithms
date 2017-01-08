import java.beans.BeanInfo;
import java.util.Stack;

/**
 * Created by 蔡小木 on 2017/1/8 0008.
 */
public class BinaryTreeUtil {
    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(1);
        root.setLeft(new BinaryTreeNode(2));
        root.setRight(new BinaryTreeNode(3));
        root.getLeft().setLeft(new BinaryTreeNode(4));
        root.getLeft().setRight(new BinaryTreeNode(5));
        root.getRight().setLeft(new BinaryTreeNode(6));
        root.getRight().setRight(new BinaryTreeNode(7));
        //preOrder(root);
        //preOrderNonRecursive(root);
        //inOrder(root);
        //inOrderNonRecursive(root);
        postOrder(root);
        iterativePostOrder(root);
    }

    /**
     * 前序遍历
     *
     * @param root 根节点
     */
    static void preOrder(BinaryTreeNode root) {
        if (root != null) {
            System.out.println(root.getData());
            preOrder(root.getLeft());
            preOrder(root.getRight());
        }
    }

    /**
     * 非递归前序遍历
     *
     * @param root 根节点
     */
    static void preOrderNonRecursive(BinaryTreeNode root) {
        if (root == null) return;
        Stack<BinaryTreeNode> stack = new Stack<>();
        while (true) {
            while (root != null) {
                System.out.println(root.getData());
                stack.push(root);
                root = root.getLeft();
            }
            if (stack.isEmpty()) break;
            root = stack.pop();
            root = root.getRight();
        }
    }

    /**
     * 中序遍历
     *
     * @param root 根节点
     */
    static void inOrder(BinaryTreeNode root) {
        if (root != null) {
            inOrder(root.getLeft());
            System.out.println(root.getData());
            inOrder(root.getRight());
        }
    }

    /**
     * 非递归中序遍历
     *
     * @param root 根节点
     */
    static void inOrderNonRecursive(BinaryTreeNode root) {
        if (root == null) return;
        Stack<BinaryTreeNode> stack = new Stack<>();
        while (true) {
            while (root != null) {
                stack.push(root);
                root = root.getLeft();
            }
            if (stack.isEmpty()) break;
            root = stack.pop();
            System.out.println(root.getData());
            root = root.getRight();
        }
    }

    /**
     * 后序遍历
     *
     * @param root 根节点
     */
    static void postOrder(BinaryTreeNode root) {
        if (root != null) {
            postOrder(root.getLeft());
            postOrder(root.getRight());
            System.out.println(root.getData());
        }
    }

    //有问题
    static void postOrderNonRecursive(BinaryTreeNode root) {
        Stack<BinaryTreeNode> stack = new Stack<>();
        while (true) {
            if (root != null) {
                stack.push(root);
                root = root.getLeft();
            } else {
                if (stack.isEmpty()) {
                    System.out.println("Stack is empty");
                    break;
                } else if (stack.peek().getRight() == null) {
                    root = stack.pop();
                    System.out.println(root.getData());
                    if (root == stack.peek().getRight()) {
                        System.out.println(stack.pop().getData());
                    }
                }
                if (!stack.isEmpty()) root = stack.peek().getRight();
                else root = null;
            }
        }
        stack.clear();
    }

    /**
     * 非递归实现后序遍历
     */
    static void iterativePostOrder(BinaryTreeNode p) {
        BinaryTreeNode q = p;
        Stack<BinaryTreeNode> stack = new Stack<>();
        while (p != null) {
            // 左子树入栈
            for (; p.getLeft() != null; p = p.getLeft())
                stack.push(p);
            // 当前节点无右子或右子已经输出
            while (p != null && (p.getRight() == null || p.getRight() == q)) {
                System.out.println(p.getData());
                q = p;// 记录上一个已输出节点
                if (stack.empty())
                    return;
                p = stack.pop();
            }
            // 处理右子
            stack.push(p);
            p = p.getRight();
        }
    }
}
