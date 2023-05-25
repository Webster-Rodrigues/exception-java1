package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reserva;

public class Programa {

	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Numero do quarto: ");
		int numeroQuarto = sc.nextInt();
		
		System.out.print("Check-in (dd/MM/yyyy): ");
		Date checkIn = sdf.parse(sc.next());
		
		System.out.print("Check-out (dd/MM/yyyy): ");
		Date checkOut= sdf.parse(sc.next());
		
		if(!checkOut.after(checkIn)) {
			System.out.println("Erro na reserva: Reserva deve conter datas futuras para atualização");
		}
		
		else {
			Reserva reserva = new Reserva(numeroQuarto, checkIn, checkOut);
			System.out.println("Reserva: " + reserva);
			
			System.out.println();
			System.out.println("Entre com as datas para atualizar a reserva:");
			
			System.out.print("Check-in (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());
			
			System.out.print("Check-out (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());
			
			String erro = reserva.updateData(checkIn, checkOut);
			if(erro != null) {
				System.out.println("Erro na reserva: " + erro);
			}
			
			else {
				System.out.println("Reserva: " + reserva);
			}
			
			
			
		}
		
		
		
		
		
		sc.close();

	}

}