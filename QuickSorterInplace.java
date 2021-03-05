import java.util.ArrayList;
import java.util.List;

public class QuickSorterInplace {

    public List<Integer> sort(List<Integer> toSort) {
        if (toSort.isEmpty()) return toSort;
        sortHelper(toSort, 0, toSort.size()-1);
        return toSort;
    }

    private int partition(List<Integer> l, int low, int high) {
        int pivot = l.get(high);
        while (high > low) {
            if (l.get(high-1) > pivot) {
                swap(l, high-1, high);
                high--;
            } else {
                swap(l, high-1, low);
                low++;
            }
        }
        l.set(high, pivot);
        return high;
    }

    private void swap(List<Integer> l, int index1, int index2) {
        int temp = l.get(index1);
        l.set(index1, l.get(index2));
        l.set(index2, temp);
    }

    private void sortHelper(List<Integer> toSort, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(toSort, low, high);
            sortHelper(toSort, low, pivotIndex-1);
            sortHelper(toSort, pivotIndex+1, high);
        }
    }

    public static void main(String[] args) {
        QuickSorterInplace ms = new QuickSorterInplace();
        List<Integer> l1 = new ArrayList<>();
        l1.add(5);
        l1.add(7);
        l1.add(6);
        l1.add(4);
        l1.add(3);
        l1.add(1);
        l1.add(2);
        System.out.println(ms.sort(l1));
    }
}
