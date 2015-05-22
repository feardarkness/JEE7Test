package pruebaJEE7;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import javax.ws.rs.GET;
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
}
