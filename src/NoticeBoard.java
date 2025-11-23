import java.util.ArrayList;

public class NoticeBoard {
    private ArrayList<Object> newsList = new ArrayList<>();
    private String inchargeName;

    public NoticeBoard(){

    }

    //setter
    public void setNewsList(Object o){
        newsList.add(o);
    }
    public void setInchargeName(String inchargeName){
        this.inchargeName = inchargeName;
    }

    //getter
    public Object getNewsList(){
        for (Object object : newsList) {
            return object;
        }
        return newsList;
    }
    public String getInchargeName(){
        return inchargeName;
    }

    //methods
    public String display(){
        return "";
    }
    public void addContent(){
        
    }
}
