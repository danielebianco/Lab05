package it.polito.tdp.anagrammi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AnagrammiDAO {
	
	public boolean isCorrect(String anagramma) {
		
		final String sql = "SELECT * FROM parola WHERE nome=?";
		
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, anagramma);
			
			ResultSet rs = st.executeQuery();
			
			boolean returnValue = false;
			
			if(rs.next())
				returnValue = true;
			
			conn.close();
			return returnValue;
			
		} catch (SQLException e) {
			throw new RuntimeException("Errore Db");
		}
	}

}
