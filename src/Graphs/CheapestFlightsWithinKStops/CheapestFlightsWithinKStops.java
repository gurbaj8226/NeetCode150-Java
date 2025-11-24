package Graphs.CheapestFlightsWithinKStops;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class CheapestFlightsWithinKStops {
	public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map <Integer, List<int[]>> graph = new HashMap<>();

        for(int i = 0; i < n; i++){
            graph.put(i, new ArrayList<>());
        }
        
        for(int[] f: flights){
            graph.get(f[0]).add(new int[] {f[1], f[2]});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[] {0, src, 0});

        int[] costTo = new int[n];
        int[] stopsTo = new int[n];
        Arrays.fill(costTo, Integer.MAX_VALUE);
        Arrays.fill(stopsTo, Integer.MAX_VALUE);

        costTo[src] = 0;
        stopsTo[src] = 0;

        while(!pq.isEmpty()){
            int[] top = pq.poll();
            int cost = top[0];
            int city = top[1];
            int stop = top[2];

            if(city == dst){
                return cost;
            }
            if(stop > k){
                continue;
            }

            for(int[] edge: graph.get(city)){
                int nextCity = edge[0];
                int price = edge[1];

                int newCost = cost + price;
                int newStops = stop + 1;

                if(newCost < costTo[nextCity] || newStops < stopsTo[nextCity]){
                    costTo[nextCity] = newCost;
                    stopsTo[nextCity] = newStops;
                    pq.offer(new int[] {newCost, nextCity, newStops});
                }
            }
        }
        return -1;
    }
}
