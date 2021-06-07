import java.util.HashMap;
import java.util.Map;

public class App {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    ProcessBuilder process = new ProcessBuilder();
    Integer port;
    if (process.environment().get("PORT") != null) {
        port = Integer.parseInt(process.environment().get("PORT"));
    } else {
        port = 4567;
    };

    setPort(port);

    get("/", (request, response) -> {
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("template", "templates/index.vtl");
        return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("squads/:id/heros/new", (request, response) -> {
        Map<String, Object> model = new HashMap<String, Object>();
        Squad squad = Squad.find(Integer.parseInt(request.params(":id")));
        model.put("squad", squad);
        model.put("template", "templates/squad-heros-form.vtl");
        return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/heros", (request, response) -> {
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("heros", Hero.all());
        model.put("template", "templates/heros.vtl");
        return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/heros", (request, response) -> {
        Map<String, Object> model = new HashMap<String, Object>();
        Squad squad = Squad.find(Integer.parseInt(request.queryParams("squadId")));
        String name = request.queryParams("name");
        Integer age = Integer.parseInt(request.queryParams("age"));
        String specialPower = request.queryParams("special_power");
        String weakness = request.queryParams("weakness");
        Hero newHero = new Hero(name, age, specialPower, weakness);
        squad.addHero(newHero);
        model.put("squad", squad);
        model.put("template", "templates/squad-hero-success.vtl");
        return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/heros/:id", (request, response) -> {
        Map<String, Object> model = new HashMap<String, Object>();
        Hero hero = Hero.find(Integer.parseInt(request.params(":id")));
        model.put("hero", hero);
        model.put("template", "templates/hero.vtl");
        return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/squads/new", (request, response) -> {
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("template", "templates/squad-form.vtl");
        return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/squads", (request, response) -> {
        Map<String, Object> model = new HashMap<String, Object>();
        String name = request.queryParams("name");
        Integer maxSize = Integer.parseInt(request.queryParams("maxSize"));
        Squad newSquad = new Squad(name, maxSize);
        model.put("template", "templates/squad-success.vtl");
        return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/squads", (request, response) -> {
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("squads", Squad.all());
        model.put("template", "templates/squads.vtl");
        return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/squads/:id", (request, response) -> {
        Map<String, Object> model = new HashMap<String, Object>();
        Squad squad = Squad.find(Integer.parseInt(request.params(":id")));
        model.put("squad", squad);
        model.put("template", "templates/squad.vtl");
        return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

}
}
