package br.com.dambroski.model;

public class Person {
	
	private int id;
	private String name;
	private String cpf;
	
	public Person(){
		
	}
	
	public Person(String name, String cpf) {
		this.name = name;
		this.cpf = cpf;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public int getId() {
		return id;
	}
	
	public void setID(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		String str = "ID: " + this.getId() + "\nNome: " + this.getName() + "\nCpf: " + this.getCpf();
		
		return str;
		
	}
	
	
	

}
