package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    // fields
    final static String[] ROUTE_1 = {"140", "134", "Unicentro", "100", "30", "R", "Marsella", "Mu", "Bosa"};
    final static String[] ROUTE_2 = {"Germania", "19", "Sabana", "R", "Espec", "F"};
    final static String[] ROUTE_3 = {"Gu", "Santiago", "SENA", "Mu", "Timiza"};

    final static String INTERSECTION_R12 = "R";
    final static int INTER12_R1_INDEX = 5;
    final static int INTER12_R2_INDEX = 3;

    final static String INTERSECTION_R13 = "Mu";
    final static int INTER13_R1_INDEX = 7;
    final static int INTER13_R3_INDEX = 3;

    private static String initialStation;
    private static String finalStation;

    private static int initialStationRoute;
    private static int finalStationRoute;

    private static int initialStationIndex;
    private static int finalStationIndex;


    // main main main
    public static void main(String[] args) {

        System.out.println("Welcome to the Routes program written by Soungmin Lee!");

        Scanner userChoice = new Scanner(System.in);

        boolean userMapChoice = true;
        String userMap;

        while (userMapChoice) {
            System.out.println();
            System.out.print("Would you like to see a map of the routes? (Y/N): ");
            userMap = userChoice.nextLine();

            if (userMap.equals("Y") || userMap.equals("y") || userMap.equals("Yes") || userMap.equals("YES") || userMap.equals("yes")) {
                printMap();
                userMapChoice = false;
            } else if (userMap.equals("N") || userMap.equals("n") || userMap.equals("No") || userMap.equals("NO") || userMap.equals("no")) {
                userMapChoice = false;
            } else {
                System.out.println("Invalid input!");
            }

        }

        System.out.println();


        boolean runRoutes = true;

        while (runRoutes) {

            // initializing
            initialStation = "";
            finalStation = "";

            initialStationRoute = 0;
            finalStationRoute = 0;

            initialStationIndex = -1;
            finalStationIndex = -1;

            routeSetup();

            ArrayList<String> finalPath = findPath();
            System.out.println("The path from " + "\"" + initialStation + "\"" + " to " + "\"" + finalStation + "\"" + " is:");

            for (int i = 0; i < finalPath.size(); i++) {
                System.out.print(finalPath.get(i));

                if (i != finalPath.size()-1) {
                    System.out.print(" -> ");
                }
            }

            System.out.println(" " + "\n");

            boolean validInput = false;
            while (!validInput) {
                System.out.print("Would you like to search for more routes? (Y/N): ");
                String userInput = userChoice.nextLine();

                if (userInput.equals("Y") || userInput.equals("y") || userInput.equals("Yes") || userInput.equals("YES") || userInput.equals("yes")) {
                    validInput = true;
                    System.out.println(" ");
                } else if (userInput.equals("N") || userInput.equals("n") || userInput.equals("No") || userInput.equals("NO") || userInput.equals("no")) {
                    runRoutes = false;
                    validInput = true;
                    System.out.println(" ");
                    System.out.println("Thank you for using Routes!");
                } else {
                    System.out.println("Invalid input!");
                    System.out.println(" ");
                }
            }
        }

    }

    // print map
    private static void printMap() {
        System.out.println(" ");
        System.out.println(" — — — — — — — — — — — — — — — — — — — — — — — — — — — — — — — — — ");
        System.out.println("|                                 R2                R3             |");
        System.out.println("|                                    Germania          Gu          |");
        System.out.println("|                                       |              |           |");
        System.out.println("|                                       19          Santiago       |");
        System.out.println("|                                       |              |           |");
        System.out.println("|                                     Sabana          SENA         |");
        System.out.println("| R1                                    |              |           |");
        System.out.println("|    140 — 134 — Unicentro — 100 — 30 — R — Marsella — Mu — Bosa   |");
        System.out.println("|                                       |              |           |");
        System.out.println("|                                      Espec         Timiza        |");
        System.out.println("|                                       |                          |");
        System.out.println("|                                       F                          |");
        System.out.println(" — — — — — — — — — — — — — — — — — — — — — — — — — — — — — — — — — ");
    }

    // user station & route setup
    private static void routeSetup() {
        Scanner sc = new Scanner(System.in);

        while (initialStationRoute == 0) {
            System.out.print("Please enter your initial station: ");
            initialStation = sc.nextLine();
            initialStationRoute = findRoute(initialStation);

            if (initialStationRoute == 0) {
                System.out.println("Station " + "\"" + initialStation + "\"" +  " not found!");
                System.out.println(" ");
            }
        }

        if (initialStation.equals(INTERSECTION_R12))  {
            System.out.println("Initial station \"R\" is an intersection between Route 1 and 2.");
        } else if (initialStation.equals(INTERSECTION_R13)) {
            System.out.println("Initial station \"Mu\" is an intersection between Route 2 and 3.");
        } else {
            System.out.println("Initial station " + "\"" + initialStation + "\"" + " is on Route " + initialStationRoute + ".");
        }

        System.out.println(" ");

        while (finalStationRoute == 0) {
            System.out.print("Please enter your final station: ");
            finalStation = sc.nextLine();
            finalStationRoute = findRoute(finalStation);

            if (finalStationRoute == 0) {
                System.out.println("Station " + "\"" + finalStation + "\"" +  " not found!");
                System.out.println(" ");
            }
        }

        if (finalStation.equals(INTERSECTION_R12))  {
            System.out.println("Final station \"R\" is an intersection between Route 1 and 2.");
        } else if (finalStation.equals(INTERSECTION_R13)) {
            System.out.println("Final station \"Mu\" is an intersection between Route 2 and 3.");
        } else {
            System.out.println("Final station " + "\"" + finalStation + "\"" + " is on Route " + finalStationRoute + ".");
        }

        System.out.println(" ");
    }

    // find which route the station is in
    private static int findRoute(String station) {

        for (String stationInR1 : ROUTE_1) { // check route 1
            if (station.equals(stationInR1)) {
                return 1;
            }
        }

        for (String stationInR2 : ROUTE_2) { // check route 2
            if (station.equals(stationInR2)) {
                return 2;
            }
        }

        for (String stationInR3 : ROUTE_3) { // check route 3
            if (station.equals(stationInR3)) {
                return 3;
            }
        }

        return 0; // if it is not here
    }

    // find index of stations
    private static int findIndex(String station, int route) {
        switch (route) {
            case (1): {
                int counter = 0;
                for (String element : ROUTE_1) {
                    if (element.equals(station)) {
                        return counter;
                    } else {
                        ++counter;
                    }
                }
            }
            case (2): {
                int counter = 0;
                for (String element : ROUTE_2) {
                    if (element.equals(station)) {
                        return counter;
                    } else {
                        ++counter;
                    }
                }
            }
            case (3): {
                int counter = 0;
                for (String element : ROUTE_3) {
                    if (element.equals(station)) {
                        return counter;
                    } else {
                        ++counter;
                    }
                }
            }
        }
        return -1;
    }

    // find path
    private static ArrayList<String> findPath() {

        // set index
        initialStationIndex = findIndex(initialStation, initialStationRoute);
        finalStationIndex = findIndex(finalStation, finalStationRoute);

        // set path array
        ArrayList<String> path = new ArrayList<String>();

        // IMPORTANT: WRITE EXCEPTIONAL CASES FOR INTERSECTIONS

        // hardcode - DO NOT TOUCH - CODE IS FRAGILE
        switch (initialStationRoute) {
            case(1): {
                switch (finalStationRoute) {
                    case(1): {  // route 1 to 1
                        if (initialStationIndex < finalStationIndex) {
                            for (int i = initialStationIndex; i <= finalStationIndex; i++) {
                                path.add(ROUTE_1[i]);
                            }
                        } else if (initialStationIndex > finalStationIndex) {
                            for (int i = initialStationIndex; i >= finalStationIndex; i--) {
                                path.add(ROUTE_1[i]);
                            }
                        }
                        break;
                    }
                    case(2): {  // route 1 to 2
                        // route 1 initial station to intersection "R"
                        if (initialStationIndex < INTER12_R1_INDEX) {
                            for (int i = initialStationIndex; i < INTER12_R1_INDEX; i++) {
                                path.add(ROUTE_1[i]);
                            }
                        } else if (initialStationIndex > INTER12_R1_INDEX) {
                            for (int i = initialStationIndex; i > INTER12_R1_INDEX; i--) {
                                path.add(ROUTE_1[i]);
                            }
                        }
                        // intersection "R" to route 2 final station
                        if (finalStationIndex < INTER12_R2_INDEX) {
                            for (int i = INTER12_R2_INDEX; i >= finalStationIndex; i--) {
                                path.add(ROUTE_2[i]);
                            }
                        } else if (finalStationIndex > INTER12_R2_INDEX) {
                            for (int i = INTER12_R2_INDEX; i <= finalStationIndex; i++) {
                                path.add(ROUTE_2[i]);
                            }
                        }
                        break;
                    }
                    case(3): {  // 1 to 3
                        // route 1 initial station to intersection "Mu"
                        if (initialStationIndex < INTER13_R1_INDEX) {
                            for (int i = initialStationIndex; i < INTER13_R1_INDEX; i++) {
                                path.add(ROUTE_1[i]);
                            }
                        } else if (initialStationIndex > INTER13_R1_INDEX) {
                            for (int i = initialStationIndex; i > INTER13_R1_INDEX; i--) {
                                path.add(ROUTE_1[i]);
                            }
                        }
                        // station "Mu" to route 3 final station
                        if (finalStationIndex < INTER13_R3_INDEX) {
                            for (int i = INTER13_R3_INDEX; i >= finalStationIndex; i--) {
                                path.add(ROUTE_3[i]);
                            }
                        } else if (finalStationIndex > INTER13_R3_INDEX) {
                            for (int i = INTER13_R3_INDEX; i <= finalStationIndex; i++) {
                                path.add(ROUTE_3[i]);
                            }
                        }
                        break;
                    }
                }
                break;
            }

            case(2): {
                switch (finalStationRoute) {
                    case(1): {  // route 2 to 1
                        // route 2 initial station to intersection "R"
                        if (initialStationIndex < INTER12_R2_INDEX) {
                            for (int i = initialStationIndex; i < INTER12_R2_INDEX; i++) {
                                path.add(ROUTE_2[i]);
                            }
                        } else if (initialStationIndex > INTER12_R2_INDEX) {
                            for (int i = initialStationIndex; i > INTER12_R2_INDEX; i--) {
                                path.add(ROUTE_2[i]);
                            }
                        }
                        // intersection "R" to route 1 final station
                        if (finalStationIndex <= INTER12_R1_INDEX) {
                            for (int i = INTER12_R1_INDEX; i >= finalStationIndex; i--) {
                                path.add(ROUTE_1[i]);
                            }
                        } else {
                            for (int i = INTER12_R1_INDEX; i <= finalStationIndex; i++) {
                                path.add(ROUTE_1[i]);
                            }
                        }
                        break;
                    }

                    case(2): {  // 2 to 2
                        if (initialStationIndex < finalStationIndex) {
                            for (int i = initialStationIndex; i <= finalStationIndex; i++) {
                                path.add(ROUTE_2[i]);
                            }
                        } else if (initialStationIndex > finalStationIndex) {
                            for (int i = initialStationIndex; i >= finalStationIndex; i--) {
                                path.add(ROUTE_2[i]);
                            }
                        }
                        break;
                    }

                    case(3): {  // 2 to 3
                        // route 2 initial station to intersection "R"
                        if (initialStationIndex < INTER12_R2_INDEX) {
                            for (int i = initialStationIndex; i < INTER12_R2_INDEX; i++) {
                                path.add(ROUTE_2[i]);
                            }
                        } else if (initialStationIndex > INTER12_R2_INDEX) {
                            for (int i = initialStationIndex; i > INTER12_R2_INDEX; i--) {
                                path.add(ROUTE_2[i]);
                            }
                        }
                        // intersection "R" to intersection "Mu"
                        for (int i = INTER12_R1_INDEX; i < INTER13_R1_INDEX; i++) {
                            path.add(ROUTE_1[i]);
                        }
                        // intersection "Mu" to route 3 final station
                        if (finalStationIndex < INTER13_R3_INDEX) {
                            for (int i = INTER13_R3_INDEX; i >= finalStationIndex; i--) {
                                path.add(ROUTE_3[i]);
                            }
                        } else if (finalStationIndex > INTER13_R3_INDEX) {
                            for (int i = INTER13_R3_INDEX; i <= finalStationIndex; i++) {
                                path.add(ROUTE_3[i]);
                            }
                        }
                        break;
                    }
                }
                break;
            }

            case(3): {
                switch (finalStationRoute) {
                    case(1): {  // 3 to 1
                        // route 3 initial station to intersection "Mu"
                        if (initialStationIndex < INTER13_R3_INDEX) {
                            for (int i = initialStationIndex; i < INTER13_R3_INDEX; i++) {
                                path.add(ROUTE_3[i]);
                            }
                        } else if (initialStationIndex > INTER13_R3_INDEX) {
                            for (int i = initialStationIndex; i > INTER13_R3_INDEX; i--) {
                                path.add(ROUTE_3[i]);
                            }
                        }
                        // intersection "Mu" to route 1 final station
                        if (finalStationIndex <= INTER13_R1_INDEX) {
                            for (int i = INTER13_R1_INDEX; i >= finalStationIndex; i--) {
                                path.add(ROUTE_1[i]);
                            }
                        } else {
                            for (int i = INTER13_R1_INDEX; i <= finalStationIndex; i++) {
                                path.add(ROUTE_1[i]);
                            }
                        }
                        break;
                    }

                    case(2): {  // 3 to 2
                        // route 3 initial station to intersection "Mu"
                        if (initialStationIndex < INTER13_R3_INDEX) {
                            for (int i = initialStationIndex; i < INTER13_R3_INDEX; i++) {
                                path.add(ROUTE_3[i]);
                            }
                        } else if (initialStationIndex > INTER13_R3_INDEX) {
                            for (int i = initialStationIndex; i > INTER13_R3_INDEX; i--) {
                                path.add(ROUTE_3[i]);
                            }
                        }
                        // intersection "Mu" to intersection "R"
                        for (int i = INTER13_R1_INDEX; i > INTER12_R1_INDEX; i--) {
                            path.add(ROUTE_1[i]);
                        }
                        // intersection "R" to route 2 final station
                        if (finalStationIndex < INTER12_R2_INDEX) {
                            for (int i = INTER12_R2_INDEX; i >= finalStationIndex; i--) {
                                path.add(ROUTE_2[i]);
                            }
                        } else if (finalStationIndex > INTER12_R2_INDEX) {
                            for (int i = INTER12_R2_INDEX; i <= finalStationIndex; i++) {
                                path.add(ROUTE_2[i]);
                            }
                        }
                        break;
                    }

                    case(3): {  // 3 to 3
                        if (initialStationIndex < finalStationIndex) {
                            for (int i = initialStationIndex; i <= finalStationIndex; i++) {
                                path.add(ROUTE_3[i]);
                            }
                        } else if (initialStationIndex > finalStationIndex) {
                            for (int i = initialStationIndex; i >= finalStationIndex; i--) {
                                path.add(ROUTE_3[i]);
                            }
                        }
                        break;
                    }
                }
                break;
            }
        }

        return path;
    }
}