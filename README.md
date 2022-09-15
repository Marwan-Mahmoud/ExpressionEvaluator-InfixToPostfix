# ExpressionEvaluator-InfixToPostfix
This a Java program that takes a symbolic infix expression as input and converts it to postfix notation, takes the values of each symbol, evaluates the postfix expression and outputs the resulting expression and its value.  
The program support the operators '+', '-', '*', '/' and '^'.  
Expressions can contain parentheses '(' and ')'.  
All operands are integer values.

### Infix to Postfix conversion
All variables, constants or numerals are added to the output expression.  
Left parentheses are always pushed onto the stack. When a right parenthesis is encountered, symbols on top of the stack are popped and copied to the resulting expression until the symbol at the top of the stack is a left parenthesis. At that time, parentheses are discarded.  
If the symbol being scanned has a higher precedence than the symbol at the top of the stack, the symbol being scanned is pushed onto the stack and the scan pointer is advanced.  
If the precedence of the symbol being scanned is lower than or equal to the precedence of the symbol at the top of the stack, one element of the stack is popped to the output and the scan pointer is not advanced. So, the symbol being scanned will be compared with the new top element on the stack.  
When the end of the expression is encountered, the stack is popped to the output.  
If the top of the stack is a left parenthesis and the end of the expression is encountered, or a right parenthesis is scanned when there is no left one in the stack, the parentheses of the original expressions were unbalanced and an unrecoverable error has occurred.

### Evaluating Postfix Expressions
The postfix expression is scanned left-to-right.  
Operands are placed on a stack until an operator is found. Operands are then removed from the stack, the operation is performed on the operands and the result is pushed on to the stack.  
The process continues until the end of expression is reached. 

### Input Format
First line has Infix expression.  
The next 3 lines have the values for 'a', 'b', and 'c', even if not all of them exist in the expression.

#### Sample Input 1
-(a+b)  
a=8  
b=-2  
c=9  

#### Sample Output 1
ab+-  
-6  

#### Sample Input 2
a\*b\*c  
a=-2  
b=8  
c=-3  

#### Sample Output 2
ab\*c\*  
48  
