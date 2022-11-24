package nta_07;
import Formulario.Login;
import Formulario.Menu;
import Formulario.Ticket;

public class NTA_07 {
    public static void main(String[] args) {
        Login l = new Login();
        l.setVisible(true);
        
        Menu m = new Menu();
        m.setVisible(true);
        
        Ticket t = new Ticket();
        t.setVisible(true);
    }  
}
