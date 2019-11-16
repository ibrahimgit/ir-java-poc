package com.ir.learning.poc;

import java.util.HashMap;
import java.util.Map;

import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import com.ir.learning.poc.domainmodel.Applicant;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LearnSpEL {
	
	private static final ExpressionParser parse = new SpelExpressionParser();
	
	public static void main(String[] args) {
		
//		String expression = "'Ibrahim Rashid'.length() != 0"
		String expression = "1 == 1";
		Boolean result = evaluateSimpleExpression(expression);
		log.debug("The result is {}", result);
		
		Applicant appl = new Applicant("Ibrahim", "M", "Kolkara", "Married");
		
		StandardEvaluationContext context = new StandardEvaluationContext(appl);
//		String expression1 = "sex != 'M'"
		String expression1 = "fullName.length() == 7";
		result = evaluate(expression1, context);
		log.debug("The result is {}", result);
		
		Map<String, Object> model = new HashMap<>();
		model.put("appl", appl);
		model.put("booleanValue", true);
		model.put("key", "key");
		
		context = new StandardEvaluationContext();
		// in case of map, use the setVariables to set the context
		// and then use # to access the map because variable is accessed through #
		context.setVariables(model);
		//String expression2 = "#appl.fullName.length() == 7"
		String expression2 = "#booleanValue != false";
		result = evaluate(expression2, context);
		log.debug("The result:: {}", result);
		
		
	}
	
	private static boolean evaluateSimpleExpression(String expressionStr) {
		Expression expression = parse.parseExpression(expressionStr);
		return expression.getValue(Boolean.class);
	}
	
	private static boolean evaluate(String expressionStr, EvaluationContext context) {
		Expression expression = parse.parseExpression(expressionStr);
		return expression.getValue(context, Boolean.class);
	}

}
