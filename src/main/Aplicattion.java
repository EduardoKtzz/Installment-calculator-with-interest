import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import model.Entities.Contrato;
import model.Entities.Parcelas;
import model.Services.ContractService;
import model.Services.ServicoPaypal;

public class Aplicattion {
	public static void main(String[] args) {

		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		Scanner sc = new Scanner(System.in);
		System.out.println();

		System.out.println("Digite os dados do seu contrato:");

		//Número contrato
		System.out.println("Número do contrato:");
		int numeroContrato =  sc.nextInt();
		sc.nextLine();

		//Data inicio do contrato
		System.out.println("Data inicio do contrato(dd/MM/yyyy):");
		LocalDate dataContrato = LocalDate.parse(sc.nextLine(), fmt);

		//Valor total do contrato
		System.out.println("Valor total do contrato:");
		Double valorTotalContrato = sc.nextDouble();

		//Instanciando classe do contrato
		Contrato contrato = new Contrato(numeroContrato, dataContrato, valorTotalContrato);

		//Receber número de meses do parcelamento
		System.out.println("Qual o número de parcelas em meses?");
		int parcelas = sc.nextInt();

		//Fazendo o processamento de contrato
		ContractService service = new ContractService(new ServicoPaypal());
		service.processamentoContrato(contrato, parcelas);

		for(int i = 0; i<parcelas; i++)

		System.out.println();
		System.out.println("PARCELAS:");
		for (Parcelas parcela : contrato.getParcelas()){
			System.out.println(parcela);
		}

		sc.close();
	}
}
