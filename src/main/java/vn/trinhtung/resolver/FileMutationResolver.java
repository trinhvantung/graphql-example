package vn.trinhtung.resolver;

import java.util.List;

import javax.servlet.http.Part;

import org.springframework.stereotype.Component;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;

@Component
public class FileMutationResolver implements GraphQLMutationResolver {
	public String uploadFile(List<Part> files) {
//		List<Part> parts = env.getArgument("files");

		System.out.println(files.size());
//		System.out.println(parts.size());
		
		
		for (Part part : files) {
			System.out.println(part.getSubmittedFileName());
		}
		return "OK";
	}
}
