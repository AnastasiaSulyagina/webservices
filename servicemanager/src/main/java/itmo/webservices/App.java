package itmo.webservices;

/**
 * Created by anastasia.sulyagina
 */
public class App {
    private static final String PUBLISH = "publish";
    private static final String CALL = "call";

    public static void main(String[] args) {
        String command = args[0];
        switch (command) {
            case PUBLISH:
                Publish.publish();
                break;
            case CALL:
                Call.call();
                break;
            default:
                help();
        }
    }

    private static void help() {
        System.out.println("Please specify command, either " + PUBLISH + " or " + CALL);
    }
}
