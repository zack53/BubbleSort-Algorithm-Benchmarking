/*File: SortMain.java
 *Author: Zackary Scott
 *Date: 2-11-2019
 *Purpose: Main program to make and run BenchmarkSorts
 */
import java.awt.Color;
import java.awt.GridBagLayout;
import javax.swing.*;
/**The SortMain class is used to run the Bubble sort algorithm.
 */
public class SortMain extends JFrame{
    private static JFrame frame = new JFrame("Benchmarking Data");
    private static JPanel myJPanel = new JPanel(new GridBagLayout());
    private  static JTextArea outputField = new JTextArea();
    private static int warmupNum = 200;
    
    public static void main(String[] args)  {
        //data set sizes
        int[] sizes = new int[]{5,10,20,50,100,200,350,600,1000,1500};
        System.out.println("Manual JVM warmup in progress, 200 to complete.");
        //manual warmup with the last iteration being displayed to screen
        for (int i = 1; i <= warmupNum; i++) {
            BenchmarkSorts sortMain = new BenchmarkSorts(sizes);
            try {
                sortMain.runSorts();
            } catch (UnsortedException ex) {
                ex.getMessage();
            }
            if(i<warmupNum)
                System.out.println("JVM iteration: " + i );
            else{
                //build the display for the GUI
                outputField.setText(sortMain.displayReport());
                outputField.setEditable(false);
                myJPanel.add(outputField);
                myJPanel.setBackground(Color.white);
                frame.add(myJPanel);
                //Sets location, visibility, size, and close operation of GUI.
                frame.setLocation(100, 400);
                frame.pack();
                frame.setSize(1800,400);
                frame.setVisible(true);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                //outputField.setText(sbuilder);
            }
        }
    }
}
