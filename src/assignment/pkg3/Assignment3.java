/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.pkg3;

/**
 *
 * @author Slatz8075
 */
public class Assignment3 {

    public void swap(int[] array, int p1, int p2) {
        int temp = array[p1];
        array[p1] = array[p2];
        array[p2] = temp;
    }

    //question 1
    public void selectionSort(int[] array) {
        //keep track of which position we are sorting
        for (int position = 0; position < array.length; position++) {
            //create a variable to keep track of the smallest number
            int smallestSoFar = position;
            //create an integer to go through the later parts of the array
            int nextNum = 1;
            //go through the rest looking for a smaller number
            for (int i = position + 1; i < array.length; i++) {
                //have we found a number smaller than position 0 or smaller than smallestSoFar?
                if (array[i] < array[smallestSoFar]) {
                    //We have, so keep track of it
                    smallestSoFar = i;
                }
            }
            //we have reached this point so we know that smallest so far is the smallest number, so swap them
            swap(array, position, smallestSoFar);
        }
    }

    //question 4
    public void countSort(int[] array) {
        //create new array 100 spots long
        int[] sums = new int[100]; 
        //create a for loop to go through the array, adding the specific numbers to their number counts.
        for (int position = 0; position < array.length; position++) {
            // add the array-position-number (ex: 56) and add it to the sums[array-position-number] (ex: sums[56])
            sums[array[position]] += 1;
            
        }
        //create the new array
        for (int position = 0; position < sums.length; position++) {
            //fill the array with the specific #, sums[position] # of times
            while(sums[position] > 0){
                //
                array[position] = sums[position];
                sums[position]--;
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Assignment3 test = new Assignment3();
        //making a random array of ints
        int[] numbers = new int[10];
        for (int i = 0; i < numbers.length; i++) {
            //make a random number
            numbers[i] = (int) (Math.random() * 101);
        }
        //before
        System.out.println("BEFORE:");
        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }
        //SORT Here
        test.selectionSort(numbers);

        //after
        System.out.println("AFTER:");
        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }
    }
}
