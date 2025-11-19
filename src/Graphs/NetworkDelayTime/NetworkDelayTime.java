package Graphs.NetworkDelayTime;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class NetworkDelayTime {
	public int networkDelayTime(int[][] times, int n, int k) {
        Map <Integer, List <int[]>> graph = new HashMap<>();
        for(int[] edge: times){
            graph.computeIfAbsent(edge[0], x -> new ArrayList<>()).add(new int[] {edge[1], edge[2]});
        }
        PriorityQueue <int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[] {k, 0}); 

        int[] distances = new int[n + 1];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[k] = 0;

        while(!pq.isEmpty()){
            int[] current = pq.poll();
            int currentNode = current[0];
            int currentDist = current[1];

            if(currentDist > distances[currentNode]){
                continue;
            }
            if(graph.containsKey(currentNode)){
                for(int[] neighbor: graph.get(currentNode)){
                    int nextNode = neighbor[0];
                    int nextDist = currentDist + neighbor[1];

                    if(nextDist < distances[nextNode]){
                        distances[nextNode] = nextDist;
                        pq.offer(new int[] {nextNode, nextDist});
                    }
                }
            }
        }
        int maxDist = Arrays.stream(distances).skip(1).max().getAsInt();
        return maxDist == Integer.MAX_VALUE ? -1: maxDist;

    }
}
