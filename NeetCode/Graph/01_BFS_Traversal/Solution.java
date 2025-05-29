
class Solution {
    // Function to perform BFS traversal of a graph
    public List<Integer> bfsTraversal(int numVertices, List<List<Integer>> adjacencyList) {
        // Result list to store the BFS traversal order
        List<Integer> bfsOrder = new ArrayList<>();
        // Array to track visited nodes
        boolean[] visited = new boolean[numVertices];
        // Queue to process nodes in BFS order
        Queue<Integer> queue = new LinkedList<>();

        // Start BFS from the first node (node 0)
        queue.add(0);        // Add node 0 to the queue
        visited[0] = true;   // Mark node 0 as visited

        // Process nodes until the queue is empty
        while (!queue.isEmpty()) {
            // Get the next node from the queue
            int currentNode = queue.poll();
            bfsOrder.add(currentNode); // Add it to the BFS result

            // Visit all neighbors of the current node
            for (int neighbor : adjacencyList.get(currentNode)) {
                if (!visited[neighbor]) { // If neighbor is not visited
                    visited[neighbor] = true; // Mark it as visited
                    queue.add(neighbor);      // Add it to the queue
                }
            }
        }

        // Return the BFS traversal order
        return bfsOrder;
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

        // Creating a Solution object and calling the BFS method
        Solution solution = new Solution();
        List<Integer> bfsOrder = solution.bfsTraversal(numVertices, adjacencyList);

        // Printing the BFS traversal
        System.out.println("BFS Traversal: " + bfsOrder);
    }
}
