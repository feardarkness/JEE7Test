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
package pruebaJEE7Rest;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class CustomizedExceptionHandler implements ExceptionMapper<CustomizedRestException> {

    @Override
    public Response toResponse(CustomizedRestException exception) {
        return Response.status(Status.BAD_REQUEST).entity(new ErrorMessage(exception.getMessage())).type(MediaType.APPLICATION_JSON).build();
    }

}
