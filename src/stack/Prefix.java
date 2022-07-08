package stack;

public class Prefix {
    public static void main(String[] args) {

        String exp = "+7*29";

        System.out.println(evaluatePrefix(exp));
    }

    private static double evaluatePrefix(String exp) {

        java.util.Stack<Double> stack = new java.util.Stack<>();

        for(int i=exp.length()-1;i>=0;i--){
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
