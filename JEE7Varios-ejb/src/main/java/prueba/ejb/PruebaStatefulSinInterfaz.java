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

import javax.ejb.Stateful;
import javax.interceptor.AroundConstruct;
import javax.interceptor.Interceptors;

@Stateful
public class PruebaStatefulSinInterfaz {

    private float numero = 0;
    
    @Interceptors({AroundConstructInterceptor.class})
    public PruebaStatefulSinInterfaz() {
        System.out.println("[PruebaStatefulSinInterfaz][PruebaStatefulSinInterfaz]Entra al constructor");
    }

    public float sumarTreinta() {
        numero += 30;
        return numero;
    }

    public float sumarCuarenta() {
        numero += 40;
        return numero;
    }
}