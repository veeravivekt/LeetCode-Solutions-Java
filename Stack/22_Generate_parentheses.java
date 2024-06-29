/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.



Example 1:

Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]
Example 2:

Input: n = 1
Output: ["()"]
 */
class Solution {

    Stack<Character> stack = new Stack<>();
    List<String> list = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        backtrack(0, 0, n);
        return list;
    }

    public void backtrack(int open, int close, int max) {
        if (open == close && close == max) {
            Iterator it = stack.iterator();
            String temp = "";
            while (it.hasNext()) {
                temp += it.next();
            }
            list.add(temp);
        }
        if (open < max) {
            stack.push('(');
            backtrack(open + 1, close, max);
            stack.pop();
        }
        if (close < open) {
            stack.push(')');
            backtrack(open, close + 1, max);
            stack.pop();
        }
    }
}