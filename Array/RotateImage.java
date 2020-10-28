package com.practise.Leetcode;

import java.util.Arrays;

class RotateImage
{
    public static void main(String[] args) {
        int [][] matrix = new int[][]{{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        rotate(matrix);
        for (int i=0;i<matrix.length;i++)
        {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }
    public static void rotate(int[][] matrix) {

        int n = matrix.length;

        //Transpose the matrix
        for (int i=0;i<n;i++)
        {
            for (int j=i;j<n;j++)
            {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        //Reverse the matrix
        for (int i=0;i<n;i++)
        {
            for (int j=0;j<n/2;j++)
            {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n-j-1];
                matrix[i][n-j-1] = temp;
            }
        }

    }
}
