/**
 * @author Alex Wong wong4a@gmail.com
 * @version 1.0
 * This is the tester class of the Merge Sort program.
 * This will generate a list of 100 values and print out
 * the values of the unsorted array and then sort them with
 * the merge sort program. Then it will print out the newly
 * sorted list.
 */
public class MergeSortTest {
    public static void main(String args[])
    {
        MergeSort ms = new MergeSort();
        ms.listGen(100);
        System.out.println("Unsorted List:");
        ms.printList();
        ms.sort(ms.getArray());
        System.out.println();
        System.out.println("Sorted List:");
        ms.printList();
    }
}
