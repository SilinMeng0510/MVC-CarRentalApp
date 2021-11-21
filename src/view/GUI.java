package view;

import model.car.Car;

import javax.swing.*;
import java.awt.*;
import java.util.TreeSet;

public class GUI {
    enum Action {
        alphabetical, chronological
    }

    public static TreeSet<Car> manager = new TreeSet<>();

    public static <DatePicker> void main(String[] args) {
        // frame
        JFrame frame = new JFrame("Car Reservation");
        JPanel panel = new JPanel();
        frame.getContentPane();

        // Add Cars
        JButton addCar = new JButton("Car Storage");
        addCar.setBounds(900, 150, 150, 150);
        addCar.addActionListener(e -> viewCarOption());

        JButton addApp=new JButton("add Reservation");
        addApp.setBounds(900,150,150,150);

        JButton deleteApp = new JButton("delete Reservation");
        deleteApp.setBounds(900, 150, 150, 150);
        //  deleteApp.addActionListener(e->deleteOption());

//        com.github.lgooddatepicker.components.DatePicker datePicker1 = new com.github.lgooddatepicker.components.DatePicker();
//        datePicker1.addDateChangeListener(e->printOut(datePicker1.getDate(),Action.alphabetical));
//        // View button
//        JButton view = new JButton("View Reservation");
//        view.setBounds(900,150,150,150);
//        view.addActionListener(e -> viewOption());
//
//
        // BoxLayout Attempt
        panel.setLayout(new BoxLayout(panel, BoxLayout.LINE_AXIS));
        JPanel buttonPane = new JPanel();
        buttonPane.setLayout(new BoxLayout(buttonPane, BoxLayout.Y_AXIS));
        // Adding buttons
        buttonPane.add(addCar);
        buttonPane.add(addApp);
        buttonPane.add(deleteApp);

//        // Adding Calendar and buttonPane
//        panel.add(datePicker1);
        panel.add(buttonPane);
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.setSize(500, 300);
        frame.setVisible(true);
    }


    private static void viewCarOption() {
        JFrame frame = new JFrame("Car Storage");
        frame.getContentPane();
        frame.setPreferredSize(new Dimension(300, 300));

        // view the car storage
        JPanel view = new JPanel();
        for(Car car: manager){
            String s= car.getCompany() + " " + car.getModel() + " " + car.getYear();
            JTextArea listDisplay = new JTextArea();
            System.out.println(s);
            listDisplay.setText(s);
            view.add(listDisplay);
        }

        // add car to the storage
        JPanel add = new JPanel();
        JLabel model = new JLabel("Model name:");
        JLabel company = new JLabel("Company name:");
        JLabel year = new JLabel("Year :");
        // JLabel price = new JLabel("plz enter the prie");
        JTextField modelTXT = new JTextField(20);
        JTextField companyTXT = new JTextField(20);
        JTextField yearTXT = new JTextField(20);
        // JTextField priceT = new JTextField(20);
        add.add(model);
        add.add(modelTXT);
        add.add(company);
        add.add(companyTXT);
        add.add(year);
        add.add(yearTXT);

        JButton button = new JButton("Add");
        // add a listener to button
        button.addActionListener(e -> {
            Car car = new Car(modelTXT.getText(), companyTXT.getText(), yearTXT.getText(), 0.0);
            manager.add(car);
        });
        add.add(button);

        add.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 90));
        view.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        frame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        frame.add(view, BorderLayout.NORTH);
        frame.add(add, BorderLayout.CENTER);
        frame.setSize(500, 200);
        frame.setVisible(true);

    }

//    private static void viewOption() {
//        JFrame frame = new JFrame("Options");
//        JPanel panel = new JPanel();
//        frame.getContentPane();
//        // frame.setPreferredSize(new Dimension(300,300));
//        JButton alpha = new JButton("View reservations by alphabetical order.");
//        JButton startDay = new JButton("View reservations by start date.");
//        alpha.setBounds(0,0,150,150);
//        startDay.setBounds(150,0,150,150);
//
//        panel.add(alpha);
//        panel.add(startDay);
//
//        alpha.addActionListener(e -> {
//            frame.dispose();
//            pickAllOrDay(Action.alphabetical);
//            System.out.println("Description");
//        });
//
//        startDay.addActionListener(e -> {
//            frame.dispose();
//            pickAllOrDay(Action.chronological);
//            System.out.println("start day");
//        });
//
//
//        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
//        frame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
//        frame.add(panel);
//        frame.setSize(500,200);
//        frame.setVisible(true);
//
//    }

