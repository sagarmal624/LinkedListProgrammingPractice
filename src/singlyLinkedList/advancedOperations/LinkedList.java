package singlyLinkedList.advancedOperations;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LinkedList {
    private Node root = null;

    public static void main(String[] args) {
        LinkedList list1 = new LinkedList();
        list1.addLastNode(10);
        list1.addLastNode(11);
        list1.addLastNode(7);
        list1.addLastNode(5);
        list1.addLastNode(6);
        list1.display();
        System.out.println("no of elements in list=" + list1.size(list1.root));
    }


    public void rightRotateListByK(int k) {
        Node current = root, prev = null;
        Integer counter = 1;
        while (current != null) {
            if (k + 1 == counter) {
                Node head = current, start = current;
                prev.setNext(null);
                while (head != null) {
                    if (head.getNext() == null) {
                        head.setNext(root);
                        break;
                    }
                    head = head.getNext();
                }
                root = start;
                break;
            }
            prev = current;
            current = current.getNext();
            counter++;

        }
    }

    public void lettRotateListByK(int k) {
        Node current = root, prev = null;
        Integer counter = 1, length = size(root);
        while (current != null) {
            if (length - k + 1 == counter) {
                Node head = current;
                while (head != null) {
                    if (head.getNext() == null) {
                        head.setNext(root);
                        break;
                    }
                    head = head.getNext();
                }
                prev.setNext(null);
                root = current;
                break;
            }
            prev = current;
            current = current.getNext();
            counter++;

        }
    }

    public LinkedList merge(LinkedList linkedList) {
        Node current = root, start = null;
        Node head = linkedList.root;
        LinkedList list = new LinkedList();
        Integer counter = 0;
        while (current != null && head != null) {
            list.addLastNode(current.getData());
            list.addLastNode(head.getData());
            current = current.getNext();
            head = head.getNext();
        }
        if (current != null) {
            start = current;
            while (start != null) {
                list.addLastNode(start.getData());
                start = start.getNext();
            }
        }
        if (head != null) {
            start = head;
            while (start != null) {
                list.addLastNode(start.getData());
                start = start.getNext();
            }
        }
        return list;
    }

    public void deleteN_Node_After_M_Node(int m, int n) {
        Node current = root, prev = root;
        Integer counter = 1;
        while (current != null) {
            if (counter == m) {
                deleteN_Node(current, n);
                break;
            }
            counter++;
            prev = current;
            current = current.getNext();
        }

    }

    public void deleteN_Node(Node head, int n) {
        Node current = head;
        Integer counter = 1;
        while (current != null) {
            if (counter == n) {
                head.setNext(current.getNext().getNext());
                break;
            }
            counter++;
            current = current.getNext();
        }
    }

    public LinkedList removeDuplicateFromUnsorted() {
        Node start = root;
        LinkedList list = new LinkedList();
        while (start != null) {
            if (!contains(start.getNext(), start.getData()))
                list.addLastNode(start.getData());
            start = start.getNext();
        }
        return list;
    }

    public Boolean contains(Node head, Integer k) {
        Node start = head;
        Boolean flag = false;
        while (start != null) {
            if (k == start.getData()) {
                flag = true;
                break;
            }
            start = start.getNext();
        }
        return flag;
    }

    public LinkedList removeDuplicate() {
        Node current = root;
        Node prev = root;
        LinkedList lst = new LinkedList();
        lst.addLastNode(prev.getData());
        while (current != null) {
            if (prev.getData() != current.getData())
                lst.addLastNode(current.getData());
            prev = current;
            current = current.getNext();
        }
        return lst;
    }

    public Integer findNthFromEnd(int n) {
        Node current = root;
        Integer length = size(root), counter = 1;
        Integer item = -1;
        if (n <= length) {
            while (current != null && counter <= length) {
                if ((length - n) + 1 == counter) {
                    item = current.getData();
                    break;
                }
                counter++;
                current = current.getNext();
            }
        }
        return item;
    }

    void detectLoop() {
        Node fast = root;
        Node slow = root;
        while (slow != null && fast != null && fast.getNext() != null) {
            fast = fast.getNext().getNext();
            slow = slow.getNext();
            if (fast == slow) {
                removeLoop(slow);
                break;
            }

        }

    }

    void removeLoop(Node loop) {
        Node ptr1 = loop, ptr2 = loop;
        int k = 1, i;
        while (ptr1.getNext() != ptr2) {
            ptr1 = ptr1.getNext();
            k++;
        }
        ptr1 = root;
        ptr2 = root;
        while (ptr2 != ptr1) {
            ptr1 = ptr1.getNext();
            ptr2 = ptr2.getNext();
        }
        ptr2 = ptr2.getNext();
        while (ptr2.getNext() != ptr1) {
            ptr2 = ptr2.getNext();
        }
        ptr2.setNext(null);
    }

    public void createLoop() {
        Node current = root;
        while (current != null) {
            if (current.getNext() == null) {
                current.setNext(root);
                break;
            }
            current = current.getNext();
        }
    }

    public Integer size(Node head) {
        if (head == null)
            return 0;
        return 1 + size(head.getNext());
    }

    public Boolean isCyclic() {
        Node fast = root;
        Node slow = root;
        Boolean flag = false;
        while (slow != null && fast != null && fast.getNext() != null) {
            fast = fast.getNext().getNext();
            slow = slow.getNext();

            if (fast == slow) {
                flag = true;
                break;
            }

        }
        return flag;
    }

    Node reverse(Node head, int k) {
        Node current = head;
        Node next = null;
        Node prev = null;
        int count = 0;
        while (count < k && current != null) {
            next = current.getNext();
            current.setNext(prev);
            prev = current;
            current = next;
            count++;
        }

        if (next != null)
            head.setNext(reverse(next, k));
        return prev;
    }

    public void reverse() {
        Node current = root, prev = null, next = null;
        while (current != null) {
            next = current.getNext();
            current.setNext(prev);
            prev = current;
            current = next;
        }
        root = prev;
    }

    public void printallSubarrays() {
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
