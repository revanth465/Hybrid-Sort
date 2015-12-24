// ********************** Code Starts from Here ****************************
// NOTE: Increasing the input size may lead to errors ad system may get crashed This code is written for input size with 60000 and less.
// NOTE: This code is initialized with input array of 60000; range of random numbers as 10; threshold value from 1000 to 20000 with 1000 incremented at each time;
package improvequick;
import java.util.Random;  // package with class random for generating random numbers;
class Sorting {
public static int hcount; // variable for total comparisions
public static void InsertionSort(int Array[], int p, int r){  // Insertion Sort Method starts from here
for(int j=p+1;j<=r;j++){
int i=j-1;
int key = Array[j];
while(i>(p-1) && Array[i]>key){
hcount++;
Array[i+1]=Array[i];
i=i-1; 		
}
Array[i+1]=key;  	
}    
} // InsertionSort is done.
	public static void QuickSort(int A[],int start,int end,int m){	// Quicksort is starting		
if((start<end)&&(end-start)>m && m!=0){  // Condition for checking m value
int pivot=partition(A,start,end); // Calls out for Partition procedure.
QuickSort(A,start,pivot-1,m); // Recursive call to Quicksort()
QuickSort(A,pivot+1,end,m); // Recursive call to Quicksort()
}
else{			
InsertionSort(A,start,end); // Calling Insertionsort method
}
}
// Partition Procedure starts
public static int partition(int A[], int p, int r) {
int x=A[r];
int temp;
int i=p-1;
for(int j=p;j<r;j++){
if(A[j]<=x){
hcount++;
i=i+1;
temp=A[j];
A[j]=A[i];
A[i]=temp;
}			
}
temp=A[i+1];
A[i+1]=A[r];
A[r]=temp;
return i+1;
}	
}
	
public class ImproveQuick{ // main class ***NOTE: initialize the file name with this classname as classname.java
public static void main(String[] args){ //main method
Random gen=new Random(); // creating object for random class
int primary[]=new int[60010]; // input array with size 60000 ** Size can be changed **
int secondary[]=new int[60010]; // another array with size 60000 ** Size can be changed **
for(int i=1; i<=60000; i++){ // for loop to load array with random numbers.
primary[i]=gen.nextInt(10);  // loading random numbers to input array with range 100. ** Range can be changed from 10-10000000
secondary[i]=primary[i]; // loading numbers from primary to secondary
	}	
for(int w=1000;w<20000;w=w+1000){ // *** Note : this loop is used to determine the threshold value, initialize the variable w, change the condition if necessary and increment the w value according to the random range. So that Threhold value can be determined.
Sorting.QuickSort(primary,1,60000,w); // calling quicksort method 
System.out.println(" Total Comparisions are   "  + Sorting.hcount + "   m value " + w); // diplaying the value of comparisons
Sorting.hcount=0; // Setting count to zero
System.arraycopy(secondary, 1, primary, 1, 59999); // reloading the elements from secondary to primary array
}
	}
}
// ********************** code ends here ********************