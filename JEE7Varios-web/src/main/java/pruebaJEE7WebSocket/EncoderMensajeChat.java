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

import java.util.logging.Logger;
import javax.json.Json;
import javax.json.JsonObject;
import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

public class EncoderMensajeChat implements Encoder.Text<MensajeChat> {

    private static Logger log = Logger.getLogger(EncoderMensajeChat.class.getName());

    @Override
    public String encode(MensajeChat mensajeChat) throws EncodeException {
        log.info("[EncoderMensajeChat][encode]Codificando...");
        JsonObject objetoJson = Json.createObjectBuilder()
                .add("mensaje", mensajeChat.getMensaje())
                .add("usuario", mensajeChat.getUsuario())
                .add("fechaRecepcion", mensajeChat.getFechaRecepcion())
                .add("sala", mensajeChat.getSala())
                .build();
        return objetoJson.toString();
    }

    @Override
    public void init(EndpointConfig config) {
        log.info("[EncoderMensajeChat][init]Funciona el init");
    }

    @Override
    public void destroy() {
        log.info("[EncoderMensajeChat][destroy]Funciona el destroy");
    }

}
