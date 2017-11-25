package doublyLinkedList;

import java.util.*;

public class DoublyLinkedList {
    private Node root = null;
    private Node last = null;

    public static void main(String[] args) {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.addLast(1);
        doublyLinkedList.addLast(2);
        doublyLinkedList.addMidPosition(2, 3);
        doublyLinkedList.addMidPosition(3, 4);
        doublyLinkedList.addMidPosition(2, 5);
        System.out.println("Display list element in forward direction");
        doublyLinkedList.displayInForward();
        System.out.println("\nDisplay list element in backward direction");
        doublyLinkedList.displayInBackword();

    }

    public void intersectionByMethod1(DoublyLinkedList second) {
        Node start = root;
        Node head = second.root;
        Set<Integer> set = new HashSet<>();
        while (head != null) {
            set.add(head.getData());
            head = head.getNext();
        }
        DoublyLinkedList commonElements = new DoublyLinkedList();
        while (start != null) {
            if (set.contains(start.getData())) {
                commonElements.addLast(start.getData());
            }
            start = start.getNext();
        }
        System.out.println("Common elements of two list by method 1");
        commonElements.displayInForward();
    }

    public static void intersection(DoublyLinkedList l1, DoublyLinkedList l2, DoublyLinkedList l3) {
        Node i = l1.root;
        Node j = l2.root;
        Node k = l3.root;
        while (i != null && j != null && k != null) {
            if (i.getData().equals(j.getData()) && j.getData().equals(k.getData())) {
                System.out.println(i.getData());
                i = i.getNext();
                j = j.getNext();
                k = k.getNext();
            } else if (i.getData() < j.getData()) {
                i = i.getNext();
            } else if (j.getData() < k.getData()) j = j.getNext();
            else k = k.getNext();
        }
    }

    public void printNonRepeatedElementFrom1ToN() {
        Integer sum = 0, counter = 0;
        Node start = root;
        while (start != null) {
            sum = sum + start.getData();
            ++counter;
            start = start.getNext();
        }
        counter = (counter % 2 != 0 ? ++counter : counter) / 2;
        Integer expextedSum = 0;
        for (int i = 1; i <= counter; i++) {
            expextedSum += i + i;
        }
        System.out.println(expextedSum - sum);
    }

    public void printNonRepeatedElement() {
        Node start = root;
        Map<Integer, Integer> map = new HashMap<>();
        while (start != null) {
            map.put(start.getData(), 0);
            start = start.getNext();
        }
        start = root;
        while (start != null) {
            if (map.containsKey(start.getData())) ;
            {
                Integer counter = map.get(start.getData());
                map.put(start.getData(), ++counter);
            }
            start = start.getNext();
        }
        map.entrySet().stream().filter(it -> it.getValue() == 1).map(i -> i.getKey()).forEach(System.out::println);
    }

    public void intersectionByMethod2(DoublyLinkedList second) {
        Node start = root;
        Node head = second.root;
        DoublyLinkedList commonElements = new DoublyLinkedList();
        while (start != null) {
            if (contains(head, start.getData())) {
                commonElements.addLast(start.getData());
            }
            start = start.getNext();
        }
        System.out.println("Common elements of two list by method 2");

        commonElements.displayInForward();
    }

