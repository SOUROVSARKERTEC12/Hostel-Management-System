package Admin;


public class User {
    private String RoomNo1;
    private String Name1;
    private String CurrentDue;
    private String Add;
    private String Subtract;


    public User(String RoomNo1, String Name1, String Add,String Subtract, String CurrentDue ){

        this.RoomNo1 =RoomNo1;
        this.Name1 =Name1;
        this.CurrentDue = CurrentDue;
        this.Add = Add;
        this.Subtract = Subtract;
    }

    public String getRoomNo1() {
        return RoomNo1;
    }

    public String getName1() {
        return Name1;
    }

    public String getCurrentDue() {
        return CurrentDue;
    }

    public String getAdd() {
        return Add;
    }

    public String getSubtract() {
        return Subtract;
    }

    public void setRoomNo1(String roomNo1) {
        RoomNo1 = roomNo1;
    }

    public void setName1(String name1) {
        Name1 = name1;
    }

    public void setCurrentDue(String currentDue) {
        CurrentDue = currentDue;
    }

    public void setAdd(String add) {
        Add = add;
    }

    public void setSubtract(String subtract) {
        Subtract = subtract;
    }
}
