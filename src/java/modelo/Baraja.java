/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Angel
 */
public class Baraja {

    // De primeras se mapean todas las cartas.
    private final String rutaCarta = "resources/images/baraja/";
    private final String rutaBoton = "resources/images/botones/";
    private final Carta carta1 = new Carta(rutaCarta + "carta1.png", rutaBoton + "1.png", rutaBoton + "2.png", rutaBoton + "3.png", rutaBoton + "4.png", rutaBoton + "25.png", rutaBoton + "31.png");
    private final Carta carta2 = new Carta(rutaCarta + "carta2.png", rutaBoton + "5.png", rutaBoton + "6.png", rutaBoton + "7.png", rutaBoton + "8.png", rutaBoton + "9.png", rutaBoton + "25.png");
    private final Carta carta3 = new Carta(rutaCarta + "carta3.png", rutaBoton + "25.png", rutaBoton + "10.png", rutaBoton + "11.png", rutaBoton + "12.png", rutaBoton + "13.png", rutaBoton + "14.png");
    private final Carta carta4 = new Carta(rutaCarta + "carta4.png", rutaBoton + "25.png", rutaBoton + "15.png", rutaBoton + "16.png", rutaBoton + "17.png", rutaBoton + "18.png", rutaBoton + "19.png");
    private final Carta carta5 = new Carta(rutaCarta + "carta5.png", rutaBoton + "25.png", rutaBoton + "20.png", rutaBoton + "21.png", rutaBoton + "22.png", rutaBoton + "23.png", rutaBoton + "24.png");
    private final Carta carta6 = new Carta(rutaCarta + "carta6.png", rutaBoton + "5.png", rutaBoton + "10.png", rutaBoton + "15.png", rutaBoton + "20.png", rutaBoton + "26.png", rutaBoton + "31.png");
    private final Carta carta7 = new Carta(rutaCarta + "carta7.png", rutaBoton + "26.png", rutaBoton + "21.png", rutaBoton + "16.png", rutaBoton + "11.png", rutaBoton + "6.png", rutaBoton + "1.png");
    private final Carta carta8 = new Carta(rutaCarta + "carta8.png", rutaBoton + "2.png", rutaBoton + "7.png", rutaBoton + "12.png", rutaBoton + "17.png", rutaBoton + "22.png", rutaBoton + "26.png");
    private final Carta carta9 = new Carta(rutaCarta + "carta9.png", rutaBoton + "26.png", rutaBoton + "23.png", rutaBoton + "18.png", rutaBoton + "13.png", rutaBoton + "8.png", rutaBoton + "3.png");
    private final Carta carta10 = new Carta(rutaCarta + "carta10.png", rutaBoton + "4.png", rutaBoton + "9.png", rutaBoton + "14.png", rutaBoton + "19.png", rutaBoton + "24.png", rutaBoton + "26.png");
    private final Carta carta11 = new Carta(rutaCarta + "carta11.png", rutaBoton + "6.png", rutaBoton + "31.png", rutaBoton + "27.png", rutaBoton + "24.png", rutaBoton + "18.png", rutaBoton + "12.png");
    private final Carta carta12 = new Carta(rutaCarta + "carta12.png", rutaBoton + "1.png", rutaBoton + "7.png", rutaBoton + "13.png", rutaBoton + "19.png", rutaBoton + "20.png", rutaBoton + "27.png");
    private final Carta carta13 = new Carta(rutaCarta + "carta13.png", rutaBoton + "27.png", rutaBoton + "21.png", rutaBoton + "15.png", rutaBoton + "14.png", rutaBoton + "8.png", rutaBoton + "2.png");
    private final Carta carta14 = new Carta(rutaCarta + "carta14.png", rutaBoton + "3.png", rutaBoton + "9.png", rutaBoton + "10.png", rutaBoton + "16.png", rutaBoton + "22.png", rutaBoton + "27.png");
    private final Carta carta15 = new Carta(rutaCarta + "carta15.png", rutaBoton + "27.png", rutaBoton + "4.png", rutaBoton + "5.png", rutaBoton + "11.png", rutaBoton + "17.png", rutaBoton + "23.png");
    private final Carta carta16 = new Carta(rutaCarta + "carta16.png", rutaBoton + "7.png", rutaBoton + "14.png", rutaBoton + "16.png", rutaBoton + "23.png", rutaBoton + "31.png", rutaBoton + "28.png");
    private final Carta carta17 = new Carta(rutaCarta + "carta17.png", rutaBoton + "28.png", rutaBoton + "24.png", rutaBoton + "17.png", rutaBoton + "10.png", rutaBoton + "8.png", rutaBoton + "1.png");
    private final Carta carta18 = new Carta(rutaCarta + "carta18.png", rutaBoton + "2.png", rutaBoton + "9.png", rutaBoton + "11.png", rutaBoton + "18.png", rutaBoton + "20.png", rutaBoton + "28.png");
    private final Carta carta19 = new Carta(rutaCarta + "carta19.png", rutaBoton + "28.png", rutaBoton + "21.png", rutaBoton + "19.png", rutaBoton + "12.png", rutaBoton + "3.png", rutaBoton + "5.png");
    private final Carta carta20 = new Carta(rutaCarta + "carta20.png", rutaBoton + "4.png", rutaBoton + "6.png", rutaBoton + "13.png", rutaBoton + "15.png", rutaBoton + "22.png", rutaBoton + "28.png");
    private final Carta carta21 = new Carta(rutaCarta + "carta21.png", rutaBoton + "31.png", rutaBoton + "29.png", rutaBoton + "22.png", rutaBoton + "19.png", rutaBoton + "11.png", rutaBoton + "8.png");
    private final Carta carta22 = new Carta(rutaCarta + "carta22.png", rutaBoton + "1.png", rutaBoton + "9.png", rutaBoton + "12.png", rutaBoton + "15.png", rutaBoton + "23.png", rutaBoton + "29.png");
    private final Carta carta23 = new Carta(rutaCarta + "carta23.png", rutaBoton + "29.png", rutaBoton + "24.png", rutaBoton + "16.png", rutaBoton + "13.png", rutaBoton + "5.png", rutaBoton + "2.png");
    private final Carta carta24 = new Carta(rutaCarta + "carta24.png", rutaBoton + "3.png", rutaBoton + "6.png", rutaBoton + "14.png", rutaBoton + "17.png", rutaBoton + "20.png", rutaBoton + "29.png");
    private final Carta carta25 = new Carta(rutaCarta + "carta25.png", rutaBoton + "29.png", rutaBoton + "21.png", rutaBoton + "10.png", rutaBoton + "7.png", rutaBoton + "4.png", rutaBoton + "18.png");
    private final Carta carta26 = new Carta(rutaCarta + "carta26.png", rutaBoton + "9.png", rutaBoton + "13.png", rutaBoton + "17.png", rutaBoton + "21.png", rutaBoton + "30.png", rutaBoton + "31.png");
    private final Carta carta27 = new Carta(rutaCarta + "carta27.png", rutaBoton + "30.png", rutaBoton + "22.png", rutaBoton + "18.png", rutaBoton + "14.png", rutaBoton + "5.png", rutaBoton + "1.png");
    private final Carta carta28 = new Carta(rutaCarta + "carta28.png", rutaBoton + "2.png", rutaBoton + "6.png", rutaBoton + "10.png", rutaBoton + "19.png", rutaBoton + "23.png", rutaBoton + "30.png");
    private final Carta carta29 = new Carta(rutaCarta + "carta29.png", rutaBoton + "30.png", rutaBoton + "15.png", rutaBoton + "11.png", rutaBoton + "7.png", rutaBoton + "3.png", rutaBoton + "24.png");
    private final Carta carta30 = new Carta(rutaCarta + "carta30.png", rutaBoton + "4.png", rutaBoton + "8.png", rutaBoton + "12.png", rutaBoton + "16.png", rutaBoton + "20.png", rutaBoton + "30.png");
    private final Carta carta31 = new Carta(rutaCarta + "carta31.png", rutaBoton + "30.png", rutaBoton + "29.png", rutaBoton + "26.png", rutaBoton + "27.png", rutaBoton + "28.png", rutaBoton + "25.png");

