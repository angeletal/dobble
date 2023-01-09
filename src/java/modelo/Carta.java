/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Angel
 */
public class Carta {

    private String url;
    private String opcion1;
    private String opcion2;
    private String opcion3;
    private String opcion4;
    private String opcion5;
    private String opcion6;

    // Constructor de la clase carta, a este se le pasa como parámetro la url de la carta y las url de sus respectivas opciones.
    public Carta(String url, String opcion1, String opcion2, String opcion3, String opcion4, String opcion5, String opcion6) {
        this.url = url;     
        this.opcion1 = opcion1;
        this.opcion2 = opcion2;
        this.opcion3 = opcion3;
        this.opcion4 = opcion4;
        this.opcion5 = opcion5;
        this.opcion6 = opcion6;
    }

    // Getters para las opciones.
    public String getOpcion1() {
        return opcion1;
    }

    public String getOpcion2() {
        return opcion2;
    }

    public String getOpcion3() {
        return opcion3;
    }

    public String getOpcion4() {
        return opcion4;
    }

    public String getOpcion5() {
        return opcion5;
    }

    public String getOpcion6() {
        return opcion6;
    }

    // Función para saber si la opción que se ha escogido aparece o no en una carta.
    public boolean compararOpciones(String opcion) {
        return opcion1.equals(opcion) || opcion2.equals(opcion) || opcion3.equals(opcion) || opcion4.equals(opcion) || opcion5.equals(opcion) || opcion6.equals(opcion);
    }

    // Modificación del toString() para devolver solamente la url.
    @Override
    public String toString() {
        return url;
    }

}
