package model.Services;

import java.time.LocalDate;

import model.Entities.Contrato;
import model.Entities.Parcelas;

public class ContractService {

	//Associações
	private ServicoOnlinePagamento servicoOnlinePagamento;

	//Construtor
	public ContractService(ServicoOnlinePagamento servicoOnlinePagamento) {
		this.servicoOnlinePagamento = servicoOnlinePagamento;
	}

	//Métados para processamento de contrato
	public void processamentoContrato(Contrato contrato, int months) {

		double parcelaBasica = contrato.getValortotalContrato() / months;
		
		for (int i=1;i<=months; i++) {
			LocalDate vencimentoParcela = contrato.getDataContrato().plusMonths(i);

			//Calculo para conseguir o valor total com base nos juros e taxas
			double juros =  servicoOnlinePagamento.juros(parcelaBasica, i);
			double taxa = servicoOnlinePagamento.taxaPagamento(parcelaBasica + juros);

			//Valor total
			double quota = parcelaBasica + juros + taxa;

			contrato.getParcelas().add(new Parcelas(vencimentoParcela, quota));

		}
	}
}
