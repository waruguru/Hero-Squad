import java.io.StringWriter;
import java.util.Map;
import java.util.Properties;

public class VelocityTemplateEngine extends TemplateEngine{
    private final VelocityEngine velocityEngine;// create an object
    private String encoding;

    //constructor
    public VelocityTemplateEngine(VelocityTemplateEngine velocityTemplateEngine, String encoding) {
        this.velocityTemplateEngine = velocityTemplateEngine;
        this.encoding = encoding;
    }
    public VelocityTemplateEngine(){}
    Properties properties =new Properties();
    properties .setProperty("resource.loader","class");
    roperties.setProperty(
            "class.resource.loader.class",
            "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
        this.velocityEngine = new org.apache.velocity.app.VelocityEngine(properties);
}
    public VelocityTemplateEngine(String encoding) {
        this();
        this.encoding = encoding;
    }

    /**
     * Constructor
     *
     * @param velocityEngine The velocity engine, must not be null.
     */
    public VelocityTemplateEngine(VelocityEngine velocityEngine) {
        if (velocityEngine == null) {
            throw new IllegalArgumentException("velocityEngine must not be null");
        }
        this.velocityEngine = velocityEngine;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String render(ModelAndView modelAndView) {
        String templateEncoding = Optional.ofNullable(this.encoding).orElse(StandardCharsets.UTF_8.name());
        Template template = velocityEngine.getTemplate(modelAndView.getViewName(), templateEncoding);
        Object model = modelAndView.getModel();
        if (model instanceof Map) {
            Map<?, ?> modelMap = (Map<?, ?>) model;
            VelocityContext context = new VelocityContext(modelMap);
            StringWriter writer = new StringWriter();
            template.merge(context, writer);
            return writer.toString();
        } else {
            throw new IllegalArgumentException("modelAndView must be of type java.util.Map");
        }
    }
}
