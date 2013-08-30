package client;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static int p1,p2,m1,m2;
/* Head ends here */
static void displayPathtoPrincess(int n, String [] grid){

      int p1=0;
     int p2=0;
      for(int i = 0; i < n; i++) {
          if((i ==0) || (i == (n-1)))
          if( grid[i].contains("p")){
              for(int k =0 ; k<grid[i].length();k++)
              {
                  if(grid[i].charAt(k) == 'p')
                  {
                      p1 = i;
                      p2 = k;
                  }
                      
              }
              }
          }
    if(p1 == 0 && p2 ==0) // on top line
    {
        for(int i = 0 ;i<n/2;i++ )
        {
            System.out.println("UP");
            System.out.println("LEFT");
        }
    }
    else     if(p1 == 0 && p2 == n-1) // on top line
    {
        for(int i = 0 ;i<n/2;i++ )
        {
            System.out.println("UP");
            System.out.println("RIGHT");
        }
    }
    
      else     if(p1 == n-1 && p2 == n-1) // on top line
      {
          for(int i = 0 ;i<n/2;i++ )
          {
              System.out.println("DOWN");
              System.out.println("RIGHT");
          }
      }
      else     if(p1 == n-1 && p2 == 0) // on top line
      {
          for(int i = 0 ;i<n/2;i++ )
          {
              System.out.println("DOWN");
              System.out.println("LEFT");
          }
      }
    
  }
/* Tail starts here */
public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m;
        m = in.nextInt();
        String grid[] = new String[m];
        for(int i = 0; i < m; i++) {
            grid[i] = in.next();
            
        }

    displayPathtoPrincess(m,grid);
    }
}