package singlyLinkedList.advancedOperations;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Java8PracticeProblem {
    public static void main(String[] args) {
        List lst = new LinkedList<>(Arrays.asList(1, 3, 4, 5, 6, 2, 3, 4, 5));
        reverse(lst).stream().forEach(System.out::println);
    }

    public static List<Integer> reverse(List<Integer> lst) {
        return lst.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());
    }

    public static List<Integer> removeDuplicate(List<Integer> lst) {
        return lst.stream().distinct().collect(Collectors.toList());
    }
}
