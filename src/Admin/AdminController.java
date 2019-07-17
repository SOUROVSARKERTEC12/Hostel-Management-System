package Admin;

import Login.Login;
import dbUtil.dbConnection;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.function.Predicate;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;



public class AdminController
        implements Initializable
{

    @FXML
    private Button Add;

    @FXML
    private Button remove;

    @FXML
    private Button edited;

    @FXML
    private Button loadtable;

    @FXML
    private Button refresh;

    @FXML
    TableView <User> table;

    @FXML
    private TableColumn<User, String> roomCol;

    @FXML
    private TableColumn<User,String> nameCol;

    @FXML
    private TableColumn<User, String> currentDueCol;

    @FXML
    private TableColumn<User, String> addCol;

    @FXML
    private TableColumn<User, String> subtractCol;

    @FXML
   private TextField searchBox1;

    @FXML
    private TextField roomNo;

    @FXML
    private TextField Name;

    @FXML
    private TextField CurrentDue;

    @FXML
    private TextField AddAmount;

    @FXML
    private TextField SubtractAmount;


    @FXML
    private TextField searchBox;
    @FXML
    private TextField id;
    @FXML
    private TextField rollnumber;
    @FXML
    private TextField name;
    @FXML
    private TextField email;
    @FXML
    private TextField Department;
    @FXML
    private TextField Batch;
    @FXML
    private TextField RoomNo;
    @FXML
    private TextField GarduainName;
    @FXML
    private TextField Address;
    @FXML
    private TextField PhoneNumber;
    @FXML
    private TextField Gender;
    @FXML
    private DatePicker dob;
    @FXML
    private TableView<StudentData> studenttable;
    @FXML
    private TableColumn<StudentData, String> idcolumn;
    @FXML
    private TableColumn<StudentData, String> rollnumbercolumn;
    @FXML
    private TableColumn<StudentData, String> namecolumn;
    @FXML
    private TableColumn<StudentData, String> emailcolumn;
    @FXML
    private TableColumn<StudentData, String> dobcolumn;
    @FXML
    private TableColumn<StudentData, String> deptcolumn;
    @FXML
    private TableColumn<StudentData, String> Batchcolumn;
    @FXML
    private TableColumn<StudentData, String> RoomNocolumn;
    @FXML
    private TableColumn<StudentData, String> GarduianNocolumn;
    @FXML
    private TableColumn<StudentData, String> Addresscolumn;
    @FXML
    private TableColumn<StudentData, String> Phonecolumn;
    @FXML
    private TableColumn<StudentData, String> Gendercolumn;
    @FXML
    private Button loadbutton;
    @FXML
    private Button deletebutton;
    @FXML
    private Button updatebutton;
    private ObservableList<StudentData> data = FXCollections.observableArrayList();
    private FilteredList<StudentData> filteredData = new FilteredList<>(data,e ->true);
    private dbConnection dc;

    private ObservableList<User> data1 = FXCollections.observableArrayList();
    private FilteredList<User> filteredData1 = new FilteredList<>(data1,e1 ->true);
    private dbConnection db1;

    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    public void initialize(URL url, ResourceBundle rb)
    {
        this.dc = new dbConnection();
        this.db1 = new dbConnection();

        idcolumn.setCellValueFactory(new PropertyValueFactory<>("ID"));
        rollnumbercolumn.setCellValueFactory(new PropertyValueFactory<>("RollNumber"));
        namecolumn.setCellValueFactory(new PropertyValueFactory<>("Name"));
        emailcolumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        dobcolumn.setCellValueFactory(new PropertyValueFactory<>("DOB"));
        deptcolumn.setCellValueFactory(new PropertyValueFactory<>("Dept"));
        Batchcolumn.setCellValueFactory(new PropertyValueFactory<>("Batch"));
        RoomNocolumn.setCellValueFactory(new PropertyValueFactory<>("RoomNo"));
        GarduianNocolumn.setCellValueFactory(new PropertyValueFactory<>("GarduianNo"));
        Addresscolumn.setCellValueFactory(new PropertyValueFactory<>("Address"));
        Phonecolumn.setCellValueFactory(new PropertyValueFactory<>("Phone"));
        Gendercolumn.setCellValueFactory(new PropertyValueFactory<>("Gender"));
        loadStudentData();

        roomCol.setCellValueFactory(new PropertyValueFactory<>("RoomNo1"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("Name1"));
        currentDueCol.setCellValueFactory(new PropertyValueFactory<>("CurrentDue"));
        addCol.setCellValueFactory(new PropertyValueFactory<>("Add"));
        subtractCol.setCellValueFactory(new PropertyValueFactory<>("Subtract"));
        loadFinanceData();

    }


   //All Student information code start here
    ResultSet rs =null;
    @FXML
    public void loadStudentData()
    {
        try
        {
            id.clear();
            rollnumber.clear();
            name.clear();
            email.clear();
            Department.clear();
            Batch.clear();
            RoomNo.clear();
            Gender.clear();
            Address.clear();
            PhoneNumber.clear();
            GarduainName.clear();
            dob.getEditor().clear();

            Connection conn = dbConnection.getConnection();
            this.data = FXCollections.observableArrayList();

            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM students");
            while (rs.next()) {
                this.data.add(new StudentData(rs.getString(1), rs.getString(2),
                        rs.getString(3), rs.getString(4), rs.getString(5),
                        rs.getString(6), rs.getString(7), rs.getString(8),
                        rs.getString(9), rs.getString(10),rs.getString(11),
                        rs.getString(12)));
                studenttable.setItems(data);
            }

            conn.close();
            rs.close();
        }
        catch (SQLException e)
        {
            System.err.println("Error " + e);
        }

        this.idcolumn.setCellValueFactory(new PropertyValueFactory("ID"));
        this.rollnumbercolumn.setCellValueFactory(new PropertyValueFactory("RollNumber"));
        this.namecolumn.setCellValueFactory(new PropertyValueFactory("Name"));
        this.emailcolumn.setCellValueFactory(new PropertyValueFactory("email"));
        this.dobcolumn.setCellValueFactory(new PropertyValueFactory("DOB"));
        this.deptcolumn.setCellValueFactory(new PropertyValueFactory("Dept"));
        this.Batchcolumn.setCellValueFactory(new PropertyValueFactory("Batch"));
        this.RoomNocolumn.setCellValueFactory(new PropertyValueFactory("RoomNo"));
        this.GarduianNocolumn.setCellValueFactory(new PropertyValueFactory("GarduianNo"));
        this.Addresscolumn.setCellValueFactory(new PropertyValueFactory("Address"));
        this.Phonecolumn.setCellValueFactory(new PropertyValueFactory("Phone"));
        this.Gendercolumn.setCellValueFactory(new PropertyValueFactory("Gender"));

        this.studenttable.setItems(null);
        this.studenttable.setItems(this.data);
    }

    @FXML
    private void addStudent(ActionEvent event)
    {
        String sql = "INSERT INTO `students`(`id`, `roll`, `name`, `email`, `DOB`, `Dept`,`Batch`,`RN`,`GN`,`Address`,`phn`,`Sex`) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?)";
        try
        {
            Connection conn = dbConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, id.getText());
            stmt.setString(2, rollnumber.getText());
            stmt.setString(3, name.getText());
            stmt.setString(4, email.getText());
            stmt.setString(5, dob.getEditor().getText());
            stmt.setString(6, Department.getText());
            stmt.setString(7, Batch.getText());
            stmt.setString(8, RoomNo.getText());
            stmt.setString(9, GarduainName.getText());
            stmt.setString(10, Address.getText());
            stmt.setString(11, PhoneNumber.getText());
            stmt.setString(12, Gender.getText());

            stmt.execute();
            conn.close();
        }
        catch (SQLException e)
        {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }

        loadStudentData();
        //Login.showInformationAlertBox("New User '"+id+"' Added Successfully!");
    }

    @FXML
    public void update(){
        String sql = "update  students set id=?, roll=?, name=?, email=?, DOB=?, Dept=?, Batch=?, RN=?, GN=?, Address=?, phn=?, sex=? where  name='"+tempName+"'";
        try
        {
            Connection conn = dbConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, id.getText());
            stmt.setString(2, rollnumber.getText());
            stmt.setString(3, name.getText());
            stmt.setString(4, email.getText());
            stmt.setString(5, dob.getEditor().getText());
            stmt.setString(6, Department.getText());
            stmt.setString(7, Batch.getText());
            stmt.setString(8, RoomNo.getText());
            stmt.setString(9, GarduainName.getText());
            stmt.setString(10, Address.getText());
            stmt.setString(11, PhoneNumber.getText());
            stmt.setString(12, Gender.getText());

            stmt.execute();
            conn.close();
            Login.showInformationAlertBox("User '"+id.getText()+"' Updated Successfully!");
            loadStudentData();
        }
        catch (SQLException e)
        {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
    }

    static String tempName;
    @FXML
    public void ClickOnShow(){
        try {
            StudentData user=(StudentData)studenttable.getSelectionModel().getSelectedItem();
            String query="select * from students";
            Connection conn = dbConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query);

            tempName=user.getName();
            id.setText(user.getID());
            rollnumber.setText(user.getRollNumber());
            name.setText(user.getName());
            email.setText(user.getEmail());
            Department.setText(user.getDept());
            Batch.setText(user.getBatch());
            RoomNo.setText(user.getRoomNo());
            GarduainName.setText(user.getGarduianNo());
            Address.setText(user.getAddress());
            PhoneNumber.setText(user.getPhone());
            Gender.setText(user.getGender());
            dob.getEditor().setText(user.getDOB());


            stmt.close();
        }
        catch (SQLException e){
            System.out.println(e);
        }
    }
    @FXML
    public void delete(){

    String name = null;
        try {
            StudentData user =(StudentData) studenttable.getSelectionModel().getSelectedItem();
            String sql = "delete from students where name=?";
            Connection conn = dbConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1,user.getName());
            name = user.getName();

            stmt.executeUpdate();
            conn.close();

        }
        catch (SQLException ex){
            System.err.println("Got an Exception");
            System.err.println(ex.getMessage());
        }
        loadStudentData();
        Login.showInformationAlertBox("User '"+name+"' Deleted Successfully!");
    }

    @FXML
    public void search()
    {
        searchBox.textProperty().addListener((observableValue,oldValue,newValue)->{
            filteredData.setPredicate((Predicate<? super StudentData>)user->{
                if(newValue==null||newValue.isEmpty()){
                    return true;
                }
                String lowerCaseFilter=newValue.toLowerCase();
                if(user.getID().toLowerCase().contains(lowerCaseFilter)){
                    return true;
                }
                /*else if(user.getID().toLowerCase().contains(lowerCaseFilter)){
                   return true;
                }*/
                return false;
            });
        });
        SortedList<StudentData> sortedData=new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(studenttable.comparatorProperty());
        studenttable.setItems(sortedData);
    }
    @FXML
    private void clearFields(ActionEvent event)
    {
      // searchBox.setText("");
        this.id.setText("");
        this.rollnumber.setText("");
        this.name.setText("");
        this.email.setText("");
        this.dob.setValue(null);
        this.Department.setText("");
        this.Batch.setText("");
        this.RoomNo.setText("");
        this.GarduainName.setText("");
        this.Address.setText("");
        this.PhoneNumber.setText("");
        this.Gender.setText("");

    }
    // All student information code end here



    //Finance code start here
    @FXML
    public void loadFinanceData(){

        try {
            roomNo.clear();
            Name.clear();
            CurrentDue.clear();
            AddAmount.clear();
            SubtractAmount.clear();

            Connection conn1 = dbConnection.getConnection();
            this.data1 = FXCollections.observableArrayList();

            ResultSet rs1 = conn1.createStatement().executeQuery("SELECT * FROM Finance");
            while (rs1.next()) {
                this.data1.add(new User(rs1.getString(1), rs1.getString(2),
                        rs1.getString(3), rs1.getString(4), rs1.getString(5)
                        ));
                table.setItems(data1);

                conn1.close();
                rs1.close();
            }
        }
        catch (Exception e){
            System.err.println(e);
        }

        this.roomCol.setCellValueFactory(new PropertyValueFactory("RoomNo1"));
        this.nameCol.setCellValueFactory(new PropertyValueFactory("Name1"));
        this.currentDueCol.setCellValueFactory(new PropertyValueFactory("CurrentDue"));
        this.addCol.setCellValueFactory(new PropertyValueFactory("Add"));
        this.subtractCol.setCellValueFactory(new PropertyValueFactory("Subtract"));


        this.table.setItems(null);
        this.table.setItems(this.data1);

    }

      @FXML
      public void addFinace() throws SQLException{

            String sql = "INSERT INTO 'Finance'('RoomNo', 'Name', 'SAmount', 'CDAmount', 'Add1' ) VALUES (?,?,?,?,?)";
            try {
                Connection conn = dbConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, roomNo.getText());
                stmt.setString(2, Name.getText());
                stmt.setString(3, AddAmount.getText());
                stmt.setString(4, SubtractAmount.getText());
                stmt.setString(5, CurrentDue.getText());

                stmt.execute();
                conn.close();
            }

            catch (NullPointerException e){
                System.out.println(e);
            }

            loadFinanceData();
    }

    @FXML
    public void updateFinance(){
        String sql = "update Finance set RoomNo=?, Name =?, Add1 =?,  SAmount =?, CDAmount =? where Name='"+tepName+"'";
        try {
            Connection connection = dbConnection.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, roomNo.getText());
            stmt.setString(2, Name.getText());
            stmt.setString(3, AddAmount.getText());
            stmt.setString(4, SubtractAmount.getText());
            stmt.setString(5, CurrentDue.getText());

            stmt.execute();
            connection.close();

            System.out.println("Update Data");

            loadFinanceData();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    static String tepName;
    @FXML
    public void ClickOnShowFinance() throws SQLException{

        try {
            User user = (User) table.getSelectionModel().getSelectedItem();
            String query = "select * from Finance";
            Connection connection = dbConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            tepName = user.getName1();
            roomNo.setText(user.getRoomNo1());
            Name.setText(user.getName1());
            AddAmount.setText(user.getAdd());
            SubtractAmount.setText(user.getSubtract());
            CurrentDue.setText(user.getCurrentDue());

            preparedStatement.close();
        }

        catch (NullPointerException e){
            System.out.println(e);
        }

    }

    @FXML
    public void Delete() throws SQLException{
        String name = null;

        try
        {
            User user = (User) table.getSelectionModel().getSelectedItem();

            String sql = "delete from Finance where Name=?";
            Connection conn = dbConnection.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setString(1,user.getName1());
            name = user.getName1();

            preparedStatement.executeUpdate();
            conn.close();


        }
        catch (NullPointerException e){
            System.out.println(e);
        }

        loadFinanceData();
    }

    @FXML
    private void refresh(ActionEvent event){
        roomNo.setText("");
        Name.setText("");
        AddAmount.setText("");
        SubtractAmount.setText("");
        CurrentDue.setText("");

    }
}
