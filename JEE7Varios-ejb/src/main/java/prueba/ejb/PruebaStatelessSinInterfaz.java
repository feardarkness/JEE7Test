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
package prueba.ejb;

import javax.ejb.Stateless;
import javax.interceptor.AroundConstruct;
import javax.interceptor.Interceptors;

// Ojo, en JEE 7 no necesitamos interfaz para ejb locales, solamente para remotos
@Stateless
public class PruebaStatelessSinInterfaz {

    // ojo un bean Stateless no debe declarar NUNCA una variable de instancia
    // no es necesario darle un valor, pero de todas maneras por motivo del ejemplo
    float numero = 0f;
    
    @Interceptors({AroundConstructInterceptor.class})
    public PruebaStatelessSinInterfaz() {
        System.out.println("Statelessssssssssssssssssssssssssssssssssss");
    }

    public float sumarDiez() {
        numero += 10;
        return numero;
    }

    public float sumarVeinte() {
        numero += 20;
        return numero;
    }
}
