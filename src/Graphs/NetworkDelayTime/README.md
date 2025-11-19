# Network Delay Time

**Category:** Graphs (NeetCode)  
**Difficulty:** Medium  
**Time Complexity:** O(E log V)  
**Space Complexity:** O(V + E)

## Problem Description
You are given a list of travel times as directed edges in a network:  
`t[i] = (u, v, w)` means it takes `w` time to travel from node `u` to node `v`.

You must determine how long it will take for a signal to reach **all nodes** starting from node `k`.  
If some nodes cannot be reached, return `-1`.

This is a **single-source shortest path** problem.

## Approach
* Use **Dijkstra’s Algorithm** with a min-heap (priority queue).
* Build an adjacency list where each entry stores `(neighbor, weight)`.
* Use a `distance[]` array initialized to infinity.
* Set `distance[k] = 0` and push `(0, k)` into the priority queue.
* While the queue is not empty:
  * Pop the node with the smallest current distance.
  * Relax its edges:
    * If a new shorter path is found, update and push into the queue.
* After processing all reachable nodes:
  * Take the maximum distance across all nodes.
  * If any node is unreachable (`∞`), return `-1`.
  * Otherwise return the maximum time.

## Example
**Input:**
times = [[2,1,1],[2,3,1],[3,4,1]]

n = 4

k = 2

**Output:**
2

**Explanation:**  
Signal reaches nodes 1 and 3 in 1 unit, then node 4 in 2 units.

##Java Code
```Java
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