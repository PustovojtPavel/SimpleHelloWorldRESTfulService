package org.example.web.rest;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.util.resource.Resource;
import org.eclipse.jetty.webapp.WebAppContext;
import org.eclipse.jetty.xml.XmlConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.util.concurrent.ThreadLocalRandom;

public class HelloWorldControllerTest {

    private static final Logger log = LoggerFactory.getLogger(HelloWorldController.class);
    private static Server server;
    private static int port = ThreadLocalRandom.current().nextInt(10000, 12000);


    @BeforeMethod
    public void setUp() throws Exception {

        try(Resource resource = Resource.newResource(new File("./src/test/config/jetty/jetty-web.xml"))) {
            WebAppContext webAppContext = (WebAppContext) new XmlConfiguration(resource.getInputStream()).configure();
            server = new Server(port);
            server.setHandler(webAppContext);
            server.start();
        }
    }

    @AfterMethod
    public void tearDown() throws Exception {
        server.stop();
    }

    @Test
    public void testSayHello() {
        log.info("test");
    }
}