//    private static void deleteOption(){
//        JFrame frame = new JFrame("delete");
//        JPanel panel = new JPanel();
//        frame.getContentPane();
//        // frame.setPreferredSize(new Dimension(300,300));
//        JLabel del = new JLabel("plz enter the description of the appointment that you want to delete") ;
//        JTextField delTXT = new JTextField(20);
//
//        panel.add(del);
//        panel.add(delTXT);
//
//
//        JButton button = new JButton("delete");
//        // add a listener to button
//        button.addActionListener(e -> {
//            String del_des= delTXT.getText();
//            if (manager.(del_des)) {
//                frame.dispose();
//            } else {
//                delTXT.setText("This appointment doesn't exist!");
//            }
//        });
//        panel.add(button);
//
//        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
//        frame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
//        frame.add(panel);
//        frame.setSize(500,200);
//        frame.setVisible(true);
//
//    }
//    private static void addOption() {
//        JFrame frame = new JFrame("Add an appointment");
//        JPanel panel = new JPanel();
//        frame.getContentPane();
//        frame.setPreferredSize(new Dimension(300,300));
//        JLabel startDate = new JLabel("plz enter your start date:");
//        JLabel endDate = new JLabel("plz enter your end date");
//        JLabel description = new JLabel("plz enter your description :");
//        JLabel type = new JLabel("plz enter your appointment type(monthly/daily/onetime):");
//
//        JTextField startDateTXT = new JTextField(20);
//        JTextField endDateTXT = new JTextField(20);
//        JTextField descriptionTXT = new JTextField(20);
//        JTextField typeTXT = new JTextField(20);
//
//        panel.add(startDate);
//        panel.add(startDateTXT);
//        panel.add(endDate);
//        panel.add(endDateTXT);
//        panel.add(description);
//        panel.add(descriptionTXT);
//
//
//        JButton button = new JButton("add");
//        // add a listener to button
//        button.addActionListener(e -> {
//            try {
//                LocalDate start = LocalDate.parse(startDateTXT.getText().trim());
//                LocalDate end = LocalDate.parse(endDateTXT.getText().trim());
//                if (end.compareTo(start) < 0) {
//                    throw new DateTimeException("End date proceeds start date");
//                }
//                String des = descriptionTXT.getText();
//                Time time=new Time(start,end);
//                manager.addReservation(new CarReservation(des));
//            } catch (DateTimeParseException e1) {
//                JOptionPane.showMessageDialog(button, "Unsupported Date Format",
//                        "Error", JOptionPane.ERROR_MESSAGE);
//            } catch (DateTimeException e2) {
//                JOptionPane.showMessageDialog(button, e2.getMessage(), "Error",
//                        JOptionPane.ERROR_MESSAGE);
//            }
//        });
//        panel.add(button);
//
//
//        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
//        frame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
//        frame.add(panel);
//        frame.setSize(500,200);
//        frame.setVisible(true);
//
//    }

//    private static void pickAllOrDay(Action action)
//    {
//
//        JFrame frame = new JFrame("Options");
//        JPanel panel = new JPanel();
//        JButton dateInput = new JButton("Search this date");
//        JButton allAppoint = new JButton("Show all appointments");
//        JTextField field = new JTextField(10);
//        JTextArea errorMessage = new JTextArea();
//        frame.getContentPane();
//
//        panel.add(field);
//        panel.add(errorMessage);
//        panel.add(dateInput);
//        panel.add(allAppoint);
//
//        dateInput.addActionListener(e->{
//            String input = field.getText();
//            try {
//                LocalDate parse = LocalDate.parse(input);
//                printOut(parse,action);
//                System.out.println(action);
//                frame.dispose();
//
//            } catch (Exception exception) {
//                errorMessage.setText("Sorry, wrong input!");
//                System.out.println("error");
//            }
//
//
//        });
//
//        allAppoint.addActionListener(e->{
//            printOut(null,action);
//            frame.dispose();
//        });
//
//
//
//
//        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
//        frame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
//        frame.add(panel);
//        frame.setSize(500,200);
//        frame.setVisible(true);
//
//    }

//    private static void printOut(LocalDate parse, Action action) {
//        JFrame frame = new JFrame("Appointment display");
//        JPanel panel = new JPanel();
//        JTextArea listDisplay = new JTextArea();
//        frame.getContentPane();
//        panel.add(listDisplay);
//        AppComparator comparator = null;
//        String list;
//        if (action.toString().equals("chronological"))
//        {
//            comparator  = new AppComparator();
//        }
//        if (parse == null)
//        {
//            //Print all appointment
//            list = manager.printAppointment(comparator);
//        }
//        else {
//            //Print appointment on specific date
//            list = manager.printOccursOn(parse,comparator);
//        }
//        listDisplay.setText(list);
//        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
//        frame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
//        frame.add(panel);
//        frame.setSize(500,200);
//        frame.setVisible(true);
//    }
}