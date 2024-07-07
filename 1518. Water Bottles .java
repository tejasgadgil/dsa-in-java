class Solution {
    public int numWaterBottles(int numBottles, int numEx) {
        // Initialize the total number of bottles drunk to the initial number of bottles
        int bottles = numBottles;
        int drink = numBottles;

        // Continue exchanging as long as the number of empty bottles is greater than or equal to the exchange rate
        while (bottles >= numEx) {
            // Calculate the remainder when empty bottles are divided by the exchange rate
            int isRemaining = bottles % numEx;
            
            // Calculate the number of new bottles obtained by exchanging empty ones
            bottles /= numEx;

            // Add the newly obtained full bottles to the total count of bottles drunk
            drink += bottles;

            // Update the count of empty bottles by adding the remaining empty bottles
            bottles += isRemaining;
        }

        // Return the total count of bottles drunk
        return drink;
    }
}


// Time Complexity
// The time complexity is O(log numEx(numBottles)). This is because in each iteration of the while loop, the number of bottles is divided by numEx, leading to a logarithmic reduction in the number of iterations required.
// Space Complexity
// The space complexity is O(1). This is because the solution only uses a constant amount of extra space for the variables bottles, drink, and isRemaining, regardless of the size of the input.
// Algorithm Approach
// The algorithm approach used in this solution is a Greedy algorithm.
