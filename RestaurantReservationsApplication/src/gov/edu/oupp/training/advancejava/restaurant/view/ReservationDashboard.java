/**
 * 
 */
package gov.edu.oupp.training.advancejava.restaurant.view;

import java.sql.Connection;
import java.util.Scanner;

import gov.edu.oupp.training.advancejava.restaurant.model.EditReserveTable;
import gov.edu.oupp.training.advancejava.restaurant.model.Reservation;
import gov.edu.oupp.training.advancejava.restaurant.model.ReserveNewTable;

/**
 * @author Asish Kumar Gouda
 *
 */
public class ReservationDashboard {

	public static void main(String[] args) {

	}

	public void reservationMenu(Connection conn, Reservation reservation) {

		Scanner sc = new Scanner(System.in);

		// Restaurant MENU
		boolean isActiveLoop = true;
		while (isActiveLoop) {

			System.out.println("*******Admin Dashboard*******\n");
			System.out.println("1. Reserve Table(s)");
			System.out.println("2. Edit Reservation");
			System.out.println("3. Cancel Reservation");
			System.out.println("0. Exit Window");

			System.out.print("Enter your Choice: ");
			int accountChoice = sc.nextInt();

			try {
				switch (accountChoice) {
				case 1:
					ReserveNewTable rnt = new ReserveNewTable();
					rnt.reserveTables(conn, reservation);
					break;
				case 2:
					EditReserveTable ert = new EditReserveTable();
					 ert.editReservation(conn, reservation);
					// populate data in the form and update
					break;
				case 3:
					// cancelReservation(connn, reservation);
					// soft-delete form sql table using preparedstatement
					// soft-delete -> if isdelete=1 in DB hide the reservation;
					break;
				case 0:
					boolean isExit;
					System.out.print("Do you want to exit? [true/false] : ");
					isExit = sc.nextBoolean();
					if (isExit) {
						isActiveLoop = false;
					} else {
						continue;
					}
					break;
				default:
					System.out.println("Invalid Choice!! Try Again.\nPlease Enter your Choice[1-5].");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}
