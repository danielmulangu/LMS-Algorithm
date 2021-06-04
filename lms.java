
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author danielmulangu
 */
public class lms {
    public class numbers
            {
        public static final int row=4;
            // The row represents the numbers of element for each training data
        //plus the bias value 
        public static final int column=4;
        //The column represents the number of training data we'll have
    }
    public static void main(String[] args) {
        // TODO code application logic here
     
  
        int data[][]= new int[numbers.row][numbers.column];
        int d[]= new int[numbers.column];// the d represents the desired value 
        //for each training data
        float w[]= new float[numbers.row];//weight
        int y[]= new int[numbers.column];//actual value
        int x=0,init=0;//init is the parameter that helps initializing the weight
        float v=0;
        float n=(float) 0.15; //The learning parameter
        int count1=0,count2=1;
        //Set the bias value of training data
        for(int j=0;j<numbers.column;j++)
        {
            data[0][j]=1;
        }
        //Store the training data in arrays
        for(int j=0;j<numbers.column;j++)
        {
           
            System.out.println("Enter the value of "+j+" Trainig data ");
             for(int k=1;k<numbers.row;k++)
            {
                 Scanner Read= new Scanner(System.in);
            data[k][j]=Read.nextInt();
            }
            System.out.println("Enter the desired data ");
            Scanner desired= new Scanner(System.in);
            d[j]=desired.nextInt();
        }
        x=0;
        while(x<=3)
       {
           for(int i=0;i<numbers.column;i++)
               {
                  if(init==0)
                  {
                //for the first time initialize all the values of w by setting it all to zero
                      for(int k=0;k<numbers.row;k++){w[k]=0; }
                      v=0;
                      for(int k=0;k<numbers.row;k++){v+=(w[k]*data[k][i]); }
                      
                      init++;
                      
                      if(d[i]!=v){
                                       for(int k=0;k<numbers.row;k++)
                                       {w[k]=w[k]+n*(d[i]-v)*data[k][i]; }
                                     //create a loop which will help calculate the value of
                                     //weight and generalizes the whole program
                                   
                                    }
                      else {count1++;}
                  }
                  v=0;
                 for(int k=0;k<numbers.row;k++){v+=(w[k]*data[k][i]); }
            
                   if(d[i]!=v){
                                  for(int k=0;k<numbers.row;k++)
                                       {w[k]=w[k]+n*(d[i]-v)*data[k][i]; }
                                  count1=0;
                                 }
                   else {count1++;}
                  x++;
               }
           System.out.println("\nIn the "+count2+" Iteration, The weights are: ");
        for(int k=0;k<numbers.row;k++){System.out.print("  "+w[k]); }
        
           count2++; 
       }
        System.out.println("\nDone after "+count2+" Iterations");
        System.out.println("The weights: ");
        for(int k=0;k<numbers.row;k++){System.out.print("  "+w[k]); }
        
        
    }
    
}
