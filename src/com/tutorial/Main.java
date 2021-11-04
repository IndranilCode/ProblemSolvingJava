package com.tutorial;

public class Main {

    public static void main(String[] args) {
	// write your code here

        //Day 4 - (18 Oct) - Introduction to Problem Solving

        //2. Add Binary String [a = "100" , b = "11", a+b = "111"]
        //System.out.println(addBinary("1000", "10"));

//        TimeComplexity2 timeComplexity2 = new TimeComplexity2();
//        timeComplexity2.executeTimeComplexity2();

        ArraysDynamicArrays arraysDynamicArrays = new ArraysDynamicArrays();
        arraysDynamicArrays.executeArraysDynamicArrays();
    }


    public static String addBinary(String a, String b) {
        int aLen = a.length();
        int bLen = b.length();
        int higherlength = Math.max(aLen, bLen);
        int lowerLength = Math.min(aLen, bLen);

        String preConnectString = "";

        for (int i = 0; i< (higherlength-lowerLength); i++) {
            preConnectString = preConnectString + "0";
        }
        if (aLen < higherlength) {
            a = preConnectString + a;
        }
        if (bLen < higherlength) {
            b = preConnectString + b;
        }

        String result = "";

        for(int i = higherlength-1 ; i >= 0; i--) {
            int aBit = Integer.parseInt(a.substring(i,i+1));
            int bBit = Integer.parseInt(b.substring(i,i+1));
            result = ((int)aBit | (int)bBit) + result;
        }
        return result;
    }
}
