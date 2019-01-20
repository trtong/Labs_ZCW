package com.zipcodewilmington.singlylinkedlist;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedList<T extends Comparable<T>> {
    private int size;

    private class Node<T extends Comparable<T>> implements Comparable<Node<T>> {

        private T data;
        private Node<T> address;

        public Node(T data) {
            this.data = data;
        }

        public Node(T data, Node<T> address) {
            this.data = data;
            this.address = address;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node<T> getAddress() {
            return address;
        }

        public void setAddress(Node<T> address) {
            this.address = address;
        }


        public int compareTo(Node<T> n) {
            return this.data.compareTo(n.data);
        }
    }

    // singly linkedlist of T, only including nodes of T

    private Node<T> head;

    public SinglyLinkedList(Node<T> head) {
        this.head = head;
    }

    public SinglyLinkedList() {
    }

    public void add(T data) {
        size++;
        if (head == null) {
            head = new Node<T>(data);
        } else {
            Node<T> tail = head;

            while (tail.getAddress() != null) {
                tail = tail.getAddress();
            }

            tail.setAddress(new Node<T>(data));
        }
    }

    public void remove(int index) {

        if (index < 0 || index >= size) {
            throw new RuntimeException("Node does not exist within bounds.");
        } else {
            Node<T> cur = head;
            Node<T> prior = null;

            for (int i = 0; i < index; i++) {
                prior = cur;
                cur = cur.getAddress();
            }

            if (prior == null) {
                head = cur.getAddress();
            } else {
                prior.setAddress(cur.getAddress());
            }
            size--;
        }
    }

    public boolean contains(T data) {

        Node<T> cur = head;
        for (int i = 0; i < size; i++) {
            if (cur.getData().equals(data)) {
                return true;
            } else {
                cur = cur.getAddress();
            }
        }
        return false;
    }

    public int find(T data) {

        Node<T> cur = head;
        for (int i = 0; i < size; i++) {
            if (cur.getData().equals(data)) {
                return i;
            } else {
                cur = cur.getAddress();
            }
        }
        return -1;
    }

    public Integer size() {
        return size;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new RuntimeException("Node does not exist within bounds.");
        } else {
            Node<T> cur = head;
            for (int i = 0; i < index; i++) {
                cur = cur.getAddress();
            }

            return cur.getData();
        }
    }

    public SinglyLinkedList<T> copy() {

        SinglyLinkedList<T> newList = new SinglyLinkedList<T>();

        Node<T> cur = this.head;

        for (int i = 0; i < this.size(); i++) {
            newList.add(cur.getData());
            cur = (cur.getAddress());
        }

        return newList;
    }

    public void print() {
        Node<T> current = head;
        while(current != null) {
            System.out.println(current.getData());
            current = current.getAddress();
        }
        System.out.println("");
    }

    // Bubble sort

    public void sort() {
        Node<T> lowNode = head,
                lowPriorNode = null,
                currentNode,
                lowAddress,
                currentPriorNode,
                tempNode;

        for (int i = 0; i < size; i++) {
            currentNode = lowNode;
            for (int j = i+1; j < size; j++) {
                currentPriorNode = currentNode;
                currentNode = currentNode.getAddress();
                if (currentNode == null) break;

                // Need to swap
                if (currentNode.compareTo(lowNode) < 0) {
                    lowAddress = lowNode.getAddress();
                    // Swap low node first

                    lowNode.setAddress(currentNode.getAddress());
                    if (currentPriorNode != lowNode) {
                        currentPriorNode.setAddress(lowNode);
                    }

                    if (lowPriorNode == null) {
                        if (currentNode != lowAddress) {
                            currentNode.setAddress(lowAddress);
                        } else {
                            currentNode.setAddress(lowNode);
                        }
                        head = currentNode;
                    } else {
                        if (currentNode != lowAddress) {
                            currentNode.setAddress(lowAddress);
                        } else {
                            currentNode.setAddress(lowNode);
                        }
                        lowPriorNode.setAddress(currentNode);
                    }
                    tempNode = currentNode;
                    currentNode = lowNode;
                    lowNode = tempNode;
                }
            }
            lowPriorNode = lowNode;
            lowNode = lowNode.getAddress();
        }
    }
}
