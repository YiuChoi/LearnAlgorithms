## 链表简单学习
### 什么是链表
链表是一种用于存储数据集合的数据结构。链表有以下属性：
- 相邻元素通过指针链接
- 最后一个元素的后继指针为null
- 在程序执行过程中，链表的长度可以增加或缩小
- 链表的空间能够按需分配（直到系统内存耗尽）
- 没有内存空间浪费
### 使用链表
使用链表结构可以克服数组链表需要预先知道数据大小的缺点，链表结构可以充分利用计算机内存空间，实现灵活的内存动态管理。但是链表失去了数组随机读取的优点，同时链表由于增加了结点的指针域，空间开销比较大。
### 链表分类
- 单向链表
- 双向链表

   双向链表也叫双链表，是链表的一种，它的每个数据结点中都有两个指针，分别指向直接后继和直接前驱。所以，从双向链表中的任意一个结点开始，都可以很方便地访问它的前驱结点和后继结点。一般我们都构造双向循环链表。
- 其他链表

    以上两种链表有各种变形，比如松散链表，循环链表等。
### 链表的实现
- 单向链表

```java
public class ListNode {
    private int data;
    private ListNode next;
    public ListNode(int data){
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }
}
```
- 双向链表

```java
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
```
### 链表简单操作
- 在单向链表中插入节点
1. 在开头插入
    
    - 修改新节点 next 指针，使其指向当前表头节点。
    - 修改表头结点指针，使其指向新节点。
2. 在结尾插入
    
    - 新节点的 next 指针指向NULL。
    - 最后一个节点的 next 指针指向新节点。
3. 在中间插入

    - 如果要在位置 n 增加新节点，则需要将指针定位于链表 n-1 。即需要从表头开始经过 n-1 个节点，然后插入新节点，新节点的 next 指针指向 n 节点，n-1 节点的 next 指针指向新节点。 
- 学会了插入新节点，删除等其他操作大同小异
### 其他
- 栈
    
    先入后出
- 队列

    先入先出
  
都可以用链表或数组实现，链表更优