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

import com.sun.istack.internal.logging.Logger;
import java.io.IOException;
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

    private static Logger log = Logger.getLogger(ServidorWebSocket.class);

    @OnOpen
    public void socketAbierto(Session sesion, EndpointConfig endPointConfig) {
        log.info("[ServidorWebSocket][SocketAbierto]Socket abierto" + sesion.getId() + ", " + sesion.getRequestURI());
    }

    @OnError
    public void socketConError(Session sesion, Throwable error) {
        log.severe("[ServidorWebSocket][SocketConError]Socket con error" + error.getStackTrace().toString());
    }

    @OnClose
    public void socketCerrado(Session sesion, CloseReason closeReason) {
        log.info("[ServidorWebSocket][SocketCerrado]Socket cerrado" + closeReason.getReasonPhrase());
    }

    @OnMessage
    public void mensajeRecibido(Session sesion, String mensaje) throws IOException {
        log.info("[ServidorWebSocket][mensajeRecibido]Se ha recibido un mensaje" + mensaje);
        for (Session s : sesion.getOpenSessions()) {
            if (s.isOpen() && sesion.getId() != s.getId()) {
                s.getBasicRemote().sendText(mensaje);
            }
        }
        
    }
}
