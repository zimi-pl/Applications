/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.reit.applications;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Szymon
 */
public class ApplicationBeanTest {
    
    public ApplicationBeanTest() {
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
    public void testPage() {
        List<Application> firstPageApplications = applicationBeanFactory(11).page(new Criteria(1, null, null)).getApplications();
        assertEquals(10, firstPageApplications.size());
    }
    
    @Test
    public void testPage_lastOne() {
        List<Application> firstPageApplications = applicationBeanFactory(11).page(new Criteria(2, null, null)).getApplications();
        assertEquals(1, firstPageApplications.size());
    }
    
    @Test(expected = WrongPageRuntimeException.class)
    public void testPage_wrongPage() {
        applicationBeanFactory(11).page(new Criteria(3, null, null));
    }
    
    @Test(expected = WrongPageRuntimeException.class)
    public void testPage_boundCaseWrongPage() {
        applicationBeanFactory(10).page(new Criteria(2, null, null));
    }
    
    @Test(expected = WrongPageRuntimeException.class)
    public void testPage_incorrectPage() {
        applicationBeanFactory(11).page(new Criteria(0, null, null));
    }
    
    @Test
    public void testPage_criteria() {
        Criteria criteria = new Criteria(1, null, null);
        assertEquals(10, applicationBeanFactory(11).page(criteria).getApplications().size());
    }
    
    @Test
    public void testSave() {
        Application application = new Application();
        application.setName("próba");
        application.setContent("zapisu");
        Application saved = applicationBeanFactory(11).save(application);
        assertEquals((Integer)12, saved.getId());
    }
    
    @Test
    public void testFind() {
        Application retrieved = applicationBeanFactory(11).find(8);
        assertEquals((Integer)8, retrieved.getId());
    }

    public static ApplicationBean applicationBeanFactory(int limit) {
        List<Application> applications = new ArrayList<>();
        for (int i = 1; i <= limit; i++) {
            Application a = new Application();
            a.setName("Wniosek o wydanie prawa jazdy: " + i);
            a.setContent("W związku ze zdaniem prawa jazdy przeze mnie. Wnoszę o wydanie prawa jazdy na moje nazwisko.");
            a.create().verify();
            applications.add(a);
        }

        return new ApplicationBean(applications);
    }
}
