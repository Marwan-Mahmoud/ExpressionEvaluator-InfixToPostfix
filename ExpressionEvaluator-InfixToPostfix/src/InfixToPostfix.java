import java.util.Stack;

public class InfixToPostfix {

	private Stack<Character> stack;

	public InfixToPostfix() {
		stack = new Stack<>();
	}

	/**
	 * Takes a symbolic/numeric infix expression as input and converts it to postfix
	 * notation.
	 *
	 * @param expression infix expression
	 * @return postfix expression
	 */
	public String convert(String expression) {
		expression = removeDoubleNegative(expression);
		StringBuilder newExpression = new StringBuilder();
		for (int i = 0; i < expression.length(); i++) {
			char current = expression.charAt(i);
			if (isVariable(current))
				newExpression.append(current);
			else if (isOperator(current)) {
				while (!stack.isEmpty() && !hasHigherPrecedence(current, stack.peek()))
					newExpression.append(stack.pop());
				stack.push(current);
			} else if (current == '(')
				stack.push(current);
			else if (current == ')') {
				do {
					if (stack.isEmpty())
						throw new RuntimeException("Invalid expression");
					newExpression.append(stack.pop());
				} while (stack.peek() != '(');
				stack.pop();
			} else
				throw new RuntimeException("Invalid expression");
		}
		while (!stack.isEmpty()) {
			if (stack.peek() == '(')
				throw new RuntimeException("Invalid expression");
			newExpression.append(stack.pop());
		}
		return newExpression.toString();
	}

	private String removeDoubleNegative(String expression) {
		String temp = expression.replaceAll("--", "");
		StringBuilder builder = new StringBuilder();
		builder.append(temp.charAt(0));
		for (int i = 1; i < temp.length(); i++) {
			if (isVariable(temp.charAt(i)) && isVariable(builder.charAt(builder.length() - 1)))
				builder.append('+');
			builder.append(temp.charAt(i));
		}
		return builder.toString();
	}

	private boolean isVariable(char current) {
		return ExpressionEvaluator.isVariable(current);
	}

	private boolean isOperator(char current) {
		return Operators.isOperator(current);
	}

	private boolean hasHigherPrecedence(char current, char prev) {
		return prev == '(' || (Operators.getPrecedence(current) > Operators.getPrecedence(prev));
	}
}
