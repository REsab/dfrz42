package mssql.kza.test_properties;

public class J {
    public static void main(String[] a) {
        // as "absolute"

        // ok
        System.err.println(J.class.getResourceAsStream("/app.properties") != null);

        // pop            
        System.err.println(J.class.getClassLoader().getResourceAsStream("/app.properties") != null);

        // as relative

        // ok
        System.err.println(J.class.getResourceAsStream("./app.properties") != null);

        // ok
        System.err.println(J.class.getClassLoader().getResourceAsStream("./app.properties") != null);

        // no path

        // ok
        System.err.println(J.class.getResourceAsStream("app.properties") != null);

        // ok
        System.err.println(J.class.getClassLoader().getResourceAsStream("app.properties") != null);
    }
}
