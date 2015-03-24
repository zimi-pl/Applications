/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.reit.applications;

import java.io.File;
import java.util.Arrays;
import static spark.Spark.*;

/**
 *
 * @author Szymon
 */
public class Server {

    public static void main(String[] args) {
        System.out.println(new File(".").getAbsolutePath());
        staticFileLocation("/web");
        
        ApplicationBean bean = prepareDB();
        get("/page/:pageId", new ListController(bean), JsonUtil.json());
        get("/application/:applicationId", new ApplicationController(bean), JsonUtil.json());
        post("/application/:applicationId", new ApplicationController(bean), JsonUtil.json());
        get("/newApplication", new ApplicationNewController(bean), JsonUtil.json());
        post("/newApplication", new ApplicationNewController(bean), JsonUtil.json());
        
    }

    private static ApplicationBean prepareDB() {
        Application a = new Application();
        a.setName("Wniosek o wydanie prawa jazdy");
        a.setContent("W związku ze zdaniem prawa jazdy przeze mnie. Wnoszę o wydanie prawa jazdy na moje nazwisko.");
        a.create().verify();
        Application b = new Application();
        b.setName("Wniosek o wydanie dowodu osobistego");
        b.setContent("Mój stary dokument traci już ważność");
        b.create().verify().accept();
        Application c = new Application();
        c.setName("Wniosek o zwrot podatku");
        c.setContent("Przysługuje mi ulga w związku z artykułem 134 punkt 12 c)");
        c.create().verify().reject("Źle wypełniony wniosek");
        Application d = new Application();
        d.setName("Wniosek o wydanie prawa jazdy");
        d.setContent("W związku ze zdaniem prawa jazdy przeze mnie. Wnoszę o wydanie prawa jazdy na moje nazwisko.");
        d.create().verify();
        Application e = new Application();
        e.setName("Wniosek o wydanie dowodu osobistego");
        e.setContent("Mój stary dokument traci już ważność");
        e.create().verify().accept();
        Application f = new Application();
        f.setName("Wniosek o zwrot podatku");
        f.setContent("Przysługuje mi ulga w związku z artykułem 134 punkt 12 c)");
        f.create().verify().reject("Źle wypełniony wniosek");
        Application g = new Application();
        g.setName("Wniosek o wydanie prawa jazdy");
        g.setContent("W związku ze zdaniem prawa jazdy przeze mnie. Wnoszę o wydanie prawa jazdy na moje nazwisko.");
        g.create().verify();
        Application h = new Application();
        h.setName("Wniosek o wydanie dowodu osobistego");
        h.setContent("Mój stary dokument traci już ważność");
        h.create().verify().accept();
        Application i = new Application();
        i.setName("Wniosek o zwrot podatku");
        i.setContent("Przysługuje mi ulga w związku z artykułem 134 punkt 12 c)");
        i.create().verify().reject("Źle wypełniony wniosek");
        Application j = new Application();
        j.setName("Wniosek o wydanie prawa jazdy");
        j.setContent("W związku ze zdaniem prawa jazdy przeze mnie. Wnoszę o wydanie prawa jazdy na moje nazwisko.");
        j.create().verify();
        Application k = new Application();
        k.setName("Wniosek o wydanie dowodu osobistego");
        k.setContent("Mój stary dokument traci już ważność");
        k.create().verify().accept();
        Application l = new Application();
        l.setName("Wniosek o zwrot podatku");
        l.setContent("Przysługuje mi ulga w związku z artykułem 134 punkt 12 c)");
        l.create().verify().reject("Źle wypełniony wniosek");
        ApplicationBean bean = new ApplicationBean(Arrays.asList(a, b, c, d, e, f, g, h, i, j, k, l));
        return bean;
    }
}
