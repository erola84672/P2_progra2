package prog2.vista;

import prog2.model.Camping;
import prog2.model.TascaManteniment;

import java.io.*;
import java.util.Scanner;
public class VistaCamping {
    private Camping camping;
    static private enum OpcionsMenuPrincipal {MENU_PRINCIPAL_SUBMENU1, MENU_PRINCIPAL_OPCIO1,MENU_PRINCIPAL_OPCIO2,MENU_PRINCIPAL_OPCIO3, MENU_PRINCIPAL_OPCIO4, MENU_PRINCIPAL_OPCIO5, MENU_PRINCIPAL_OPCIO6,MENU_PRINCIPAL_SORTIR};
    static private enum OpcionsSubmenu1 {MENU_S1_OPCIO1,MENU_S1_OPCIO2,MENU_S1_OPCIO3, MENU_S1_OPCIO4, MENU_S1_OPCIO5, MENU_S1_OPCIO6, MENU_S1_SORTIR};


    // Declarem descripcions personalitzades per a les opcions del menú principal
    static private String[] descMenuPrincipal={"Llistar informació (obrir menú secundari)",
            "Afegir tasca de manteniment",
            "Completar tasca de manteniment",
            "Nombre d'accessos que no proporcionen accessibilitat amb vehicle",
            "Metres d'accessos de terra",
            "Guardar càmping",
            "Recuperar càmping",
            "Sortir de l'aplicació"};

    // Declarem descripcions personalitzades per a les opcions del menú secundari
    static private String[] descMenu2={"Llistar informació dels allotjaments",
            "Llistar informació dels allotjaments operatius",
            "Llistar informació dels allotjaments no operatius",
            "Llistar informació dels accessos oberts",
            "Llistar informació dels accessos tancats",
            "Llistar informació de les tasques de manteniment actives",
            "Menú anterior"};
    public VistaCamping(String nom) {
        this.camping = new Camping(nom);
        camping.inicialitzaDadesCamping();
    }

