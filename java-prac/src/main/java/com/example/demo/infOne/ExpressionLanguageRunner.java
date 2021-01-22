package com.example.demo.infOne;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.stereotype.Component;

/**
 * Created By Seungmin lee
 * User: dnx
 * Date: 2021-01-22
 * Description: Spring Expression Language
 * Spring 에서 맨날 사용하는 ${properties}, 타임리프에서 사용하는 #, $ 등등 모두 spring expression language 였다.
 */

@Component
public class ExpressionLanguageRunner implements ApplicationRunner {

    @Value("#{'hello' eq 'hello'}")
    boolean trueOrFalse;

    @Value("#{1+1}")
    int sum;

    @Value("${spring.expression.language}")
    String spEL;

    @Value("#{testFieldContainer.value}")
    int valueFromOtherBean;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("##################### ExpressionLanguageRunner #####################");
        System.out.println(spEL);
        System.out.println(trueOrFalse);
        System.out.println(sum);
        System.out.println(valueFromOtherBean);

        // how spring expression language works
        ExpressionParser parser = new SpelExpressionParser();
        Expression expression = parser.parseExpression("'this_is_spring_expression_language'");
        String value = expression.getValue(String.class);

        System.out.println(value);
    }
}
