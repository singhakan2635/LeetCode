package com.practise.Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class subsets
{
    public static void main(String[] args)
    {
        int[] nums = {1,1,2};
        //String S = "tmmzuxt";
        int target = 0;
        subsets s = new subsets();
        List<List<Integer>> result;
        result = s.subsetsWithDup(nums);
        for (int i = 0; i < 6; i++) {
            System.out.print(Arrays.toString(new List[]{result.get(i)}) + " ");
            //System.out.println("Result is "+result);
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums)
    {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(res,new ArrayList<>(),nums,0);
        return res;
    }
    private void backtrack(List<List<Integer>> res,List<Integer> templist,int[] nums,int index)
    {
        res.add(new ArrayList<>(templist));
        for (int i= index;i<nums.length;i++)
        {
            if (i>index && nums[i]==nums[i-1]) continue;
            templist.add(nums[i]);
            backtrack(res,templist,nums,i+1);
            templist.remove(templist.size()-1);
        }
    }
}
