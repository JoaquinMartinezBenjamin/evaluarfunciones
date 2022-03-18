
import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.JOptionPane;

public class InvocableFunc {
  public static void main(String args[]) {
    ScriptEngineManager manager = new ScriptEngineManager();
    ScriptEngine engine = manager.getEngineByName("javascript");
    double x=3.5;
    String func=JOptionPane.showInputDialog("Escribe una función de x");
    try {
      engine.eval("function myFunction(x){var output = '';"
          + "{output = "+func+";"
          + "  } return output;}");
      Invocable invokeEngine = (Invocable) engine;
      Object o = invokeEngine.invokeFunction("myFunction", x);
      System.out.println(o);

    } catch (NoSuchMethodException e) {
      System.err.println(e);
    } catch (ScriptException e) {
      System.err.println(e);
    }
  }
}
