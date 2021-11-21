package view;

import controller.AddCarMessage;
import controller.Message;
import model.car.Car;

import javax.swing.*;
import java.awt.*;
import java.util.TreeSet;
import java.util.concurrent.BlockingQueue;

public class View extends JFrame {
    ImageIcon imageCar = new ImageIcon("Car.jpg");
    public static TreeSet<Car> storage = new TreeSet<>();
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
        JButton addCar = new JButton("Car Storage");
        addCar.setBounds(900, 150, 150, 150);
        addCar.addActionListener(e -> viewCarOption());

        JButton addRes = new JButton("add Reservation");
        addRes.setBounds(900,150,150,150);

        JButton deleteRes = new JButton("delete Reservation");
        deleteRes.setBounds(900, 150, 150, 150);

        JPanel buttonPane = new JPanel();
        buttonPane.setLayout(new BoxLayout(buttonPane, BoxLayout.Y_AXIS));
        // Adding buttons
        buttonPane.add(addCar);
        buttonPane.add(addRes);
        buttonPane.add(deleteRes);

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


    private void viewCarOption() {
        JFrame frame = new JFrame("Car Storage");
        frame.getContentPane();
        frame.setPreferredSize(new Dimension(300, 300));

        // view the car storage
        JPanel view = new JPanel();
        for(Car car: storage){
            String s= car.getCompany() + " " + car.getModel() + " " + car.getYear() + "\n" + "$" + car.getPrice() + "/day";
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
        JLabel price = new JLabel("Price:");
        JTextField modelTXT = new JTextField(20);
        JTextField companyTXT = new JTextField(20);
        JTextField yearTXT = new JTextField(25);
        JTextField priceTXT = new JTextField(20);

        add.add(model);
        add.add(modelTXT);
        add.add(company);
        add.add(companyTXT);
        add.add(year);
        add.add(yearTXT);
        add.add(price);
        add.add(priceTXT);

        JButton button = new JButton("Add");
        // add a listener to button
        button.addActionListener(e -> {
            try {
                Car car = new Car(modelTXT.getText(), companyTXT.getText(), yearTXT.getText(), Integer.parseInt(priceTXT.getText()));
                Message msg = new AddCarMessage(car);
                this.queue.put(msg);
            } catch (Exception exception) {
            }
            frame.dispose();
        });
        add.add(button);

        add.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 129));
        view.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        frame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        frame.add(view, BorderLayout.NORTH);
        frame.add(add, BorderLayout.CENTER);
        frame.setSize(500, 300);
        frame.setVisible(true);
    }

    public void updateAddCar(TreeSet<Car> cars){
        this.storage = cars;
        viewCarOption();
    }
}
