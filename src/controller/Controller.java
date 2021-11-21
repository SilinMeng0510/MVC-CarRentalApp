package controller;

import model.car.CarStorage;
import view.View;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.BlockingQueue;

public class Controller {
    BlockingQueue<Message> queue;
    CarStorage carModel;
    View view;
    private List<Valve> valves = new LinkedList<>();

    public Controller(BlockingQueue<Message> queue, CarStorage carModel, View view){
        this.queue = queue;
        this.carModel = carModel;
        this.view = view;

        valves.add(new AddCarValve());

    }

    public void mainLoop() {
        ValveResponse response = ValveResponse.EXECUTED;
        Message message = null;
        while (response != ValveResponse.FINISH) {
            try {
                message = queue.take(); // <--- take next message from the queue
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // Look for a Valve that can process a message
            for (Valve valve : valves) {
                response = valve.execute(message);
                // if successfully processed or game over, leave the loop
                if (response != ValveResponse.MISS) {
                    break;
                }
            }
        }
    }

    private class AddCarValve implements Valve {
        @Override
        public ValveResponse execute(Message message) {
            if (message.getClass() != AddCarMessage.class){
                return ValveResponse.MISS;
            }
            AddCarMessage msg = (AddCarMessage) message;
            carModel.add(msg.getCar());
            view.updateAddCar(carModel.getCars());
            return ValveResponse.EXECUTED;
        }
    }

    private interface Valve {
        /**
         * Performs certain action in response to message
         */
        public ValveResponse execute(Message message);
    }
}

