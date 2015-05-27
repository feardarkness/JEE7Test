package pruebaJEE7Rest;

import java.io.IOException;
import java.util.logging.Logger;
import javax.annotation.Priority;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;
/*
 Cuando no tiene ninguna configuracion por defecto, entonces se realiza el binding global (a todos los request del REST)
 */

@ServerLogged       // se añade con la clase server logged para añadir la anotacion donde se quiere utilizar el filter
// para realizar el bind a metodos o clases específicas
@Provider
@Priority(500)      // Si tenemos varios filtros, entonces esto determina el orden en que seran ejecutados
public class LoggerRestFilter implements ContainerRequestFilter, ContainerResponseFilter {

    private Logger log = Logger.getLogger(LoggerRestFilter.class.getName());

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        log.severe("Cuidado Request");
        for (String key : requestContext.getHeaders().keySet()) {
            log.warning("Request -> " + key + " : " + requestContext.getHeaders().getFirst(key));
        }
    }

    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) throws IOException {
        log.severe("Cuidado Response");
        responseContext.getHeaders().add("EncabezadoPrueba", "arielPrueba");
        for (String key : responseContext.getHeaders().keySet()) {
            log.warning("Response -> " + key + " : " + responseContext.getHeaders().getFirst(key));
        }
    }

}
