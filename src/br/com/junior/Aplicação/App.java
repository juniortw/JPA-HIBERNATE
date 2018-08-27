package br.com.junior.Aplicação;

import br.com.junior.Bean.Pessoa;

public class App {

	public static void main(String[] args) {
		
		Pessoa p1 = new Pessoa(1, "Maria", "maria@email.com");
		Pessoa p2 = new Pessoa(2, "Joao", "Joao@email.com");
		Pessoa p3 = new Pessoa(3, "Junior", "Junior@email.com");
		
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p3);
		
		
	}

}
