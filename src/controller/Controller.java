package controller;

import model.car.Car;
import model.car.CarStorage;
import model.reservation.ReservationList;
import view.View;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.BlockingQueue;

/**
 * Controller is a part of MVC model.
 */
public class Controller {
    BlockingQueue<Message> queue;
    CarStorage carModel;
    ReservationList reservationModel;
    View view;
    private List<Valve> valves = new LinkedList<>();

    /**
     *
     * @param queue
     * @param carModel
     * @param reservationModel
     * @param view
     */
    public Controller(BlockingQueue<Message> queue, CarStorage carModel, ReservationList reservationModel, View view){
        this.queue = queue;
        this.carModel = carModel;
        this.reservationModel = reservationModel;
        this.view = view;

        valves.add(new AddCarValve());
        valves.add(new DeleteCarValve());
        valves.add(new CreateReservationValve());
        valves.add(new DeleteReservationValve());
    }

    /**
     * MainLoop takes next message from the queue and look for a value that can process a message.If sucessfully process or game over, it leaves the loop.
     */
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

    /**
     * The funciton for this class it o DeleteResrvationValue.It implements the Valve class and overrides the execute class.
     */
    private class DeleteReservationValve implements Valve{

        /**
         *
         * @param message
         * @return
         */
        @Override
        public ValveResponse execute(Message message) {
            if (message.getClass() != DeleteReservationMessage.class) {
                return ValveResponse.MISS;
            }
            DeleteReservationMessage msg = (DeleteReservationMessage) message;
            reservationModel.delete(msg.getReservation());
            carModel.add(msg.getReservation().getCar());
            view.updateCarStorage(carModel.getCars());
            view.updateReservation(reservationModel.getSet());
            return ValveResponse.EXECUTED;
        }
    }

    /**
     * The function for this class it o CreateReservation.It implements the Valve class and overrides the execute class.
     */
    private class CreateReservationValve implements Valve{

        /**
         *
         * @param message
         * @return
         */
        @Override
        public ValveResponse execute(Message message) {
            if (message.getClass() != CreateReservationMessage.class) {
                return ValveResponse.MISS;
            }
            CreateReservationMessage msg = (CreateReservationMessage) message;
            Car c = msg.getReservation().getCar();
            for (Car car : carModel.getCars()){
                if (car.equals(c)){
                    reservationModel.add(msg.getReservation());
                    carModel.delete(car);
                    view.updateCarStorage(carModel.getCars());
                    view.updateReservation(reservationModel.getSet());
                    break;
                }
            }
            return ValveResponse.EXECUTED;
        }
    }

    /**
     * The function for this class it o delete car valve.It implements the Valve class and overrides the execute class.
     */
    private class DeleteCarValve implements Valve {

        /**
         *
         * @param message
         * @return
         */
        @Override
        public ValveResponse execute(Message message) {
            if (message.getClass() != DeleteCarMessage.class) {
                return ValveResponse.MISS;
            }
            DeleteCarMessage msg = (DeleteCarMessage) message;
            carModel.delete(msg.getCar());
            view.updateCarStorage(carModel.getCars());
            return ValveResponse.EXECUTED;
        }
    }

    /**
     *  The function for this class it o add car valve.It implements the Valve class and overrides the execute class.
     */
    private class AddCarValve implements Valve {

        /**
         *
         * @param message
         * @return
         */
        @Override
        public ValveResponse execute(Message message) {
            if (message.getClass() != AddCarMessage.class){
                return ValveResponse.MISS;
            }
            AddCarMessage msg = (AddCarMessage) message;
            carModel.add(msg.getCar());
            view.updateCarStorage(carModel.getCars());
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

