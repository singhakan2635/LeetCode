package com.practise.Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2
{
    public static void main(String[] args)
    {
        int[] nums = {10,1,2,7,6,1,5};
        //String S = "tmmzuxt";
        int target = 8;
        CombinationSum2 s = new CombinationSum2();
        List<List<Integer>> result;
        result = s.combinationSum2(nums,target);
        for (int i = 0; i < 4; i++) {
            System.out.print(Arrays.toString(new List[]{result.get(i)}) + " ");
            //System.out.println("Result is "+result);
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target)
    {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(res,new ArrayList<>(),candidates,target,0,new boolean[candidates.length]);
        return res;
    }
    private void backtrack(List<List<Integer>> res, List<Integer> templist, int[] candidates, int target, int index, boolean[] seen)
    {
        if (target==0)
        {
            res.add(new ArrayList<>(templist));
        }
        else
        {
            for (int i= index;i<candidates.length;i++)
            {
                if (candidates[i]>target) break;
                if (seen[i] || i>index && candidates[i]==candidates[i-1] && !seen[i-1]) continue;
                templist.add(candidates[i]);
                seen[i] = true;
                backtrack(res,templist,candidates,target-candidates[i],i,seen);
                seen[i]=false;
                templist.remove(templist.size()-1);
            }
        }
    }

}
