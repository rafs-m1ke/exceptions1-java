package application;

import models.entities.Reservation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.print("Room number: ");
        int number = sc.nextInt();
        System.out.print("Check-in date (DD/MM/YYYY): ");
        LocalDate checkIn = LocalDate.parse(sc.next(), fmt);
        System.out.print("Check-out date (DD/MM/YYYY): ");
        LocalDate checkOut = LocalDate.parse(sc.next(), fmt);

        if(!checkOut.isAfter(checkIn)) {
            System.out.println("Error in reservation: Check-out date must be after check-in date!");
        } else {
            Reservation reservation = new Reservation(number, checkIn, checkOut);
            System.out.println("Reservation: "+ reservation);

            System.out.println("\nEnter data to update the reservation:");
            System.out.print("Check-in date (DD/MM/YYYY): ");
            checkIn = LocalDate.parse(sc.next(), fmt);
            System.out.print("Check-out date (DD/MM/YYYY): ");
            checkOut = LocalDate.parse(sc.next(), fmt);

            String error = reservation.updateDates(checkIn, checkOut);
            if(error != null) {
                System.out.println("Erro in reservation: " + error);
            } else {
                System.out.println("Reservation: "+ reservation);
            }
        }
        sc.close();
    }
}
