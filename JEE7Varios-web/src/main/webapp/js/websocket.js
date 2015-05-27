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

$(document).ready(function () {
    console.log(window.location.href);
    var usuario = "Ariel";
    var webSocketChat = new WebSocket("ws://"+window.location.host+"/JEE7Varios-web/webSocketChat");
    // cuando ha ocurrido un error
    webSocketChat.addEventListener("error", function (event) {
        alert("ups, un error terrible" + event);
        console.log(event);
    });
    // cuando el websocket ya esta abierto
    webSocketChat.addEventListener("open", function (event) {
        console.log("WebSocket abierto...");
        console.log(event);
    });
    // cuando el websocket se cierra
    webSocketChat.addEventListener("close", function (event) {
        alert("Se ha cerrado el WebSocket" + event);
        console.log(event);
    });
    // cuando se recibe datos del servidor
    webSocketChat.addEventListener("message", function (event) {
        alert("Se ha recibido un mensaje del Servidor" + event);
        console.log(event);
    });
    
    $("#enviar").on("click", function (e) {
        e.preventDefault();
        var mensaje = $("#mensaje").val();
        webSocketChat.send(mensaje);
        var $divChatContenedor = $("#chat").parent();
        var $divChat = $("#chat").detach();
        var contenidoChat = $divChat.html();
        contenidoChat += "<br>" + usuario + ": " + mensaje;
        $divChat.html(contenidoChat);
        $divChat.appendTo($divChatContenedor);
    });
});








