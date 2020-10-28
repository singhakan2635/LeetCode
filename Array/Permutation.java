package com.practise.Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutation
{
    public static void main(String[] args)
    {
        int[] nums = {1,2,3};
        //String S = "tmmzuxt";
        int target = 0;
        Permutation s = new Permutation();
        List<List<Integer>> result;
        result = s.permute(nums);
        for (int i = 0; i < 6; i++) {
            System.out.print(Arrays.toString(new List[]{result.get(i)}) + " ");
            //System.out.println("Result is "+result);
        }
    }

    public List<List<Integer>> permute(int[] nums)
    {
        List<List<Integer>> res = new ArrayList<>();
        Backtrack(res,new ArrayList<>(),nums);
        return res;
    }
    private void Backtrack(List<List<Integer>> res, List<Integer> templist, int[] nums)
    {
        if (templist.size()==nums.length)
        {
            res.add(new ArrayList<>(templist));
        }
        else
        {
            for (int i=0;i<nums.length;i++)
            {
                if (templist.contains(nums[i])) continue;
                templist.add(nums[i]);
                Backtrack(res,templist,nums);
                templist.remove(templist.size()-1);
            }
        }
    }
}