    public boolean contains(Node head, Integer element) {
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

    public DoublyLinkedList uniqueBySorted() {
        Integer prev = root.getData();
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.addLast(prev);
        for (Node i = root.getNext(); i != null; i = i.getNext()) {
            if (prev != i.getData()) {
                doublyLinkedList.addLast(i.getData());
            }
            prev = i.getData();
        }
        return doublyLinkedList;
    }

    public Integer findKthSmallest(int k) {
        sort();
        Node start = root;
        Integer counter = 1, item = null;
        while (start != null) {
            if (counter == k) {
                item = start.getData();
                break;
            }
            ++counter;
            start = start.getNext();
        }
        return item;
    }

    public Integer findKthLargest(Integer k) {
        sort();
        Node start = root;
        Integer counter = 1, item = null;
        while (start != null) {
            if (counter == k) {
                item = start.getData();
                break;
            }
            ++counter;
            start = start.getNext();
        }
        return item;
    }

    public void printallSublist() {
        Node start = root;
        Node head = null;
        Integer sum = 0, counter_i = 0, counter_j = 0;
        while (start != null) {
            sum = 0;
            head = start;
            counter_j = counter_i;
            while (head != null) {
                sum += head.getData();
                if (sum == 0) {
                    System.out.println("Zero Sum Sub List Index From:" + counter_i + "->" + counter_j);
                }
                head = head.getNext();
                counter_j++;
            }
            counter_i++;
            start = start.getNext();
        }
    }

    public boolean isZeroSumSubList() {
        Node start = root;
        HashMap<Integer, Integer> hM =
                new HashMap<Integer, Integer>();
        int sum = 0, counter = 0;
        while (start != null) {
            sum += start.getData();
            if (sum == 0 || start.getData() == 0 || hM.get(sum) != null) {
                return true;
            }
            hM.put(sum, counter++);
            start = start.getNext();
        }
        return false;
    }

    public Integer firstRepeatedElement() {
        Node start = root;
        Set set = new HashSet();
        Integer item = null;
        while (start != null) {
            if (!set.add(start.getData())) {
                item = start.getData();
                break;
            }
            start = start.getNext();
        }
        if (item != null)
            return item;
        else
            return -1;
    }

    public void sort() {
        for (Node i = root; i != null; i = i.getNext()) {
            for (Node j = i.getNext(); j != null; j = j.getNext()) {
                if (i.getData() > j.getData()) {
                    i.setData(i.getData() + j.getData());
                    j.setData(i.getData() - j.getData());
                    i.setData(i.getData() - j.getData());
                }
            }
        }


    }

    public DoublyLinkedList uniqueByHashSet() {
        Set<Integer> set = new HashSet<>();
        Node current = root;
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        current = root;
        while (current != null) {
            if (set.add(current.getData()))
                doublyLinkedList.addLast(current.getData());
            current = current.getNext();
        }
        return doublyLinkedList;
    }

    public void flatten(DoublyLinkedList... linkedLists) {
//        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
//        doublyLinkedList.addLast(1);
//        doublyLinkedList.addLast(2);
//        doublyLinkedList.addLast(3);
//        doublyLinkedList.addLast(4);
//        DoublyLinkedList doublyLinkedList2 = new DoublyLinkedList();
//        doublyLinkedList2.addLast(6);
//        doublyLinkedList2.addLast(7);
//        doublyLinkedList2.addLast(8);
//        doublyLinkedList2.addLast(9);
//
//        DoublyLinkedList doublyLinkedList3 = new DoublyLinkedList();
//        doublyLinkedList3.addLast(11);
//        doublyLinkedList3.addLast(12);
//        doublyLinkedList3.addLast(13);
//        doublyLinkedList3.addLast(14);
//
//        doublyLinkedList.flatten(doublyLinkedList2,doublyLinkedList3);
//        doublyLinkedList.displayInBackword();
//

        for (DoublyLinkedList linkedList : linkedLists) {
            Node current = root;
            while (current != null) {
                if (current.getNext() == null) {
                    Node head = linkedList.root;
                    head.setPrev(current);
                    current.setNext(head);
                    last = linkedList.last;
                    break;
                }
                current = current.getNext();
            }
        }
    }

    public void deleteElementSumEqualToZero() {
        Node current = root;
        Stack<Integer> stack = new Stack<>();
        List<Integer> lst = new ArrayList<>();
        Boolean flag = false;
        while (current != null) {
            if (current.getData() > 0) {
                stack.push(current.getData());
            } else {
                flag = false;
                Integer sum = current.getData();
                while (!stack.isEmpty()) {
                    sum += stack.pop();
                    if (sum == 0) {
                        flag = true;
                        lst.clear();
                        break;
                    }
                    lst.add(current.getData());
                }
                if (!flag) {
                    lst.forEach(i -> stack.add(i));
                    stack.add(current.getData());
                }
            }
            current = current.getNext();
        }
        root = null;
        for (Integer item : stack) {
            if (item != 0)
                addLast(item);
        }
    }

    public void displayInForward() {
        Node current = root;
        while (current != null) {
            System.out.print(current.getData() + "->");
            current = current.getNext();
        }
    }

    public void displayInBackword() {
        Node current = last;
        while (current != null) {
            System.out.print(current.getData() + "->");
            current = current.getPrev();
        }
    }

    public void addLast(Integer element) {
        Node node = new Node();
        node.setData(element);

        if (root == null) {
            node.setNext(null);
            node.setPrev(null);
            root = node;
            last = root;
        } else {
            Node current = root;
            while (current != null) {
                if (current.getNext() == null) {
                    node.setNext(null);
                    node.setPrev(current);
                    current.setNext(node);
                    last = node;
                    break;
                }
                current = current.getNext();
            }
        }

    }

    public void addFront(Integer element) {
        Node node = new Node();
        node.setData(element);

        if (root == null) {
            node.setNext(null);
            node.setPrev(null);
            root = node;
            last = root;
        } else {
            node.setPrev(null);
            node.setNext(root);
            root.setPrev(node);
            root = node;
        }
    }

    public Integer size(Node head) {
        if (head == null)
            return 0;
        else
            return 1 + size(head.getNext());
    }

    public void addMidPosition(Integer position, Integer element) {
        Node current = root;

        if (position == 1 || position == 0) {
            addFront(element);
        } else if (size(root) + 1 == position) {
            addLast(element);
        } else {
            Integer counter = 1;
            while (current != null) {
                if (counter == position) {
                    Node node = new Node();
                    node.setData(element);
                    node.setNext(current);
                    node.setPrev(current.getPrev());
                    current.getPrev().setNext(node);
                    current.setPrev(node);
                    break;
                }
                counter++;
                current = current.getNext();
            }
        }
    }

    public void deleteFirst() {
        if (root != null) {
            Node temp = root.getNext();
            if (temp != null) {
                temp.setPrev(null);
                root = temp;
            } else {
                root = null;
                last = null;
            }
        } else
            System.out.println("Linked list is empty");
    }

    public void deleteMidPosition(Integer postion) {
        if (postion == 1 || postion == 0)
            deleteFirst();
        else if (postion == size(root))
            deleteLast();
        else {
            Node current = root;
            Integer counter = 1;

            while (current != null) {
                if (counter == postion) {
                    Node prevous = current.getPrev();
                    current.getNext().setPrev(prevous);
                    prevous.setNext(current.getNext());
                    current = null;
                    break;
                }
                counter++;
                current = current.getNext();
            }
        }
    }

    public void deleteLast() {
        if (root != null) {
            Node current = root;
            while (current != null) {
                if (current.getNext().getNext() == null) {
                    current.setNext(null);
                    last = current;
                    break;
                }
                current = current.getNext();
            }
        } else
            System.out.println("Linked list is empty");
    }
}
