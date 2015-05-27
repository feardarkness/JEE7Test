package pruebaJEE7Rest;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class NombreCompleto {
    @NotNull
    @Size(min=5, message="El nombre debe tener al menos 5 carácteres")
    public String nombre;
    @Size(min=5, message="El apellido debe tener al menos 5 carácteres")
    public String apellido;

    public NombreCompleto() {
    }

    public NombreCompleto(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }
}
