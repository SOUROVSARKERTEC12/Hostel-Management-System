package Admin;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class StudentData
{
    private final StringProperty ID;
    private final StringProperty RollNumber;
    private final StringProperty Name;
    private final StringProperty email;
    private final StringProperty DOB;
    private final StringProperty Dept;
    private final StringProperty Batch;
    private final StringProperty RoomNo;
    private final StringProperty GarduianNo;
    private final StringProperty Address;
    private final StringProperty Phone;
    private final StringProperty Gender;


    public StudentData(String id, String rollnumber, String name, String email, String dob, String dept, String batch, String roomno, String garduianno, String address, String phone, String gender)
    {
        super();
        this.ID = new SimpleStringProperty(id);
        this.RollNumber = new SimpleStringProperty(rollnumber);
        this.Name = new SimpleStringProperty(name);
        this.email = new SimpleStringProperty(email);
        this.DOB = new SimpleStringProperty(dob);

        this.Dept = new SimpleStringProperty(dept);
        this.Batch = new SimpleStringProperty(batch);
        this.GarduianNo = new SimpleStringProperty(garduianno);
        this.Address = new SimpleStringProperty(address);
        this.Phone = new SimpleStringProperty(phone);

        this.RoomNo = new SimpleStringProperty(roomno);
        this.Gender = new SimpleStringProperty(gender);



    }

    public String getName()
    {
        return Name.get();
    }

    public String getDept() {
        return Dept.get();
    }

    public StringProperty deptProperty() {
        return Dept;
    }

    public String getBatch() {
        return Batch.get();
    }

    public StringProperty batchProperty() {
        return Batch;
    }

    public String getRoomNo() {
        return RoomNo.get();
    }

    public StringProperty roomNoProperty() {
        return RoomNo;
    }

    public String getGarduianNo() {
        return GarduianNo.get();
    }

    public StringProperty garduianNoProperty() {
        return GarduianNo;
    }

    public String getAddress() {
        return Address.get();
    }

    public StringProperty addressProperty() {
        return Address;
    }

    public String getPhone() {
        return Phone.get();
    }

    public StringProperty phoneProperty() {
        return Phone;
    }

    public String getGender() {
        return Gender.get();
    }

    public StringProperty genderProperty() {
        return Gender;
    }

    public String getID()
    {
        return (String) ID.get();
    }

    public String getRollNumber()
    {
        return (String)RollNumber.get();
    }


    public String getEmail()
    {
        return (String)email.get();
    }

    public String getDOB()
    {
        return (String)DOB.get();
    }

    public void setID(String id)
    {
        this.ID.setValue(id);
    }

    public void setRollNumber(String value)
    {
        this.RollNumber.set(value);
    }

    public void setName(String value)
    {
        this.Name.set(value);
    }

    public void setEmail(String value)
    {
        this.email.set(value);
    }

    public void setDOB(String value)
    {
        this.DOB.set(value);
    }

    public void setDept(String dept) {
        this.Dept.set(dept);
    }

    public void setBatch(String batch) {
        this.Batch.set(batch);
    }

    public void setRoomNo(String roomNo) {
        this.RoomNo.set(roomNo);
    }

    public void setGarduianNo(String garduianNo) {
        this.GarduianNo.set(garduianNo);
    }

    public void setAddress(String address) {
        this.Address.set(address);
    }

    public void setPhone(String phone) {
        this.Phone.set(phone);
    }

    public void setGender(String gender) {
        this.Gender.set(gender);
    }

    public StringProperty idProperty()
    {
        return this.ID;
    }

    public StringProperty rollnumber()
    {
        return this.RollNumber;
    }

    public StringProperty NameProperty()
    {
        return this.Name;
    }

    public StringProperty emailProperty()
    {
        return this.email;
    }

    public StringProperty dobProperty()
    {
        return this.DOB;
    }


}