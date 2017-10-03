package is.hi.byrjun.repository;

import is.hi.byrjun.model.Banquet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

/**
*
* @author Pétur Logi Pétursson
* @date september 2017
* HBV501G Hugbúnaðarverkefni 1
* Háskóli Íslands
* 
* Safn af veislusölum
* 
*/
@Repository
public class BanquetRepositoryImp implements BanquetRepository {
	
	//Listi af Veislusölum
	private List<Banquet> banquets;
	
	// Attributes for SQL Connection
	Connection con;
	private final String url = "jdbc:postgresql://localhost:5432/bookingdb";
	private final String driver = "org.postgresql.Driver";
	private final String userName = "postgres";
	private final String password = "123456";
	
	
	public BanquetRepositoryImp() {
		banquets = new ArrayList<Banquet>();
	}
	
	// Connection to Database
	public Connection connect() {
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userName, password);
			if (con == null) {
				System.out.println("Connection cannot be established");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	
	@Override
	public ArrayList<Banquet> getAll() {
		// TODO Auto-generated method stub
		ArrayList<Banquet> list = new ArrayList<Banquet>();
		try {
			Connection con = DriverManager.getConnection(url, userName, password);
			PreparedStatement ps = con.prepareStatement("SELECT * FROM banquets");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Banquet temp = new Banquet(rs.getInt("id"),
										   rs.getString("name"),
										   rs.getString("location"),
										   rs.getString("street"),
										   rs.getInt("price"),
										   rs.getInt("maxppl"),
										   rs.getInt("phonenr"),
										   rs.getString("email"));
				list.add(temp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		this.banquets = list;
		return list;
	}
	
	/*public static void main(String[] args) {
		List<Banquet> test;
		BanquetRepositoryImp list = new BanquetRepositoryImp();
		test = list.getAll();
		for (int i = 0; i < test.size(); i++) {
			System.out.println(test.get(i).toString());
		}
	}*/

	@Override
	public List<Banquet> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Banquet> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Banquet> findAll(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Banquet> List<S> save(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends Banquet> S saveAndFlush(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteInBatch(Iterable<Banquet> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllInBatch() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Banquet getOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Banquet> findAll(Pageable arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(Long arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Banquet arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Iterable<? extends Banquet> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean exists(Long arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Banquet findOne(Long arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Banquet> S save(S arg0) {
		// TODO Auto-generated method stub
		return null;
	}
}
