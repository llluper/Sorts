/**
 *
 * @author Mitchell Stanford
 */
public class Sorts {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int [] mainList = {4, 5, 6, 2, 1, 7, 10, 3, 8, 9};

        int [] list = mainList.clone();
        selectionSort(list);
        System.out.print("Selection sort: ");
        print(list);

        list = mainList.clone();
        bubbleSort(list);
        System.out.print("Bubble sort: ");
        print(list);

        list = mainList.clone();
        insertionSort(list);
        System.out.print("Insertion sort: ");
        print(list);

        list = mainList.clone();
        shellSort(list);
        System.out.print("Shell sort: ");
        print(list);

        System.out.print("Binary search - Number 3 is at index: ");
        System.out.print(binarySearch(list, 3));
    }

    public static void print(int[] list) {
        for (int el : list) {
            System.out.print(el + " ");
        }
        System.out.println();
    }

    public static void swap(int[] list, int i, int j) {
        int temp = list[i];
        list[i] = list[j];
        list[j] = temp;
    }

    public static void selectionSort(int[] list) {
        int N = list.length;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N ; j++) {
                if (list[i] > list[j]) {
                    swap(list, i, j);
                }
            }
        }
    }

    public static void bubbleSort(int[] list) {
        int N = list.length;
        Boolean swapped;
        for (int i = 0; i < N; i++) {
            swapped = false;
            for (int j = N - 1; j > i ; j--) {
                if (list[j] < list[j-1]) {
                    swap(list, j, j-1);
                    swapped = true;
                }
            }
            if(!swapped) {  //Already sorted
                i = N;      //break
            }
        }
    }

    public static void insertionSort(int[] list) {
        int N = list.length-1;          //go to second to last element
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j > 0 ; j--) {
                if (list[j] < list[j-1]) {
                    swap(list, j, j-1);
                } else {
                    j = 0;  //break
                }
            }
        }
    }

    //USED FOR SHELL SORT
    public static void modifiedInsertionSort(int[] list, int startIndex, int increment) {
        int N = list.length;
        for (int i = startIndex; i < N; i = i + increment) {
            for (int j = Math.min(i + increment, N-1);
                 j - increment >= 0;
                 j = j - increment) {
                if (list[j] < list[j-increment]) {
                    swap(list, j, j-increment);
                } else {
                    j = 0;  //break
                }
            }
        }
    }

    public static void shellSort(int[] list) {
        int increment = list.length;            //random choice of increment, just be greater than 1
        while (increment > 1) {
            increment = increment / 2;
            for (int startIndex = 0; startIndex < increment; startIndex++) {
                modifiedInsertionSort(list, startIndex, increment);
            }
        }
    }

    public static int binarySearch(int[] sortedList, int number) {
        int min = 0;
        int max = sortedList.length-1;

        while (min <= max) {
            int mid = min + (max - min) / 2;
            if (sortedList[mid] == number) {
                return mid;
            }
            if (sortedList[mid] > number) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return -1;
    }
}
