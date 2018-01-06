package WebService;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import javax.ws.rs.POST;
import javax.ws.rs.PUT;

import javax.ws.rs.Consumes;

import model.ProjectManager;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.sql.Connection;
import java.sql.Date;

import DAO.DatabaseHelper;
import dto.FlightCard;
import dto.Lease;
import dto.Pilot;
import dto.Plane;

@Path("/WebService")
public class WebService {
	DatabaseHelper db = new DatabaseHelper();

	@GET
	@Path("/GetFromFlightTable")
	@Produces("application/json")
	public String feed() {
		String feeds = null;
		try {
			ArrayList<FlightCard> cards = null;
			ProjectManager pm = new ProjectManager();
			cards = pm.getFlightCards();
			Gson gson = new Gson();
			feeds = gson.toJson(cards);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return feeds;
	}
	

	@POST
	@Path("/addToFlightCard")
	@Consumes("application/json")
	public String add(String card) { 

		Gson gson = new GsonBuilder().create();
		FlightCard newcard = gson.fromJson(card, FlightCard.class);
		
	    String dateOut = newcard.getDateOut();
	    String formatedString = dateOut.substring(0,19);
	    
	    
	    
		String sql = "INSERT INTO flightcardtable (dateOut,dateIn,destination,hobbsIn,hobbsOut,hobbsTotal,"
				+ "cashSpent,flightType,leasename,pilotName,planeType,passenger1,passenger2,passenger3,passenger4,passenger5,passenger6,"
				+ "passenger7,passenger8,passenger9,passenger10,passenger11,passenger12,passenger13,passenger14,"
				+ "passenger15,passenger16,passenger17,passenger18,passenger19,passenger20,passenger21,passenger22,passenger23,passenger24)"
				+ " Values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try (Connection con = db.getConnection()) {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,formatedString);
			ps.setString(2, newcard.getDateIn());
			ps.setString(3, newcard.getDestination());
			ps.setString(4, newcard.getHobbsIn());
			ps.setString(5, newcard.getHobbsOut());
			ps.setString(6, newcard.getHobbsTotal());
			ps.setString(7, newcard.getCashSpent());
			ps.setString(8, newcard.getFlightType());
			ps.setString(9, newcard.getLeaseName());
			ps.setString(10, newcard.getPilotName());
			ps.setString(11, newcard.getPlaneType());
			ps.setString(12, newcard.getPassenger1());
			ps.setString(13, newcard.getPassenger2());
			ps.setString(14, newcard.getPassenger3());
			ps.setString(15, newcard.getPassenger4());
			ps.setString(16, newcard.getPassenger5());
			ps.setString(17, newcard.getPassenger6());
			ps.setString(18, newcard.getPassenger7());
			ps.setString(19, newcard.getPassenger8());
			ps.setString(20, newcard.getPassenger9());
			ps.setString(21, newcard.getPassenger10());
			ps.setString(22, newcard.getPassenger11());
			ps.setString(23, newcard.getPassenger12());
			ps.setString(24, newcard.getPassenger13());
			ps.setString(25, newcard.getPassenger14());
			ps.setString(26, newcard.getPassenger15());
			ps.setString(27, newcard.getPassenger16());
			ps.setString(28, newcard.getPassenger17());
			ps.setString(29, newcard.getPassenger18());
			ps.setString(30, newcard.getPassenger19());
			ps.setString(31, newcard.getPassenger20());
			ps.setString(32, newcard.getPassenger21());
			ps.setString(33, newcard.getPassenger22());
			ps.setString(34, newcard.getPassenger23());
			ps.setString(35, newcard.getPassenger24());

			ps.executeUpdate();
			ps.close();
           System.out.println("inside save card dateOut = "+newcard.getDateOut());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "recieved";
	}

	@PUT
	@Path("/update")
	@Consumes("application/json")
	public String put(String string) {
		Gson gson = new GsonBuilder().create();
		
		FlightCard card = gson.fromJson(string, FlightCard.class);
		
		String dateOut = card.getDateOut();
		String formattedDate = dateOut.substring(0,19);
		
		String sql = "UPDATE flightcardtable "
				+ "SET dateOut = ? ,dateIn = ?,destination = ?,hobbsIn = ?,hobbsOut = ?,hobbsTotal = ?,"
				+ "cashSpent = ?,flightType = ?,leaseName = ?,pilotName = ?,planeType = ?,passenger1 = ?,passenger2 = ?,passenger3 = ?,"
				+ "passenger4 = ?,passenger5 = ?,passenger6 = ?,"
				+ "passenger7 = ?,passenger8 = ?,passenger9 = ?,passenger10 = ?,passenger11 = ?,passenger12 = ?,"
				+ "passenger13 = ?,passenger14 = ?,"
				+ "passenger15 = ?,passenger16 = ?,passenger17 = ?,passenger18 = ?,passenger19 = ?,"
				+ "passenger20 = ?,passenger21 = ?,passenger22 = ?,passenger23 = ?,passenger24 = ?"
				+ " WHERE  dateOut = ?  AND leaseName = ?";
				
		try (Connection con = db.getConnection()) {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,formattedDate);
			ps.setString(2, card.getDateIn());
			ps.setString(3, card.getDestination());			
			ps.setString(4, card.getHobbsIn());
			ps.setString(5, card.getHobbsOut());
			ps.setString(6, card.getHobbsTotal());
			ps.setString(7, card.getCashSpent());
			ps.setString(8, card.getFlightType());
			ps.setString(9, card.getLeaseName());
			ps.setString(10, card.getPilotName());
			ps.setString(11, card.getPlaneType());
			ps.setString(12, card.getPassenger1());
			ps.setString(13, card.getPassenger2());
			ps.setString(14, card.getPassenger3());
			ps.setString(15, card.getPassenger4());
			ps.setString(16, card.getPassenger5());
			ps.setString(17, card.getPassenger6());
			ps.setString(18, card.getPassenger7());
			ps.setString(19, card.getPassenger8());
			ps.setString(20, card.getPassenger9());
			ps.setString(21, card.getPassenger10());
			ps.setString(22, card.getPassenger11());
			ps.setString(23, card.getPassenger12());
			ps.setString(24, card.getPassenger13());
			ps.setString(25, card.getPassenger14());
			ps.setString(26, card.getPassenger15());
			ps.setString(27, card.getPassenger16());
			ps.setString(28, card.getPassenger17());
			ps.setString(29, card.getPassenger18());
			ps.setString(30, card.getPassenger19());
			ps.setString(31, card.getPassenger20());
			ps.setString(32, card.getPassenger21());
			ps.setString(33, card.getPassenger22());
			ps.setString(34, card.getPassenger23());
			ps.setString(35, card.getPassenger24());
			ps.setString(36,formattedDate);
			ps.setString(37, card.getLeaseName());
			
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "updated";
	}

	@POST
	@Path("/delete")
	@Consumes("application/json")
	public String delete(String string) {
		
		Gson gson = new GsonBuilder().create();
		FlightCard card = gson.fromJson(string, FlightCard.class);
		     
		String dateOut = card.getDateOut();
		String formattedDateOut = dateOut.substring(0,19);
		
		String sql = "DELETE FROM flightcardtable WHERE dateOut = ?"
				+ "AND dateIn = ?"
				+"AND destination = ?"
				+"AND hobbsIn = ?"
				+"AND hobbsOut = ?"
				+"AND hobbsTotal = ?"
				+"AND cashSpent = ?"
				+"AND flightType = ?"
				+"AND leaseName = ?"
				+"AND pilotName = ?"
				+"AND planeType = ?"
				+"AND passenger1 = ?";
		try(Connection con = db.getConnection()) {
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,formattedDateOut);
			ps.setString(2, card.getDateIn());
			ps.setString(3, card.getDestination());
			ps.setString(4, card.getHobbsIn());
			ps.setString(5, card.getHobbsOut());
			ps.setString(6, card.getHobbsTotal());
			ps.setString(7, card.getCashSpent());
			ps.setString(8, card.getFlightType());
			ps.setString(9, card.getLeaseName());
			ps.setString(10, card.getPilotName());
			ps.setString(11, card.getPlaneType());
			ps.setString(12, card.getPassenger1());
			ps.executeUpdate();
			ps.close();
		  System.out.println("dateOut = "+card.getDateOut());
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return "deleted";
	}

	@GET
	@Path("/getFromPilotTable")
	@Produces("application/json")
	public String getPilots() {
		String pilotsString = null;
		ArrayList<Pilot> pilots = new ArrayList<Pilot>();
		try (Connection con = db.getConnection()) {

			String sql = "SELECT * FROM pilottable";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Pilot pilot = new Pilot();
				pilot.setName(rs.getString("pilotName"));
				pilots.add(pilot);
			}
			ps.close();
			Gson gson = new Gson();
			pilotsString = gson.toJson(pilots);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pilotsString;
	}
	@POST
	@Path("/addPilot")
	@Consumes("application/json")
	public void addPilot(String string){
		System.out.println("pilot in add pilot service = "+string);
		Gson gson = new GsonBuilder().create();
		Pilot pilot = gson.fromJson(string, Pilot.class);
		String sql = "INSERT INTO pilottable (pilotName) VALUES (?)";
		try(Connection con = db.getConnection()){
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, pilot.getName());
			ps.executeUpdate();
			ps.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		}
	
	@POST
	@Path("/deletePilot")
	@Consumes("application/json")
	public void deletePilot(String string){
		Gson gson = new GsonBuilder().create();
		Pilot pilot = gson.fromJson(string, Pilot.class);
		String sql = "DELETE FROM pilottable WHERE pilotName = ?";
		try(Connection con = db.getConnection()){
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, pilot.getName());
			ps.executeUpdate();
			ps.close();
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
			
	}
	
	@GET
	@Path("/getFromLeaseTable")
	@Produces("application/json")
	public String getFromLease(){
		String leaseString = null;
		ArrayList<Lease>leases = new ArrayList<Lease>();
		try(Connection  con = db.getConnection()){
			String sql = "SELECT * FROM leasetable";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Lease lease = new Lease();
				lease.setName(rs.getString("leaseName"));
				leases.add(lease);
			}
			ps.close();
			Gson gson = new Gson();
			leaseString = gson.toJson(leases);
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		return leaseString;
	}
	@POST
	@Path("/addLease")
	@Consumes("application/json")
	public void addLease(String string){
		System.out.println("string add lease = " + string);
		Gson gson = new GsonBuilder().create();
		Lease lease = gson.fromJson(string, Lease.class);
		System.out.println("lease name = "+lease.getName());
		String sql = "INSERT INTO leaseTable (leaseName) VALUES (?)";
		try(Connection con = db.getConnection()){
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, lease.getName());
			ps.executeUpdate();
			ps.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		
	}
	@POST
	@Path("/deleteLease")
	@Consumes("application/json")
	public void deleteLease(String string){
		Gson gson = new GsonBuilder().create();
		Lease lease = gson.fromJson(string, Lease.class);
		String sql = "DELETE FROM leasetable WHERE leaseName = ?";
		try(Connection con = db.getConnection()){
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, lease.getName());
			ps.executeUpdate();
			ps.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	@GET
	@Path("/getFromPlaneTable")
	@Produces("application/json")
	public String getFromPlane(){
		String planeString = null;
		ArrayList<Plane>planes = new ArrayList<Plane>();
		try(Connection  con = db.getConnection()){
			String sql = "SELECT * FROM planetypetable";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Plane plane = new Plane();
				plane.setName(rs.getString("name"));
				planes.add(plane);
			}
			ps.close();
			Gson gson = new Gson();
			planeString = gson.toJson(planes);
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		return planeString;
	}
	@POST
	@Path("/addPlane")
    @Consumes("application/json")
    public void addPlane(String string){
    	Gson gson = new GsonBuilder().create();
    	Plane plane = gson.fromJson(string, Plane.class);
    	System.out.println("plane in add plane = "+ plane.name);
    	String sql = "INSERT INTO planetypetable (name) VALUES(?)";
    	try(Connection con = db.getConnection()){
    		PreparedStatement ps = con.prepareStatement(sql);
    		ps.setString(1, plane.getName());
    		ps.executeUpdate();
    		ps.close();
    		
    	}catch(SQLException e){
    		e.printStackTrace();
    	}
    }
	@POST
	@Path("/deletePlane")
	@Consumes("application/json")
	public void deletePlane(String string){
		Gson gson = new GsonBuilder().create();
		Plane plane = gson.fromJson(string, Plane.class);
		String sql = "DELETE FROM planetypetable WHERE name = ?";
		try(Connection con = db.getConnection()){
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,plane.getName());
			ps.executeUpdate();
			ps.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
}
