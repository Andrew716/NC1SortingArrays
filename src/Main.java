import java.util.*;

/**
 * Created by Andrii on 9/12/2015.
 */
public class Main {
    /**
     * @param sortedArray  is array which has numbers in order
     * @param sortedArrayWithAddedElementInTheEnd is array which has all numbers in order but one last number in out of order
     * @param sortedArrayViceVersa is array which all numbers sorted from top to bottom
     * @param mixedArray is array which has random numbers
     */
    public static final int[] sortedArray = {1,2,3,4,7,9,10,19,100};
    public static final int[] sortedArrayWithAddedElementInTheEnd = {2,5,8,11,15,56,78,3};
    public static final int[] sortedArrayViceVersa = {100,78,65,54,43,11,7,4,1};
    private static int[] mixedArray = new int[10];

    /**
     * static block which initialises mixed array
     */
    static {
        Random random = new Random();
        for (int i = 0; i < mixedArray.length - 1; i++) {
            mixedArray[i] = random.nextInt(9);
        }
    }

    /**
     * method output array on console
     * @param array gets an array for outputting
     */
    public static void outputArray(int[] array){
        for (int i = 0; i < array.length-1; i++){
            System.out.print(array[i]);
            System.out.print(" ");
        }
    }

    public static void main(String[] args) {

        Map<Double, String> timeMap = new HashMap<Double, String>();
        double[] array = new double[10];
        //Sorting right array with lost element in the end by using different methods
        SortingArrayClass.bubbleSortingUp(sortedArrayViceVersa);
        SortingArrayClass.bubbleSortingDown(sortedArrayViceVersa);
        SortingArrayClass.exchangeSorting(sortedArrayViceVersa);
        SortingArrayClass.mergeSorting(sortedArrayViceVersa);
        SortingArrayClass.recursiveSortingWithHalfDivision(sortedArrayViceVersa);
        SortingArrayClass.defaultSortingMethod(sortedArrayViceVersa);

        //Sorting right array with lost element in the end by using different methods
        SortingArrayClass.bubbleSortingUp(sortedArrayWithAddedElementInTheEnd);
        SortingArrayClass.bubbleSortingDown(sortedArrayWithAddedElementInTheEnd);
        SortingArrayClass.exchangeSorting(sortedArrayWithAddedElementInTheEnd);
        SortingArrayClass.mergeSorting(sortedArrayWithAddedElementInTheEnd);
        SortingArrayClass.recursiveSortingWithHalfDivision(sortedArrayWithAddedElementInTheEnd);
        SortingArrayClass.defaultSortingMethod(sortedArrayWithAddedElementInTheEnd);

        //Sorting already sorted array by using different methods
        SortingArrayClass.bubbleSortingUp(sortedArray);
        SortingArrayClass.bubbleSortingDown(sortedArray);
        SortingArrayClass.exchangeSorting(sortedArray);
        SortingArrayClass.mergeSorting(sortedArray);
        SortingArrayClass.recursiveSortingWithHalfDivision(sortedArray);
        SortingArrayClass.defaultSortingMethod(sortedArray);

        //Sorting mixed array by using different methods
        System.out.println("Initial array");
        Main.outputArray(mixedArray);
        System.out.println();

        System.out.println("BubbleTo Top sorting");
        double timeBeforeBubbleSorting = System.nanoTime();
        Main.outputArray(SortingArrayClass.bubbleSortingUp(mixedArray));
        double timeAfterBubbleSorting = System.nanoTime();
        timeMap.put(timeAfterBubbleSorting - timeBeforeBubbleSorting, "BubbleTo Top sorting");
        array[0] = timeAfterBubbleSorting - timeBeforeBubbleSorting;
        System.out.println(timeAfterBubbleSorting - timeBeforeBubbleSorting);

        System.out.println("BubbleTo Bottom sorting");
        double timeBeforeBubbleBottomSorting = System.nanoTime();
        Main.outputArray(SortingArrayClass.bubbleSortingDown(mixedArray));
        double timeAfterBubbleBottomsorting = System.nanoTime();
        timeMap.put(timeAfterBubbleBottomsorting - timeBeforeBubbleBottomSorting , "BubbleTo Bottom sorting");
        array[1] = timeAfterBubbleBottomsorting - timeBeforeBubbleBottomSorting;
        System.out.println(timeAfterBubbleBottomsorting - timeBeforeBubbleBottomSorting);

        System.out.println("Exchange Sorting");
        double timeExchangeBefore = System.nanoTime();
        Main.outputArray(SortingArrayClass.exchangeSorting(mixedArray));
        double timeExchangeAfter = System.nanoTime();
        timeMap.put(timeExchangeAfter - timeExchangeBefore, "Exchange Sorting");
        array[2] = timeExchangeAfter - timeExchangeBefore;
        System.out.println(timeExchangeAfter - timeExchangeBefore);

        System.out.println("Merge Sorting");
        double timeMergeBefore = System.nanoTime();
        Main.outputArray(SortingArrayClass.mergeSorting(mixedArray));
        double timeMergeAfter = System.nanoTime();
        timeMap.put(timeMergeAfter - timeMergeBefore ,"Merge Sorting" );
        array[3] = timeMergeAfter - timeMergeBefore;
        System.out.println(timeMergeAfter - timeMergeBefore);

        System.out.println("Half division method");
        double timeRecursiveBefore = System.nanoTime();
        Main.outputArray(SortingArrayClass.recursiveSortingWithHalfDivision(mixedArray));
        double timeRecursiveAfter = System.nanoTime();
        timeMap.put(timeRecursiveAfter - timeRecursiveBefore , "Half division method");
        array[4] = timeRecursiveAfter - timeRecursiveBefore;
        System.out.println(timeRecursiveAfter - timeRecursiveBefore);

        System.out.println("Default java sorted method");
        double timeDefaultSortingBefore = System.nanoTime();
        Main.outputArray(SortingArrayClass.defaultSortingMethod(mixedArray));
        double timeDefaultSoringAfter = System.nanoTime();
        timeMap.put( timeDefaultSoringAfter - timeDefaultSortingBefore,"Default java sorted method" );
        array[5] = timeDefaultSoringAfter - timeDefaultSortingBefore;
        System.out.println(timeDefaultSoringAfter - timeDefaultSortingBefore);

        System.out.println(timeMap.size());
        double min = array[0];
        for (int i = 1; i < array.length - 1; i++){
            if (min > array[i]){
                min = array[i];
            }
        }
        List<Double> doubleArrays = new ArrayList<Double>();
        List<String> stringList = new ArrayList<String>();
        doubleArrays.add(min);
        System.out.println(doubleArrays.get(0));
        stringList.add(timeMap.get(doubleArrays.get(0)));
        System.out.println(stringList.get(0));
    }
}
