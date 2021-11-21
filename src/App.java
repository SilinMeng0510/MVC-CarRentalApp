import controller.Controller;
import controller.Message;
import model.car.CarStorage;
import view.View;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class App {
    public static void main(String[] args) {
        BlockingQueue<Message> queue = new LinkedBlockingQueue<>();

        CarStorage carModel = new CarStorage();

        View view = new View(queue);
        Controller controller = new Controller(queue, carModel, view);
        controller.mainLoop();
    }
}
