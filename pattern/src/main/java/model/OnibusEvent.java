package model;

import java.util.EventObject;

/**
 * OnibusEvent
 */
public class OnibusEvent extends EventObject{

    private static final long serialVersionUID = 1L;

    public OnibusEvent(Onibus source) {
        super(source);
    }
}