class Solution {

    // Helper class to store the result of removePairs function
    class Result {
        int tmpScore;
        String remStr;

        Result(int tmpScore, String remStr) {
            this.tmpScore = tmpScore;
            this.remStr = remStr;
        }
    }

    // Function to remove pairs and calculate the score
    public Result removePairs(String s, int pointToAdd, char stkTop, char strCmp) {
        StringBuilder stack = new StringBuilder();
        int tmpScore = 0;

        // Iterate through each character in the string
        for (char c : s.toCharArray()) {
            // If a pair is found, remove it and add to the score
            if (stack.length() > 0 && c == strCmp && stack.charAt(stack.length() - 1) == stkTop) {
                tmpScore += pointToAdd;
                stack.deleteCharAt(stack.length() - 1);
            } else {
                stack.append(c);
            }
        }

        // Return the score and the remaining string
        return new Result(tmpScore, stack.toString());
    }

    public int maximumGain(String s, int x, int y) {
        Result result;
        int score = 0;

        // Determine which pair to remove first based on the higher score
        if (x > y) {
            // Remove 'ab' pairs first
            result = removePairs(s, x, 'a', 'b');
            score += result.tmpScore;
            s = result.remStr;
            // Then remove 'ba' pairs
            result = removePairs(s, y, 'b', 'a');
            score += result.tmpScore;
        } else {
            // Remove 'ba' pairs first
            result = removePairs(s, y, 'b', 'a');
            score += result.tmpScore;
            s = result.remStr;
            // Then remove 'ab' pairs
            result = removePairs(s, x, 'a', 'b');
            score += result.tmpScore;
        }

        // Return the total score
        return score;
    }
}



// locate higher scored pair using top of stack and string, score, repeat for lower scored pair

// Time Complexity
// O(n)
// Space Complexity
// O(n)
// Algorithm Approach
// Greedy algorithm with a Stack-based approach.