    public void gestioCamping() {


        /**
         * Fitxer principal. Crea el menú principal i un menú secundari
         * @param args the command line arguments
         */
        // Creem un objecte per llegir des del teclat
        Scanner sc = new Scanner(System.in);

        // Creem un objecte principal
        prog2.vista.ExempleMenu app = new prog2.vista.ExempleMenu();

        // Iniciem la gestió del menú principal de l'aplicació
        Menu<OpcionsMenuPrincipal> menu = new Menu<OpcionsMenuPrincipal>("Menu Principal", OpcionsMenuPrincipal.values());

        // Assignem la descripció de les opcions
        menu.setDescripcions(descMenuPrincipal);

        // Obtenim una opció des del menú i fem les accions pertinents
        OpcionsMenuPrincipal opcio = null;
        do {
            // Mostrem les opcions del menú
            menu.mostrarMenu();

            // Demanem una opcio
            opcio = menu.getOpcio(sc);

            // Fem les accions necessÃ ries
            switch (opcio) {
                case MENU_PRINCIPAL_OPCIO1:
                    System.out.println("Introdueix el número de la tasca: ");
                    int numero = sc.nextInt();
                    System.out.println("Introdueix el nom de l'allotjament: ");
                    sc.nextLine();
                    String allotjament = sc.nextLine();
                    System.out.println("Introdueix la data d'avui: ");
                    String data = sc.nextLine();
                    System.out.println("Introdueix els dies esperats per realitzar la tasca: ");
                    int dies = sc.nextInt();
                    for(int i = 0 ; i< TascaManteniment.TipusTascaManteniment.values().length; i++){
                        System.out.println(i + 1 + ": " + TascaManteniment.TipusTascaManteniment.values()[i]);
                    }
                    int tipusn = 7;
                    do{
                        System.out.println("Introdueix el tipus de tasca: ");
                        tipusn = sc.nextInt();
                    }while(tipusn < 1 && tipusn>4);
                    try{
                        camping.afegirTascaManteniment(numero, TascaManteniment.TipusTascaManteniment.values()[tipusn-1].name(),allotjament,data, dies);
                    } catch (ExcepcioCamping e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case MENU_PRINCIPAL_OPCIO2:
                    try {
                        camping.llistarTasquesManteniment();
                        System.out.println("Introdueix el número de la tasca completada: ");
                        numero = sc.nextInt();
                        camping.completarTascaManteniment(numero);
                    } catch (ExcepcioCamping e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case MENU_PRINCIPAL_OPCIO3:
                    System.out.println("Nombre d'accessos no accessibles amb vehicles: " + camping.calculaAccessosNoAccessibles());
                    break;
                case MENU_PRINCIPAL_OPCIO4:
                    System.out.println("Metres totals d'accessos de terra: " + camping.calculaMetresTerra());
                    break;
                case MENU_PRINCIPAL_OPCIO5:
                    try {
                        camping.save("camping.txt");
                    } catch (ExcepcioCamping e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case MENU_PRINCIPAL_OPCIO6:
                    File file = new File("camping.txt");
                    FileInputStream fis = null;
                    ObjectInputStream ois = null;
                    VistaCamping campingai = null;
                    try {
                        fis = new FileInputStream(file);
                        ois = new ObjectInputStream(fis);
                        campingai = (VistaCamping) ois.readObject();

                    } catch(FileNotFoundException e){
                        System.out.println("Elfitxernoexisteix");
                    }catch(IOException e){
                        System.out.println("El fitxer no IO");
                    }catch(ClassNotFoundException e){
                        System.out.println("No em trobo");
                    }
                    finally{
                        try{
                            fis.close();
                            ois.close();}
                        catch(IOException e){
                            System.out.println("IO TANCANT");
                        }
                    }
                    break;
                case MENU_PRINCIPAL_SUBMENU1:
                    // Cridem el métode de gestió del menú secundari
                    gestioMenuSecundari(sc);
                    break;

                case MENU_PRINCIPAL_SORTIR:
                    System.out.println("Fins aviat!");
                    break;
            }

        } while (opcio != OpcionsMenuPrincipal.MENU_PRINCIPAL_SORTIR);


    }
            /**
             * Menú secundari
             * @param sc Objecte de tipus Scanner que permet accedir al teclat
             */
            private void gestioMenuSecundari(Scanner sc) {

                // Creem l'objecte per al menú. Li passem com a primer parÃ metre el nom del menú
                Menu<OpcionsSubmenu1> menu=new Menu<OpcionsSubmenu1>("Menu Secundari", OpcionsSubmenu1.values());

                // Assignem la descripció de les opcions
                menu.setDescripcions(descMenu2);

                // Obtenim una opció des del menú i fem les accions pertinents
                OpcionsSubmenu1 opcio = null;
                do {
                    // Mostrem les opcions del menú
                    menu.mostrarMenu();

                    // Demanem una opcio
                    opcio=menu.getOpcio(sc);

                    // Fem les accions necessàries
                    switch(opcio) {
                        case MENU_S1_OPCIO1:
                            try {
                                System.out.println("Allotjaments: " + camping.llistarAllotjaments("Operatiu") + camping.llistarAllotjaments("No operatiu"));
                            } catch (ExcepcioCamping e) {
                                System.out.println(e.getMessage());
                            }
                            break;
                        case MENU_S1_OPCIO2:
                            try {
                                System.out.println("Allotjaments operatius: " + camping.llistarAllotjaments("Operatiu"));
                            } catch (ExcepcioCamping e) {
                                System.out.println(e.getMessage());
                            }
                            break;
                        case MENU_S1_OPCIO3:
                            try {
                                System.out.println("Allotjaments no operatius: " + camping.llistarAllotjaments("No operatiu"));
                            } catch (ExcepcioCamping e) {
                                System.out.println(e.getMessage());
                            }
                            break;
                        case MENU_S1_OPCIO4:
                            try {
                                System.out.println("Accessos oberts: " + camping.llistarAccessos("Obert"));
                            } catch (ExcepcioCamping e) {
                                System.out.println(e.getMessage());
                            }
                            break;
                        case MENU_S1_OPCIO5:
                            try {
                                System.out.println("Accessos tancats: " + camping.llistarAccessos("Tancat"));
                            } catch (ExcepcioCamping e) {
                                System.out.println(e.getMessage());
                            }
                            break;
                        case MENU_S1_OPCIO6:
                            try {
                                System.out.println("Tasques de manteniment: " + camping.llistarTasquesManteniment());
                            } catch (ExcepcioCamping e) {
                                System.out.println(e.getMessage());
                            }
                            break;
                        case MENU_S1_SORTIR:
                            break;
                    }

                } while(opcio!= OpcionsSubmenu1.MENU_S1_SORTIR);
            }

        }


