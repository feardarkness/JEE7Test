package pruebaJEE7Rest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("resturl")
public class PruebaRestJEE7 {

    @GET
    @Path("saludo")
    public String saluda2() {
        return "Holas, saludo desde REST!!!";
    }

    @GET
    @Path("saludo2")
    public String saludaParametrizado(@QueryParam("nombre") String nombre) {
        return "Holas, saludo desde REST, estimado(a) " + nombre + "!!!";
    }

    @GET
    @Path("saludo3")
    @ServerLogged
    public NombreCompleto saludaNombre() {
        NombreCompleto nc = new NombreCompleto("Ariel", "Alvarado");
        return nc;
    }

    @GET
    @Path("saludo4")    
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @ServerLogged
    public ArrayList<NombreCompleto> saludaLista() {
        ArrayList<NombreCompleto> lista = new ArrayList<NombreCompleto>();
        lista.add(new NombreCompleto("Ariél", "Alvarado"));
        lista.add(new NombreCompleto("Nombre", "ApellidóÁ"));
        return lista;
    }

    @POST
    @Path("saluda5")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @ServerLogged
    public String saluda5(@FormParam("nombrepar") String nombre, @FormParam("apellidopar") String apellido) {
        return "Hola " + nombre + " " + apellido;
    }

    @POST
    @Path("saluda6")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @ServerLogged
    public String saluda6(NombreCompleto fullName) throws CustomizedRestException {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<NombreCompleto>> errores = validator.validate(fullName);        
        if (!errores.isEmpty()){
            Iterator<ConstraintViolation<NombreCompleto>> iterador = errores.iterator();
            StringBuilder mensajeError = new StringBuilder();
            while(iterador.hasNext()){
                mensajeError.append(iterador.next().getMessage());
            }
            throw new CustomizedRestException(mensajeError.toString());
        }
        return "Hola " + fullName.nombre + " " + fullName.apellido;
    }
    
}
