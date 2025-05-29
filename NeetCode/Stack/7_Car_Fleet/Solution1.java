// Time complexity: O(nlogn); Space Complexity: O(n)
class Solution1 {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        double[][] cars = new double[n][2];

        for(int i=0 ; i<n; i++){
            cars[i][0] = position[i];  // Position
            cars[i][1] = (double)(target - position[i])/speed[i];  // Time to reach target
        }

        Arrays.sort(cars, Comparator.comparingDouble(a -> -a[0])); //Sort cars by starting position in descending order

        for(int i=0 ; i<cars.length ; i++){
            System.out.println(cars[i][0] + " :: " + cars[i][1]);
        }

        int fleets = 0;
        int i = 0;
        while(i < n){
            fleets++;  // Start a new fleet with the current car
            double timeToTarget = cars[i][1];  // Current car's time to reach the target
            
            int j = i+1;            // Look ahead to see if the next car joins this fleet
            while(j<n && cars[j][1]<=timeToTarget) {
                j++;                // Skip cars that would join the current fleet
            }
            
            i = j;          // Move i to the next car that would form a new fleet
        }

        return fleets;
    }
}
