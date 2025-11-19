# Course Schedule II

**Category:** Graphs (NeetCode)  
**Difficulty:** Medium  
**Time Complexity:** O(V + E)  
**Space Complexity:** O(V + E)

## Problem Description
You are given `numCourses` and a list of prerequisite pairs.  
Each pair `[a, b]` means you must take course **b before a**.

Your goal is to return a valid order to complete all courses.  
If no such order exists (cycle), return an empty array.

## Approach
* Use **Kahn’s Algorithm (BFS Topological Sort)** to produce an actual order.
* Build adjacency list + indegree array.
* Initialize a queue with all courses whose indegree is 0.
* While the queue is not empty:
  * Pop a course and append it to the `order` list.
  * Decrease the indegree of its neighbors.
  * If a neighbor’s indegree reaches 0, push it into the queue.
* At the end:
  * If `order.size() == numCourses`, return it.
  * Otherwise, a **cycle** exists → return empty array.

## Example
**Input:**
numCourses = 4

prerequisites = [[1,0],[2,0],[3,1],[3,2]]

**Output:**
[0,1,2,3]

**Explanation:**  
You must take course 0 first. Then you may take 1 and 2. Course 3 depends on both.

##Java Code
```Java

public class CourseScheduleII {
	public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        int[] indegree = new int[numCourses];

        for(int i = 0; i < numCourses; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] pre: prerequisites){
            int course = pre[0];
            int prereq = pre[1];

            adj.get(prereq).add(course);
            indegree[course]++;
        }
        Queue <Integer> q = new LinkedList<>();
        
        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        int count = 0;
        int[] res = new int[numCourses];
        while(!q.isEmpty()){
            int current = q.poll();
            res[count] = current;
            count++;
            for(int next: adj.get(current)){
                indegree[next]--;
                if(indegree[next] == 0){
                    q.add(next);
                }
            }
        }
        return count == numCourses ? res: new int[0];
    }
}

