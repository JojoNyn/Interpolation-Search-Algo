// Name: Joe Huynh
// Class: CS 4306/4
// Term: Fall 2022
// Instructor: Dr. Haddad
// Assignment: 2

//Interpolation Search
//Make an array of 1024 random distinct values that range from 1 to 9999
//Create an Interpolation Search Class that holds 3 attributes: Boolean that determines if value found, index of the value, number of divisions the search made
//When creating an interpolation search object, it will search for the values using Values[] and the key value


import java.util.*;
import java.lang.Math;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int option = 0;
        int tableSize = 5; //default size
        int Values[] = RandomDistinct(); //default values
        while (option != 4) {
            System.out.println("---------------Main Menu--------------");
            System.out.println("1. Create and Display array Values[] \n2. Read output table size\n3. Run algorithm and display outputs \n4. Exit Program");
            System.out.print("Enter Number Option: ");
            option = scan.nextInt();

            switch (option) {
                case 1:
                    int Temp[] = RandomDistinct();
                    for (int i = 0; i < Temp.length; i++) {
                        Values[i] = Temp[i]; //puts new values in array
                    }
                    for (int j = 0; j < Values.length; j++) {
                        System.out.print(Values[j] + "\t");
                        if (j % 30 == 0 && j != 0) {
                            System.out.print("\n"); //every 30 entries, print on a new row
                        }
                    }
                    System.out.print("\n");
                    break;
                case 2:
                    System.out.println("Enter table size: ");
                    tableSize = scan.nextInt();

                    break;
                case 3:
                    runIS(tableSize, Values);
                    break;
                case 4:

                    break;

                default:
                    System.out.println("Invalid number");
            }
        }
    }

    public static int[] RandomDistinct() {
        int[] random = new int[1024];
        ArrayList<Integer> Temp = new ArrayList<Integer>();
        //temporary arraylist to make sorting and generating unique values easier
        for (int i = 0; i < 1024; i++) {
            int rand = (int) Math.floor(Math.random() * (9999 - 1 + 1) + 1);
            //random value between 1 and 9999
            if (!Temp.contains(rand)) {
                Temp.add(rand);
                //if the value doesn't exist, add to the arraylist
            } else {
                i--;
                //don't iterate if value hasn't been found.
            }
        }
        Collections.sort(Temp);
        //sort arraylist
        for (int j = 0; j < 1024; j++) {
            random[j] = Temp.get(j);
        }
        //add everything to array
        return random;
        //return random
    }

    public static void runIS(int tableSize, int[] Values) {
        Scanner scan = new Scanner(System.in);
        //first we get our key values
        ArrayList<Integer> Temp = new ArrayList<Integer>();//list of integers
        int divisionsTotal = 0; //default division total

        for (int i = 0; i < tableSize; i++) {
            int rand = scan.nextInt();
            //random value between 1 and 9999
            if (!Temp.contains(rand)) {
                Temp.add(rand);
                //if the value doesn't exist, add to the arraylist
            } else {
                i--;
                //don't iterate if value hasn't been found.
            }
        }
        for (Integer integer : Temp) {
            InterpolationSearch Temp3 = new InterpolationSearch(integer, Values); //create object
            System.out.print(integer + "\t\t" + Temp3.keyStatus + "\t" + Temp3.indexTarget + "\t" + Temp3.divisions);
            divisionsTotal += Temp3.divisions;
            System.out.print("\n");
        }
        double average = (double)(divisionsTotal/tableSize);
        System.out.println("Divisions Average: " + "\t" + average);
        double difference = 3.322 - average;
        System.out.println("Difference: " + "\t" + difference);
    }
}
