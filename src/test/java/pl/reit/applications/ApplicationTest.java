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

/**
 *
 * @author Szymon
 */
public class ApplicationTest {
    
    public static final String SOME_CONTENT = "some content";
    
    public static final String SOME_NAME = "some name";
    
    public static final String SOME_REASON = "Too short explanation";
    
    public static final String EMPTY_REASON = " \n ";
    
    public ApplicationTest() {
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
    public void testCreation() {
        assertEquals(State.CREATED, created().getState());
    }

    private static Application created() {
        return new Application().create();
    }

    @Test
    public void testDelete() {
        assertEquals(State.DELETED, deleted().getState());
    }

    @Test(expected = WrongActionTakenRuntimeException.class)
    public void testDelete_wrongState() {
        deleted().delete(SOME_REASON);
    }

    private static Application deleted() {
        return created().delete(SOME_REASON);
    }

    @Test
    public void testVerify() {
        assertEquals(State.VERIFIED, verified().getState());
    }
    
    @Test(expected = WrongActionTakenRuntimeException.class)
    public void testVerify_wrongState() {
        deleted().verify();
    }
    
    @Test
    public void testReject() {
        assertEquals(State.REJECTED, verified().reject(SOME_REASON).getState());
    }
    
    @Test(expected = WrongActionTakenRuntimeException.class)
    public void testReject_wrongState() {
        deleted().reject(SOME_REASON);
    }
    
    @Test
    public void testAccept() {
        assertEquals(State.ACCEPTED, acceptedApplication().getState());
    }
    
    @Test(expected = WrongActionTakenRuntimeException.class)
    public void testAccept_wrongState() {
        created().accept();
    }
    
    @Test
    public void testPublish() {
        assertEquals(State.PUBLISHED, acceptedApplication().publish().getState());
    }
    
    @Test(expected = WrongActionTakenRuntimeException.class)
    public void testPublish_wrongState() {
        created().publish();
    }

    private static Application acceptedApplication() {
        return verified().accept();
    }
    
    @Test
    public void testContentChange() {
        Application application = created();
        application.setContent(SOME_CONTENT);
        assertEquals(SOME_CONTENT, application.getContent());
    }
    
    @Test(expected = WrongStateForChangeRuntimeException.class)
    public void testContentChange_wrongState() {
        deleted().setContent(SOME_CONTENT);
    }
    
    @Test
    public void testNameChange() {
        Application application = created();
        application.setName(SOME_NAME);
        application.setName(SOME_NAME);
        assertEquals(SOME_NAME, application.getName());
    }
    
    @Test(expected = WrongStateForChangeRuntimeException.class)
    public void testNameChange_wrongState() {
        deleted().setName(SOME_NAME);
    }
    
    @Test
    public void testDelete_withExplanation() {
        Application application = deleted();
        assertEquals(SOME_REASON, application.getReason());
    }
    
    @Test(expected = WrongReasonRuntimeException.class)
    public void testDelete_withBlankExplanation() {
        created().delete(EMPTY_REASON);
    }
    
    @Test
    public void testReject_withExplanation() {
        Application application = verified().reject(SOME_REASON);
        assertEquals(SOME_REASON, application.getReason());
    }

    private static Application verified() {
        return created().verify();
    }
    
    @Test
    public void testPreviousStates() {
        Application application = verified().accept().publish();
        assertEquals(5, application.getPreviousStates().size());
    }
    
}