    private ArrayList<Carta> cartas;

    //Constructor de la clase Baraja.
    public Baraja() {
        // Inicializamos el arraylist y le añadimos todas las cartas.
        cartas = new ArrayList<Carta>();
        cartas.add(carta1);
        cartas.add(carta2);
        cartas.add(carta3);
        cartas.add(carta4);
        cartas.add(carta5);
        cartas.add(carta6);
        cartas.add(carta7);
        cartas.add(carta8);
        cartas.add(carta9);
        cartas.add(carta10);
        cartas.add(carta11);
        cartas.add(carta12);
        cartas.add(carta13);
        cartas.add(carta14);
        cartas.add(carta15);
        cartas.add(carta16);
        cartas.add(carta17);
        cartas.add(carta18);
        cartas.add(carta19);
        cartas.add(carta20);
        cartas.add(carta21);
        cartas.add(carta22);
        cartas.add(carta23);
        cartas.add(carta24);
        cartas.add(carta25);
        cartas.add(carta26);
        cartas.add(carta27);
        cartas.add(carta28);
        cartas.add(carta29);
        cartas.add(carta30);
        cartas.add(carta31);
       
        // Las ordenamos aleatoriamente gracias al método shuffle de la clase Collections.
        Collections.shuffle(cartas);

    }

    // Getter para poder acceder al método get() del ArrayList de cartas.
    public Carta get(int indice) {
        return cartas.get(indice);
    }

}
