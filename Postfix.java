//Postfix.java
//cs 111 sample program using the collections interface
//stack facility to evaluate postfix expressions

//import java.util.Stack;
import java.io.IOException;
import java.util.Scanner;

public class Postfix
{
    public static void main(String [] args) throws StackEmptyException
    {
	StackDyn<Integer> postfix = new StackDyn<Integer>();
	char s;
	int right, left, result=0;
	Scanner sc = new Scanner (System.in);
	String ws;
	
	System.out.println("enter postfix expression");
	ws = sc.next();
	for (int i=0; i < ws.length();i++)
	    {s = ws.charAt(i);
	    if (s >= '0' && s <='9')
		postfix.push((int) (s) - 48);
	    else
		{right = postfix.pop();
		left = postfix.pop();
		switch (s)
		    {case '+':
			 result = left + right;
			 break;
		    case '-':
			result = left - right;
			break;
		    case '/':
			result = left /right;
			break;
		    case '*':
			result = left * right;
			break;
		    }

		postfix.push(result);
		}
	    }
	result = postfix.pop();
	System.out.println("the result of the expression is: " + result);
    }
}



