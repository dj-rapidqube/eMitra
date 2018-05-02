package finger.model;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "PidOptions", strict = false)
public class PidOptions {

    @Root(name = "PidOptions", strict = false)
    public PidOptions() {
    }

    @Attribute(name = "ver", required = false)
    public String ver;

    @Element(name = "Opts", required = false)
    public Opts Opts;

    @Element(name = "Demo", required = false)
    public Demo demo;

//    @Element(name = "Demo", required = false)
//    public String demo;

    @Element(name = "CustOpts", required = false)
    public CustOpts CustOpts;

}
