package leetcode;

public class DifferentWaysToAddParentheses {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            char chatAtI = input.charAt(i);
            if (Operator.isOperator(chatAtI)) {
                Operator operator = new Operator(chatAtI);
                List<Integer> lefts = diffWaysToCompute(input.substring(0, i));
                List<Integer> rights = diffWaysToCompute(input.substring(i+1, input.length()));
                for (Integer left : lefts) {
                    for (Integer right : rights) {
                        result.add(operator.apply(left, right));
                    }
                }
            }
        }
        if (result.isEmpty()) {
            result.add(Integer.parseInt(input));
        }
        return result;
    }
}

class Operator {
    static Set<String> operators = new HashSet<>(Arrays.asList("+", "-", "*"));
    static boolean isOperator(char candidate) {
        return operators.contains(candidate);
    }

    char rawChar;

    Operator(char rawChar) {
        this.rawChar = rawChar;
    }

    Integer apply(Integer left, Integer right) {
        if (rawChar == '+') return left + right;
        if (rawChar == '-') return left - right;
        if (rawChar == '*') return left * right;
        throw new IllegalArgumentException();
    }
}
