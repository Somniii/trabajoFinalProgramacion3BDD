/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package seahub.trabajofinaltorneo;

import seahub.trabajofinaltorneo.logica.Controladora;
import seahub.trabajofinaltorneo.logica.Participante;


/**
 *
 * @author tinov
 */
public class TrabajoFinalTorneo {

    public static void main(String[] args) throws Exception {
        System.out.println("Hello World!");
        
        Controladora control = new Controladora();
        
        Participante parti = new Participante(2 , "nico" ,"somni","somnielmejor", "somni@gmail.com" );
        
        control.crearParticipante(parti);
        
    }
}
