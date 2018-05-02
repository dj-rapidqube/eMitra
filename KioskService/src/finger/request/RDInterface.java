package finger.request;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

@Root(name = "Interface")
public class RDInterface {
	
	@Attribute(name = "id")
	public String id;

	@Attribute(name = "path")
	public String path;
}
