package model.Services;

public class ServicoPaypal implements ServicoOnlinePagamento {

	@Override
	public Double taxaPagamento(Double amount){
		return amount * 0.02;
	}

	@Override
	public Double juros(Double amount, int months) {
		return amount * 0.01 * months;
	}

}
