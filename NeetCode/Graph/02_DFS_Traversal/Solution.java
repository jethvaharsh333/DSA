import java.util.*;

class Solution {
    // Function to perform DFS traversal of a graph
    public List<Integer> dfsTraversal(int numVertices, List<List<Integer>> adjacencyList) {
        // Result list to store the DFS traversal order
        List<Integer> dfsOrder = new ArrayList<>();
        // Array to track visited nodes
        boolean[] visited = new boolean[numVertices];

        // Start DFS from node 0
        dfs(0, adjacencyList, visited, dfsOrder);

        return dfsOrder;
    }

    // Helper function to perform DFS recursively
    private void dfs(int node, List<List<Integer>> adjacencyList, boolean[] visited, List<Integer> dfsOrder) {
        // Mark the current node as visited
        visited[node] = true;
        // Add the current node to the DFS result
        dfsOrder.add(node);

        // Visit all neighbors of the current node
        for (int neighbor : adjacencyList.get(node)) {
            if (!visited[neighbor]) { // If neighbor is not visited
                dfs(neighbor, adjacencyList, visited, dfsOrder); // Recursive call for the neighbor
            }
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        int numVertices = 5; // Total number of nodes in the graph

        // Creating the adjacency list for the graph
        List<List<Integer>> adjacencyList = new ArrayList<>();
        for (int i = 0; i < numVertices; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        // Adding edges to the graph
        adjacencyList.get(0).add(1);
        adjacencyList.get(0).add(2);
        adjacencyList.get(1).add(3);
        adjacencyList.get(1).add(4);

        // Creating a Solution object and calling the DFS method
        Solution solution = new Solution();
        List<Integer> dfsOrder = solution.dfsTraversal(numVertices, adjacencyList);

        // Printing the DFS traversal
        System.out.println("DFS Traversal: " + dfsOrder);
    }
}
