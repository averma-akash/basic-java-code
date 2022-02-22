import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
 
public class ArrayListExample 
{
    public static void main(String[] args) {

        // ArrayList with duplicate elements
        ArrayList<Integer> numbersList = new ArrayList<>(Arrays.asList(1, 1, 2, 3, 3, 3, 4, 5, 6, 6, 6, 7, 8));
         
        System.out.println("ArrayList with duplicate elements: ", numbersList);
 
        LinkedHashSet<Integer> hashSet = new LinkedHashSet<>(numbersList); 
        ArrayList<Integer> listWithoutDuplicates = new ArrayList<>(hashSet);
         
        System.out.println("ArrayList without duplicate elements: ", listWithoutDuplicates);
    }
}

/*
ArrayList with duplicate elements: [1, 1, 2, 3, 3, 3, 4, 5, 6, 6, 6, 7, 8]
ArrayList without duplicate elements: [1, 2, 3, 4, 5, 6, 7, 8]

The LinkedHashSet is the best approach for removing duplicate elements in an arraylist. LinkedHashSet does two things internally :

Remove duplicate elements
Maintain the order of elements added to it
*/