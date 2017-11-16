package advancedOperations;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LinkedList {
    private Node root = null;

    public static void main(String[] args) {
        LinkedList list1 = new LinkedList();
        list1.addLastNode(10);
        list1.addLastNode(14);
        list1.addLastNode(22);
        list1.addLastNode(20);
        list1.addLastNode(20);
        list1.addLastNode(13);
        list1.addLastNode(23);
        list1.addLastNode(4);
        list1.addLastNode(4);
        Integer item = list1.firstRepeatedElement();
        System.out.println("First Repeating element is:=" + item);
    }

    public void addLastNode(Integer element) {
        Node start = root;
        Node node = new Node();
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


    public void sort() {

        for (Node i = root; i != null; i = i.getNext()) {
            for (Node j = i.getNext(); j != null; j = j.getNext()) {
                if (i.getData() < j.getData()) {
                    i.setData(i.getData() + j.getData());
                    j.setData(i.getData() - j.getData());
                    i.setData(i.getData() - j.getData());
                }
            }
        }
    }

    public void display() {
        Node start = root;
        while (start != null) {
            System.out.println(start.getData());
            start = start.getNext();
        }
    }

    public Integer firstRepeatedElement() {
        Node start = root;
        Set<Integer> set = new HashSet<Integer>();
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

    public static void intersection(LinkedList l1, LinkedList l2, LinkedList l3) {
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
            } else if (j.getData() < k.getData())
                j = j.getNext();
            else
                k = k.getNext();
        }
    }

    public void findMaxAndMin() {
        Node start = root;
        Integer max = root.getData();
        Integer min = root.getData();
        while (start != null) {
            if (max < start.getData())
                max = start.getData();
            if (min > start.getData())
                min = start.getData();
            start = start.getNext();
        }
        System.out.println("Min=" + min);
        System.out.println("Max=" + max);
    }

}
