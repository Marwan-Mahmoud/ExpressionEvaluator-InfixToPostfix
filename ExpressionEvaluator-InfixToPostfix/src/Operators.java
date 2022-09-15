import java.util.function.BiFunction;

public class Operators {

	private static final Operator nullOperator = new Operator(-1, (x, y) -> -1);
	private static final Operator addition = new Operator(0, (x, y) -> x + y);
	private static final Operator subtraction = new Operator(0, (x, y) -> x - y);
	private static final Operator unaryMinus = new Operator(0, (x, y) -> x * -1);
	private static final Operator multiplication = new Operator(1, (x, y) -> x * y);
	private static final Operator division = new Operator(1, (x, y) -> x / y);
	private static final Operator exponent = new Operator(2, (x, y) -> (int) Math.pow(x, y));

	private static class Operator {
		private int precedence;
		private BiFunction<Integer, Integer, Integer> operation;

		Operator(int precedence, BiFunction<Integer, Integer, Integer> operation) {
			this.operation = operation;
			this.precedence = precedence;
		}

		BiFunction<Integer, Integer, Integer> getOperation() {
			return operation;
		}

		int getPrecedence() {
			return precedence;
		}
	}

	public static boolean isOperator(char current) {
		return getOperator(current, 2) != nullOperator;
	}

	public static BiFunction<Integer, Integer, Integer> getOperation(char operator, int numOperands) {
		return getOperator(operator, numOperands).getOperation();
	}

	public static int getPrecedence(char current) {
		return getOperator(current, 2).getPrecedence();
	}

	private static Operator getOperator(char operator, int numOperands) {
		switch (operator) {
		case '+':
			return addition;
		case '-':
			if (numOperands == 1)
				return unaryMinus;
			return subtraction;
		case '*':
			return multiplication;
		case '/':
			return division;
		case '^':
			return exponent;
		default:
			return nullOperator;
		}
	}
}
