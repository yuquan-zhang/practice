package pattern;

import java.util.Stack;

interface Pattern {
    String conversion(String exp);
}

class InfixToPostfixPattern implements Pattern {
    public String conversion(String exp) {
        String postfix = "";
        int priority = 0;
        Stack<Character> s1 = new Stack<>();
        for(int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);
            if (ch == '+' || ch == '-' || ch == '*' || ch == '/'||ch=='%'){
                if(s1.size() <= 0) s1.push(ch);
                else{
                    Character chTop = s1.peek();
                    if (chTop == '*' || chTop == '/')
                        priority = 1;
                    else
                        priority = 0;
                    if (priority == 1) {
                        if (ch == '*' || ch == '/'||ch=='%') {
                            postfix += s1.pop();
                            i--;
                        } else { // Same
                            postfix += s1.pop();
                            i--;
                        }
                    } else {
                        if (ch == '+' || ch == '-') {
                            postfix += s1.pop();
                            s1.push(ch);
                        } else s1.push(ch);
                    }
                }
            }else {
                postfix += ch;
            }
        }

        int len = s1.size();
        for (int j = 0; j < len; j++)
            postfix += s1.pop();

        return postfix;
    }
}

public class InterpreterPattern {
    public static void main(String[] args) {
        String infix = "a+b*c";

        InfixToPostfixPattern ip=new InfixToPostfixPattern();

        String postfix = ip.conversion(infix);
        System.out.println("Infix:   " + infix);
        System.out.println("Postfix: " + postfix);
    }
}
