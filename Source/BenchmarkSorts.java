/*File: BenchmarkSorts.java
 *Author: Zackary Scott
 *Date: 2-11-2019
 *Purpose: Create 50 data sets for every value of n passed in from SortMain
 */
import java.util.Random;
/**The BenchmarkSorts creates, calculates, and displays the information
 * pertaining to the data sets.
 */
public class BenchmarkSorts{
    private BubbleSort bubbleSort = new BubbleSort();
    private Random random = new Random();
    //variable to store the sizes passed in from SortMain
    private int[] sizes;
    //arrays to handle the iterative calcuations
    private double[] iterativeCountData = new double[50];
    private double[] iterativeTimeData = new double[50];
    private double[] avgIterativeCount;
    private double[] iterativeCoefCount;
    private double[] avgIterativeTime;
    private double[] iterativeCoefTime;
    //arrays to handle the recursive calculations
    private double[] recursiveCountData = new double[50];
    private double[] recursiveTimeData = new double[50];
    private double[] avgRecursiveCount;
    private double[] recursiveCoefCount;
    private double[] avgRecursiveTime;
    private double[] recursiveCoefTime;
    //constructor
    public BenchmarkSorts(int[] sizes) {
        this.sizes = sizes;
        //initializes iterative arrays
        avgIterativeCount = new double[sizes.length];
        iterativeCoefCount = new double[sizes.length];
        avgIterativeTime = new double[sizes.length];
        iterativeCoefTime = new double[sizes.length];
        //initializes recursive arrays
        avgRecursiveCount = new double[sizes.length];
        recursiveCoefCount = new double[sizes.length];        
        avgRecursiveTime = new double[sizes.length];
        recursiveCoefTime = new double[sizes.length];
    }
    //public method to call to create and sort arrays of data
    public void runSorts() throws UnsortedException {
        for(int i = 0; i<sizes.length;i++){
            int[] iterativeData = new int[sizes[i]];
            int[] recursiveData = new int[sizes[i]];
            for(int j = 0; j<50; j++){
                //creates 50 data sets of size passed into contructor
                for (int k = 0; k < sizes[i]; k++) {
                    int randNum = random.nextInt(5000);
                    iterativeData[k] = randNum;
                    recursiveData[k] = randNum;
                }
                //sorts using iterative sort
                bubbleSort.iterativeSort(iterativeData);
                iterativeCountData[j] = bubbleSort.getCount();
                iterativeTimeData[j] = bubbleSort.getTime();
                //sorts using recursive sort
                bubbleSort.recursiveSort(recursiveData);
                recursiveCountData[j] = bubbleSort.getCount();
                recursiveTimeData[j] = bubbleSort.getTime();
            }
            doCalculations(i);
        }
    }
    //gets average
    private double getAverage(double[] list) {
        double sum = 0;
        for (int i = 0; i<list.length;i++) {
            sum += list[i];
        }
        return sum / list.length;
    }
    //gets coef
    private double getCoef(double[] list) {
        double avg = getAverage(list);
        double sum = 0;
        for (int i = 0; i<list.length; i++) {
            sum += (list[i] - avg) * (list[i] - avg);
        }
        return (Math.sqrt(sum/list.length) / getAverage(list)) * 100;
    }
    //stores the calculations in arrays to be called in display results
    private void doCalculations(int i){
        avgIterativeCount[i] = getAverage(iterativeCountData);
        iterativeCoefCount[i] = getCoef(iterativeCountData);
        avgIterativeTime[i] = getAverage(iterativeTimeData);
        iterativeCoefTime[i] = getCoef(iterativeTimeData);

        avgRecursiveCount[i] = getAverage(recursiveCountData);
        recursiveCoefCount[i] = getCoef(recursiveCountData);
        avgRecursiveTime[i] = getAverage(recursiveTimeData);
        recursiveCoefTime[i] = getCoef(recursiveTimeData);
    }
    //displays results 
    public String displayReport() {
        String sbuilder ="";
        sbuilder+="\n\tIterative"
                + "\t\t\t\t\t\t\t\t\t Recursive\n"
                +"     Size n\tAverage Critical Operation Count"
                +"\tCoefficient of Variance Count"
                +"\tAverage Execution Time"
                +"\tCoefficient of Variance Time"
                +"\tAverage Critical Operation Count"
                +"\tCoefficient of Variance Count"
                +"\tAverage Execution Time"
                +"\tCoefficient of Variance Time\n";
        for (int i = 0; i < sizes.length; i++) {
            sbuilder+="        "+sizes[i]+"\t"+ avgIterativeCount[i]+"\t"
                    +"\t\t"+iterativeCoefCount[i]+"\t"+avgIterativeTime[i]
                    +"\t\t"+iterativeCoefTime[i]+"\t"+avgRecursiveCount[i] 
                    +"\t\t\t"+recursiveCoefCount[i]+"\t"+avgRecursiveTime[i] 
                    +"\t\t"+recursiveCoefTime[i]+"\n";
        }
        return sbuilder;
    }
}
