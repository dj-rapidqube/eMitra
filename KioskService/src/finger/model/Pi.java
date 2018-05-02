package finger.model;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

/**
 * Created by SW11 on 9/3/2015.
 */
@Root(name = "Pi")
public class Pi {

    public Pi() {
    }

    @Attribute(name = "ms", required = false)
    public String ms;

    @Attribute(name = "mv", required = false)
    public String mv;

    @Attribute(name = "name", required = false)
    public String name;

    @Attribute(name = "lname", required = false)
    public String lname;

    @Attribute(name = "lmv", required = false)
    public String lmv;

    @Attribute(name = "gender", required = false)
    public String gender;

    @Attribute(name = "dob", required = false)
    public String dob;

    @Attribute(name = "dobt", required = false)
    public String dobt;

    @Attribute(name = "age", required = false)
    public String age;

    @Attribute(name = "phone", required = false)
    public String phone;

    @Attribute(name = "email", required = false)
    public String email;

}
