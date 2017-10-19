package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.FlightCard;

public class Project {

	public ArrayList<FlightCard> getFlightcards(Connection con) {
		ArrayList<FlightCard> cards = new ArrayList<FlightCard>();
		FlightCard card;
		try {
			String sql = "SELECT * FROM flightcardtable";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				card = new FlightCard();
				//card.setId( rs.getInt("id"));
				card.setDateOut(rs.getString("dateOut"));
				card.setDateIn( rs.getString("dateIn"));
				card.setDestination( rs.getString("destination"));
				card.setHobbsIn(rs.getString("hobbsIn"));
				card.setHobbsOut( rs.getString("hobbsOut"));
				card.setHobbsTotal(rs.getString("hobbsTotal"));
				card.setCashSpent(rs.getString("cashSpent"));
				card.setFlightType(rs.getString("flightType"));
				card.setLeaseName(rs.getString("leaseName"));
				card.setPilotName(rs.getString("pilotName"));
				card.setPlaneType(rs.getString("planeType"));
				card.setPassenger1(rs.getString("passenger1"));
				card.setPassenger2(rs.getString("passenger2"));
				card.setPassenger3(rs.getString("passenger3"));
				card.setPassenger4(rs.getString("passenger4"));
				card.setPassenger5(rs.getString("passenger5"));
				card.setPassenger6(rs.getString("passenger6"));
				card.setPassenger7(rs.getString("passenger7"));
				card.setPassenger8(rs.getString("passenger8"));
				card.setPassenger9(rs.getString("passenger9"));
				card.setPassenger10(rs.getString("passenger10"));
				card.setPassenger11(rs.getString("passenger11"));
				card.setPassenger12(rs.getString("passenger12"));
				card.setPassenger13(rs.getString("passenger13"));
				card.setPassenger14(rs.getString("passenger14"));
				card.setPassenger15(rs.getString("passenger15"));
				card.setPassenger16(rs.getString("passenger16"));
				card.setPassenger17(rs.getString("passenger17"));
				card.setPassenger18(rs.getString("passenger18"));
				card.setPassenger19(rs.getString("passenger19"));
				card.setPassenger20(rs.getString("passenger20"));
				card.setPassenger21(rs.getString("passenger21"));
				card.setPassenger22(rs.getString("passenger22"));
				card.setPassenger23(rs.getString("passenger23"));
				card.setPassenger24(rs.getString("passenger24"));
				cards.add(card);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return cards;

	}
}
