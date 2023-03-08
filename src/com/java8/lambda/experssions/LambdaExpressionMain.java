package com.java8.lambda.experssions;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

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
		
		Predicate<String> predicate = (String s)->{return s.length() == 3;};
		System.out.println("predicate: "+predicate.test("mam"));
		
		Product product = new Product();
		product.setPrice(100);
		List<Product> list = new ArrayList<>();
		list.add(product);
		int totalPrice = obj.calculateTotalPrice(list);
		System.out.println("Total Product Price: "+totalPrice);
		
		Random random = new Random(314L);
		Supplier<Integer> newRandom = () -> random.nextInt(10);

		for (int index = 0; index < 5; index++) {
		    System.out.println(newRandom.get() + " ");
		}
		
	}

	private int operate(int a, int b, MathOperation mathOperation) {
		return mathOperation.operation(a, b);
	}
	
	int calculateTotalPrice(List<Product> products) {
		int total =0;
		Consumer<Product> consumer = product-> product.getPrice();
		for(Product product:products) {
			consumer.accept(product);
		}
		return total;
	}
}
