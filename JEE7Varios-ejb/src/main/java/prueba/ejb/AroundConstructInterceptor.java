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

import javax.interceptor.AroundConstruct;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@PruebaAroundConstruct
@Interceptor
public class AroundConstructInterceptor {

    /*
     @AroundConstruct methods are interposed on the invocation of the target class's constructor. 
     Methods decorated with @AroundConstruct may only be defined within interceptor classes or 
     superclasses of interceptor classes. You may not use @AroundConstruct methods within the target class.

     The @AroundConstruct method is called after dependency injection has been completed for 
     all interceptors associated with the target class. The target class is created and the 
     target class's constructor injection is performed after all associated @AroundConstruct 
     methods have called the Invocation.proceed method. At that point, dependency injection 
     for the target class is completed, and then any @PostConstruct callback methods are invoked.

     @AroundConstruct methods can access the constructed target instance after calling Invocation.proceed 
     by calling the InvocationContext.getTarget method.

     Caution:
     Calling methods on the target instance from an @AroundConstruct method is dangerous because dependency 
     injection may not have completed on the target instance.
     
     @AroundConstruct methods must call Invocation.proceed in order to create the target instance. 
     If an @AroundConstruct method does not call Invocation.proceed, the target instance will not be created.
     */
    @AroundConstruct
    public Object validateConstructor(InvocationContext context) throws Exception {
        System.out.println("[AroundConstructInterceptor][validateConstructor]Interceptor deberia entrar acá");
        return context.proceed();
    }
}
