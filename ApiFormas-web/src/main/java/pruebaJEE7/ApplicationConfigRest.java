package pruebaJEE7;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("jee")
public class ApplicationConfigRest extends Application {

    public ApplicationConfigRest() {
        System.out.println("Entra al constructor de configuracion");
    }
}
