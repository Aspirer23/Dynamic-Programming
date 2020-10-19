import java.util.*;
import java.io.*;
public class MCM
{
    public static int ChainOrder(int p[], int n)
    {
        int m[][] = new int[n][n];
        int i, j, k, temp, tm;
        for(i = 1 ; i < n ; i++)
            m[i][i] = 0;
        for (temp = 2; temp < n; temp++)
        {
            for (i = 1; i < n - temp + 1; i++)
            {
                j = i + temp - 1;
                if (j == n)
                    continue;
                m[i][j] = Integer.MAX_VALUE;
                for (k = i; k <= j - 1; k++)
                {
                    tm = m[i][k] + m[k + 1][j] + p[i -1] * p[k] * p[j];
                    if (tm < m[i][j])
                        m[i][j] = tm;
                }
            }
        }
        return m[1][n - 1];
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.println("Enter the size of array : ");
        n = sc.nextInt();
        int a[] = new int[n];
        System.out.println("Enter size of array for multiplication as elements : ");
        for(int i=0;i<n;i++)
            a[i] = sc.nextInt();
        int size = a.length;
        System.out.println();
        System.out.println("Minimum number of multiplications : " + ChainOrder(a, size));
    }
}