package pruebaJEE7;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "nombres")
public class NombreCompleto {

    public String nombre;
    public String apellido;

    public NombreCompleto() {
    }

    public NombreCompleto(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }
}
