package br.com.simpleJavaCrud.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import br.com.dambroski.model.Person;
import br.com.tables.factory.ConnectionFactory;

public class SimpleJavaCrudDAO {
	
	
	public void insert(Person person) {
		
		String sql = "INSERT INTO person(name,cpf) VALUES (?,?);";
		
		
		Connection coon = null;
		PreparedStatement pstm = null;
		
		
		try {
			coon = ConnectionFactory.createConnectionToMySQL();
			
			pstm = (PreparedStatement) coon.prepareStatement(sql);
			pstm.setString(1, person.getName());
			pstm.setString(2, person.getCpf());
			pstm.execute();
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstm != null) {
					pstm.close();
				}
				if(coon != null) {
					coon.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	
	}
	public List<Person> read(){
		String sql = "SELECT * FROM person;";
		
		List<Person> person_list = new ArrayList<Person>();
		
		Connection coon = null;
		PreparedStatement pstm = null;
		
		ResultSet rset = null;
		try {
			coon = ConnectionFactory.createConnectionToMySQL();
			
			pstm = (PreparedStatement) coon.prepareStatement(sql);
			
			rset = pstm.executeQuery();
			
			while(rset.next()) {
				Person person = new Person();
				
				person.setID(rset.getInt("idPerson"));
				
				person.setName(rset.getString("name"));
				
				person.setCpf(rset.getString("cpf"));
				
				person_list.add(person);
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rset != null) {
					rset.close();
				}
				if(pstm != null) {
					pstm.close();
				}
				if(coon != null) {
					coon.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return person_list;
		
	}
	
	public Person return_one_person(int x) {
		String sql = "SELECT * FROM person WHERE idPerson = (?);";
		
		
		Connection coon = null;
		PreparedStatement pstm = null;
		
		ResultSet rset = null;
		Person person = new Person();
		try {
			coon = ConnectionFactory.createConnectionToMySQL();
			
			pstm = (PreparedStatement) coon.prepareStatement(sql);
			pstm.setInt(1, x);
			
			rset = pstm.executeQuery();
			
			while(rset.next()) {
				
				person.setID(rset.getInt("idPerson"));
				
				person.setName(rset.getString("name"));
				
				person.setCpf(rset.getString("cpf"));	
				
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rset != null) {
					rset.close();
				}
				if(pstm != null) {
					pstm.close();
				}
				if(coon != null) {
					coon.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return person;
	}
	
	public void update(Person x) {
		String sql = "UPDATE person SET Name = (?), CPF = (?) WHERE Idperson = (?);";
		Connection coon = null;
		PreparedStatement pstm = null;
		
		
		try {
			coon = ConnectionFactory.createConnectionToMySQL();
			
			pstm = (PreparedStatement) coon.prepareStatement(sql);
			pstm.setString(1, x.getName());
			pstm.setString(2, x.getCpf());
			pstm.setInt(3, x.getId());
			pstm.execute();
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstm != null) {
					pstm.close();
				}
				if(coon != null) {
					coon.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		
	}
	
	public void delete(int x) {
		String sql = "DELETE FROM person WHERE Idperson = (?);";
		Connection coon = null;
		PreparedStatement pstm = null;
		
		
		try {
			coon = ConnectionFactory.createConnectionToMySQL();
			
			pstm = (PreparedStatement) coon.prepareStatement(sql);
			pstm.setInt(1,x);
			pstm.execute();
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstm != null) {
					pstm.close();
				}
				if(coon != null) {
					coon.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}

	