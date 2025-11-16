
package swingIntro;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.List;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import swingIntro.Classes.TaskItem;
import swingIntro.Helpers.MsgHelper;



public class Taskapp {
    
    private static JFrame frame;
    
    public static void main(String[] args) {
         
        
    
        SwingUtilities.invokeLater(() -> {
            
                // Ventana principal 
                frame = new JFrame("Gestor de tareas finas");
                frame.setSize(600, 300);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                
                // Lista para memoria.
                List<TaskItem> tasks = new ArrayList<>();
                
                // == Modelo visual y lista ==
                DefaultListModel<String> model = new DefaultListModel<>();
                JList<String> taskList = new JList<>(model);
                JScrollPane listScroll = new JScrollPane(taskList);
                frame.add(listScroll, BorderLayout.CENTER);
                
                // Panel superior.
                JPanel inputPanel = new JPanel(new FlowLayout());
                JTextField taskField = new JTextField(20);
                JButton btnAdd = new JButton("Añadir tasca");
                
                inputPanel.add(taskField);
                inputPanel.add(btnAdd);
                frame.add(inputPanel, BorderLayout.NORTH);
                
                // Panel inferior
                JPanel buttonPanel = new JPanel(new FlowLayout()); 
                JButton btnList = new JButton("Listar tareas");               buttonPanel.add(btnList);
                JButton btnDone = new JButton("Marcar tarea");          buttonPanel.add(btnDone);
                JButton btnEdit = new JButton("Editar tarea");               buttonPanel.add(btnEdit);
                JButton btnClear = new JButton("Limpiar");                    buttonPanel.add(btnClear);
                JButton btnDelete = new JButton("Eliminar tarea");       buttonPanel.add(btnDelete);
                JButton btnExit = new JButton("Salir");                             buttonPanel.add(btnExit);
                frame.add(buttonPanel, BorderLayout.SOUTH);
                
                
                        
                /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                // ACCIONES
                
                // 1- AÑADIR TAREA.
                btnAdd.addActionListener(e -> { addTask(taskField, tasks, model); });
                
                // 2 - LISTAR TAREAS.
                btnList.addActionListener( e -> { listTask(tasks, model); });
                
                // 3 - MARCAR TAREA COMO COMPLETADA
                btnDone.addActionListener(e -> { markTaskDone(tasks, model); });
                
                // 3 - EDITAR TAREA.
                btnEdit.addActionListener(e -> { editTask(tasks, model); });
                
                // 4 - LIMPIAR CONSOLA...
                btnClear.addActionListener(e -> { model.clear(); });
                
                // 5 - ELIMINAR TAREA.
                btnDelete.addActionListener(e -> { deleteTask(tasks, model); });
                
                // 6 - SALIR.
                btnExit.addActionListener(e -> System.exit(0));
                frame.setVisible(true);
        });
     } 
    
    private static void addTask(JTextField taskField, List<TaskItem> tasks, DefaultListModel<String> model) {
        String text = taskField.getText().trim();
        System.out.println("frame = " + frame);
        if (text.isEmpty()) { 
            MsgHelper.warn(frame, "Por favor, indique una tarea..."); return; }
        
        TaskItem item = new TaskItem(text);
        tasks.add(item);
        
        int index = tasks.size();
        model.addElement(index + "- " + item.toString());
          
        taskField.setText("");
             
    }
    
    private static void listTask(List<TaskItem> tasks, DefaultListModel<String> model) {
        model.clear();        
        if (tasks.isEmpty()) { MsgHelper.info(frame, "No hay notas en el listado"); return; }        
        for (int i = 0; i < tasks.size(); i++) {
            TaskItem t = tasks.get(i);
            model.addElement((i + 1) + ". " + t.toString());  }
    }    
    
    private static void markTaskDone(List<TaskItem> tasks, DefaultListModel<String> model) {
        if (model.isEmpty()) { listTask(tasks, model); }
        
        int index = MsgHelper.askIndex(frame, "marcar", tasks.size());
        
        if (index == -1) return;
        
        TaskItem t = tasks.get(index);
        
       if (t.isDone()) { MsgHelper.info(frame, "La tarea ya está completada."); return; }
       
       t.markDone();
       
       model.set(index, (index + 1) + "- " + t.toString());                      
    }
    
    private static void editTask(List<TaskItem> tasks, DefaultListModel<String> model) {
        if (model.isEmpty()) { listTask(tasks, model); }
        int index = MsgHelper.askIndex(frame, "editar", tasks.size());
        if (index == -1) {return; } 
        TaskItem oldTask = tasks.get(index);
        
        String newText = MsgHelper.ask(
                frame,
                "Nuevo nombre para la tarea" + index +":",
                oldTask.getText()
          );
        if (newText == null) return;
        if (newText.isEmpty()) { MsgHelper.warn(frame, "El texto no puede estar vacío."); return; }
        
        TaskItem updated = new TaskItem(newText);
        if (oldTask.isDone()) { updated.markDone(); }
        
        tasks.set(index, updated);
        model.set(index, (index + 1) + "- " + updated.toString());
    }
    
    private static void deleteTask(List<TaskItem> tasks, DefaultListModel<String> model) {
        if (model.isEmpty()) { listTask(tasks, model); }
        int index = MsgHelper.askIndex(frame, "eliminar", tasks.size());
        if (index == -1) { return; }
        TaskItem item = tasks.get(index);
        boolean confirmed = MsgHelper.confirm(frame, "¿Seguro que desea eliminar esta tarea?");
        if (!confirmed) { return; }
        tasks.remove(index);
        model.remove(index);
        model.clear();
        listTask(tasks, model);        
    }
}
