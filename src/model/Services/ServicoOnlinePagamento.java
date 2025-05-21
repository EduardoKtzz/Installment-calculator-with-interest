package model.Services;

public interface ServicoOnlinePagamento {

	Double taxaPagamento(Double amount);
	Double juros(Double amount, int months);

} 
