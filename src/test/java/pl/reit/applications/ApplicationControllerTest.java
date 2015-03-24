/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.reit.applications;

import java.util.Arrays;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Matchers;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;
import spark.Request;

/**
 *
 * @author Szymon
 */
public class ApplicationControllerTest {
    
    public ApplicationControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testHandle() throws Exception {
        ApplicationController controller = new ApplicationController(ApplicationBeanTest.applicationBeanFactory(11));
        Request req = Mockito.mock(Request.class);
        when(req.params(Matchers.anyString())).thenReturn("3");
        ApplicationPage retrieved = (ApplicationPage)controller.handle(req, null);
        assertEquals("Wniosek o wydanie prawa jazdy: 3", retrieved.getApplication().getName());
        assertEquals(Arrays.asList(State.REJECTED, State.ACCEPTED), retrieved.getPossibleActions());
    }
    
}
