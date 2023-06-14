package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reserva;
import model.exception.DomainException;

public class Programa {

	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			
			System.out.print("Numero do quarto: ");
			int numeroQuarto = sc.nextInt();
			
			System.out.print("Check-in (dd/MM/yyyy): ");
			Date checkIn = sdf.parse(sc.next());
			
			System.out.print("Check-out (dd/MM/yyyy): ");
			Date checkOut= sdf.parse(sc.next());
			
			Reserva reserva = new Reserva(numeroQuarto, checkIn, checkOut);
			System.out.println("Reserva: " + reserva);
			
			System.out.println();
			System.out.println("Entre com as datas para atualizar a reserva:");
			
			System.out.print("Check-in (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());
			
			System.out.print("Check-out (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());
			
			reserva.updateData(checkIn, checkOut);
			System.out.println("Reserva: " + reserva);
		}
		catch (ParseException e) {
			System.out.println("Formato de data inválido");
		}
		catch (DomainException e) {
			System.out.println("Erro na reserva " + e.getMessage());
		}
		catch (RuntimeException e) {
			System.out.println("Erro inesperado"); //exceção genérica
		}
		
		


	
	
		sc.close();

	}

}