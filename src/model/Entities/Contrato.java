package model.Entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Contrato {

	//Formato para datas
	DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	//Atributos
	private int numeroContrato;
	private LocalDate dataContrato;
	private Double valortotalContrato;

	//lista por que um contrato tem várias parcelas
	private List<Parcelas> parcelas = new ArrayList<>();

	//Construtores
	public Contrato() {

	}

	public Contrato(int numeroContrato, LocalDate dataContrato, Double valortotalContrato) {
		this.numeroContrato = numeroContrato;
		this.dataContrato = dataContrato;
		this.valortotalContrato = valortotalContrato;
	}
	
	//Getters e setters
	public int getNumeroContrato() {
		return numeroContrato;
	}

	public void setNumeroContrato(int numeroContrato) {
		this.numeroContrato = numeroContrato;
	}

	public LocalDate getDataContrato() {
		return dataContrato;
	}

	public void setDataContrato(LocalDate dataContrato) {
		this.dataContrato = dataContrato;
	}

	public Double getValortotalContrato() {
		return valortotalContrato;
	}

	public void setValortotalContrato(Double valortotalContrato) {
		this.valortotalContrato = valortotalContrato;
	}

	public List<Parcelas> getParcelas() {
		return parcelas;
	}

}
