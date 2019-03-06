/*File: SortInterface.java
 *Author: Zackary Scott
 *Date: 2-11-2019
 *Purpose: Interface to be used by BubbleSort class
 */
public interface SortInterface {
    public void recursiveSort(int[] list) throws UnsortedException;
    public void iterativeSort(int[] list) throws UnsortedException;
    public int getCount();
    public long getTime();
}
