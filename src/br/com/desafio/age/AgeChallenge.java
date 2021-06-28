package br.com.desafio.age;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AgeChallenge {

	public static void main(String[] args) throws IOException {
		URL coderByte = new URL("https://coderbyte.com/api/challenges/json/age-counting");
		URLConnection yc = coderByte.openConnection();

		BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
		StringBuilder sb = new StringBuilder();
		sb.append(in.readLine());
		in.close();
				
		String data = sb.toString();
		data.trim();
		data = data.replace(" ", "");
		data = data.replace("\"}", "");
		List<String> dados = Arrays.asList(data.split(","));
		dados = dados.stream().filter(s -> s.contains("age")).collect(Collectors.toList()); 
		
		//java 7
		List<Integer> idades = new ArrayList<Integer>();
		Integer soma = 0;
		for (String s : dados) {
			int idade = Integer.valueOf(s.substring(4));
			idades.add(idade);
		}
				
		//Java 8 
		long somaJ8 = ageList.stream().filter(i -> i >= 50 ).mapToInt(Integer::intValue).count();
		System.out.println(somaJ8);
	}

}

