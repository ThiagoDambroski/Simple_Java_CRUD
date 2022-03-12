package br.com.dambroski.main;


import java.util.Scanner;

import br.com.dambroski.model.Person;
import br.com.simpleJavaCrud.dao.SimpleJavaCrudDAO;

public class Main {

	public static void main(String[] args) {
		
		SimpleJavaCrudDAO dao = new SimpleJavaCrudDAO();
		
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("1 - Adicionar");
		System.out.println("2 - Vizualizar");
		System.out.println("3 - Editarr");
		System.out.println("4 - Excluir");
		System.out.print("Digite sua opção: ");
		int op = sc.nextInt();
		sc.next();
		if(op == 1) {
			System.out.print("Digite o nome da pessoa: ");
			String name = sc.nextLine();
			System.out.println("Digite o cpf da pessoa: ");
			String cpf = sc.nextLine();
			Person person = new Person(name,cpf);
			dao.insert(person);
		}
		else if(op == 2) {
			for(Person c : dao.read()) {
				System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
				System.out.println(c);
				}
		}
		else if(op == 3) {
			System.out.print("Digite a ID da pessoa que voce quer editar: ");
			int id = sc.nextInt();
			Person person = dao.return_one_person(id);
			System.out.println(person);
			System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
			System.out.print("Digite o novo nome da pessoa: ");
			person.setName(sc.nextLine());
			System.out.println("Digite o novo cpf da pessoa: ");
			person.setCpf(sc.nextLine());
			dao.update(person);
				
		}
		else if( op == 4 ) {
			System.out.print("Digite o ID da pessoa que voce quer deletar: ");
			int id = sc.nextInt();
			sc.next();
			Person person = dao.return_one_person(1);
			System.out.println(person);
			System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
			System.out.println("Tem certeza que quer deletar ? 1 - sim | 2 - nao");
			int confirm = sc.nextInt();
			sc.next();
			if(confirm == 1) {
				dao.delete(person.getId());
			}
			else if(confirm == 2) {
				System.out.println("não deletado");
			}
			
			}
		
		
		
		
		for(Person c : dao.read()) {
			System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
			System.out.println(c);
		
		}
		
		
		
		

	}

}
