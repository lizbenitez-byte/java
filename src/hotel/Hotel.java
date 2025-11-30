/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package hotel;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ACER
 */
public class Hotel {

    public static ArrayList<Clients> client = new ArrayList();
    public static ArrayList<Habitacions> habitacio = new ArrayList();
    public static ArrayList<Estades> estada = new ArrayList();
    public static ArrayList<Serveis> servei = new ArrayList();
    public static Scanner sc = new Scanner(System.in);
    public static Estades estadActual = null;

    public static void main(String[] args) {

        //crem hablitacions
        for (int i = 1; i < 10; i++) {
        habitacio.add(new Habitacions(i+9,60,true));
        }
        for (int i = 1; i < 10; i++) {
        habitacio.add(new Habitacions(i+20,80,true));
        }
        //crem serveis
        servei.add(new Serveis(01, "Bogaderia", 10.0));
        servei.add(new Serveis(02, "Esmorzar", 11.0));
        servei.add(new Serveis(03, "Dinar", 20.0));
        servei.add(new Serveis(04, "Sopar", 18.0));
        
        //crear clients 
        client.add(new Clients ("111A", "Liz", "20-03-2000", "Vic"));
        client.add(new Clients ("222B", "Laura", "12-09-2007", "Torello"));
        client.add(new Clients ("333C", "Xevi", "20-03-2000", "Vic"));
        
        Menu();
    }

    public static Clients AltaClient() {
        System.out.println("Entra nif:");
        String nif = sc.next();
        System.out.println("Entra nom:");
        String nom = sc.next();
        System.out.println("Entra Dataneixament:");
        String dataNaix = sc.next();
        System.out.println("Entra Localitat:");
        String localitat = sc.next();
        //Cremm clients
        Clients nouclient = (new Clients(nif, nom, dataNaix, localitat));
        client.add(nouclient);

        //Mostra el client acabat de crear
        System.out.println(client.getLast().toString());

        return nouclient;
    }

    public static Clients ModificarDades() {
        System.out.println("Posa el nif del client que cal modificar: ");
        String nif = sc.next();

        int cMod = 0;

        for (int i = 0; i < client.size(); i++) {
            if (nif.equals(client.get(i).getNif())) {
                System.out.println(client.get(i).toString());

                cMod = i;
            }
        }

        System.out.println("Entra el nou nif: ");
        nif = sc.next();
        client.get(cMod).setNif(nif);
        System.out.println("Entra el nou nom: ");
        String nom = sc.next();
        client.get(cMod).setNom(nom);
        System.out.println("Entra el nova data de neixament: ");
        String dataNaix = sc.next();
        client.get(cMod).setDataNaix(dataNaix);
        System.out.println("Entra el nova localitat: ");
        String localitat = sc.next();
        client.get(cMod).setLocalitat(localitat);

        return client.get(cMod);
    }

    public static void Menu() {
        int input = 0;
        while (input != 5) {
            System.out.println("1. Alta nou client");
            System.out.println("2. LListar Clients");
            System.out.println("3. Modificar les dades");
            System.out.println("4. Operacions amb client");
            input = sc.nextInt();

            switch (input) {

                case 1:
                    AltaClient();
                    break;
                case 2:

                    for (int i = 0; i < client.size(); i++) {
                        System.out.println(client.get(i).toString());
                    }
                    break;
                case 3:
                    String nif;
                    ModificarDades();
                    break;

                case 4:

                    boolean clientExisteix = true;

                    System.out.println("Entra el nif del client");

                    nif = sc.next();  // demana el NIf

                    for (int i = 0; i < client.size(); i++) {
                        if (nif.equals(client.get(i).getNif())) {
                            submenu(nif);
                        } else {
                            clientExisteix = false;
                        }
                    }
                    if (!clientExisteix) {
                        System.out.println("No s'ha trobat el client.");
                    }
                    break;
                default:
                    System.out.println("opcio no valida !");
            }
        }
    }

