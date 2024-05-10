package notepad;
import action.Action;

import java.time.LocalDateTime;
import java.util.*;

public class Notepad {
    private int id;
    private String notepad[];
    private Stack<Action> undoAction;
    private Stack<Action> redoAction;
    private Queue<String> clipBoard;
    private int capacity;
    

    public Notepad(int capacity){
        notepad=new String[capacity];
        for(int i=0;i<capacity;i++){
            notepad[i]="";
        }
        undoAction=new Stack<>();
        redoAction=new Stack<>();
        clipBoard=new LinkedList<>();
        this.capacity=capacity;
    }
    public void dispaly(){
        for(int i=0;i<this.capacity;i++){
            System.out.println(notepad[i]);
        }
    }
    public void display(int startLine,int endLine){
        if(startLine<0 || startLine>endLine ||endLine>capacity ){
                    System.out.println("unable to display text check input");
                    return;
        }
        for(int i=startLine-1;i<endLine;i++){
            System.out.println(notepad[i]);
        }
    }
    public void insertLine(int linenumber,String text){
        if(linenumber>capacity){
            System.out.println("Notepad limit crossed");
            return ;
        }
        notepad[linenumber-1]=text;
        undoAction.push(new Action(id++, LocalDateTime.now(), true, linenumber, text));

    }
    public void deleteLine(int linenumber){
        if(linenumber>capacity){
            System.out.println("Error!! Exceeds capacity No such row to delete");
            return ;
        }
        if(notepad[linenumber-1].isEmpty()){
           System.out.println("Nothing to delete");
           return;
        }
        redoAction.push(new Action(id++, LocalDateTime.now(), false, linenumber,notepad[linenumber-1]));
        notepad[linenumber-1]="";
    }
    public void delete(int startLine,int endLine){
        if(startLine>endLine || endLine>capacity){
            System.out.println("unable to delete check input");
            return ;
        }
        for(int i=startLine;i<=endLine;i++){
           deleteLine(i);
        }
    }
    public void copy(int startLine,int endLine){
        if(startLine>endLine || endLine>capacity){
            System.out.println("Error!! unable to copy check input");
            return ;
        }
        String copytext="";
        for(int i=startLine-1;i<endLine;i++){
            copytext+=(notepad[i]+"\n");

        }
        if(!copytext.isEmpty()) clipBoard.add(copytext);
    }
    public void paste(int linenumber){
        if(this.clipBoard.isEmpty()){
            System.out.println("nothing to paste");
            return ;
        }
        String text=clipBoard.peek();
        insertLine(linenumber, text);
    }
    public void undo(){
        if(this.undoAction.isEmpty()){
            System.out.println("Nothing to undo");
            return;
        }
        Action action=this.undoAction.peek();
        this.undoAction.pop();
        deleteLine(action.getLineNumber());
    }
    public void redo(){
        if(this.redoAction.isEmpty()){
            System.out.println("Nothing to redo");
            return;
        }
        Action action=this.redoAction.peek();
        redoAction.pop();
        insertLine(action.getLineNumber(),action.getText());
    }



}
