import java.util.*;

class Solution {

    // Helper class to represent each robot with its properties
    class Robot {
        int index;
        int position;
        char direction;
        int health;

        // Constructor to initialize a robot's attributes
        public Robot(int index, int position, char direction, int health) {
            this.index = index;
            this.position = position;
            this.direction = direction;
            this.health = health;
        }
    }

    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        List<Robot> robots = new ArrayList<>();
        
        // Initialize a list of robots with their attributes
        for (int i = 0; i < n; i++) {
            robots.add(new Robot(i, positions[i], directions.charAt(i), healths[i]));
        }

        // Sort robots by their positions
        robots.sort(Comparator.comparingInt(robot -> robot.position));

        Stack<Robot> stack = new Stack<>();
        int i = 0;
        
        // Process each robot in sorted order
        while (i < n) {
            if (!stack.isEmpty() && stack.peek().direction == 'R' && robots.get(i).direction == 'L') {
                // If both robots have the same health, both are destroyed
                if (stack.peek().health == robots.get(i).health) {
                    stack.pop();
                    i++;
                }
                // If the robot in the stack has higher health, it survives but loses one health point
                else if (stack.peek().health > robots.get(i).health) {
                    stack.peek().health -= 1;
                    i++;
                }
                // If the incoming robot has higher health, it survives but loses one health point
                else if (stack.peek().health < robots.get(i).health) {
                    robots.get(i).health -= 1;
                    stack.pop();
                }
            } else {
                // If there is no collision, add the current robot to the stack
                stack.push(robots.get(i));
                i++;
            }
        }

        // Sort the remaining robots by their original index to return their health in the original order
        stack.sort(Comparator.comparingInt(robot -> robot.index));

        List<Integer> result = new ArrayList<>();
        for (Robot robot : stack) {
            result.add(robot.health);
        }
        return result;
    }
}

// Time Complexity
// Sorting the robots by their positions takes O(nlogn), where n is the number of robots.
// The while loop processes each robot once, resulting in O(n) time complexity for this part.
// Sorting the stack by the original index takes O(nlogn).
// The total time complexity is O(nlogn).
  
// Space Complexity
// The space complexity is O(n) due to the stack and the additional list used to combine and sort the robot attributes.
  
// Algorithm Approach
// The algorithm approach used in this solution is a Greedy algorithm combined with a Stack-based approach.
