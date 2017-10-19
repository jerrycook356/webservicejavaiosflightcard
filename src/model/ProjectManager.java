package model;
import java.sql.Connection;

import java.util.ArrayList;

import DAO.DatabaseHelper;
import dto.FlightCard;
import DAO.Project;
public class ProjectManager {

	public ArrayList<FlightCard> getFlightCards(){
		ArrayList<FlightCard> cards = null;
		
		try{
			DatabaseHelper dbh = new DatabaseHelper();
			Connection con = dbh.getConnection();
			Project proj = new Project();
			cards = proj.getFlightcards(con);			
		}catch(Exception e){
			e.printStackTrace();
		}
		return cards;
	}
}
