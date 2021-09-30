import java.util.ArrayList;
import java.util.Arrays;

public class Basics {
    public static void main(String[] args) {

    for (int i = 1; i <= 255; i++) {
        System.out.println(i);
    }

    for (int j =1; j<=255; j+=2) {
        System.out.println(j);
    }

    int sum = 0;
    int k = 1;
    for (k =1; k<=255; k++) {
        sum = sum + k;
    }

    System.out.println(sum);


    int [] myArray = {1,3,5,7,9,13};
    for (int num: myArray) {
        System.out.println(num);
    }

    int [] nextArray = {3,-7,8,27,3,5};
    int max = 0;
    for (int a = 0; a < nextArray.length; a++) {
        if(nextArray[a] > max) {
            max = nextArray[a];
        }
    }
    System.out.println(max);


    ArrayList<Integer> OddArray = new ArrayList<Integer>();
    for(int b = 1; b<=255; b+=2) {
        OddArray.add(b);
    }

    System.out.println(OddArray);


    int [] AverageArray = {3,-7,8,27,3,5};
    float total = 0;
    for(int c = 0; c < AverageArray.length; c++) {
        total = total + AverageArray[c];
    }
    float average = total / AverageArray.length;
    System.out.println(average);


    int x = 7;
    int [] nums = {3, 8, 21, -32, 6};
    for(int i = 0; i < nums.length; i++) {
        if (nums[i] > x) {
            System.out.println(nums[i]);
        }
    }

    int [] squares = {-1, 3, 20, -12};
    for (int i = 0; i < squares.length; i++) {
        squares[i] = squares[i] * squares[i];
    }
    System.out.println(Arrays.toString(squares));


    int [] zeroes = {-1, 3, 20, -12};
    for (int i = 0; i< zeroes.length; i++) {
        if (zeroes[i] < 0) {
            zeroes[i] = 0;
        }
    }
    System.out.println(Arrays.toString(zeroes));


    // int [] MaxMinAvg = {-3, 7, 10, 3, 1, 6};
    // int maximum = 0;
    // int min = 0;
    // float totals = 0;
    // for(int i = 0; i < MaxMinAvg.length; i++) {
    //     totals = totals + MaxMinAvg[i];
    //     for (int j = i + 1; j < MaxMinAvg.length; j++) {
    //         if (MaxMinAvg[j] > MaxMinAvg[i]) {
    //             maximum = MaxMinAvg[j];
    //         }
    //         if (MaxMinAvg[j] < MaxMinAvg[i]) {
    //             min = MaxMinAvg[j];
    //         }
    //     }
        
    // }
    // float averages = totals / MaxMinAvg.length;
    // System.out.println("The max is " + maximum + ", the min is " + min + ", and the average is " + averages);




    int [] shift = {-1,5,10,7,2};

    for(int i = 0; i < shift.length; i++) {
        if (i + 1 == shift.length) {
            shift[i] = 0;
            break;
        }
        shift[i] = shift[i + 1];
    }

    System.out.println(Arrays.toString(shift));

    }

   
}