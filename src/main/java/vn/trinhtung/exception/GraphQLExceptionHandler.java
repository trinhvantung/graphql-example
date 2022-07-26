package vn.trinhtung.exception;


import org.hibernate.exception.ConstraintViolationException;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;

import graphql.kickstart.spring.error.ThrowableGraphQLError;

@Component
public class GraphQLExceptionHandler {
	@ExceptionHandler(ConstraintViolationException.class)
	public ThrowableGraphQLError handler(Exception e) {
		return new ThrowableGraphQLError(e);
	}
}
