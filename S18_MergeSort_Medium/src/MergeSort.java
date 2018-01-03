import java.util.ArrayList;
import java.util.Random;

/**
 * @author Alex Wong wong4a@gmail.com
 * @version 1.0
 * This is a program that will generate an ArrayList of any size from numbers from
 * 0 to 1000. This will then use a merge sort algorithm to sort the list from least
 * to greatest. This program also is able to print the ArrayList.
 */
public class MergeSort {

    /**
     * The ArrayList that will contain the values unsorted and then sorted once sort() is called.
     */
    ArrayList<Integer> array = new ArrayList<>();

    /**
     * This is to retrieve the ArrayList that is in this program.
     * @return The ArrayList in the program
     */
    public ArrayList<Integer> getArray()
    {
        return array;
    }

    /**
     * This will generate a ArrayList of a specified number of values.
     * These values will randomly be generated from 0 to 1000.
     * @param size This is the size of the ArrayList to be generated
     */
    public void listGen(int size)
    {
        for(int i = 0; i < size; i++)
        {
            Random ran = new Random();
            array.add(ran.nextInt(1001));
        }
    }

    /**
     * This is to print out the ArrayList in its current order.
     */
    public void printList()
    {
        for(int i = 0; i < array.size(); i++)
        {
            if(i == array.size()-1)
            {
                System.out.println(array.get(i));
            }
            else
            {
                System.out.print(array.get(i)+", ");
            }
        }
    }

    /**
     * This function will sort the ArrayList from least to greatest. This is a recursive function that
     * will be called multiple times splitting and merging the ArrayList. In the end the original stored
     * ArrayList will be replaced with a Sorted ArrayList.
     * @param array The ArrayList that is to be sorted
     */
    public void sort(ArrayList<Integer> array)
    {
        if(array.size()>1)
        {
            int mid = array.size()/2;
            ArrayList<Integer> left = new ArrayList<>(array.subList(0, mid));
            ArrayList<Integer> right = new ArrayList<>(array.subList(mid,array.size()));
            sort(left);
            sort(right);
            int i = 0;
            int j = 0;
            int k = 0;
            while((i < left.size()) && (j < right.size()))
            {
                if(left.get(i) < right.get(j))
                {
                    array.set(k, left.get(i));
                    i += 1;
                }
                else
                {
                    array.set(k, right.get(j));
                    j += 1;
                }
                k += 1;
            }
            while(i < left.size())
            {
                array.set(k, left.get(i));
                i += 1;
                k += 1;
            }
            while(j < right.size())
            {
                array.set(k, right.get(j));
                j += 1;
                k += 1;
            }
        }
    }
}
