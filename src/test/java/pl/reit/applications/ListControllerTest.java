/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.reit.applications;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Matchers;
import org.mockito.Mockito;
import spark.Request;

/**
 *
 * @author Szymon
 */
public class ListControllerTest {
    
    public ListControllerTest() {
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

    /**
     * Test of handle method, of class ListController.
     */
    @Test
    public void testHandle() throws Exception {
        System.out.println("handle");
        Request request = Mockito.mock(Request.class);
        Mockito.when(request.params(Matchers.anyString())).thenReturn("1");
        
        ListController instance = new ListController(ApplicationBeanTest.applicationBeanFactory(11));
        ListPage page = (ListPage) instance.handle(request, null);
        assertEquals(2, page.getNumberOfPages());
        assertEquals(10, page.getApplications().size());
    }
    
}
