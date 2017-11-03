import java.util.List;

public class UerInfo{
    private String name;
    private int sex;
    private String birthday;
    private String address;
    private List<Children> children;


    public String getName(){
        return name;
    }
    public void setName(String input){
        this.name = input;
    }
    public int getSex(){
        return sex;
    }
    public void setSex(int input){
        this.sex = input;
    }
    public String getBirthday(){
        return birthday;
    }
    public void setBirthday(String input){
        this.birthday = input;
    }
    public String getAddress(){
        return address;
    }
    public void setAddress(String input){
        this.address = input;
    }
    public List<Children> getChildren(){
        return children;
    }
    public void setChildren(List<Children> input){
        this.children = input;
    }
}
