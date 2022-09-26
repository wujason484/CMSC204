/*
 * Class: CMSC204
 * Intsructor:Dr.Monshi
 * Description: Convert infix notation to postfix or postfix notation to infix, also evaluates postfix expressions
 * Due: 10/6/22
 * Platform/compiler:
 * I pledge that I have completed the programming assignment independently.
 * I have not copied the code from a student or any source.
 * I have not given my code to any student.
 * Print your Name here: Jason Wu
 */
public class Notation {
	
	/**
	 * Evaluates a postfix expression
	 * @param postfixExpr
	 * @return Evaluation of expression as a double
	 * @throws InvalidNotationFormatException
	 */
	public static double evaluatePostfixExpression(String postfixExpr) throws InvalidNotationFormatException, StackOverflowException, StackUnderflowException{
		MyStack<Double> postStack=new MyStack<>(50);
		double num1=0.0, num2=0.0;
		
		for( int i=0; i < postfixExpr.length(); i++) {

			char nextChar = postfixExpr.charAt(i);

			if(nextChar==' ') {
				throw new InvalidNotationFormatException();
			}
			else if(nextChar=='0'||nextChar=='1'||nextChar=='2'||nextChar=='3'||nextChar=='4'||nextChar=='5'||
					nextChar=='6'||nextChar=='7'||nextChar=='8'||nextChar=='9') {
				postStack.push(Double.parseDouble(Character.toString(nextChar)));
			}
			else if(nextChar=='+') {
				if (postStack.size() < 2)
					throw new InvalidNotationFormatException();
				else {
				num2 = postStack.pop();
				num1 = postStack.pop();
				postStack.push(num1 + num2);
				}
			}
			else if(nextChar=='-') {
				if (postStack.size() < 2)
					throw new InvalidNotationFormatException();
				else {
				num2 = postStack.pop();
				num1 = postStack.pop();
				postStack.push(num1 - num2);
				}
			}
			else if(nextChar=='*') {
				if (postStack.size() < 2)
					throw new InvalidNotationFormatException();
				else {
				num2 = postStack.pop();
				num1 = postStack.pop();
				postStack.push(num1 * num2);
				}
			}
			else if(nextChar=='/') {
				if (postStack.size() < 2)
					throw new InvalidNotationFormatException();
				else {
				num2 = postStack.pop();
				num1 = postStack.pop();
				postStack.push(num1 / num2);
				}
			}
			
		}
		
		if ( postStack.size() > 1)
			throw new InvalidNotationFormatException();
		
		return postStack.pop();
		}
	
	/**
	 * Converts a postfix expression to infix notation
	 * @param postfix
	 * @return infix expression
	 * @throws InvalidNotationFormatException
	 */
	public static String convertPostfixToInfix(String postfix) throws InvalidNotationFormatException, StackOverflowException, StackUnderflowException{
		MyStack<String> stack=new MyStack<>(50);
		
		for( int i=0; i < postfix.length(); i++) {

			char nextChar = postfix.charAt(i);

			if(nextChar==' ') {
				throw new InvalidNotationFormatException();
			}
			else if(nextChar=='0'||nextChar=='1'||nextChar=='2'||nextChar=='3'||nextChar=='4'||nextChar=='5'||
					nextChar=='6'||nextChar=='7'||nextChar=='8'||nextChar=='9') {
				stack.push(Character.toString(nextChar));
			}
			else if(nextChar=='+') {
				if (stack.size() < 2)
					throw new InvalidNotationFormatException();
				else {
					String num2 = stack.top();
					stack.pop();
					String num1 = stack.top();
					stack.pop();

					String expr = "(" + num1 + "+" + num2 + ")";
					
					stack.push(expr);
				}
			}
			else if(nextChar=='-') {
				if (stack.size() < 2)
					throw new InvalidNotationFormatException();
				else {
					String num2 = stack.top();
					stack.pop();
					String num1 = stack.top();
					stack.pop();

					String expr = "(" + num1 + "-" + num2 + ")";
					
					stack.push(expr);
				}
			}
			else if(nextChar=='*') {
				if (stack.size() < 2)
					throw new InvalidNotationFormatException();
				else {
					String num2 = stack.top();
					stack.pop();
					String num1 = stack.top();
					stack.pop();

					String expr = "(" + num1 + "*" + num2 + ")";
					
					stack.push(expr);
				}
			}
			else if(nextChar=='/') {
				if (stack.size() < 2)
					throw new InvalidNotationFormatException();
				else {
					String num2 = stack.top();
					stack.pop();
					String num1 = stack.top();
					stack.pop();

					String expr = "(" + num1 + "/" + num2 + ")";
					
					stack.push(expr);
				}
			}
			
		}
		
		if (stack.size() > 1)
			throw new InvalidNotationFormatException();
		
		return stack.top();
	}
	
	/**
	 * Converts an infix expression to postfix notation
	 * @param infix
	 * @return postfix expression
	 * @throws InvalidNotationFormatException
	 * @throws StackOverflowException
	 * @throws StackUnderflowException
	 */
	public static String convertInfixToPostfix(String infix) throws InvalidNotationFormatException, StackOverflowException, StackUnderflowException, QueueOverflowException{
		MyStack<Character> stack = new MyStack<Character>(50);
		MyQueue<Character> postQueue = new MyQueue<Character>(50);

		int rightParen = 0;
		int leftParen = 0;
		
		for( int i=0; i < infix.length(); i++) {

			char nextChar = infix.charAt(i);

			if(nextChar==' ') {
				throw new InvalidNotationFormatException();
			}
			else if(nextChar=='0'||nextChar=='1'||nextChar=='2'||nextChar=='3'||nextChar=='4'||nextChar=='5'||
					nextChar=='6'||nextChar=='7'||nextChar=='8'||nextChar=='9') {
				postQueue.enqueue(nextChar);
			}
			else if(nextChar=='(') {
				leftParen ++;
				stack.push(nextChar);
			}
			else if(nextChar=='+') {
				if (stack.size() < 2)
					throw new InvalidNotationFormatException();
				else {
					while (!stack.isEmpty()) 
					{
						postQueue.enqueue('+');
					}
					stack.push(nextChar);
				}
			}
			else if(nextChar=='-') {
				if (stack.size() < 2)
					throw new InvalidNotationFormatException();
				else {
					while (!stack.isEmpty()) 
					{
						postQueue.enqueue('-');
					}
					stack.push(nextChar);
				}
			}
			else if(nextChar=='*') {
				if (stack.size() < 2)
					throw new InvalidNotationFormatException();
				else {
					while (!stack.isEmpty()) 
					{
						postQueue.enqueue('*');
					}
					stack.push(nextChar);
				}
			}
			else if(nextChar=='/') {
				if (stack.size() < 2)
					throw new InvalidNotationFormatException();
				else {
					while (!stack.isEmpty()) 
					{
						postQueue.enqueue('/');
					}
					stack.push(nextChar);
				}
			}
			else if(nextChar==')') {
				rightParen++;
				while(!stack.isEmpty() && stack.top()!='(') 
				{
					char topOperator = stack.pop();
					postQueue.enqueue(topOperator);

				}

				if (stack.size()>1 && stack.top()=='(' )
					stack.pop();
			}
			
		}

		if ( leftParen != rightParen)
			throw new InvalidNotationFormatException();
		
		while(!stack.isEmpty()) 
		{

			if (stack.top() == '(')
				stack.pop();
			else {
				char top_Operator = stack.pop();
				postQueue.enqueue( top_Operator);
			}
		}

		return postQueue.toString();
	}

}
