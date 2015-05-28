/*
 * Copyright (C) 2015 FearDarkness
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or    implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package pruebaJEE7WebSocket;

public class MensajeChat {

    private String mensaje;
    private String usuario;
    private String fechaRecepcion;
    private String sala;

    public MensajeChat(String mensaje, String usuario, String fechaRecepcion, String sala) {
        this.mensaje = mensaje;
        this.usuario = usuario;
        this.fechaRecepcion = fechaRecepcion;
        this.sala = sala;
    }

    /**
     * @return the mensaje
     */
    public String getMensaje() {
        return mensaje;
    }

    /**
     * @param mensaje the mensaje to set
     */
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the fechaRecepcion
     */
    public String getFechaRecepcion() {
        return fechaRecepcion;
    }

    /**
     * @param fechaRecepcion the fechaRecepcion to set
     */
    public void setFechaRecepcion(String fechaRecepcion) {
        this.fechaRecepcion = fechaRecepcion;
    }

    /**
     * @return the sala
     */
    public String getSala() {
        return sala;
    }

    /**
     * @param sala the sala to set
     */
    public void setSala(String sala) {
        this.sala = sala;
    }

    @Override
    public String toString() {
        return "MensajeChat{" + "mensaje=" + mensaje + ", usuario=" + usuario + ", fechaRecepcion=" + fechaRecepcion + ", sala=" + sala + '}';
    }

}
