import controller.Controller;
import controller.Message;
import model.reservation.ReservationList;
import model.car.CarStorage;
import view.View;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class App {
    public static void main(String[] args) {
        BlockingQueue<Message> queue = new LinkedBlockingQueue<>();

        CarStorage carModel = new CarStorage();
        ReservationList reservationModel = new ReservationList();

        View view = new View(queue);
        Controller controller = new Controller(queue, carModel, reservationModel, view);
        controller.mainLoop();
    }
}
