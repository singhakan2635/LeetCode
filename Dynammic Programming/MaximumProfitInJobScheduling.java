package com.practise.Leetcode;


import java.util.Arrays;

public class MaximumProfitInJobScheduling
{
    public static void main(String[] args) {
        int[] startTime = new int[]{1,2,3,4,6};
        int[] endTime = new int[]{3,5,10,6,9};
        int[] profit = new int[]{20,20,100,70,60};
        int result = jobScheduling(startTime,endTime,profit);
        System.out.println("Result is "+result);

    }
    public static int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;

        Jobs[] jobs = new Jobs[n];

        for (int i =0;i<n;i++)
        {
            jobs[i] = new Jobs(startTime[i],endTime[i],profit[i]);
        }

        int[] dp = new int[n];
        dp[0] = jobs[0].profit;
        for (int i=1;i<n;i++)
        {
            int currProfit = jobs[i].profit;
            int index = BinarySearch(jobs,i);
            if (index!=-1)
            {
                currProfit += dp[index];
            }
            dp[i] = Math.max(dp[i-1],currProfit);

        }
        return dp[n-1];

    }
    static class Jobs
    {
        int start, end, profit;

        public Jobs(int start, int end, int profit) {
            this.start = start;
            this.end = end;
            this.profit = profit;
        }
    }
    private static int BinarySearch(Jobs[] jobs, int target)
    {
        int start =0, end = target-1;
        while (start<=end)
        {
            int mid = start + (end-start)/2;

            if (jobs[mid].end <= jobs[target].start)
            {
                if (jobs[mid+1].end <= jobs[target].start)
                {
                    start = mid+1;
                }
                else
                    return mid;
            }
            else
                end = mid-1;
        }
        return -1;
    }
}

