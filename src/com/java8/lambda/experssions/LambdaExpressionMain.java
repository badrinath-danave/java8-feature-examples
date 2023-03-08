package com.java8.lambda.experssions;

public class LambdaExpressionMain{

	public static void main(String[] args) {
		LambdaExpressionMain obj = new LambdaExpressionMain();

		MathOperation addition = (int a, int b)->{return a+b;};

		MathOperation subtraction = (a, b)->{return a-b;};

		MathOperation multiply = (a, b)->a*b;

		MathOperation division = (a, b)->a/b;

		System.out.println("addition: "+obj.operate(10, 50, addition));

		System.out.println("addition   :  "+addition.operation(100, 10));
		System.out.println("subtraction: "+subtraction.operation(100, 10));
		System.out.println("multiply   : "+multiply.operation(100, 10));
		System.out.println("division   : "+division.operation(100, 10));
	}

	private int operate(int a, int b, MathOperation mathOperation) {
		return mathOperation.operation(a, b);
	}
}
