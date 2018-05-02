package finger.model;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

/**
 * Created by SW11 on 9/3/2015.
 */
@Root(name = "Pa")
public class Pa {

    public Pa() {
    }

    @Attribute(name = "ms", required = false)
    public String ms;

    @Attribute(name = "co", required = false)
    public String co;

    @Attribute(name = "house", required = false)
    public String house;

    @Attribute(name = "street", required = false)
    public String street;

    @Attribute(name = "lm", required = false)
    public String lm;

    @Attribute(name = "loc", required = false)
    public String loc;

    @Attribute(name = "vtc", required = false)
    public String vtc;

    @Attribute(name = "subdist", required = false)
    public String subdist;

    @Attribute(name = "dist", required = false)
    public String dist;

    @Attribute(name = "state", required = false)
    public String state;

    @Attribute(name = "country", required = false)
    public String country;

    @Attribute(name = "pc", required = false)
    public String pc;

    @Attribute(name = "po", required = false)
    public String po;

}
