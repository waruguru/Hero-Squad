import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;
public class App {
    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }
    public static void main(String[] args) {
        port(getHerokuAssignedPort());
        staticFileLocation("/public");
        Map<String, Object> model = new HashMap<String, Object>();
//        ProcessBuilder process = new ProcessBuilder();
//        Integer port;
//        if (process.environment().get("PORT") != null) {
//            port = Integer.parseInt(process.environment().get("PORT"));
//        } else {
//            port = 4567;
//        }
//
//        setPort(port);
        staticFileLocation("/public");
        String layout = "templates/layout.vtl";
        get("/", (request, response) -> {
            model.put("template", "templates/home.vtl" );
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());
        get("/squadform", (request, response) -> {
            model.put("template", "templates/squadform.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());
        get("/squad", (request, response) -> {
            String squadname = request.queryParams("squadname");
            String squadcause = request.queryParams("squadcause");
            String membernumber = request.queryParams("membernumber");
            model.put("squadname", squadname);
            model.put("squadcause", squadcause);
            model.put("membernumber", membernumber);
            model.put("template", "templates/squadteam.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());
        get("/heroform", (request, response) -> {
            model.put("template", "templates/heroform.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());
        get("/hero", (request, response) -> {
            String heroname = request.queryParams("heroname");
            String whichsquad = request.queryParams("whichsquad");
            String heropower = request.queryParams("heropower");
            String heroweakness = request.queryParams("heroweakness");
            String heroage = request.queryParams("heroage");
            model.put("heroname", heroname);
            model.put("whichsquad", whichsquad);
            model.put("heropower", heropower);
            model.put("heroweakness", heroweakness);
            model.put("heroage", heroage);
            model.put("template", "templates/hero.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());
        get("/herolist", (request, response) -> {
            model.put("template", "templates/listhero.vtl" );
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());
    }
}