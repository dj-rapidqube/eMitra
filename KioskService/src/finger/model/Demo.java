package finger.model;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by SW11 on 9/3/2015.
 */
@Root(name = "Demo")
public class Demo {

    public Demo() {
    }

    @Attribute(name = "lang", required = false)
    public String lang;

    @Element(name = "Pi", required = false)
    public Pi pi;

    @Element(name = "Pa", required = false)
    public Pa pa;

    @Element(name = "Pfa", required = false)
    public Pfa pfa;

}
