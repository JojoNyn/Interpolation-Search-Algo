// Name: Joe Huynh
// Class: CS 4306/4
// Term: Fall 2022
// Instructor: Dr. Haddad
// Assignment: 2


import java.util.*;

public class InterpolationSearch {
    boolean keyStatus;
    int indexTarget;
    int divisions;

    InterpolationSearch(int keyValue, int []Values){
        //starting the search
        int low = 0;
        int high = Values.length - 1;
        int search = 0;
        int numOfDivisions = 0;
        this.indexTarget = 0; //defaults to zero
        while((Values[high] != Values[low]) && (keyValue >= Values[low]) && (keyValue <= Values[high])) {
            numOfDivisions++;
            search = low + ((keyValue - Values[low]) * (high - low) / (Values[high] - Values[low]));
            //using the code formula from wikipedia
            if (Values[search] < keyValue) {
                low = search + 1;
            } else if (keyValue < Values[search]) {
                high = search - 1;
            }else if (keyValue == Values[search]){ //if the search value equals what we're trying to find
                this.indexTarget = search;
                this.keyStatus = true;
                break;
            }
            else if (keyValue == Values[low]) {
                this.indexTarget = low;
                this.keyStatus = true;
            }
            else {
                this.indexTarget = -1; //key is not in array
                this.keyStatus = false;
            }
        }
        divisions = numOfDivisions;

    }
}
