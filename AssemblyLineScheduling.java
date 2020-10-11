import java.util.*;
import java.io.*;
class AssemblyLineScheduling
{
      static int nLine = 2;
      static int nStation = 15;
      static int min(int a, int b)
      {
            if (a < b)
                  return a;
            else 
                  return b;
      }
      static int Assembly(int a[][], int t[][], int e[], int x[])
      {
            int time1[]= new int [nStation];
            int time2[] =new int[nStation];
            int i; 
            time1[0] = e[0] + a[0][0];
            time2[0] = e[1] + a[1][0];
            for (i = 1; i < nStation; ++i)
            {
                  time1[i] = min(time1[i - 1] + a[0][i],time2[i - 1] + t[1][i] + a[0][i]); 
                  time2[i] = min(time2[i - 1] + a[1][i],time1[i - 1] + t[0][i] + a[1][i]); 
            }
            return min(time1[nStation-1] + x[0],time2[nStation-1] + x[1]); 
      }
      public static void main (String args[])
      {
            int a[][] = {{5,9,6,8,6,7,8,7,6,9,13,14,10,8,10},{3,8,11,13,15,8,9,14,6,5,10,11,13,7,12,2}}; 
            int t[][] = {{9,7,14,8,7,9,8,9,10,12,11,5,13,7,14},{7,9,12,10,12,13,14,15,8,9,7,6,5,10,12}};
            int e[] = {10, 12}, x[] = {12, 6};
            System.out.println(Assembly(a, t, e, x));
      } 
}