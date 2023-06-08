package org.example;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String pathToFord = "C:/Users/gmalyshev/Desktop/Ford.txt";
        String pathToVolkswagen = "C:/Users/gmalyshev/Desktop/Volkswagen.txt";
        Path pathFiesta = Paths.get(pathToFord);
        Path pathPolo = Paths.get(pathToVolkswagen);

        Ford ford = null;
        Volkswagen volkswagen = null;

        Scanner scanFiesta = null;
        Scanner scanPolo = null;
        try {
            scanFiesta = new Scanner (pathFiesta);
            scanPolo = new Scanner (pathPolo);
            while (scanFiesta.hasNextLine()) {
                String[] infoFord = scanFiesta.nextLine().split(", ");
                ford = new Ford(infoFord);
            }

            while (scanPolo.hasNextLine()) {
                String[] infoVolkswagen = scanPolo.nextLine().split(", ");
                volkswagen = new Volkswagen(infoVolkswagen);
            }
        } catch (IOException e) {
            System.out.println("Error finding the docs");
        }


        System.out.println("Solving Ford Methods");
        ford.countHowManyLitresWillBeConsumed(ford.getAverageConsumption(), (double) 775, 54.83);
        ford.startCar(ford.getIsDrivable());
        ford.possibleToDriveOutOfMud(ford.getAutoStart(), ford.getModel(), ford.getMaximumSpeed());

        System.out.println("Solving Volkswagen Methods");
        volkswagen.countHowManyLitresWillBeConsumed(volkswagen.getAverageConsumption(), (double) 893, 51.99);
        volkswagen.startCar(volkswagen.getIsDrivable());
        volkswagen.possibleToDriveOutOfMud(volkswagen.getAutoStart(), volkswagen.getModel(), volkswagen.getMaximumSpeed());

        System.out.println();

        System.out.println("Are the ford.object equal to volkswagen.object?");
        if (ford.equals(volkswagen)) {
                System.out.println("Objects are EQUAL");
            }
            else System.out.println("Objects are NOT Equal");
        }

    }
}









