import java.util.*;
import notepad.*;


public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        Notepad notepad=new Notepad(100);
        do{
            System.out.println("Choose option");
            System.out.println("1) Display the text");
            System.out.println("2) Display the text from given lines");
            System.out.println("3) Insert the text");
            System.out.println("4) Delete the text");
            System.out.println("5) Delete the text from given lines");
            System.out.println("6) Copy the text");
            System.out.println("7) Paste thr text");
            System.out.println("8) undo your action");
            System.out.println("9) redo your action");
            System.out.println("10) Exit");

            System.out.println("Enter your choice   ");
            int choice=sc.nextInt();
            switch(choice){
                case 1:
                notepad.dispaly();
                break;
                case 2:
                System.out.println("Enter startLine and Endline");
                int sL=sc.nextInt();
                int eL=sc.nextInt();
                notepad.display(sL, eL);
                break;
                case 3:
                sc.nextLine();
                System.out.println("Enter the text");
                String text=sc.nextLine();
                System.out.println("Enter line number");
                int l=sc.nextInt();
                notepad.insertLine(l, text);
                break;
                case 4:
                System.out.println("Enter line number");
                int li=sc.nextInt();
                notepad.deleteLine(li);
                break;
                case 5:
                System.out.println("Enter startLine and Endline");
                int staL=sc.nextInt();
                int endL=sc.nextInt();
                notepad.delete(staL, endL);
                break;
                case 6:
                System.out.println("Enter startLine and Endline");
                int starL=sc.nextInt();
                int endLi=sc.nextInt();
                notepad.copy(starL, endLi);
                break;
                case 7:
                System.out.println("Enter line number");
                int line=sc.nextInt();
                notepad.paste(line);
                break;
                case 8:
                notepad.undo();
                break;
                case 9:
                notepad.redo();
                break;
                case 10:
                System.exit(0);
                break;


            }
        }while(true);
    }
}
