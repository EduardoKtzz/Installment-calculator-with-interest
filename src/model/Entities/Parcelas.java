package model.Entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Parcelas {

	//Formato da data
	private static DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	//Atributos
	private LocalDate dataVencimento;
	private Double amount;

	//Construtores
	public Parcelas() {

	}

	public Parcelas(LocalDate dataVencimento, Double amount) {
		this.dataVencimento = dataVencimento;
		this.amount = amount;
	}

	//Getters e setters
	public LocalDate getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(LocalDate dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return dataVencimento.format(fmt) + " - " + String.format("%.2f", amount);
	}

	

}
