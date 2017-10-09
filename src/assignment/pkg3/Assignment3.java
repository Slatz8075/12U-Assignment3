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

    //question 5 assist
    public void swap(String[] array, int pOne, int pTwo) {
        //swap the two positions
        String temp = array[pOne];
        array[pOne] = array[pTwo];
        array[pTwo] = temp;
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

    //question 2
    public int smallestMissingNumber(int[] array) {
        //create a loop that goes through the array until it reaches the end
        for (int position = 0; position < array.length; position++) {
            //check to see if the position after this one is not the position's # + 1
            if (array[position] != array[position + 1] - 1) {
                //it is not so return this unconforming position
                return array[position] + 1;
            }
        }
        //since it has made it through the array,we know all numbers are like: 1 + 2 + 3 etc.
        //so tell them
        return -1;
    }

    //question 3
    public int countOnes(int[] array) {
        //create a integer to count the total number of ones
        int ones = 0;
        //create a for loop to go through the array, checking all positions
        for (int position = 0; position < array.length; position++) {
            //check to see if this position is a one
            if (array[position] == 1) {
                //it is so add one to the ones count
                ones++;
            }
        }
        //finally return the total of ones counted in this layer, and the ones added from layers beneath 
        return ones;
    }

    //question 4
    public void countSort(int[] array) {
        //create new array 100 spots long
        int[] sums = new int[101];
        //set all the positions to zero
        for (int position = 0; position < array.length; position++) {
            //set the position to 0
            sums[position] = 0;
        }
        //create a for loop to go through the array, adding the specific numbers to their number counts.
        for (int position = 0; position < array.length; position++) {
            //add 1 to the sums array in the position of the actual number in question
            sums[array[position]] += 1;

        }
        
        //create the new array
        //create a vaiable to keep teack of while position in the new array is being modified
        int positionHolder = 0;
        //create an array that moves through the sums array
        for (int position2 = 0; position2 < sums.length; position2++) {
            //while thare is still a number grater than zero in the sums position, add its position numberinto the array
            for (int position = positionHolder; sums[position2] > 0; sums[position2]--){
                //change the new arrays position to the sumsarray position#
                array[position] = position2;
                //move to the next new array position
                positionHolder++;
            }
        }
    }

    //question 5
    public void alphInsertionSort(String[] array) {
        //create an int starting at the back of the array to 
        int position = array.length - 1;
        //an integer to keep track of how sorted the array is
        int sortCount = 0;
        //check to see if the current position is greater than the position before it
        while (array[position].compareTo(array[position - 1]) == -1) {
            //it is so swap this position before it
            swap(array, position, position - 1);
            //adjust the position since our number of interest is in a new spot
            position--;
        }
        //Now since a new number is in the back we repeat the process
        alphInsertionSort(array);

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Assignment3 test = new Assignment3();
        
        System.out.println("ASSIGNMENT 1");
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

        

        System.out.println("ASSIGNMENT 2");
        int[] numbersTwo = new int[5];
        numbersTwo[0] = 0;
        numbersTwo[1] = 1;
        numbersTwo[2] = 2;
        numbersTwo[3] = 3;
        numbersTwo[4] = 5;
        //before
        System.out.println("BEFORE:");
        for (int i = 0; i < numbersTwo.length; i++) {
            System.out.println(numbersTwo[i]);
        }
        //result
        System.out.println("RESULT:");
        System.out.println(test.smallestMissingNumber(numbersTwo));

         
        
        System.out.println("ASSIGNMENT 3");
        int[] numbersThree = new int[10];
        for (int i = 0; i < numbersThree.length; i++) {
            //make a random number
            numbersThree[i] = (int) (Math.random() * 2);
        }
        //before
        System.out.println("BEFORE:");
        for (int i = 0; i < numbersThree.length; i++) {
            System.out.println(numbersThree[i]);
        }
        //result
        System.out.println("RESULT:");
        System.out.println(test.countOnes(numbersThree));
        
        

        System.out.println("ASSIGNMENT 4");
        int[] numbersFour = new int[10];
        for (int i = 0; i < numbersFour.length; i++) {
            //make a random number
            numbersFour[i] = (int) (Math.random() * 101);
        }
        //before
        System.out.println("BEFORE:");
        for (int i = 0; i < numbersFour.length; i++) {
            System.out.println(numbersFour[i]);
        }
        //SORT Here
        test.countSort(numbersFour);
        //after
        System.out.println("AFTER:");
        for (int i = 0; i < numbersFour.length; i++) {
            System.out.println(numbersFour[i]);
        }

        
        
        System.out.println("ASSIGNMENT 5");
        String[] lettersFive = new String[5];
        lettersFive[1] = "b";
        lettersFive[2] = "c";
        lettersFive[3] = "e";
        lettersFive[4] = "a";
        lettersFive[5] = "d";

        //before
        System.out.println("BEFORE:");
        for (int i = 0; i < lettersFive.length; i++) {
            System.out.println(lettersFive[i]);
        }
        //SORT Here
        test.alphInsertionSort(lettersFive);

        //after
        System.out.println("AFTER:");
        for (int i = 0; i < lettersFive.length; i++) {
            System.out.println(lettersFive[i]);
        }
    }
}
