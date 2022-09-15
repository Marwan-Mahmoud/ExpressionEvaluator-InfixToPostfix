import java.util.Scanner;

public class ExpressionEvaluatorDemo {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String infix = scanner.nextLine();
		InfixToPostfix converter = new InfixToPostfix();
		String postfix = converter.convert(infix);

		ExpressionEvaluator evaluator = new ExpressionEvaluator();
		int numVariables = 3;
		for (int i = 0; i < numVariables; i++) {
			String input = scanner.next();
			evaluator.setVariable(input.charAt(0), Integer.parseInt(input.substring(2)));
		}
		scanner.close();
		int result = evaluator.evaluate(postfix);
		System.out.println(postfix);
		System.out.println(result);
	}
}
