package configuration;

import java.util.List;
import java.util.ArrayList;
import javax.servlet.ServletContext;

public class ContainerServletMappingsExtractor {
	
	public static List<String> getMappingsFromContext(ServletContext context ) {
		ArrayList<String> result = new ArrayList<>();
		for (String a : context.getServletRegistrations().keySet()) {
				//w.println("Mappings for key " + a);
				for (String mapping: context.getServletRegistrations().get(a).getMappings()) {
					//w.println("Mappings: for registration " + mapping.getClass());
					//w.println("Mapping " + mapping);
					result.add(mapping);
				}
			}
		return result;
	}
}
