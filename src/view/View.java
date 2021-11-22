package view;

import controller.*;
import model.reservation.CarReservation;
import model.car.Car;
import model.user.Administer;
import model.user.Customer;

import javax.swing.*;
import java.awt.*;
import java.util.TreeSet;
import java.util.concurrent.BlockingQueue;

public class View extends JFrame {
    ImageIcon imageCar = new ImageIcon("pic/Car.jpg");
    ImageIcon imageRes = new ImageIcon("pic/hand-car.jpeg");
    ImageIcon imageSto = new ImageIcon("pic/storage.jpeg");
    ImageIcon imageList = new ImageIcon("pic/funny.jpeg");
    ImageIcon imageInvetory = new ImageIcon("pic/funnycar.png");
    public static TreeSet<Car> storage = new TreeSet<>();
    public static TreeSet<CarReservation> reservations = new TreeSet<>();
    BlockingQueue<Message> queue;
    JPanel initial_GUI;

    public View(BlockingQueue<Message> queue){
        // frame
        this.queue = queue;
        this.setTitle("Car Reservation");
        this.getContentPane();

        initial_GUI = new JPanel();
        initial_GUI.setLayout(new BoxLayout(initial_GUI, BoxLayout.LINE_AXIS));

        // Add Cars
        JButton addCar = new JButton("Update Storage");
        addCar.setBounds(900, 150, 150, 150);
        addCar.addActionListener(e -> addCarOption());

        JButton reservation = new JButton("New Reservation");
        reservation.setBounds(900,150,150,150);
        reservation.addActionListener(e -> reservationOption());

        JButton list = new JButton("Now Reservations");
        list.setBounds(900,150,150,150);
        list.addActionListener(e -> reservationViewOption());

        JButton storage = new JButton("Current Storage");
        storage.setBounds(900,150,150,150);
        storage.addActionListener(e -> storageViewOption());

        JPanel buttonPane = new JPanel();
        buttonPane.setLayout(new BoxLayout(buttonPane, BoxLayout.Y_AXIS));
        // Adding buttons
        buttonPane.add(storage);
        buttonPane.add(addCar);
        buttonPane.add(list);
        buttonPane.add(reservation);

        // Add Image
        JLabel image = new JLabel(imageCar);

        initial_GUI.add(buttonPane, BorderLayout.WEST);
        initial_GUI.add(image, BorderLayout.CENTER);
        initial_GUI.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(initial_GUI);
        this.setSize(1300, 800);
        this.setVisible(true);
    }


