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
import javax.websocket.CloseReason;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/webSocketChat")
public class ServidorWebSocket {

    @OnOpen
    public void socketAbierto(Session sesion, EndpointConfig endPointConfig) {
        System.out.println("+++++++++++++++++++++++ Socket Abierto ++++++++++++++++++");
        System.out.println(sesion.getRequestURI());
        System.out.println("---------------------------------------------------------");
    }
    
    @OnError
    public void socketConError(Session sesion, Throwable error) {
        System.out.println("+++++++++++++++++++++++ Socket con error ++++++++++++++++++");
        System.out.println(sesion.getRequestURI());
        System.out.println("---------------------------------------------------------");
    }
    
    @OnClose
    public void socketCerrado(Session sesion, CloseReason closeReason) {
        System.out.println("+++++++++++++++++++++++ Socket Cerrado ++++++++++++++++++");
        System.out.println(sesion.getRequestURI());
        System.out.println("---------------------------------------------------------");
    }

    @OnMessage
    public void mensajeRecibido(Session sesion, String mensaje) throws IOException {
        System.out.println("+++++++++++++++++++++++ Mensaje recibido en Socket ++++++++++++++++++");
        for (Session s : sesion.getOpenSessions()) {
            if (s.isOpen() && sesion.getId() != s.getId()) {
                s.getBasicRemote().sendText(mensaje);
            }
        }
        System.out.println("---------------------------------------------------------");
    }
}