    public static void submenu(String nif) {

        int input = 0;
        while (input != 11) {
            System.out.println("1. Llistar Habitacions");
            System.out.println("2. Checkin");
            System.out.println("3. Servei Bogederia");
            System.out.println("4. Servei Esmorzar");
            System.out.println("5. Servei Dinar");
            System.out.println("6. Servei Sopar");
            System.out.println("7. Consultar import actual");
            System.out.println("8. Checkout");
            System.out.println("9. Tornar al menu");
            System.out.println("10. Sortir del sistema");
            System.out.println("------------------------------");

            System.out.println("Escull una d'aquestes opcions: \n");

            int entrada = sc.nextInt();

            switch (entrada) {

                case 1:
                    System.out.println(habitacio.toString());

                    break;

                case 2:
                    //check-in
                    boolean clientAllotjat = false;
                    for (int i = 0; i < client.size(); i++) {

                        if (client.get(i).getNif().equals(nif) && !client.get(i).isCheckin()) {

                            System.out.println("Introdueix el número de l'habitació que vols assignar:");
                            int numHab = sc.nextInt();

                            for (int j = 0; j < habitacio.size(); j++) {
                                if (habitacio.get(j).getNumHabitacio() == numHab && habitacio.get(j).isLliure()) {
                                    habitacio.get(j).setLliure(false);
                                    estada.add(new Estades(nif, habitacio.get(i)));
                                    client.get(i).setCheckin(true);

                                    clientAllotjat = true;

                                    System.out.println("CHECK-IN " + nif);
                                    System.out.println(estada.getLast());

                                    break; // 
                                }
                            }
                            break; // 🔥 PARA DE BUSCAR CLIENTE
                        }
                    }
                    if (!clientAllotjat) {
                        System.out.println("J'ha s'ha fet el check-in aquest client.");;
                    }
                    break;

                case 3:
                    for (int i = 0; i < estada.size(); i++) {
                        if (estada.get(i).getNifclients().equals(nif)) {
                            estadActual = estada.get(i);
                            break;
                        }
                    }
                    for (int j = 0; j < servei.size(); j++) {
                        Serveis s = servei.get(j);
                        if (s.getIdServei() == 01) {
                            estadActual.getServei().add(s);
                            estadActual.setImportActual(estadActual.getImportActual() + s.getPreu());
                            System.out.println("Al client " + nif + " s'ha afegit un servei: " + estadActual.getServei());
                        }
                    }
                    break;

                case 4:
                    for (int i = 0; i < estada.size(); i++) {
                        if (estada.get(i).getNifclients().equals(nif)) {
                            estadActual = estada.get(i);
                            break;
                        }
                    }
                    for (int j = 0; j < servei.size(); j++) {
                        Serveis s = servei.get(j);
                        if (s.getIdServei() == 02) {
                            estadActual.getServei().add(s);
                            estadActual.setImportActual(estadActual.getImportActual() + s.getPreu());
                            System.out.println("Al client " + nif + " s'ha afegit un servei: " + estadActual.getServei());
                        }
                    }

                    break;
                case 5:
                    for (int i = 0; i < estada.size(); i++) {
                        if (estada.get(i).getNifclients().equals(nif)) {
                            estadActual = estada.get(i);
                            break;
                        }
                    }
                    for (int j = 0; j < servei.size(); j++) {
                        Serveis s = servei.get(j);
                        if (s.getIdServei() == 03) {
                            estadActual.getServei().add(s);
                            estadActual.setImportActual(estadActual.getImportActual() + s.getPreu());
                            System.out.println("Al client " + nif + " s'ha afegit un servei: " + estadActual.getServei());
                        }
                    }

                    break;

                case 6:
                    for (int i = 0; i < estada.size(); i++) {
                        if (estada.get(i).getNifclients().equals(nif)) {
                            estadActual = estada.get(i);
                            break;
                        }
                    }
                    for (int j = 0; j < servei.size(); j++) {
                        Serveis s = servei.get(j);
                        if (s.getIdServei() == 04) {
                            estadActual.getServei().add(s);
                            estadActual.setImportActual(estadActual.getImportActual() + s.getPreu());
                            System.out.println("Al client " + nif + " s'ha afegit un servei: " + estadActual.getServei());
                        }
                    }
                    break;

                case 7:
                    System.out.println("L'import actual del client " + nif + " es: " + estadActual.getImportActual() + " euros");

                    break;

                case 8:
                    System.out.println("Introdueix data de sortida(yyyy-MM-dd): \n");
                    String dataSortida = sc.next();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                    LocalDate parseDate = LocalDate.parse(dataSortida, formatter);

                    //Desem la data de entrada a l'estada
                    for (int i = 0; i < estada.size(); i++) {
                        if (nif.equals(estada.get(i).getNifclients())) {
                            estada.get(i).setDataSortida(parseDate);

                            System.out.println("DADES DE LA ESTADA -CHECKOUT: \n");
                            System.out.println(estada.toString());

                            System.out.println("Preu Total:");
                            System.out.println(estada.get(i).CalculFactura(ChronoUnit.DAYS.between(estada.get(i).getDataEntrada(), parseDate))+" euros");
                           
                            //client cobrat si s'ha cobrat
                            for (i = 0; i < client.size(); i++) {
                                if(client.get(i).isCobrat()){
                                    client.get(i).setCobrat(true);    
                                }
                            }
                            //posar la habitacio lliure
                            for (int j = 0; j < habitacio.size(); j++) {
                                if (habitacio.get(j).isLliure()){
                                  habitacio.get(j).setLliure(true);  
                                }
                            }
                        }
                    }
                        break;

                case 9:
                        Menu(); 
                    break;
                    
                case 10:
                        
                    break;
                default:
                    System.out.println("Opció no vàlida!");
            }
        }
    }

}
