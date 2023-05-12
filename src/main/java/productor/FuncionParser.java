package productor;


import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class FuncionParser {

    private ScriptEngine engine;

    public FuncionParser() {
        this.engine = new ScriptEngineManager().getEngineByName("js");
    }

    public double evaluar(String funcion, double x) throws ScriptException {
        String expr = funcion.replaceAll("x", Double.toString(x));
        return (double) engine.eval(expr);
    }
}
