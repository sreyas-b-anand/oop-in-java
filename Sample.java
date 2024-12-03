import java.awt.event.TextEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.lang.reflect.Method.*;
public class Sample {
    public static void main(String args[]){
        Class<?> cl = ItemEvent.class;
        Method[] mm = cl.getMethods();
        for(Method m : mm){
            System.out.println(m);
        }
    }
}
