import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Quicksort {

    /**
     * A generic recursive list-based quicksort
     * @param input - The list to be sorted
     * @return
     */
    static List<Integer> listBasedQuicksort(List<Integer> input){
        //Base case
        if(input.size() <= 1){
            return input;
        }
        Integer pivot = input.get(0);
        //split list into greater than and smaller than list
        List<Integer> smallerList = new LinkedList<Integer>();
        List<Integer> greaterList = new LinkedList<Integer>();
        for(Integer current : input){
            if(current > pivot){
                greaterList.add(current);
            }
            else {
                smallerList.add(current);
            }
        }
        //removes the pivot from smaller list to prevent SO
        smallerList.remove(0);
        smallerList = listBasedQuicksort(smallerList);
        greaterList = listBasedQuicksort(greaterList);
        //Assemble sorted smaller list, pivot, sorted larger list
        smallerList.add(pivot);
        smallerList.addAll(greaterList);
        return smallerList;
    }

 public static void main(String[] args){
    List<Integer> test1 = Arrays.asList(19, 44, 7, 10, 4, 4, 18, 9, 3, 4, 100, 1, 4, 7, 9, 11, 4, 7, 27);
    test1 = listBasedQuicksort(test1);
     System.out.println(Arrays.toString(test1.toArray()));
 }
}
