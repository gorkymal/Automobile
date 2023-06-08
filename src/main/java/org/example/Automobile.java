package org.example;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.Objects;

@Getter
@FieldDefaults (level = AccessLevel.PRIVATE)
@Setter
public class Automobile implements FrontWheelDrive{
    String model;
    Integer amountOfWheels;
    Integer maximumSpeed = 130;
    Integer amountOfDoors = 4;
    Double engineVolume = 0.75;
    Double averageConsumption = 7.0;
    Boolean seatsHeating = false;
    Boolean autoStart = false;
    Boolean isDrivable = true;

    public Automobile(String[] line) {
        this.model = line[0].trim();
        this.amountOfWheels = Integer.parseInt(line[1].trim());
        this.maximumSpeed = Integer.parseInt(line[2].trim());
        this.amountOfDoors = Integer.parseInt(line[3].trim());
        this.engineVolume = Double.parseDouble(line[4].trim());
        this.averageConsumption = Double.parseDouble(line[5].trim());
        this.seatsHeating = Boolean.parseBoolean(line[6].trim());
        this.autoStart = Boolean.parseBoolean(line[7].trim());
        this.isDrivable = Boolean.parseBoolean(line[8].trim());
    }

    public Automobile() {
    }

    void countHowManyLitresWillBeConsumed(Double averageConsumption, Double distance, Double petrolPricePer100) {
        double part = distance / 100;
        double litresConsumed = part * averageConsumption;
        double totalPrice = litresConsumed * petrolPricePer100;
        System.out.print("Consumed amount of petrol is: " + litresConsumed + "\n");
        System.out.println("Total petrol price is: " + totalPrice);
    }

    void startCar(Boolean isDrivable) {
        if (isDrivable) {
            System.out.println("The car got started!");
        }
        else System.out.println("Can't start the car");
    }

    @Override
    public void possibleToDriveOutOfMud(Boolean autoStart, String model, Integer maximumSpeed) {
        if (!getAutoStart() &&
                (getModel().equalsIgnoreCase(("Fiesta")) || getModel().equalsIgnoreCase("Polo")) && getMaximumSpeed() > 200) {
            System.out.println("You can drive out of mud easily!");
        }
        else System.out.println("You will be stuck in mud, sorry.");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Automobile auto = (Automobile) o;
        return Objects.equals(model, auto.model) &&
                Objects.equals(amountOfWheels, auto.amountOfWheels) &&
                Objects.equals(maximumSpeed, auto.maximumSpeed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, amountOfWheels, maximumSpeed);
    }


}















