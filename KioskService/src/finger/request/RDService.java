package finger.request;

import java.util.List;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root(name = "RDService")
public class RDService {
	
	@Attribute(name = "status")
	public String status;
	
	@Attribute(name = "info")
	public String info;
	
	@ElementList(name = "Interface", inline = true)
	public List<RDInterface> rdInterface;
	
	public int port;

}
