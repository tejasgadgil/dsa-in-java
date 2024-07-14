import java.util.*;

class Solution {
    
    // Helper class to store element name and count
    private static class Element implements Comparable<Element> {
        String name;
        int count;

        Element(String name, int count) {
            this.name = name;
            this.count = count;
        }

        @Override
        public int compareTo(Element o) {
            return this.name.compareTo(o.name);
        }
    }

    // Helper function to add elements to the list
    private int addToList(List<Element> elements, String formula, int i) {
        if (formula.charAt(i) == '(') {
            elements.add(new Element("(", 1));
        } else if (Character.isUpperCase(formula.charAt(i))) {
            int j = i + 1;
            while (j < formula.length() && Character.isLowerCase(formula.charAt(j))) {
                j++;
            }
            String element = formula.substring(i, j);
            int k = j;
            while (k < formula.length() && Character.isDigit(formula.charAt(k))) {
                k++;
            }
            int count = (j != k) ? Integer.parseInt(formula.substring(j, k)) : 1;
            elements.add(new Element(element, count));
            return k - i;
        } else if (formula.charAt(i) == ')') {
            int j = i + 1;
            while (j < formula.length() && Character.isDigit(formula.charAt(j))) {
                j++;
            }
            int count = (i + 1 != j) ? Integer.parseInt(formula.substring(i + 1, j)) : 1;
            elements.add(new Element(")", count));
            return j - i;
        }
        return 1;
    }

    public String countOfAtoms(String formula) {
        // Phase 1: Separate
        List<Element> elements = new ArrayList<>();
        formula = '(' + formula + ')';
        int i = 0;
        while (i < formula.length()) {
            i += addToList(elements, formula, i);
        }

        // Phase 2: Open brackets
        Deque<Element> stack = new ArrayDeque<>();
        i = 0;
        while (i < elements.size()) {
            if (!elements.get(i).name.equals(")")) {
                stack.push(elements.get(i));
            } else {
                int mul = elements.get(i).count;
                List<Element> temp = new ArrayList<>();
                while (!stack.peek().name.equals("(")) {
                    Element elem = stack.pop();
                    elem.count *= mul;
                    temp.add(elem);
                }
                stack.pop(); // pop '('
                for (int j = temp.size() - 1; j >= 0; j--) {
                    stack.push(temp.get(j));
                }
            }
            i++;
        }

        // Phase 3: Sort
        List<Element> sortedList = new ArrayList<>(stack);
        Collections.sort(sortedList);

        // Phase 4: Add together and join
        Map<String, Integer> elementCountMap = new TreeMap<>();
        for (Element e : sortedList) {
            elementCountMap.put(e.name, elementCountMap.getOrDefault(e.name, 0) + e.count);
        }

        // Phase 5: Format the result
        StringBuilder result = new StringBuilder();
        for (Map.Entry<String, Integer> entry : elementCountMap.entrySet()) {
            result.append(entry.getKey());
            if (entry.getValue() > 1) {
                result.append(entry.getValue());
            }
        }

        return result.toString();
    }
}



// Time Complexity
// The algorithm involves multiple passes over the input string and lists, contributing to linear time complexity relative to the length of the formula.
// The sorting step adds a complexity of O(nlogn), where n is the number of distinct elements in the formula.
// Overall, the time complexity is O(nlogn).
  
// Space Complexity
// The space complexity is O(n), where n is the length of the formula due to the storage requirements for the elements list and stack.
  
// Algorithm Approach
// This algorithm uses a Stack-Based Parsing approach:
// It parses the formula into manageable parts and processes parentheses and multipliers effectively using a stack.
// By handling elements and multipliers separately and then combining them, it ensures accurate counts and correctly formatted output.
