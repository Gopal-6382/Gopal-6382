package AWT_JAVA;

import java.awt.*;
import java.awt.event.*;

class MyApp extends Frame {
    Label lblTitle, lblName, lblFather, lblAge, lblGender, lblCourse, lblHobbies, lblAddress;
    TextField txtName, txtFather, txtAge;
    TextArea txtAddress;
    Checkbox checkMale, checkFemale, Hobbies1, Hobbies2, Hobbies3, Hobbies4;
    CheckboxGroup cbg;
    Choice Course;
    Button btnSave, btnClear;

    public MyApp() {
        super("AWT - User Registration Form");
        setSize(1000, 650);
        setLayout(null);
        setBackground(new Color(53, 59, 72));
        setResizable(false);

        Font titleFont = new Font("Arial", Font.BOLD, 25);
        Font labelFont = new Font("Arial", Font.PLAIN, 18);
        Font textFont = new Font("Arial", Font.PLAIN, 15);

        // Title
        lblTitle = new Label("Registration Form");
        lblTitle.setBounds(350, 50, 400, 40);
        lblTitle.setFont(titleFont);
        lblTitle.setForeground(Color.YELLOW);
        add(lblTitle);

        // Name
        lblName = new Label("Name:");
        lblName.setBounds(200, 120, 150, 30);
        lblName.setFont(labelFont);
        lblName.setForeground(Color.WHITE);
        add(lblName);

        txtName = new TextField();
        txtName.setBounds(360, 120, 400, 30);
        txtName.setFont(textFont);
        add(txtName);

        // Father Name
        lblFather = new Label("Father's Name:");
        lblFather.setBounds(200, 170, 150, 30);
        lblFather.setFont(labelFont);
        lblFather.setForeground(Color.WHITE);
        add(lblFather);

        txtFather = new TextField();
        txtFather.setBounds(360, 170, 400, 30);
        txtFather.setFont(textFont);
        add(txtFather);

        // Age
        lblAge = new Label("Age:");
        lblAge.setBounds(200, 220, 150, 30);
        lblAge.setFont(labelFont);
        lblAge.setForeground(Color.WHITE);
        add(lblAge);

        txtAge = new TextField();
        txtAge.setBounds(360, 220, 400, 30);
        txtAge.setFont(textFont);
        add(txtAge);

        // Gender
        lblGender = new Label("Gender:");
        lblGender.setBounds(200, 270, 150, 30);
        lblGender.setFont(labelFont);
        lblGender.setForeground(Color.WHITE);
        add(lblGender);

        cbg = new CheckboxGroup();
        checkMale = new Checkbox("Male", cbg, true);
        checkFemale = new Checkbox("Female", cbg, false);

        checkMale.setBounds(360, 270, 100, 30);
        checkMale.setFont(labelFont);
        checkMale.setForeground(Color.WHITE);
        checkFemale.setBounds(480, 270, 100, 30);
        checkFemale.setFont(labelFont);
        checkFemale.setForeground(Color.WHITE);

        add(checkMale);
        add(checkFemale);

        // Course
        lblCourse = new Label("Course:");
        lblCourse.setBounds(200, 320, 150, 30);
        lblCourse.setFont(labelFont);
        lblCourse.setForeground(Color.WHITE);
        add(lblCourse);

        Course = new Choice();
        Course.setFont(labelFont);
        Course.setBounds(360, 320, 400, 30);
        Course.add("C");
        Course.add("C++");
        Course.add("Java");
        Course.add("Python");
        Course.add("JavaScript");
        Course.add("C#");
        add(Course);

        // Hobbies
        lblHobbies = new Label("Hobbies:");
        lblHobbies.setBounds(200, 370, 150, 30);
        lblHobbies.setFont(labelFont);
        lblHobbies.setForeground(Color.WHITE);
        add(lblHobbies);

        Hobbies1 = new Checkbox("Drawing");
        Hobbies2 = new Checkbox("Singing");
        Hobbies3 = new Checkbox("Music");
        Hobbies4 = new Checkbox("Others");

        Hobbies1.setBounds(360, 370, 100, 30);
        Hobbies2.setBounds(470, 370, 100, 30);
        Hobbies3.setBounds(580, 370, 100, 30);
        Hobbies4.setBounds(690, 370, 100, 30);

        Hobbies1.setFont(labelFont);
        Hobbies2.setFont(labelFont);
        Hobbies3.setFont(labelFont);
        Hobbies4.setFont(labelFont);

        Hobbies1.setForeground(Color.WHITE);
        Hobbies2.setForeground(Color.WHITE);
        Hobbies3.setForeground(Color.WHITE);
        Hobbies4.setForeground(Color.WHITE);

        add(Hobbies1);
        add(Hobbies2);
        add(Hobbies3);
        add(Hobbies4);

        // Address
        lblAddress = new Label("Address:");
        lblAddress.setBounds(200, 420, 150, 30);
        lblAddress.setFont(labelFont);
        lblAddress.setForeground(Color.WHITE);
        add(lblAddress);

        txtAddress = new TextArea();
        txtAddress.setBounds(360, 420, 400, 80);
        txtAddress.setFont(textFont);
        add(txtAddress);

        // Buttons
        btnSave = new Button("Save");
        btnSave.setBounds(360, 520, 150, 40);
        btnSave.setFont(labelFont);
        btnSave.setBackground(Color.GREEN);
        btnSave.setForeground(Color.BLACK);
        add(btnSave);

        btnClear = new Button("Clear");
        btnClear.setBounds(520, 520, 150, 40);
        btnClear.setFont(labelFont);
        btnClear.setBackground(Color.RED);
        btnClear.setForeground(Color.WHITE);
        add(btnClear);

        // Save Button Action
        btnSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String data = getString();

                Dialog d = new Dialog(MyApp.this, "User Info", true);
                d.setLayout(new FlowLayout());
                d.setSize(400, 300);
                d.add(new Label("Form Submitted Successfully!"));
                TextArea ta = new TextArea(data, 10, 40);
                d.add(ta);
                Button ok = new Button("OK");
                d.add(ok);
                ok.addActionListener(e1 -> d.setVisible(false));
                d.setVisible(true);
            }
        });

        // Clear Button Action
        btnClear.addActionListener(e -> {
            txtName.setText("");
            txtFather.setText("");
            txtAge.setText("");
            cbg.setSelectedCheckbox(checkMale);
            Course.select(0);
            Hobbies1.setState(false);
            Hobbies2.setState(false);
            Hobbies3.setState(false);
            Hobbies4.setState(false);
            txtAddress.setText("");
        });

        // Close Button
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });

        setVisible(true);
    }

    private String getString() {
        String gender = cbg.getSelectedCheckbox().getLabel();
        String hobbies = "";
        if (Hobbies1.getState()) hobbies += "Drawing ";
        if (Hobbies2.getState()) hobbies += "Singing ";
        if (Hobbies3.getState()) hobbies += "Music ";
        if (Hobbies4.getState()) hobbies += "Others ";

        String data = "Name: " + txtName.getText() + "\nFather's Name: " + txtFather.getText() + "\nAge: " + txtAge.getText() + "\nGender: " + gender + "\nCourse: " + Course.getSelectedItem() + "\nHobbies: " + hobbies + "\nAddress: " + txtAddress.getText();
        return data;
    }
}

public class Form {
    public static void main(String[] args) {
        new MyApp();
    }
}
