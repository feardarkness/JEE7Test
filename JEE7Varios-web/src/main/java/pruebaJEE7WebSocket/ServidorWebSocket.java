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

import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.websocket.CloseReason;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint(value = "/webSocketChat", decoders = DecoderMensajeChat.class, encoders = EncoderMensajeChat.class)
public class ServidorWebSocket {
    
    // catalogo de proyectos
    
    private static final Logger log = Logger.getLogger(ServidorWebSocket.class.getName());

    @OnOpen
    public void socketAbierto(Session sesion, EndpointConfig endPointConfig) {
        log.log(Level.INFO, "[ServidorWebSocket][SocketAbierto]Socket abierto: {0}, {1}", new Object[]{sesion.getId(), sesion.getRequestURI()});
    }

    @OnError
    public void socketConError(Session sesion, Throwable error) {
        log.log(Level.SEVERE, "[ServidorWebSocket][SocketConError]Socket con error: {0}", Arrays.toString(error.getStackTrace()));
    }

    @OnClose
    public void socketCerrado(Session sesion, CloseReason closeReason) {
        log.log(Level.INFO, "[ServidorWebSocket][SocketCerrado]Socket cerrado: {0}", closeReason.getReasonPhrase());
    }

    @OnMessage
    public void mensajeRecibido(Session sesionActual, String mensaje) throws IOException {
        log.log(Level.INFO, "[ServidorWebSocket][mensajeRecibido]Se ha recibido un mensaje: {0}", mensaje);
        for (Session sesion : sesionActual.getOpenSessions()) {
            if (sesion.isOpen() && sesionActual.getId() != sesion.getId()) {
                sesion.getBasicRemote().sendText(mensaje);
            }
        }

    }
}