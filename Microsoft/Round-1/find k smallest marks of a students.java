We have a fow students in the class. We need to find k smallest studonts in tho class (not in any order).
Example:
Input:
k=2
A - 175, B- 160, C - 165, D - 150, E - 180

Output: (B, D) (any order Is fine)

T.C = O(N*LogK)


/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class GFG {
    
    public static List<String> findKSmallestStudentsMarks(HashMap<Integer,String>students,int k){
        
        PriorityQueue<Integer>marks = new PriorityQueue<>(Collections.reverseOrder());
        // Collections.reverse() -  the PriorityQueue is initialized with Collections.reverseOrder(), which creates a max heap
    
        
        for(Map.Entry<Integer,String>eachStudent:students.entrySet()){
            int studentMark = eachStudent.getKey();
            marks.add(studentMark);
            
            if(marks.size()>k){
                marks.poll();
            }
        }
        
        ArrayList<String>ans = new ArrayList<>();
        while(!marks.isEmpty()){
            ans.add(students.get(marks.poll()));
        }
        
        return ans;
        
        
        
    }
    
	public static void main (String[] args) {
	//	System.out.println("GfG!");
	  HashMap<Integer,String>students = new HashMap<>();
	  students.put(175, "A");
	  students.put(160, "B");
	  students.put(165, "C");
	  students.put(150, "D");
	  students.put(180, "E");
	  
	  int k=2;
	  
	  List<String>ans= findKSmallestStudentsMarks(students,k);
	  System.out.println("k smallest marks "+ans);
	  
	}
}
