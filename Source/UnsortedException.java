/*File: UnsortedException.java
 *Author: Zackary Scott
 *Date: 2-11-2019
 *Purpose: Throws a custom exception if an array doesn't get sorted.
 */
public class UnsortedException extends Exception{
    UnsortedException(){
        System.out.println("The sort operation failed!");
    }
}
