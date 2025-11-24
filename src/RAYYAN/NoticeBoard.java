package RAYYAN;
import java.util.ArrayList;

public class NoticeBoard {
    private ArrayList<String> newsList = new ArrayList<>();
    private String inchargeName;

    public NoticeBoard(){

    }

    //setter
    public void setNewsList(String s){
        newsList.add(s);
    }
    public void setInchargeName(String inchargeName){
        this.inchargeName = inchargeName;
    }

    //getter
    public String getNewsList(){
        String s = "";
        for (int i = 0; i < newsList.size(); i++) {
            s += i + ". " + newsList.get(i) + "\n";
        }
        return s;
    }
    public String getInchargeName(){
        return inchargeName;
    }
    
    public String display(){
        return "dummy";
    }
}
