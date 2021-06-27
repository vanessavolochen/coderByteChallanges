package br.com.desafio.fibonacci;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ApproachingFibonacci {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);	
		System.out.println("Digite quantos numeros você quer incluir");
		Integer numQty = s.nextInt();
		List<Integer> numberSequence = new ArrayList<Integer>();
		for(int i = 0 ; i < numQty ; i ++) {
			System.out.println("Digite qual numero você quer incluir: ");
			Scanner numberScanner = new Scanner(System.in);
			Integer numeros = numberScanner.nextInt();
			numberSequence.add(numeros);
		}
		
		Integer somaInput = numberSequence.stream().mapToInt(Integer::intValue).sum();
		approchingFibonnaci(somaInput);

	}
	
	private static void approchingFibonnaci(Integer somaInput){
		Integer previousNumber = 0;
		Integer nextNumber = 1;
		Integer currentNumber= 0;
		//0 , 0 , 1, 2, 3, 5, 8, 13, 21, 34
		while (nextNumber < somaInput) {
			currentNumber = nextNumber;
			nextNumber = previousNumber + nextNumber;
			previousNumber = currentNumber;
			System.out.println(nextNumber);
		}
		
		Integer numberToAdd = nextNumber - somaInput;
		System.out.println("Soma dos numeros digitados:" + somaInput);
		System.out.println("Próximo fibonacci number : " + nextNumber);
		System.out.println("Numero para adicionar: " + numberToAdd);

	}

}
