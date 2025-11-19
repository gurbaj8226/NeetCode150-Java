package Graphs.CourseSchedule;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
