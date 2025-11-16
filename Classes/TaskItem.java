
package swingIntro.Classes;


public class TaskItem {
    
    private final String text;
    private boolean done;
    
    public TaskItem(String text) {
        this.text = text;
        this.done = done;
    }
    
    public String getText() { return text; }
    
    public boolean isDone() { return done; }
    
    public boolean getDone() { return done; }
    
    public void markDone() { this.done = true; }
    
    @Override
    public String toString()  { return String.format("[%s] %s", done ? "X" : "", text); }
}
