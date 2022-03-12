package br.com.dambroski.main;


import br.com.dambroski.model.Person;
import br.com.simpleJavaCrud.dao.SimpleJavaCrudDAO;

public class Main {

	public static void main(String[] args) {
		SimpleJavaCrudDAO dao = new SimpleJavaCrudDAO();
		

		//Person person = new Person("jiuip","123.533.327-42");
		//dao.insert(person);
		
		for(Person c : dao.read()) {
			System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
			System.out.println(c);
		
		}
		System.out.println("doideira");
		Person person = dao.return_one_person(1);
		System.out.println(person);
		Person person2 = new Person("thiagoo","mude2i");
		person2.setID(1);
		dao.update(person2);
		person = dao.return_one_person(1);
		System.out.println(person);
		dao.delete(2);
		for(Person c : dao.read()) {
			System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
			System.out.println(c);
		
		}
		
		
		
		

	}

}
