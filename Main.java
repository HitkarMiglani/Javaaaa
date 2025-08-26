

import java.util.*;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome!");
        int[] arr = new int[10];

        for(int i = 0; i < 10; i++) arr[i] = i;

        ArrayList<Integer> list = new ArrayList<>(Arrays.stream(arr).boxed().toList());
        Collections.rotate(list,-2);
        list.removeIf(i -> i % 2 == 0);

        System.out.println(list);
    }
}