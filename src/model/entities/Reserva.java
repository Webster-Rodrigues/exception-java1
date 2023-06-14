package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exception.DomainException;

public class Reserva {
	
	private Integer numeroQuarto;
	private Date checkIn;
	private Date checkOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reserva() {
		
	}


	public Reserva(Integer numeroQuarto, Date checkIn, Date checkOut) throws DomainException {
		if(!checkOut.after(checkIn)) {
			throw new DomainException("Data de check-out deve ser posteriores a data de check-in");
		}
		this.numeroQuarto = numeroQuarto;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getNumeroQuarto() {
		return numeroQuarto;
	}


	public void setNumeroQuarto(Integer numeroQuarto) {
		this.numeroQuarto = numeroQuarto;
	}


	public Date getCheckIn() {
		return checkIn;
	}


	public Date getCheckOut() {
		return checkOut;
	}



	public long duracao() {
		long diferenca = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(diferenca, TimeUnit.MILLISECONDS);
		//TimeUnit.DAYS converte a variavel que está no tipo TimeUnit.MILLISECONDS p/ dias
	}
	
	
	public void updateData(Date checkIn, Date checkOut) throws DomainException{
		
		Date now = new Date();
		
		if(checkIn.before(now) || checkOut.before(now)){
			throw new DomainException("Erro na reserva: Reserva deve conter datas futuras para atualização ");
			//IllegalArgumentException exceção p/ quando os argumentos passados para o método são inválidos
		}
		
		if(!checkOut.after(checkIn)) {
			throw new DomainException("Data de check-out deve ser posteriores a data de check-in");
		}

		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	
	@Override
	public String toString() {
		return "Quarto "
				+ numeroQuarto
				+ ", check-in: "
				+ sdf.format(checkIn)
				+ ", check-out: "
				+ sdf.format(checkOut)
				+", "
				+ duracao()
				+" noites";
		
	}


	
	
	
	

}
