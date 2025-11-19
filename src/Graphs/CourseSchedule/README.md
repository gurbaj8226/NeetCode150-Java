# Course Schedule

**Category:** Graphs (NeetCode)  
**Difficulty:** Medium  
**Time Complexity:** O(V + E)  
**Space Complexity:** O(V + E)

## Problem Description
You are given `numCourses` and a list of prerequisite pairs.  
Each pair `[a, b]` means you must take course **b before a**.

Your goal is to determine if it is possible to finish all courses.  
This is equivalent to checking whether the directed graph contains a **cycle**.

## Approach
* Use **Kahn’s Algorithm (BFS Topological Sort)**.
* Build an adjacency list and an `indegree` array.
* Push all courses with `indegree = 0` into a queue.
* Repeatedly remove from the queue:
  * Add it to the processed count.
  * Reduce the indegree of its neighbors.
  * If any neighbor’s indegree becomes 0, push it into the queue.
* If the processed count equals `numCourses`, all courses can be finished.
* If not, a **cycle** exists and it is impossible.

## Example
**Input:**
numCourses = 2

prerequisites = [[1,0]]

**Output:**
true

**Explanation:**  
Take course 0 → then course 1. No cycle exists.

## Java Code
```java
public class CourseSchedule {
	public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>();

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

        int total = 0;
        while(!q.isEmpty()){
            int curr = q.poll();
            total++;
            for(int nextCourse: adj.get(curr)){
                indegree[nextCourse]--;
                if(indegree[nextCourse] == 0){
                    q.add(nextCourse);
                }
            }
        }
        return total == numCourses;
    }
}
