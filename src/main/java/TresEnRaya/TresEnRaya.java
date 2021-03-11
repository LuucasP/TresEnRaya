package TresEnRaya;

import java.util.Scanner;

public class TresEnRaya {

    public static void main(String[] args) {
        Scanner leerEquipo = new Scanner(System.in);
        Scanner leerX = new Scanner(System.in);
        Scanner leerY = new Scanner(System.in);
        Scanner leerModo = new Scanner(System.in);
        Scanner leerOpciones = new Scanner(System.in);
        int x, y, opciones;

        int p1x, p1y, p2x, p2y;

        String[][] matriz = new String[3][3];
        boolean finJuego = false;
        boolean turno1 = false;
        boolean turno2 = !turno1;
        boolean turnoBot = false;
        boolean verificarTurno1 = false;
        boolean verificarTurno2 = false;
        boolean cerrarJuego = false;

        do {
            //Selección de modo de juego
            System.out.println("Seleccione el modo de juego: \n"
                    + "Seleccione 1 si quiere jugar contra un bot\n"
                    + "Seleccione 2 si quiere jugar contra otra persona");
            int modoDeJuego = leerModo.nextInt();

            if (modoDeJuego == 1) {
                System.out.println("Seleccione el Símbolo del equipo 1 con el que va a jugar");
                String Equipo1 = leerEquipo.next();

                //Empezando el tres en raya contra un bot
                do {

                    //Turno Jugador 1
                    if (turno1 != turno2 && finJuego == false) {

                        System.out.println("Ingrese las posiciones");
                        x = leerX.nextInt();
                        y = leerY.nextInt();

                        //Comprobación de turno válido
                        do {
                            boolean validarValor = false;
                            do {
                                if (x < 0 || x > 2 || y < 0 || y > 2) {
                                    System.out.println("Valor no permitido");
                                    x = leerX.nextInt();
                                    y = leerY.nextInt();

                                } else {
                                    validarValor = true;
                                }
                            } while (!validarValor);

                            if (matriz[x][y] != null) {
                                System.out.println("Ingrese nuevos valores");
                                x = leerX.nextInt();
                                y = leerY.nextInt();
                                verificarTurno1 = false;
                            } else {
                                verificarTurno1 = true;
                            }

                        } while (!verificarTurno1);

                        for (int i = 0; i < matriz.length; i++) {
                            for (int j = 0; j < matriz[i].length; j++) {
                                matriz[x][y] = Equipo1;
                                System.out.print("|\t" + matriz[i][j] + "\t" + "|");

                            }
                            System.out.println();
                        }

                        //Comprobación para jugador 1
                        //Horizontales
                        if (matriz[0][0] == Equipo1 && matriz[0][1] == Equipo1 && matriz[0][2] == Equipo1) {
                            System.out.println("Ganó el jugador 1 con el símbolo: " + Equipo1 + "\nPosición ganadora:(0,0), (0,1), (0,2)");
                            finJuego = true;
                        }
                        if (matriz[1][0] == Equipo1 && matriz[1][1] == Equipo1 && matriz[1][2] == Equipo1) {
                            System.out.println("Ganó el jugador 1 con el símbolo: " + Equipo1 + "\nPosición ganadora:(1,0), (1,1), (1,2)");
                            finJuego = true;
                        }

                        if (matriz[2][0] == Equipo1 && matriz[2][1] == Equipo1 && matriz[2][2] == Equipo1) {
                            System.out.println("Ganó el jugador 1 con el símbolo: " + Equipo1 + "\nPosición ganadora:(2,0), (2,1), (2,2)");
                            finJuego = true;
                        }

                        //Verticales
                        if (matriz[0][0] == Equipo1 && matriz[1][0] == Equipo1 && matriz[2][0] == Equipo1) {
                            System.out.println("Ganó el jugador 1 con el símbolo: " + Equipo1 + "\nPosición ganadora:(0,0), (1,0), (2,0)");
                            finJuego = true;
                        }
                        if (matriz[0][1] == Equipo1 && matriz[1][1] == Equipo1 && matriz[2][1] == Equipo1) {
                            System.out.println("Ganó el jugador 1 con el símbolo: " + Equipo1 + "\nPosición ganadora:(0,1), (1,1), (2,1)");
                            finJuego = true;
                        }

                        if (matriz[0][2] == Equipo1 && matriz[1][2] == Equipo1 && matriz[2][2] == Equipo1) {
                            System.out.println("Ganó el jugador 1 con el símbolo: " + Equipo1 + "\nPosición ganadora:(0,2), (1,2), (2,2)");
                            finJuego = true;
                        }

                        //Diagonales
                        if (matriz[0][0] == Equipo1 && matriz[1][1] == Equipo1 && matriz[2][2] == Equipo1) {
                            System.out.println("Ganó el jugador 1 con el símbolo: " + Equipo1 + "\nPosición ganadora:(0,0), (1,1), (2,2)");
                            finJuego = true;
                        }
                        if (matriz[2][0] == Equipo1 && matriz[1][1] == Equipo1 && matriz[0][2] == Equipo1) {
                            System.out.println("Ganó el jugador 1 con el símbolo: " + Equipo1 + "\nPosición ganadora:(2,0), (1,1), (0,2)");
                            finJuego = true;
                        }

                        turno1 = true;
                        turno2 = false;

                    }

                    System.out.println("\n\n");

                    //Turno Bot
                    if (turno2 != turno1 && finJuego == false) {
                        do {
                            int xRandom = (int) (Math.random() * (2 - 0 + 1) + 0);
                            int yRandom = (int) (Math.random() * (2 - 0 + 1) + 0);
                            if (matriz[xRandom][yRandom] != Equipo1 && matriz[xRandom][yRandom] != "O") {
                                System.out.println("El bot jugo en la posicion: (" + xRandom + "," + yRandom + ")\n");
                                matriz[xRandom][yRandom] = "O";
                                turnoBot = true;
                            }
                            if (matriz[0][0] != null && matriz[0][1] != null && matriz[0][2] != null
                                    && matriz[1][0] != null && matriz[1][1] != null && matriz[1][2] != null
                                    && matriz[2][0] != null && matriz[2][1] != null && matriz[2][2] != null) {
                                turnoBot = true;
                                finJuego = true;
                            }

                        } while (!turnoBot);
                        turnoBot = false;

                        for (int i = 0; i < matriz.length; i++) {
                            for (int j = 0; j < matriz[i].length; j++) {

                                System.out.print("|\t" + matriz[i][j] + "\t" + "|");

                            }
                            System.out.println();
                        }

                        //Comprobación Bot
                        //Horizontales
                        if (matriz[0][0] == "O" && matriz[0][1] == "O" && matriz[0][2] == "O") {
                            System.out.println("Ganó el jugador 2 con el símbolo: " + "O" + "\nPosición ganadora:(0,0), (0,1), (0,2)");
                            finJuego = true;
                        }
                        if (matriz[1][0] == "O" && matriz[1][1] == "O" && matriz[1][2] == "O") {
                            System.out.println("Ganó el jugador 2 con el símbolo: " + "O" + "\nPosición ganadora:(1,0), (1,1), (1,2)");
                            finJuego = true;
                        }

                        if (matriz[2][0] == "O" && matriz[2][1] == "O" && matriz[2][2] == "O") {
                            System.out.println("Ganó el jugador 2 con el símbolo: " + "O" + "\nPosición ganadora:(2,0), (2,1), (2,2)");
                            finJuego = true;
                        }

                        //Verticales
                        if (matriz[0][0] == "O" && matriz[1][0] == "O" && matriz[2][0] == "O") {
                            System.out.println("Ganó el jugador 2 con el símbolo: " + "O" + "\nPosición ganadora:(0,0), (1,0), (2,0)");
                            finJuego = true;
                        }
                        if (matriz[0][1] == "O" && matriz[1][1] == "O" && matriz[2][1] == "O") {
                            System.out.println("Ganó el jugador 2 con el símbolo: " + "O" + "\nPosición ganadora:(0,1), (1,1), (2,1)");
                            finJuego = true;
                        }

                        if (matriz[0][2] == "O" && matriz[1][2] == "O" && matriz[2][2] == "O") {
                            System.out.println("Ganó el jugador 2 con el símbolo: " + "O" + "\nPosición ganadora:(0,2), (1,2), (2,2)");
                            finJuego = true;
                        }

                        //Diagonales
                        if (matriz[0][0] == "O" && matriz[1][1] == "O" && matriz[2][2] == "O") {
                            System.out.println("Ganó el jugador 2 con el símbolo: " + "O" + "\nPosición ganadora:(0,0), (1,1), (2,2)");
                            finJuego = true;
                        }
                        if (matriz[2][0] == "O" && matriz[1][1] == "O" && matriz[0][2] == "O") {
                            System.out.println("Ganó el jugador 2 con el símbolo: " + "O" + "\nPosición ganadora:(2,0), (1,1), (0,2)");
                            finJuego = true;
                        }

                        turno2 = false;
                        turno1 = true;
                    }

                    System.out.println("\n\n");

                } while (!finJuego);

            }

            if (modoDeJuego == 2) {
                System.out.println("Seleccione el Símbolo del equipo 1 con el que va a jugar");
                String Equipo1 = leerEquipo.next();
                System.out.println("Seleccione el Símbolo del equipo 2 con el que va a jugar");
                String Equipo2 = leerEquipo.next();

                //Empezando el tres en raya contra otra persona
                do {

                    //Turno Jugador 1
                    if (turno1 != turno2 && finJuego == false) {

                        System.out.println("Ingrese las posiciones para el jugador 1");
                        p1x = leerX.nextInt();
                        p1y = leerY.nextInt();

                        //Comprobación de turno válido - Jugador 1
                        do {
                            boolean validarValor = false;
                            do {
                                if (p1x < 0 || p1x > 2 || p1y < 0 || p1y > 2) {
                                    System.out.println("Valor no permitido - Jugador 1");
                                    p1x = leerX.nextInt();
                                    p1y = leerY.nextInt();

                                } else {
                                    validarValor = true;
                                }
                            } while (!validarValor);

                            if (matriz[p1x][p1y] != null) {
                                System.out.println("Ingrese nuevos valores - Jugador 1");
                                p1x = leerX.nextInt();
                                p1y = leerY.nextInt();
                                verificarTurno1 = false;
                            } else {
                                verificarTurno1 = true;
                            }

                        } while (!verificarTurno1);

                        for (int i = 0; i < matriz.length; i++) {
                            for (int j = 0; j < matriz[i].length; j++) {
                                matriz[p1x][p1y] = Equipo1;
                                System.out.print("|\t" + matriz[i][j] + "\t" + "|");

                            }
                            System.out.println();
                        }

                        //Comprobación para jugador 1
                        //Horizontales
                        if (matriz[0][0] == Equipo1 && matriz[0][1] == Equipo1 && matriz[0][2] == Equipo1) {
                            System.out.println("Ganó el jugador 1 con el símbolo: " + Equipo1 + "\nPosición ganadora:(0,0), (0,1), (0,2)");
                            finJuego = true;
                        }
                        if (matriz[1][0] == Equipo1 && matriz[1][1] == Equipo1 && matriz[1][2] == Equipo1) {
                            System.out.println("Ganó el jugador 1 con el símbolo: " + Equipo1 + "\nPosición ganadora:(1,0), (1,1), (1,2)");
                            finJuego = true;
                        }

                        if (matriz[2][0] == Equipo1 && matriz[2][1] == Equipo1 && matriz[2][2] == Equipo1) {
                            System.out.println("Ganó el jugador 1 con el símbolo: " + Equipo1 + "\nPosición ganadora:(2,0), (2,1), (2,2)");
                            finJuego = true;
                        }

                        //Verticales
                        if (matriz[0][0] == Equipo1 && matriz[1][0] == Equipo1 && matriz[2][0] == Equipo1) {
                            System.out.println("Ganó el jugador 1 con el símbolo: " + Equipo1 + "\nPosición ganadora:(0,0), (1,0), (2,0)");
                            finJuego = true;
                        }
                        if (matriz[0][1] == Equipo1 && matriz[1][1] == Equipo1 && matriz[2][1] == Equipo1) {
                            System.out.println("Ganó el jugador 1 con el símbolo: " + Equipo1 + "\nPosición ganadora:(0,1), (1,1), (2,1)");
                            finJuego = true;
                        }

                        if (matriz[0][2] == Equipo1 && matriz[1][2] == Equipo1 && matriz[2][2] == Equipo1) {
                            System.out.println("Ganó el jugador 1 con el símbolo: " + Equipo1 + "\nPosición ganadora:(0,2), (1,2), (2,2)");
                            finJuego = true;
                        }

                        //Diagonales
                        if (matriz[0][0] == Equipo1 && matriz[1][1] == Equipo1 && matriz[2][2] == Equipo1) {
                            System.out.println("Ganó el jugador 1 con el símbolo: " + Equipo1 + "\nPosición ganadora:(0,0), (1,1), (2,2)");
                            finJuego = true;
                        }
                        if (matriz[2][0] == Equipo1 && matriz[1][1] == Equipo1 && matriz[0][2] == Equipo1) {
                            System.out.println("Ganó el jugador 1 con el símbolo: " + Equipo1 + "\nPosición ganadora:(2,0), (1,1), (0,2)");
                            finJuego = true;
                        }

                        turno1 = true;
                        turno2 = false;
                    }

                    System.out.println("\n\n");

                    //Turno Jugador 2
                    if (turno2 != turno1 && finJuego == false) {

                        System.out.println("Ingrese las posiciones para el jugador 2");
                        p2x = leerX.nextInt();
                        p2y = leerY.nextInt();

                        //Comprobación de turno válido - Jugador 2
                        do {

                            boolean validarValor = false;
                            do {
                                if (p2x < 0 || p2x > 2 || p2y < 0 || p2y > 2) {
                                    System.out.println("Valor no permitido - Jugador 2");
                                    p2x = leerX.nextInt();
                                    p2y = leerY.nextInt();

                                } else {
                                    validarValor = true;
                                }
                            } while (!validarValor);

                            if (matriz[p2x][p2y] != null) {
                                System.out.println("Ingrese nuevos valores - Jugador 2");
                                p2x = leerX.nextInt();
                                p2y = leerY.nextInt();
                                verificarTurno2 = false;
                            } else {
                                verificarTurno2 = true;
                            }

                        } while (!verificarTurno2);

                        for (int i = 0; i < matriz.length; i++) {
                            for (int j = 0; j < matriz[i].length; j++) {
                                matriz[p2x][p2y] = Equipo2;
                                System.out.print("|\t" + matriz[i][j] + "\t" + "|");

                            }
                            System.out.println();
                        }

                        //Comprobación para jugador 2
                        //Horizontales
                        if (matriz[0][0] == Equipo2 && matriz[0][1] == Equipo2 && matriz[0][2] == Equipo2) {
                            System.out.println("Ganó el jugador 2 con el símbolo: " + Equipo2 + "\nPosición ganadora:(0,0), (0,1), (0,2)");
                            finJuego = true;
                        }
                        if (matriz[1][0] == Equipo2 && matriz[1][1] == Equipo2 && matriz[1][2] == Equipo2) {
                            System.out.println("Ganó el jugador 2 con el símbolo: " + Equipo2 + "\nPosición ganadora:(1,0), (1,1), (1,2)");
                            finJuego = true;
                        }

                        if (matriz[2][0] == Equipo2 && matriz[2][1] == Equipo2 && matriz[2][2] == Equipo2) {
                            System.out.println("Ganó el jugador 2 con el símbolo: " + Equipo2 + "\nPosición ganadora:(2,0), (2,1), (2,2)");
                            finJuego = true;
                        }

                        //Verticales
                        if (matriz[0][0] == Equipo2 && matriz[1][0] == Equipo2 && matriz[2][0] == Equipo2) {
                            System.out.println("Ganó el jugador 2 con el símbolo: " + Equipo2 + "\nPosición ganadora:(0,0), (1,0), (2,0)");
                            finJuego = true;
                        }
                        if (matriz[0][1] == Equipo2 && matriz[1][1] == Equipo2 && matriz[2][1] == Equipo2) {
                            System.out.println("Ganó el jugador 2 con el símbolo: " + Equipo2 + "\nPosición ganadora:(0,1), (1,1), (2,1)");
                            finJuego = true;
                        }

                        if (matriz[0][2] == Equipo2 && matriz[1][2] == Equipo2 && matriz[2][2] == Equipo2) {
                            System.out.println("Ganó el jugador 2 con el símbolo: " + Equipo2 + "\nPosición ganadora:(0,2), (1,2), (2,2)");
                            finJuego = true;
                        }

                        //Diagonales
                        if (matriz[0][0] == Equipo2 && matriz[1][1] == Equipo2 && matriz[2][2] == Equipo2) {
                            System.out.println("Ganó el jugador 2 con el símbolo: " + Equipo2 + "\nPosición ganadora:(0,0), (1,1), (2,2)");
                            finJuego = true;
                        }
                        if (matriz[2][0] == Equipo2 && matriz[1][1] == Equipo2 && matriz[0][2] == Equipo2) {
                            System.out.println("Ganó el jugador 2 con el símbolo: " + Equipo2 + "\nPosición ganadora:(2,0), (1,1), (0,2)");
                            finJuego = true;
                        }

                        turno2 = false;
                        turno1 = true;
                    }

                    System.out.println("\n\n");

                } while (!finJuego);

            }
            System.out.println("-----------------Fin del juego-----------------"
                    + "\nSeleccione 1 si quiere volver a jugar"
                    + "\nSeleccione 2 si quiere cerrar el juego");

            opciones = leerOpciones.nextInt();
            if (opciones == 1) {
                finJuego = false;

                //Limpiando la matriz
                for (int i = 0; i < matriz.length; i++) {
                    for (int j = 0; j < matriz[i].length; j++) {
                        matriz[i][j] = null;
                    }
                }
            }

            if (opciones == 2) {
                cerrarJuego = true;
            }

        } while (!cerrarJuego);
    }
}
