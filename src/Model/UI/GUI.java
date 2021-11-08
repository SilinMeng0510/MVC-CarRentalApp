package Model.UI;

import javax.swing.*;

public class GUI {
    public static <DatePicker> void main(String[] args) {
        // frame
        JFrame frame = new JFrame("Car Reservation");
        JPanel panel = new JPanel();
        frame.getContentPane();

        // Add button
        JButton addApp=new JButton("add Reservation");
        addApp.setBounds(900,150,150,150);
       // addApp.addActionListener(e->addOption());
        // Delete button
        JButton deleteApp=new JButton("delete Reservation");
        deleteApp.setBounds(900,150,150,150);
      //  deleteApp.addActionListener(e->deleteOption());

//        DatePicker datePicker1 = new DatePicker();
//        datePicker1.addDateChangeListener(e->printOut(datePicker1.getDate(),Action.alphabetical));
        // View button
        JButton view = new JButton("View Reservation");
        view.setBounds(900,150,150,150);
       // view.addActionListener(e -> viewOption());


        // BoxLayout Attempt
        panel.setLayout(new BoxLayout(panel, BoxLayout.LINE_AXIS));
        JPanel buttonPane = new JPanel();
        buttonPane.setLayout(new BoxLayout(buttonPane, BoxLayout.Y_AXIS));
        // Adding buttons
        buttonPane.add(addApp);
        buttonPane.add(deleteApp);
        buttonPane.add(view);

        // Adding Calendar and buttonPane
     //   panel.add(datePicker1);
        panel.add(buttonPane);
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.setSize(500,300);
        frame.setVisible(true);
    }
}
