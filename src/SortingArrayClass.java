import java.util.Arrays;

/**
 * Created by Andrii on 9/12/2015.
 */
public class SortingArrayClass {
    private int[] tempMergeArray;
    private int lenght;
    private int[] array;
    private  int[] tempArray;

    /**
     * method sorts an array using bubble sorting algorithm from bottom to top
     * @param array gets an array for sorting
     * @return sorted array
     */
    public static int[] bubbleSortingUp(int[] array){
        boolean flag = true;
        while (flag){
            flag = false;
            for (int i = 0; i< array.length-1; i++) {
                if (array[i] > array[i+1]){
                    int tempNumber = array[i+1];
                    array[i+1] = array[i];
                    array[i] = tempNumber;
                    flag = true;
                }
            }
        }
        return array;
    }

    /**
     * method sorts an array using bubble sorting algorithm from top to bottom
     * @param array gets an array for sorting
     * @return sorted array
     */
    public static int[] bubbleSortingDown(int[] array){
        boolean flag = true;
        while (flag){
            flag = false;
            for (int i = 0; i < array.length-1; i++){
                if (array[i] < array[i+1]){
                    int tempNumber = array[i+1];
                    array[i+1] = array[i];
                    array[i] = tempNumber;
                    flag = true;
                }
            }
        }
        return array;
    }

    /**
     * method sorts an array using exchange sorting algorithm
     * @param array gets an array for sorting
     * @return sorted array
     */
    public static int[] exchangeSorting(int[] array){
        for (int i = 0; i < array.length-1; i++){
            for (int j = i+1; j < array.length; j++){
                if (array[i] > array[j]){
                    int tempNumber = array[i];
                    array[i] = array[j];
                    array[j] = tempNumber;
                }
            }
        }
        return array;
    }

    /**
     * method sorts an array using merge sorting algorithm
     * @param array gets an array for sorting
     * @return sorted array
     */
    //Sorting array by using merge sort method
    public static int[] mergeSorting(int[] array){
        SortingArrayClass sortingArrayClass = new SortingArrayClass();
        sortingArrayClass.sort(array);
        return array;
    }

    /**
     * method initialises auxiliary parameters and call sort method sending left and right bound
     * @param inputArray gets an array for sorting
     */
    private void sort(int[] inputArray){
        this.array = inputArray;
        this.lenght = inputArray.length;
        this.tempMergeArray = new int[lenght];
        doMergeSort(0, lenght - 1);
    }

    /**
     * method defines middle of array and calls itself to divide and method for sorting
     * @param lowerIndex lower index of array
     * @param higherIndex higher index of array
     */
    private void doMergeSort(int lowerIndex, int higherIndex){
        if (lowerIndex < higherIndex){
            int middle = lowerIndex + (higherIndex - lowerIndex)/2;
            doMergeSort(lowerIndex, middle);
            doMergeSort(middle + 1, higherIndex);
            mergeParts(lowerIndex, middle, higherIndex);
        }
    }

    /**
     * method realises the merge sorting algorithm
     * @param lowerIndex lower index of array
     * @param middle middle index of array
     * @param higherIndex higher index of array
     */
    private void mergeParts(int lowerIndex, int middle, int higherIndex){
        for (int i = lowerIndex; i <= higherIndex; i++){
            tempMergeArray[i] = array[i];
        }
        int i = lowerIndex;
        int j = middle + 1;
        int k = lowerIndex;
        try {
            while(i <= middle && j <= higherIndex){
                if (tempMergeArray[i] < tempMergeArray[j]){
                    array[k] = tempMergeArray[i];
                    i++;
                }else {
                    array[k] = tempMergeArray[j];
                    j++;
                }
                k++;
            }
            while (i <= middle){
                array[k] = tempMergeArray[i];
                k++;
                i++;
            }
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("out of bounds");
        }
    }

    /**
     * method sorts array using recursive sort with half division algorithm
     * @param givenArray gets an array for sorting
     * @return sorted array
     */
    public static int[] recursiveSortingWithHalfDivision(int[] givenArray){
        SortingArrayClass sortingArrayClass = new SortingArrayClass();
        sortingArrayClass.sortRecursiveHalfDivision(givenArray);
        return givenArray;
    }

    /**
     * method initialises auxiliary array
     * @param array gets an array for sorting
     */
    private void sortRecursiveHalfDivision(int[] array){
        this.tempArray = array;
        int left = 0;
        int right = array.length - 1;
        doSortRecursiveHalfDivision(left, right);
    }

    /**
     * method realises the recursive algorithm with half division
     * @param left left boundary of array
     * @param right right boundary of array
     */
    private void doSortRecursiveHalfDivision(int left, int right){
        int middle = tempArray[(left + right)/2];
        int i = left;
        int j = right;
        while (i <= j){
            while (tempArray[i] < middle){
                i++;
            }
            while (tempArray[j] > middle){
                j--;
            }
            if (i <= j){
                int temp = tempArray[i];
                tempArray[i] = tempArray[j];
                tempArray[j] = temp;
                i++;
                j--;
            }
        }
        if (left < j){
            doSortRecursiveHalfDivision(left, j);
        }
        if (i < right){
            doSortRecursiveHalfDivision(i, right);
        }
    }

    /**
     * method sorts an array using default java sort method Arrays.sort(int[] array)
     * @param array gets an array for sorting
     * @return sorted array
     */
    public static int[] defaultSortingMethod(int[] array){
        Arrays.sort(array);
        return array;
    }
}
