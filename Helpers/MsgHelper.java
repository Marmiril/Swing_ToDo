
package swingIntro.Helpers;

import java.awt.Component;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import swingIntro.Classes.TaskItem;

/**
 * Helper para mostrar diálogos simples con JOptionPane.
 */

public class MsgHelper {
    
    // Evitar instaciación.
    private MsgHelper() { }
    
    public static void info(Component parent, String message) {
        JOptionPane.showMessageDialog(
                    parent,
                    message,
                    "Información",
                    JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static void warn(Component parent, String message){
        JOptionPane.showMessageDialog(
                    parent, 
                    message,
                    "Aviso",
                    JOptionPane.WARNING_MESSAGE);
    }
    
    public static void error(Component parent, String message) {
        JOptionPane.showMessageDialog(
                    parent,
                    message,
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
    }
    
    public static boolean confirm(Component parent, String message) {
        int option = JOptionPane.showConfirmDialog(
                    parent,
                    message,
                    "Confirmar",
                    JOptionPane.YES_NO_OPTION);
        return option  == JOptionPane.YES_OPTION;        
    }
    
    public static String ask(Component parent,String message, String defaultValue) {
        return JOptionPane.showInputDialog(
                    parent,
                    message,
                    defaultValue);
    }
    
    public static int askIndex(
            Component parent,
            String actionName,
            int totalItems) {
        
        while (true) {            
            String input = ask(
                parent,
                "Indique la tarea a " + actionName +
                " (1 - " + totalItems + "):",
                "");        
        if (input == null) { return -1; }
        input = input.trim();        
            try { int index = Integer.parseInt(input) - 1;
                if ( index < 0 || index > totalItems) { warn(parent, "Número fuera de rango. Inténtelo de nuevo."); continue; } 
                return index;
            } catch (NumberFormatException es) { error(parent, "Ha de introducir un número entero. Inténtelo de nuevo."); }             
        }         
    }
}
