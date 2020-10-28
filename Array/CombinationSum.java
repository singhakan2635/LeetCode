package com.practise.Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum
{
    public static void main(String[] args)
    {
        int[] nums = {2,3,5};
        //String S = "tmmzuxt";
        int target = 8;
        CombinationSum s = new CombinationSum();
        List<List<Integer>> result;
        result = s.combinationSum(nums,target);
        for (int i = 0; i < 3; i++) {
            System.out.print(Arrays.toString(new List[]{result.get(i)}) + " ");
            //System.out.println("Result is "+result);
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target)
    {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res,new ArrayList<>(),candidates,target,0);
        return res;
    }
    private void backtrack(List<List<Integer>> res,List<Integer> templist,int[] candidates,int target, int index)
    {
        if (target==0)
        {
            res.add(new ArrayList<>(templist));
        }
        else
        {
            for (int i=index;i<candidates.length;i++)
            {
                if (candidates[i]>target) break;
                templist.add(candidates[i]);
                backtrack(res,templist,candidates,target-candidates[i],i);
                templist.remove(templist.size()-1);

            }
        }
    }
}
