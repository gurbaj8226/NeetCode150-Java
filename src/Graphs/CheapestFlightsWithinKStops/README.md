# Cheapest Flights Within K Stops

**Category:** Graphs (NeetCode)  
**Difficulty:** Medium  
**Time Complexity:** O((n + m) × k)  
**Space Complexity:** O(n × k)

## Problem Description
You are given `n` cities, flights represented as `[from, to, price]`, a starting city `src`, a destination `dst`, and an integer `k`.  
Return the **cheapest price** from `src` to `dst` with **at most k stops**.

If no such route exists, return -1.

## Approach
* Use a **modified Dijkstra’s Algorithm** because each state must track:
  - total cost  
  - current city  
  - number of stops taken
* Priority Queue stores:  
  `[costSoFar, city, stopsUsed]`
* Always expand the **cheapest** current path first.
* For each popped state:
  - If `city == dst`, return the cost.
  - If `stops > k`, skip the path.
* For each neighbor:
  - Compute new cost and increase stop count.
  - Push into the priority queue **if**:
    * new cost < best known cost for that city, OR  
    * new stop count < best known stops
* After exploring all possible states within k stops:
  - If destination not reached, return -1.

## Example
**Input:**  
n = 4, flights = [[0,1,100],[1,2,100],[2,3,100],[0,2,500]]  
src = 0, dst = 3, k = 1

**Output:**  
`700`

**Explanation:**  
`0 → 1 → 2 → 3` uses 2 stops, so it's invalid.  
The valid path with ≤ 1 stop is:  
`0 → 2 → 3` costing 500 + 100 = 600.

##Java Code
```Java 
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
