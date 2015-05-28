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
import java.io.StringReader;
import javax.json.Json;
import javax.json.JsonObject;
import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

public class DecoderMensajeChat implements Decoder.Text<MensajeChat> {

    private static Logger log = Logger.getLogger(DecoderMensajeChat.class);

    @Override
    public MensajeChat decode(String mensaje) throws DecodeException {
        log.info("[DecoderMensajeChat][decode]Decodificando...");
        JsonObject mensajeJson = Json.createReader(new StringReader(mensaje)).readObject();
        MensajeChat mensajeChat = new MensajeChat(mensajeJson.getString("mensaje"),
                mensajeJson.getString("usuario"),
                mensajeJson.getString("fechaRecepcion"),
                mensajeJson.getString("sala"));
        return mensajeChat;
    }

    @Override
    public boolean willDecode(String arg0) {
        log.info("[DecoderMensajeChat][init]Pregunta si se decodificará, quizas no siempre se decodifique");
        return true;        // si debe decodificar
    }

    @Override
    public void init(EndpointConfig config) {
        log.info("[DecoderMensajeChat][init]Funciona el init");
    }

    @Override
    public void destroy() {
        log.info("[DecoderMensajeChat][init]Funciona el destroy");
    }

}
