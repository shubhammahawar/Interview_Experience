You are given 2 arrays, first one has a list of process ids and the second array is the list of parent process ids of the respective processes. You are then given a process id which will be killed.
Return a list of all processes that will be killed. (Nate that when you kill a process al child processes of that process also gets killed.)
Example:-
Input :
123
012
Kill process 2
Here process 0 is parent of 1, process 1 la parent of process 2
and process 2 is parent of process 3 
so process 2 & 3 both will be killed 

2.
Input 
2 8 10 12 15 
1 5 5 10 12
Process 5, 8 ,10, 12,15 all will be killed



/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class GFG {
    
    public static List<Integer> findKilledProcess(int[]processIds, int[]parentIds, int killProcess){
        HashMap<Integer,List<Integer>>childParentProcess = new HashMap<>();
        
        for(int i=0;i<processIds.length;i++){
            childParentProcess.putIfAbsent(parentIds[i],new ArrayList<>()); // create the mapping of parent and child process
            childParentProcess.get(parentIds[i]).add(processIds[i]);
        }
        
        Queue<Integer>queue = new LinkedList<>();
        List<Integer>result = new ArrayList<>();
        
        queue.add(killProcess); // store each child process one by one in queue
        
        while(!queue.isEmpty()){
            int current = queue.poll();
            result.add(current);
            
            if(childParentProcess.containsKey(current)){ // check if childParentProcess contains key
                for(int child:childParentProcess.get(current)){
                    queue.add(child);
                }
            }
        }
        return result;
        
    }
    
	public static void main (String[] args) {
		int []processIds= {2,8,10,12,15};
		int []parentIds = {1,5,5,10,12};
		int killProcess = 5;
		
		List<Integer>ans = findKilledProcess(processIds, parentIds, killProcess);
		
		System.out.println("Killed Processes "+ans);
		
	}
}