    private void addCarOption() {
        JFrame frame = new JFrame("Update Storage");
        frame.getContentPane();
        frame.setPreferredSize(new Dimension(300, 300));

        // add car to the storage
        JPanel action = new JPanel();
        JLabel model = new JLabel("Model name:");
        JLabel company = new JLabel("Company name:");
        JLabel year = new JLabel("Year :");
        JLabel price = new JLabel("Price:");
        JTextField modelTXT = new JTextField(20);
        JTextField companyTXT = new JTextField(20);
        JTextField yearTXT = new JTextField(25);
        JTextField priceTXT = new JTextField(20);

        action.add(model);
        action.add(modelTXT);
        action.add(company);
        action.add(companyTXT);
        action.add(year);
        action.add(yearTXT);
        action.add(price);
        action.add(priceTXT);

        JButton AddButton = new JButton("Add");
        // add a listener to button
        AddButton.addActionListener(e -> {
            try {
                Car car = new Car(modelTXT.getText(), companyTXT.getText(), yearTXT.getText(), Integer.parseInt(priceTXT.getText()));
                Message msg = new AddCarMessage(car);
                this.queue.put(msg);
            } catch (Exception exception) {
                errorOption(exception);
            }
        });
        action.add(AddButton);

        JButton deleteButton = new JButton("Delete");
        // add a listener to button
        deleteButton.addActionListener(e -> {
            try {
                Car car = new Car(modelTXT.getText(), companyTXT.getText(), yearTXT.getText(), Integer.parseInt(priceTXT.getText()));
                Message msg = new DeleteCarMessage(car);
                this.queue.put(msg);
            } catch (Exception exception) {
                errorOption(exception);
            }
        });
        action.add(deleteButton);

        action.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 129));
        frame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        frame.add(action, BorderLayout.CENTER);
        frame.add(new JLabel(imageSto), BorderLayout.SOUTH);
        frame.setSize(1200, 700);
        frame.setVisible(true);
    }

    private void storageViewOption(){
        JFrame frame = new JFrame("Car Storage");
        frame.getContentPane();
        frame.setPreferredSize(new Dimension(300, 300));

        // view the car storage
        JPanel view = new JPanel();
        for(Car car: storage){
            String s= car.getCompany() + " " + car.getModel() + " " + car.getYear() + "\n" + "$" + car.getPrice() + "/day";
            JTextArea listDisplay = new JTextArea();
            listDisplay.setText(s);
            view.add(listDisplay);
        }

        view.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        frame.add(view, BorderLayout.NORTH);
        frame.add(new JLabel(imageInvetory), BorderLayout.CENTER);
        frame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        frame.setSize(1200, 700);
        frame.setVisible(true);
    }

    private void reservationOption() {
        JFrame frame = new JFrame("Reservation");
        frame.getContentPane();
        frame.setPreferredSize(new Dimension(300, 300));


        // add reservation to the list
        JPanel action = new JPanel();
        // user information
        JLabel customer = new JLabel("Customer:");
        JLabel phone = new JLabel("Phone:");
        JLabel administer = new JLabel("Administer:");
        JLabel id = new JLabel("Admin ID:");
        JTextField customerTXT = new JTextField(20);
        JTextField phoneTXT = new JTextField(25);
        JTextField administerTXT = new JTextField(25);
        JTextField idTXT = new JTextField(20);
        action.add(customer);
        action.add(customerTXT);
        action.add(phone);
        action.add(phoneTXT);
        action.add(administer);
        action.add(administerTXT);
        action.add(id);
        action.add(idTXT);
        // car information
        JLabel cut = new JLabel("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        JLabel model = new JLabel("Car Model:");
        JLabel company = new JLabel("Car Maker:");
        JLabel year = new JLabel("Car Year:");
        JLabel price = new JLabel("Car Price:");
        JTextField modelTXT = new JTextField(20);
        JTextField companyTXT = new JTextField(25);
        JTextField yearTXT = new JTextField(25);
        JTextField priceTXT = new JTextField(20);
        action.add(cut);
        action.add(model);
        action.add(modelTXT);
        action.add(company);
        action.add(companyTXT);
        action.add(year);
        action.add(yearTXT);
        action.add(price);
        action.add(priceTXT);

        JButton createButton = new JButton("Create");
        // add a listener to button
        createButton.addActionListener(e -> {
            try{
                Car c = new Car(modelTXT.getText(), companyTXT.getText(), yearTXT.getText(), Integer.parseInt(priceTXT.getText()));
                Customer cus = new Customer(customerTXT.getText(), phoneTXT.getText());
                Administer admin = new Administer(administerTXT.getText(), idTXT.getText());
                CarReservation reservation = new CarReservation(c, cus, admin);
                Message msg = new CreateReservationMessage(reservation);
                queue.put(msg);
            } catch(Exception exception){
                errorOption(exception);
            };
        });
        action.add(createButton);

        JButton returnButton = new JButton("Return");
        // add a listener to button
        returnButton.addActionListener(e -> {
            try{
                Car c = new Car(modelTXT.getText(), companyTXT.getText(), yearTXT.getText(), Integer.parseInt(priceTXT.getText()));
                Customer cus = new Customer(customerTXT.getText(), phoneTXT.getText());
                Administer admin = new Administer(administerTXT.getText(), idTXT.getText());
                CarReservation reservation = new CarReservation(c, cus, admin);
                Message msg = new DeleteReservationMessage(reservation);
                queue.put(msg);
            } catch(Exception exception){
                errorOption(exception);
            };
        });
        action.add(returnButton);

        action.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 129));
        frame.add(action, BorderLayout.CENTER);
        frame.add(new JLabel(imageRes), BorderLayout.SOUTH);
        frame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        frame.setSize(900, 800);
        frame.setVisible(true);
    }

    private void reservationViewOption(){
        JFrame frame = new JFrame("Reservation List");
        frame.getContentPane();
        frame.setPreferredSize(new Dimension(300, 300));

        // view the reservation
        JPanel view = new JPanel();
        for(CarReservation res: reservations) {
            Customer customer = res.getCustomer();
            Administer administer = res.getAdminister();
            Car car = res.getCar();
            String s = car.getCompany() + " " + car.getModel() + " " + car.getYear() + "(" + "$" + car.getPrice() + "/day)" +
                    " is reserved by " + customer.getName() + "(Phone: " + customer.getPhone() + ")" + ", and assigned by " +
                    administer.getName() + "(" + administer.getID() + ").";
            JTextArea listDisplay = new JTextArea();
            listDisplay.setText(s);
            view.add(listDisplay);
        }

            view.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 129));
            frame.add(view, BorderLayout.NORTH);
            frame.add(new JLabel(imageList), BorderLayout.CENTER);
            frame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
            frame.setSize(900, 800);
            frame.setVisible(true);
    }

    private void errorOption(Exception e) {
        JFrame frame = new JFrame("Error");
        frame.getContentPane();
        frame.setPreferredSize(new Dimension(300, 300));
        frame.add(new JLabel("Error: " + e.getMessage()), BorderLayout.NORTH);
        frame.add(new JLabel(new ImageIcon("error.jpeg")), BorderLayout.CENTER);
        frame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        frame.setSize(900, 800);
        frame.setVisible(true);
    }

    public void updateCarStorage(TreeSet<Car> cars){
        this.storage = cars;
        storageViewOption();
    }

    public void updateReservation(TreeSet<CarReservation> reservations){
        this.reservations = reservations;
        reservationViewOption();
    }
}
