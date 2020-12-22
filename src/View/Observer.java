package View;

import controller.Controller;
import exceptions.NoRecepieException;

public interface Observer {

        void Update(Controller controller) throws NoRecepieException;

}
