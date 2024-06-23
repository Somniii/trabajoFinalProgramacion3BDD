/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package seahub.trabajofinaltorneo;

import seahub.trabajofinaltorneo.igu.principal.Login;
import seahub.trabajofinaltorneo.logica.Controladora;
import seahub.trabajofinaltorneo.logica.Participante;


/**
 *
 * @author tinov
 */
public class TrabajoFinalTorneo {

    public static void main(String[] args) throws Exception {
        //System.out.println("Hello World!");
        
        //Controladora control = new Controladora();
       // prueba();
        Login login = new Login();
        login.setVisible(true);
        login.setLocationRelativeTo(null);
        //Participante parti = new Participante( "nico" ,"somni","somnielmejor", "somni@gmail.com" );
        
        //control.crearParticipante(parti);
        //control.eliminarParticipante(3);
        //Participante aux = control.traerParticipante(2);
       
        
        //System.out.println("Nombre="+aux.getNombre());
        
    }

}
