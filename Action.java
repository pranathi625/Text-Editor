package action;
import java.time.*;
public class Action {
    private int actionId;
    private LocalDateTime localDateTime;
    private boolean isAddition;
    private int linenumber;
    private String text;
    public Action(int actionId,LocalDateTime localDateTime, boolean isAddition,int linenumber,String text){
        this.actionId=actionId;
        this.localDateTime=localDateTime;
        this.isAddition=isAddition;
        this.linenumber=linenumber;
        this.text=text;
    }
    private int getActionId(){
        return this.actionId;
    }
    public void setActionId(int actionId){
        this.actionId=actionId;
    }
    public LocalDateTime getLocalDateTime(){
        return this.localDateTime;
    }
    public boolean getIsAddition(){
        return this.isAddition;
    }
    public int getLineNumber(){
        return this.linenumber;
    }
    public String getText(){
        return this.text;
    }
 
}
