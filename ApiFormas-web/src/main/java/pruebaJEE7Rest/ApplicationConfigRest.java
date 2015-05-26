package pruebaJEE7Rest;

import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("jee")
public class ApplicationConfigRest extends Application {

    public ApplicationConfigRest() {
        System.out.println("Entra al constructor de configuracion[ApplicationConfigRest][Constructor]");
    }

    @Override
    public Set<Class<?>> getClasses() {
        System.out.println("Entra al getter de configuraciones de REST[ApplicationConfigRest][getClasses]");
        /*
         Set<Class<?>> clasesConfig = super.getClasses();
         clasesConfig.add(CustomizedRestException.class);
         return clasesConfig;
         */
        return super.getClasses();
    }

}
