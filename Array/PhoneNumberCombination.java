package com.practise.Leetcode;

import java.util.*;

public class PhoneNumberCombination
{
    public static void main(String[] args)
    {
        //int[] nums = {10,1,2,7,6,1,5};
        String S = "23";
        //int target = 8;
        PhoneNumberCombination s = new PhoneNumberCombination();
        //List<List<Integer>> result;
        List<String> result;
        result = s.letterCombinations(S);
        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i));
            //System.out.println("Result is "+result);
        }
    }
    public List<String> letterCombinations(String digits)
    {
        HashMap<String,String> map = new HashMap<>();
        map.put("2","abc");
        map.put("3","def");
        map.put("4","ghi");
        map.put("5","jkl");
        map.put("6","mno");
        map.put("7","qrs");
        map.put("8","tuv");
        map.put("9","wxyz");

        List<String> result = new ArrayList<>();
        if (digits.length()==0) {
            return result;
        }
        backtrack(map,digits,"",result);
        return result;

    }
    private void backtrack(HashMap<String,String> map, String digits,String temp, List<String> result)
    {
        if (digits.length()==0)
        {
            result.add(temp);
        }
        else
        {
            String letters = map.get(digits.substring(0,1));
            for (int i=0;i<letters.length();i++)
            {
                String letter = letters.substring(i,i+1);
                backtrack(map,digits.substring(1),temp+letter,result);
            }
        }
    }
}
