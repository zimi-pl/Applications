/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.reit.applications;

import java.util.Arrays;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Szymon
 */
public class ApplicationWorkflowTest {
    
    public ApplicationWorkflowTest() {
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
     * Test of possibleActions method, of class ApplicationWorkflow.
     */
    @Test
    public void testPossibleActions() {
        System.out.println("possibleActions");
        ApplicationWorkflow instance = new ApplicationWorkflow();
        List<State> result = instance.possibleActions(State.CREATED);
        
        assertEquals(Arrays.asList(State.VERIFIED, State.DELETED), result);
    }
    
}
