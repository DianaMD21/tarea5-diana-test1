import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;

public class Main {
    public static void main(String[] args) {
        String mensaje = "Hello World";
        System.out.println(mensaje);

        Javalin app = Javalin.create(config ->{
            config.addStaticFiles(staticFileConfig -> {
                staticFileConfig.hostedPath = "/";
                staticFileConfig.directory = "/public";
                staticFileConfig.location = Location.CLASSPATH;
            });

        });
        app.start(7070);
        app.get("/",ctx->{
            ctx.result("Esta es la aplicacion 1, puerto: "+app.port());
        });
    }
}
