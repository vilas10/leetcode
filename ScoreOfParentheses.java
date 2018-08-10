/*
Given a balanced parentheses string S, compute the score of the string based on the following rule:

() has score 1
AB has score A + B, where A and B are balanced parentheses strings.
(A) has score 2 * A, where A is a balanced parentheses string.
*/
class ScoreOfParentheses {
    public int scoreOfParentheses(String S) {
        Stack<String> stack = new Stack<>();
        
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '(') {
                stack.push("(");
            } else {
                String top = stack.pop();
                int sum = 0;
                while (!top.equals("(")) {
                    sum += Integer.parseInt(top);
                    top = stack.pop();
                }
                
                if (sum == 0) {
                    stack.push("1");
                } else {
                    stack.push("" + sum * 2);
                }
            }
        }
        
        int score = 0;
        while (!stack.isEmpty()) {
            score += Integer.parseInt(stack.pop());
        }
        
        return score;
    }
}
