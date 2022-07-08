package stack;

public class Postfix {
    public static void main(String[] args) {

        String exp = "815*+";

        System.out.println(evaluatePostfix(exp));
    }

    private static double evaluatePostfix(String exp) {

        java.util.Stack<Double> stack = new java.util.Stack<>();

        for(int i=0;i<exp.length()-1;i++){
            // for(int i=0;i<exp.length;i++)

            char c = exp.charAt(i);

            if(isOperand(c)){
                stack.push( (double)(c-48));
            }else{
                double  op1 = stack.pop();
                double op2 = stack.pop();

                switch(c){
                    case '+' :
                        stack.push(op1+op2);
                        break;
                    case '-' :
                        stack.push(op1-op2);
                        break;
                    case '*' :
                        stack.push(op1*op2);
                        break;
                    case '/' :
                        stack.push(op1/op2);
                        break;
                }
            }
        }
        return stack.peek();
    }

    private static boolean isOperand(char c) {

        return c>=48 && c <=57;
    }
}
