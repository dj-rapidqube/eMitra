package finger.model;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

/**
 * Created by SW11 on 9/3/2015.
 */
@Root(name = "Pfa")
public class Pfa {

    public Pfa() {
    }

    @Attribute(name = "ms", required = false)
    public String ms;

    @Attribute(name = "mv", required = false)
    public String mv;

    @Attribute(name = "av", required = false)
    public String av;

    @Attribute(name = "lav", required = false)
    public String lav;

    @Attribute(name = "lmv", required = false)
    public String lmv;

}
