package com.sambaash.platform.pe.course.enroll;
import java.math.BigDecimal;
import java.util.EmptyStackException;
import java.util.Stack;

import com.liferay.portal.kernel.util.Validator;

/**
 *  BigDecimal - Always construct from String instead of double. because representing the decimal in double is not accurate.
 * 
 * @author nareshchebolu
 *
 */

public class InFixExpressionEvaluator {
	
	private static int ROUNDING_METHOD = BigDecimal.ROUND_HALF_DOWN;
	private static int SCALE_TEMP = 2;
	
	private static String [] operatorsArray = {"(",")","+","-","%","*","/"};
	private String expr;
	
	public InFixExpressionEvaluator(String expr){
		this.expr = expr;
	}
	
	public static BigDecimal getBigDecimal(String str){
		if(Validator.isNull(str)){
			str = String.valueOf(0);
		}
		BigDecimal d = new BigDecimal(str);
		return d;
	}
	
	public static BigDecimal getBigDecimalWithRounding(String str){
		if(Validator.isNull(str)){
			str = String.valueOf(0);
		}
		BigDecimal d = new BigDecimal(str);
		return d.setScale(SCALE_TEMP,ROUNDING_METHOD);
	}
	
	public BigDecimal evaluate() throws Exception{
		expr = expr.replaceAll("\\t|\\s","");
		Stack<BigDecimal> operands = new Stack<BigDecimal>();
		Stack<String> operators = new Stack<String>();
		
		char c;
		StringBuilder buffer = new StringBuilder();
		int length = expr.length();
		BigDecimal temp;
		for( int i = 0; i < length ; i++){
			c = expr.charAt(i);
			
			if(isOperator(String.valueOf(c))){
				
				if(buffer.length() > 0){
					temp = getBigDecimal(buffer.toString());
					operands.push(temp);
					buffer.setLength(0);
				}
				operatorDetected(String.valueOf(c), operands, operators);
			}else if(Character.isDigit(c)){
				buffer.append(c);
			}else if(c == '.'){
				buffer.append(c);
			}else{
				throw new Exception("20");
			}
		}
		// possible in casese like 1+90,
		if(buffer.length() > 0){
			temp = getBigDecimal(buffer.toString());
			operands.push(temp);
			buffer.setLength(0);
		}
		while(!operators.isEmpty()){
			String operator = operators.pop();
			processOperator(operands, operator);
		}
		return operands.pop().setScale(2, ROUNDING_METHOD);
	}

	private void operatorDetected(String operator1,Stack<BigDecimal>operands, Stack<String>operators) throws Exception{
		
		if(operator1.equals("(")){
			operators.push(operator1);
		}else if(operator1.equals(")")){
			try{
				String operator = operators.pop();
				
				while(!operator.equals("(")){
					processOperator(operands, operator);
					operator = operators.pop();
				}
			}catch(EmptyStackException ex){
				throw new Exception("Invalid expression.");
			}
		}else{
			if(operators.isEmpty()){
				//nothing.. just push operator..
			}else{
				String operator2 = operators.peek();
				while( getPrecedence(operator2) >= getPrecedence(operator1) && !operator2.equals("(")){
					operator2 = operators.pop();
					processOperator(operands, operator2);
					
					if(operators.isEmpty()){
						break;
					}
					operator2 = operators.peek();
				}
			}
			operators.push(operator1);
		}
	}

	private BigDecimal processOperator(Stack<BigDecimal> operands,
			String operator) throws Exception {
		BigDecimal result;
		BigDecimal right ;
		BigDecimal left ;
		try {
			 right = operands.pop();
			 left = operands.pop();
			
		} catch (EmptyStackException e) {
			// TODO: handle exception
			throw new Exception("Invalid expression");
		}
		if("+".equals(operator)){
			result = left.add(right);
		}else if("-".equals(operator)){
			result = left.subtract(right);
		}else if("*".equals(operator)){
			//MathContext context = new MathContext(SCALE, RoundingMode.CEILING);
			result = left.multiply(right);
		}else if("/".equals(operator)){
			result = left.divide(right,SCALE_TEMP,ROUNDING_METHOD);
		}else{
			throw new Exception("10-Operator can not be identified");
		}
		operands.push(result);
		return result;
	}
	
	private static boolean isOperator(String c){
		boolean operator = false;
		
		for (String d : operatorsArray) {
			if(c.equals(d)){
				operator = true;
				break;
			}
		}
		return operator;
	}
	
	private int getPrecedence(String operator){
		if(operator.equals("+") || operator.equals("-")){ 
			return 10;
		}
		if(operator.equals("*") || operator.equals("/")){
			return 20;
		}
		if(operator.equals("(") || operator.equals(")")){
			return 30;
		}
		
		return 0;
	}
	
	public static void main(String[] args) throws Exception {
		InFixExpressionEvaluator infix = new InFixExpressionEvaluator("(.1111*3)");
	}
}
