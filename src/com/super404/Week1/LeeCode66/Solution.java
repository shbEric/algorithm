package com.super404.Week1.LeeCode66;

public class Solution {
    public int[] plusOne(int[] digits) {

        int length = digits.length;

        for(int i = length - 1; i>=0; i--){
            //1、数组末尾没有9，则直接末尾加1，返回
            if(digits[i] != 9){
                digits[i] = digits[i] + 1;
                //2、数组末尾有几个9，就在前一位加1，后面置为0
                for(int j = i+1; j<length; j++){
                    digits[j] = 0;
                }
                return digits;
            }
        }

        //3、全部为9，则数组变长，第一位为1，其他为0
        int[] result = new int[length+1];
        result[0] = 1;
        return result;
    }
}
