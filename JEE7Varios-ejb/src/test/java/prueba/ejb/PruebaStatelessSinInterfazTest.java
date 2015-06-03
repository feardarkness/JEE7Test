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

import java.util.HashMap;
import java.util.Map;
import javax.ejb.embeddable.EJBContainer;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author aalvarado
 */
public class PruebaStatelessSinInterfazTest {

    private static EJBContainer container = null;

    public PruebaStatelessSinInterfazTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        /*
        Map<String, Object> p = new HashMap<String, Object>();
        p.put(EJBContainer.APP_NAME, "foo");
        container = EJBContainer.createEJBContainer(p);
        */
    }

    @AfterClass
    public static void tearDownClass() {
        /*
        container.close();
        */
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of sumarDiez method, of class PruebaStatelessSinInterfaz.
     */
    @Test
    public void testSumarDiez() throws Exception {
        Map<String, Object> p = new HashMap<String, Object>();
        p.put(EJBContainer.APP_NAME, "foo");
        container = EJBContainer.createEJBContainer(p);
        System.out.println("sumarDiez");
        PruebaStatelessSinInterfaz instance = (PruebaStatelessSinInterfaz) container.getContext().lookup("java:global/foo/classes/PruebaStatelessSinInterfaz");
        float expResult = 10.0F;
        float result = instance.sumarDiez();
        assertEquals(expResult, result, 0.0);
        container.close();

    }

    /**
     * Test of sumarVeinte method, of class PruebaStatelessSinInterfaz.
     */
    @Test
    public void testSumarVeinte() throws Exception {
        System.out.println("sumarVeinte");
        Map<String, Object> p = new HashMap<String, Object>();
        p.put(EJBContainer.APP_NAME, "foo");
        container = EJBContainer.createEJBContainer(p);
        PruebaStatelessSinInterfaz instance = (PruebaStatelessSinInterfaz) container.getContext().lookup("java:global/foo/classes/PruebaStatelessSinInterfaz");
        float expResult = 20.0F;
        float result = instance.sumarVeinte();
        assertEquals(expResult, result, 0.0);
        container.close();
    }
}
