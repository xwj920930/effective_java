package com.xwj;

public class App
{
    public static void main( String[] args )
    {
        Solution solution=new Solution();
        String s = solution.intToRoman(58);
        System.out.println(s);
    }
}
//I             1
//        V             5
//        X             10
//        L             50
//        C             100
//        D             500
//        M             1000
class Solution {
    public String intToRoman(int num) {
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder stringBuilder = new StringBuilder();
        int index = 0;
        while (index < 13) {
            while (num >= nums[index]) {
                stringBuilder.append(romans[index]);
                num -= nums[index];
            }
            index++;
        }
        return stringBuilder.toString();
    }
}
