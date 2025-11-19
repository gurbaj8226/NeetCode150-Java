package Graphs.CourseScheduleII;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
