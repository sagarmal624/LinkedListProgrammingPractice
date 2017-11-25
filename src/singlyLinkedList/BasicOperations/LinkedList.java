package singlyLinkedList.BasicOperations;

import java.util.*;

public class LinkedList<T> {
    private Node<T> root = null;

    public static void main(String[] args) {

        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        linkedList.addLastNode(6);
        linkedList.addLastNode(-6);
        linkedList.addLastNode(3);
        linkedList.addLastNode(2);
        linkedList.addLastNode(-5);
        linkedList.addLastNode(4);
        linkedList.deleteSumEqualToZero();
        linkedList.display();
    }


    public void intersectionByMethod1(LinkedList<T> second) {
        Node<T> start = root;
        Node<T> head = second.root;
        Set<T> set = new HashSet<>();
        while (head != null) {
            set.add(head.getData());
            head = head.getNext();
        }
        LinkedList<T> commonElements = new LinkedList<>();
        while (start != null) {
            if (set.contains(start.getData())) {
                commonElements.addLastNode(start.getData());
            }
            start = start.getNext();
        }
        System.out.println("Common elements of two list by method 1");
        commonElements.display();
    }


    public void intersectionByMethod2(LinkedList<T> second) {
        Node<T> start = root;
        Node<T> head = second.root;
        LinkedList<T> commonElements = new LinkedList<>();
        while (start != null) {
            if (contains(head, start.getData())) {
                commonElements.addLastNode(start.getData());
            }
            start = start.getNext();
        }
        System.out.println("Common elements of two list by method 2");

        commonElements.display();
    }

    public boolean contains(Node<T> head, T element) {
        boolean flag = false;
        while (head != null) {
            if (element == head.getData()) {
                flag = true;
                break;
            }
            head = head.getNext();
        }
        return flag;
    }

    public void addLastNode(T element) {
        Node<T> start = root;
        Node<T> node = new Node<T>();
        node.setData(element);
        node.setNext(null);
        if (root != null) {
            while (start != null) {
                if (start.getNext() == null) {
                    start.setNext(node);
                    break;
                }
                start = start.getNext();
            }
        } else
            root = node;
    }

    public void display() {
        Node<T> start = root;
        while (start != null) {
            System.out.println(start.getData());
            start = start.getNext();
        }
    }

    public void uniqueByHashSet() {
        Node<T> start = root;
        Set<T> set = new HashSet<>();
        while (start != null) {
            if (!set.contains(start.getData()))
                set.add(start.getData());
            start = start.getNext();
        }
        set.stream().forEach(System.out::println);
    }

    public void uniqueByMethod2() {
        Node<T> start = root;
        Node<T> head = null;
        LinkedList<T> uniqueList = new LinkedList<>();
        while (start != null) {
            if (!contains(start.getNext(), start.getData())) {
                uniqueList.addLastNode(start.getData());
            }
            start = start.getNext();
        }
        uniqueList.display();
    }

    public void flatten(LinkedList<T> secondList) {
        Node<T> start = root;
        while (start != null) {
            if (start.getNext() == null) {
                start.setNext(secondList.root);
                break;
            }
            start = start.getNext();
        }
    }

    public void deleteSumEqualToZero() {
        Node<T> start = root;
        Stack<Node<T>> stack = new Stack<Node<T>>();
        List<Node<T>> list = new ArrayList<>();
        boolean flag = false;
        while (start != null) {
            if ((Integer) start.getData() > 0) {
                stack.push(start);
            } else {
                Integer sum = (Integer) start.getData();
                flag = false;
                while (!stack.isEmpty()) {
                    Node<T> temp = stack.pop();
                    sum += (Integer) temp.getData();
                    if (sum == 0) {
                        flag = true;
                        list.clear();
                        break;
                    }
                    list.add(temp);
                }
                if (!flag) {
                    list.forEach(i -> stack.add(i));
                    stack.add(start);
                }
            }
            start = start.getNext();
        }
        root = null;
        for (Node<T> node : stack) {
            if ((Integer) node.getData() != 0)
                addLastNode(node.getData());
        }
    }

    public void addFrontNode(T element) {
        Node<T> node = new Node<T>();
        node.setData(element);
        if (root == null) {
            node.setNext(null);
            root = node;
        } else {
            Node<T> temp = root;
            node.setNext(temp);
            root = node;
        }
    }

    public boolean deleteFirst() {
        if (root != null) {
            if (root.getNext() == null) {
                root = null;
                return true;
            } else {
                Node<T> start = root.getNext();
                root = start;
                return true;
            }
        } else
            return false;
    }

    public void deleteMid(Integer index) {
        Node<T> start = root;
        Node<T> prev = null;
        Integer counter = 1, length = size(start);
        if (index == 1 || index == length) {
            deleteLast();
        } else {
            if (index <= length) {
                while (start != null) {
                    if (counter == index) {
                        prev.setNext(start.getNext());
                        break;
                    }
                    prev = start;
                    counter++;
                    start = start.getNext();
                }
            } else {
                System.out.println("LinkList Can't delete element at this position due to out of index");
            }
        }

    }

    public boolean deleteLast() {
        Node<T> start = root;
        Node<T> prev = null;
        Boolean flag = false;
        while (start != null) {
            if (start.getNext() == null) {
                prev.setNext(null);
                flag = true;
                break;
            }
            prev = start;
            start = start.getNext();
        }
        return flag;
    }


    public int size(Node<T> node) {
        if (node == null)
            return 0;
        return 1 + size(node.getNext());
    }

    public void addMiddleNode(T element, Integer index) {
        Node<T> start = root;
        Node<T> prev = null;
        Node<T> node = new Node<T>();
        node.setData(element);
        Integer counter = 1, length = size(start);
        if (index == 1 || index == length + 1) {
            addLastNode(element);
        } else {
            if (index <= length) {
                while (start != null) {
                    if (counter == index) {
                        node.setNext(start);
                        prev.setNext(node);
                        break;
                    }
                    prev = start;
                    counter++;
                    start = start.getNext();
                }
            } else {
                System.out.println("LinkList Can't add element at this position due to out of index");
            }
        }
    }

}
