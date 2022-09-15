# ExpressionEvaluator-InfixToPostfix
This a Java program that takes a symbolic infix expression as input and converts it to postfix notation, takes the values of each symbol, evaluates the postfix expression and outputs the resulting expression and its value.  
The program support the operators '+', '-', '*', '/' and '^'.  
Expressions can contain parentheses '(' and ')'.  
All operands are integer values.

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
