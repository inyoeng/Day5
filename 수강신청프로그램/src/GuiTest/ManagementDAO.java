package GuiTest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.pilates.model.Pilates;

public class ManagementDAO {


private Connection conn = null;
private PreparedStatement stmt = null;
private ResultSet rs = null;

private final String LOGIN = "select * from members where id = ? and pw = ?";
private final String INSERT = "insert into members values (?,?,?,?,?,?)";
private final String LIST = "select * from members";


 ManagementDAO() {}
private static ManagementDAO instance = new ManagementDAO();

public static ManagementDAO getInstance() {
    return instance;
}

public int idPassword(String id, String password) {

    conn = DataBase.getConnection( );

    try {
        stmt = conn.prepareStatement(LOGIN);

        stmt.setString(1, id);
        stmt.setString(2, password);

        rs = stmt.executeQuery();

        if(rs.next()) {
            return 1;
        }
    } catch(SQLException e) {
        e.printStackTrace();
    }

    return -1;
}

public int insertMember(ManagementDTO mdto) {

    conn = DataBase.getConnection();

    try {
        stmt = conn.prepareStatement(INSERT);

    
        ((Pilates) stmt).setId(rs.getString("id"));
        ((Pilates) stmt).setPw(rs.getString("pw"));
        ((Pilates) stmt).setName(rs.getString("name"));
        ((Pilates) stmt).setAge(rs.getInt("age"));
        ((Pilates) stmt).setPhone(rs.getString("phone"));
        ((Pilates) stmt).setSession(rs.getInt("sessions"));
        stmt.executeUpdate();
        return 1;

    } catch(Exception e) {
        e.printStackTrace();
    }
    return -1;
}

public List<Pilates> managementList() {
        conn = DataBase.getConnection();
    List<Pilates> list = new ArrayList<Pilates>();

     try {
        stmt = conn.prepareStatement(LIST);
        rs = stmt.executeQuery();
        while (rs.next()) {
       
				Pilates p = new Pilates();
				p.setId(rs.getString("id"));
				p.setPw(rs.getString("pw"));
				p.setName(rs.getString("name"));
				p.setAge(rs.getInt("age"));
				p.setPhone(rs.getString("phone"));
				p.setSession(rs.getInt("sessions"));
				list.add(p);

        }

        return list;

    } catch (Exception e) {
        e.printStackTrace();
    }

    return null;
  }
}
