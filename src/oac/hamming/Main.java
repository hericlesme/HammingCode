package oac.hamming;

import java.util.Scanner;

public class Main {

	private static BitSignal signal;
	private static Scanner scan;
	private static final String NL = "|" + System.lineSeparator();

	public static void main(String[] args) {
		scan = new Scanner(System.in);
		showHeader();
		while (true) {
			if (showOptions() == 2)
				return;
			hammingHandler();
		}
	}

	private static void hammingHandler() {
		System.out.print(NL + "| Insira o número de bits de dados: ");
		int size = Integer.parseInt(scan.nextLine());

		System.out.print("| Insira os bits de dados: ");
		String bits = scan.nextLine();

		signal = new BitSignal(size);
		signal.insertBits(bits);

		Hamming hamming = new Hamming(signal);
		System.out.println(NL + "| O Código gerado é: " + hamming.getGenerateCode());
		System.out.println(
				NL + "| Escolha a posição a ser alterada de um bit para checar a detecção de erros no receptor");
		System.out.println("| Insira '0' para não gerar erros");
		System.out.print("| Posição a ser alterada:  ");

		int error = Integer.parseInt(scan.nextLine());
		hamming.throwError(error);
	}

	private static void showHeader() {
		System.out.println("| UFCG - Organização e Arquitetura de Computadores" + NL
				+ "| Professora: Joseana Macêdo Fechine" + NL + "| Atividade: Implementação do Código de Hamming");
	}

	private static int showOptions() {
		System.out.println(NL + "||: Selecione Uma Opção");
		System.out.print("| [1] - Executar || [2] - Sair ");
		return Integer.parseInt(scan.nextLine());
	}
}