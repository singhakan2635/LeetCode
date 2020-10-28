package com.practise.Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutation2
{
    public static void main(String[] args)
    {
        int[] nums = {1,1,2};
        //String S = "tmmzuxt";
        int target = 0;
        Permutation2 s = new Permutation2();
        List<List<Integer>> result;
        result = s.permuteUnique(nums);
        for (int i = 0; i < 3; i++) {
            System.out.print(Arrays.toString(new List[]{result.get(i)}) + " ");
            //System.out.println("Result is "+result);
        }
    }
    public List<List<Integer>> permuteUnique(int[] nums)
    {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(res,new ArrayList<>(),nums,new boolean[nums.length]);
        return res;

    }
    private void backtrack(List<List<Integer>> res,List<Integer> templist,int[] nums,boolean[] seen)
    {
        if (templist.size()==nums.length)
        {
            res.add(new ArrayList<>(templist));
        }
        else
        {
            for (int i =0;i<nums.length;i++)
            {
                if (seen[i] || i>0 && nums[i]==nums[i-1] && !seen[i-1])
                {
                    continue;
                }
                seen[i] = true;
                templist.add(nums[i]);
                backtrack(res,templist,nums,seen);
                seen[i] = false;
                templist.remove(templist.size()-1);
            }
        }
    }
}
