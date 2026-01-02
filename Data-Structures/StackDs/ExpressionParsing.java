package StackDs;

import java.util.Stack;

public class ExpressionParsing {
    public static int precedence(char opr){
        if(opr == '+' || opr == '-') return 1;
        else if(opr == '*' || opr == '/') return 2;
        else return 0;
    }
    public static int applyOpr(int a,int b, char opr){
        return switch (opr) {
            case '+' -> a + b;
            case '-' -> a - b;
            case '*' -> a * b;
            case '/' -> a / b;
            default -> -1;
        };
    }
    public static int evaluate(char[] expression){
        int n = expression.length;
        Stack<Integer> values = new Stack<>();
        Stack<Character> oprs = new Stack<>();
        for(int i = 0; i < n; i++){
            if(expression[i] == ' ')continue;
            else if(Character.isDigit(expression[i])){
                int val = 0;
                while (Character.isDigit(expression[i])){
                    val = val*10 + (expression[i]-'0');
                    i++;
                }
                values.push(val);
                i--;
            }
            else if(expression[i] == '(') oprs.push(expression[i]);
            else if(expression[i] == ')'){
                while (!oprs.isEmpty() && oprs.peek()!='('){
                    char opr = oprs.pop();
                    int b = values.pop();
                    int a = values.pop();
                    int val = applyOpr(a,b,opr);
                    values.push(val);
                }
                oprs.pop();
            }
            else if(expression[i] == '+' || expression[i] == '-' || expression[i] == '*' || expression[i]=='/'){
                while (!oprs.isEmpty() && precedence(oprs.peek()) >= precedence(expression[i])){
                    char opr = oprs.pop();
                    int b = values.pop();
                    int a = values.pop();
                    int val = applyOpr(a,b,opr);
                    values.push(val);
                }
                oprs.push(expression[i]);
            }
        }
        while (!oprs.isEmpty()){
            char opr = oprs.pop();
            int b = values.pop();
            int a = values.pop();
            int val = applyOpr(a,b,opr);
            values.push(val);
        }
        return values.peek();
    }
    public static void main(String[] args) {
        String expression =  "3 + 4 * 2 / (1 - 5)";
        System.out.println(expression);
        System.out.println(evaluate(expression.toCharArray()));
    }
}
