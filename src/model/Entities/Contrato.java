package model.Entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Contrato {

	//Formato para datas
	DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	//Atributos
	private int numeroContrato;
	private LocalDate dataContrato;
	private Double valortotalContrato;
	private int parcelas;

	//Construtores
	public Contrato() {

	}

	public Contrato(int numeroContrato, LocalDate dataContrato, Double valortotalContrato, int parcelas) {
		this.numeroContrato = numeroContrato;
		this.dataContrato = dataContrato;
		this.valortotalContrato = valortotalContrato;
		this.parcelas = parcelas;
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

	

	public void dadosParcela() {
        double parcelaBase = valortotalContrato / parcelas;
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        for (int i = 1; i <= parcelas; i++) {
            LocalDate dataParcela = dataContrato.plusMonths(i);

            // juros simples mensal
            double valorComJurosMensal = parcelaBase + (parcelaBase * 0.01 * i);

            // juros de pagamento (2%)
            double valorFinal = valorComJurosMensal + (valorComJurosMensal * 0.02);

            System.out.println(fmt.format(dataParcela) + " - R$" + String.format("%.2f", valorFinal));
       }
    }
}
