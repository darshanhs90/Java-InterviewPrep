package Codility;

import java.util.Stack;

/*
 * Author : Haridarshan H.S.
 * Link : https://codility.com/programmers/task/brackets
 */

public class _L0503StacksAndQueuesBrackets {
	public static void main(String[] args) {
		System.out.println(solution("{[()()]}"));
	}
	 public static int solution(String str) {
		 Stack<Character> charStack=new Stack<Character>();
			for (int i = 0; i < str.length(); i++) {
				char c=str.charAt(i);
				if(c=='(' || c=='{'|| c=='[')
				{
					charStack.push(c);
				}
				else if(c==')' || c=='}'|| c==']')
				{
					if(charStack.isEmpty())
						return 0;
					else
					{
						char poppedChar=charStack.pop();
						if(!((c==')' && poppedChar=='(')||(c==']' && poppedChar=='[')||(c=='}' && poppedChar=='{')))
							return 0;
					}
				}
			}
			return 1;
     }

}