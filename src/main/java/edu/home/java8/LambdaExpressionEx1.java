package edu.home.java8;

public class LambdaExpressionEx1 {
    public static void main(final String args[]) {
        final LambdaExpressionEx1 tester = new LambdaExpressionEx1();
        
        // Using anonymous inner classes
        /*
         * MathOperation addition = new MathOperation(){
         * 
         * @Override
         * public int operation(int a, int b){
         * return a + b;
         * }
         * };
         * 
         * MathOperation subtraction = new MathOperation(){
         * 
         * @Override
         * public int operation(int a, int b){
         * return a - b;
         * }
         * };
         * 
         * MathOperation multiplication = new MathOperation(){
         * 
         * @Override
         * public int operation(int a, int b){
         * return a * b;
         * }
         * };
         * 
         * MathOperation division = new MathOperation(){
         * 
         * @Override
         * public int operation(int a, int b){
         * return a / b;
         * }
         * };
         */
        
        // Using Lambda expressions
        // with type declaration
        final MathOperation addition = (final int a, final int b) -> a + b;
        
        // with out type declaration
        final MathOperation subtraction = (a, b) -> a - b;
        
        // with return statement along with curly braces
        final MathOperation multiplication = (final int a, final int b) -> {
            return a * b;
        };
        
        // without return statement and without curly braces
        final MathOperation division = (final int a, final int b) -> a / b;
        
        System.out.println("10 + 5 = " + tester.operate(10, 5, addition));
        System.out.println("10 - 5 = " + tester.operate(10, 5, subtraction));
        System.out.println("10 x 5 = " + tester.operate(10, 5, multiplication));
        System.out.println("10 / 5 = " + tester.operate(10, 5, division));
        
        // with parenthesis
        final GreetingService greetService1 = (message) -> System.out.println("Hello " + message);
        
        // without parenthesis
        final GreetingService greetService2 = message -> System.out.println("Hello " + message);
        
        greetService1.sayMessage("Ramesh");
        greetService2.sayMessage("Suresh");
    }
    
    interface MathOperation {
        
        int operation(int a, int b);
    }
    
    interface GreetingService {
        
        void sayMessage(String message);
    }
    
    private int operate(final int a, final int b, final MathOperation mathOperation) {
        return mathOperation.operation(a, b);
    }
}
