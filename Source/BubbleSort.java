/*File: BubbleSort.java
 *Author: Zackary Scott
 *Date: 2-11-2019
 *Purpose: BubbleSort.java is where the BubbleSort algorithms are used to
 *sort arrays passed in.
 */
public class BubbleSort implements SortInterface{
    private int count;
    private long time;
    @Override
    //recursive helper
    public void recursiveSort(int[] list) throws UnsortedException {
        count = 0;
        time = 0;

        long startTime = System.nanoTime();

        list = recursive(list, list.length);

        long endTime = System.nanoTime();
        time = (endTime - startTime);

        if (!checkSort(list)) {
            throw new UnsortedException();
        }
    }
    //recursive bubbleSort
    private int[] recursive(int[] list, int n){
        //Base case
        if (n == 1)
            return list;
        //bubbleSort algorithm
        for (int i=0; i<n-1; i++){
            if (list[i] > list[i+1]){
                int temp = list[i];
                list[i] = list[i+1];
                list[i+1] = temp;
                count++;
            }
        }
        //recursive call
       return recursive(list, n-1);
    }
    @Override
    //iterative version of Bubble sort
    //the iterative method doesn't use checkSort() method
    //because the iterativeSort method doesn't stop until
    //the array is sorted.
    public void iterativeSort(int[] list) throws UnsortedException {
        boolean isSorted = false;
        count = 0;
        time = 0;
        long startTime = System.nanoTime();
        long endTime = 0;
        while(!isSorted){
            int numOfSwaps = 0;
            for(int i = 0; i<list.length-1;i++){
                if(list[i]>list[i+1]){
                    int temp = list[i];
                    list[i]=list[i+1];
                    list[i+1]=temp;
                    numOfSwaps++;
                    count++;
                }
            }
            if(numOfSwaps==0){
                isSorted = true;
            }
        }
        endTime = System.nanoTime();
        time = (endTime - startTime);
    }
    @Override
    //gets count
    public int getCount() {
        return count;
    }
    @Override
    //gets time
    public long getTime() {
        return time;
    }
    //checks if array is sorted
    private boolean checkSort (int[] list) {
        boolean checkList = true;
        for (int i = 0; i < list.length - 1; i++) {
            if(list[i]>list[i+1]){
                checkList = false;
            }
        }
        return checkList;
    }
}
