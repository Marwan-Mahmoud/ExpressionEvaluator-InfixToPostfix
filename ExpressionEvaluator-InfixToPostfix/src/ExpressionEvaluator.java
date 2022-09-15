import java.util.Stack;
import java.util.function.BiFunction;

public class ExpressionEvaluator {

	public static final char varA = 'a';
	public static final char varB = 'b';
	public static final char varC = 'c';

	private int a;
	private int b;
	private int c;
	private Stack<Integer> stack;

	public ExpressionEvaluator() {
		stack = new Stack<>();
	}

	/**
	 * Evaluate a postfix numeric expression.
	 * 
	 * @param expression postfix expression
	 * @return the expression evaluated value
	 */
	public int evaluate(String expression) {
		for (int i = 0; i < expression.length(); i++) {
			char current = expression.charAt(i);
			if (isVariable(current)) {
				int var = getVariable(current);
				stack.push(var);
			} else if (isOperator(current)) {
				BiFunction<Integer, Integer, Integer> operation = getOperation(current);
				int[] operands = getOperands(current);
				stack.push(operation.apply(operands[0], operands[1]));
			} else
				throw new RuntimeException("Invalid expression");
		}
		return stack.pop();
	}

	private int getVariable(char current) {
		switch (current) {
		case 'a':
			return a;
		case 'b':
			return b;
		case 'c':
			return c;
		default:
			throw new RuntimeException("Invalid expression");
		}
	}

	static boolean isVariable(char current) {
		return current == 'a' || current == 'b' || current == 'c';
	}

	private boolean isOperator(char current) {
		return Operators.isOperator(current);
	}

	private BiFunction<Integer, Integer, Integer> getOperation(char current) {
		return Operators.getOperation(current, getNumOperands());
	}

	private int getNumOperands() {
		if (stack.size() >= 2)
			return 2;
		else if (stack.size() == 1)
			return 1;
		else
			return -1;
	}

	private int[] getOperands(char operation) {
		int[] operands = new int[2];
		int numOperands = getNumOperands();
		if (numOperands >= 2) {
			operands[1] = stack.pop();
			operands[0] = stack.pop();
		} else if (numOperands == 1 && operation == '-') {
			operands[0] = stack.pop();
			operands[1] = -1;
		} else
			throw new RuntimeException("Invalid expression");
		return operands;
	}

	public void setVariable(char name, int value) {
		switch (name) {
		case varA:
			a = value;
			break;
		case varB:
			b = value;
			break;
		case varC:
			c = value;
			break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + name);
		}
	}
}