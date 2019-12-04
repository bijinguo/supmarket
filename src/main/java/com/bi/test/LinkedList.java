package com.bi.test;



public class LinkedList<T> {
    private Node head;//存放表头的地址引用
   /*
   *
   * */
    public boolean add(T e){
        if (head==null){
            head=new Node(e);
            head.next=head;
            head.prev=head;
            return true;

        }
        return true;
    }
    private class Node{

        T data;//要添加的元素；
        Node next;//存放下一个节点的地址（引用）
        Node prev;//存放上一个节点的地址

        public Node(T t) {
            data=t;


        }
    }



}
