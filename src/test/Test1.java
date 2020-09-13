package test;

import java.util.Scanner;

/**
 *
 */
public class Test1 {

    public static void main(String[] args) {
        Scanner scanner  = new Scanner(System.in);
        String inputLine = scanner.nextLine();
        if("null".equals(inputLine) ){
            // do something
        }
        String[] input = inputLine.trim().split(",");
        int[] arr = new int[input.length];
        for(int i = 0; i < input.length; i++){
            arr[i] = Integer.valueOf(input[i]);
            System.out.println(arr[i]);
        }
    }


}
