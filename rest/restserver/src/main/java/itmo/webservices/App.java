package itmo.webservices;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.servlet.ServletContainer;

/**
 * Created by anastasia.sulyagina
 */
public class App {
    public static void main(String... args) throws Exception {
        Utils.initDB();

        Server server = new Server(8080);

        ServletContextHandler handler = new ServletContextHandler(ServletContextHandler.NO_SESSIONS);
        handler.setContextPath("/");

        server.setHandler(handler);

        ServletHolder jerseyServletHolder = handler.addServlet(ServletContainer.class, "/*");
        jerseyServletHolder.setInitOrder(0);
        jerseyServletHolder.setInitParameter(
                "jersey.config.server.provider.packages",
                "itmo.webservices,com.fasterxml.jackson.jaxrs.json");

        try {
            server.start();
            server.join();
        } finally {
            server.stop();
        }
    }
}
