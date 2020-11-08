package controller.listener;

import java.util.EventListener;

import model.OnibusEvent;

/**
 * OnibusListener
 */
public interface OnibusListener extends EventListener{
    public void reservaCancelada(OnibusEvent e);
    
    public void passagemReservada(OnibusEvent e);
    
    public void passagemComprada(OnibusEvent e);
    
}