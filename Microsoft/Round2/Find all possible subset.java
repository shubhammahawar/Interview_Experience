Given an array arr[] of integers of size N that might contain duplicates, the task is to find all possible unique subsets.

Note: Each subset should be sorted.

Expected Time Complexity: O(2^N).
Expected Auxiliary Space: O(2^N * X), X = Length of each subset.




//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
    
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();
		for(int t=0;t<testCases;t++){
		    int n = sc.nextInt();
		    int arr[] = new int[n];
		    for(int i=0;i<n;i++){
		        arr[i] = sc.nextInt();
		    }
		    Arrays.sort(arr);
		    ArrayList <ArrayList<Integer>> res = new solve().AllSubsets(arr,n);
		    for (int i = 0; i < res.size (); i++)
		    {
		        System.out.print ("(");
		        for (int j = 0; j < res.get(i).size (); j++)
		        {
		            if (j != res.get(i).size()-1)
		                System.out.print ((res.get(i)).get(j) + " ");
		            else
		                System.out.print ((res.get(i)).get(j));
		        }
		        System.out.print (")");
		      
		    }
		    System.out.println();
		}
	}
}
// } Driver Code Ends


class solve
{
    //Function to find all possible unique subsets.
    
    public static void findAllSubsets(int arr[], int n, ArrayList<ArrayList<Integer>>ans, ArrayList<Integer>subset,
    int index){
        
        if(!subset.isEmpty()){
            if(!ans.contains(subset)){
                ans.add(new ArrayList<>(subset));
            }
        }
        
        for(int i=index;i<n;i++){
            subset.add(arr[i]);
            findAllSubsets(arr,n,ans,subset,i+1);
            subset.remove(subset.size()-1);
            
        }
    }
    
    public static ArrayList<ArrayList<Integer>> findSubset(int arr[], int n, ArrayList<ArrayList<Integer>>ans){
          ArrayList<Integer>subset = new ArrayList<>();
         findAllSubsets(arr,n,ans,subset,0);
         
         return ans;
         
    }
    
    
    public static ArrayList <ArrayList <Integer>> AllSubsets(int arr[], int n)
    {
        // your code here
        ArrayList<ArrayList<Integer>>ans = new ArrayList<ArrayList<Integer>>();
        ans.add(new ArrayList<>());
        ans = findSubset(arr,n,ans);
        return ans;
    }
}
