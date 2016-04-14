package application.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LetteraDAO {

	public boolean checkParola(String s){
		try {
			//Connessione al DB
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost/dizionario?user=root");
			PreparedStatement st = c.prepareStatement("SELECT nome FROM parola WHERE nome=?;");
			st.setString(1, s);
			ResultSet res = st.executeQuery();
			if(res.next()){
				res.close();
				c.close();
				return true;
			}
			else{
				res.close();
				c.close();
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
