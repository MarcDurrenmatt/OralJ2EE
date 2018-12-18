package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;



public class DAO {

	private final DataSource myDataSource;

	/**
	 * Construit le AO avec sa source de données
	 * @param dataSource la source de données à utiliser
	 */
	public DAO(DataSource dataSource) {
		this.myDataSource = dataSource;
	}

	/**
	 * Contenu de la table DISCOUNT_CODE
	 * @return Liste des discount codes
	 * @throws SQLException renvoyées par JDBC
         * 
	 */
         public Customer Customer(String email) throws SQLException {
        Customer c = null;
        String sql = "SELECT * FROM Customer WHERE email = ?";
        try (Connection myConnection = myDataSource.getConnection();
                PreparedStatement statement = myConnection.prepareStatement(sql)) {
            statement.setString(1, email); // On fixe le 1° paramètre de la requête
            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    int id = rs.getInt("CUSTOMER_ID");
                    String dc = rs.getString("DISCOUNT_CODE");
                    int zip = rs.getInt("ZIP");
                    String name = rs.getString("NAME");
                    String adress = rs.getString("ADDRESSLINE1");
                    String adress2 = rs.getString("ADDRESSLINE2");
                    String city = rs.getString("CITY");
                    String state = rs.getString("STATE");
                    String phone = rs.getString("PHONE");
                    String fax = rs.getString("FAX");
                    int credit = rs.getInt("CREDIT_LIMIT");
                    c = new Customer(id, dc, zip, name, adress, adress2, city, state, phone, fax, email, credit);
                }
            }
        }
        return c;
    }

        
	public List<DiscountCode> allCodes() throws SQLException {

		List<DiscountCode> result = new LinkedList<>();

		String sql = "SELECT * FROM DISCOUNT_CODE ORDER BY DISCOUNT_CODE";
		try (Connection connection = myDataSource.getConnection(); 
		     PreparedStatement stmt = connection.prepareStatement(sql)) {
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				String id = rs.getString("DISCOUNT_CODE");
				float rate = rs.getFloat("RATE");
				DiscountCode c = new DiscountCode(id, rate);
				result.add(c);
			}
		}
		return result;
	}

	/**
	 * Ajout d'un enregistrement dans la table DISCOUNT_CODE
	 * @param code le code (non null)
	 * @param rate le taux (positive or 0)
	 * @return 1 si succès, 0 sinon
	 * @throws SQLException renvoyées par JDBC
	 */
	public int addDiscountCode(String code, float rate) throws SQLException {
		int result = 0;
		String sql = "INSERT INTO DISCOUNT_CODE VALUES (?, ?)";
		try (Connection connection = myDataSource.getConnection(); 
		     PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, code);
			stmt.setFloat(2, rate);
			result = stmt.executeUpdate();
		}
		return result;
	}

		
	/**
	 * Supprime un enregistrement dans la table DISCOUNT_CODE
	 * @param code la clé de l'enregistrement à supprimer
	 * @return le nombre d'enregistrements supprimés (1 ou 0)
	 * @throws java.sql.SQLException renvoyées par JDBC
	 **/
	public int deleteDiscountCode(String code) throws SQLException {
		int result = 0;
		String sql = "DELETE FROM DISCOUNT_CODE WHERE DISCOUNT_CODE = ?";
		try (Connection connection = myDataSource.getConnection(); 
		     PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, code);
			result = stmt.executeUpdate();
		}
		return result;
	}

    /**
     *
     * @param id
     * @param name
     * @param address1
     * @param city
     * @param State
     * @param Phone
     * @param Email
     * @param credit
     * @return
     * @throws SQLException
     */
    public int updateCustomer(String name, String address1, String city, String State, String Phone) throws SQLException {
        String sql = "UPDATE CUSTOMER SET NAME=?, ADDRESSLINE1 = ?, CITY = ?, STATE = ?, PHONE=?";
        try (Connection connection = myDataSource.getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)) {
            // Définir la valeur du paramètre
            stmt.setString(1, name);
            stmt.setString(2, address1);
            stmt.setString(3, city);
            stmt.setString(4, State);
            stmt.setString(5, Phone);


            return stmt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger("DAO").log(Level.SEVERE, null, ex);
            throw new SQLException(ex.getMessage());
        }
    }
    
    public List<String> existingStates() throws DAOException {
        List<String> result = new LinkedList<>();
        String sql = "SELECT DISTINCT STATE FROM CUSTOMER";
        try (Connection connection = myDataSource.getConnection();
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                String state = rs.getString("STATE");
                result.add(state);
            }
        } catch (SQLException e) {
            throw new DAOException(e.getMessage());
        }
        return result;
    }
        public String ManbyProduct(int product) throws SQLException {
        String result = null;

        String sql = "SELECT NAME AS NOM \n"
                + "    FROM MANUFACTURER \n"
                + "        INNER JOIN PRODUCT \n"
                + "            ON PRODUCT.MANUFACTURER_ID=MANUFACTURER.MANUFACTURER_ID and PRODUCT.PRODUCT_ID=?";
        try (Connection myConnection = myDataSource.getConnection();
                PreparedStatement statement = myConnection.prepareStatement(sql)) {
            statement.setInt(1, product); // On fixe le 1° paramètre de la requête
            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    // est-ce qu'il y a un résultat ? (pas besoin de "while", 
                    // il y a au plus un enregistrement)
                    // On récupère les champs de l'enregistrement courant
                    result = rs.getString("NOM");
                }
            }
        }
        return result;
    }

    public int ProductPrice(int product) throws SQLException {
        int result = 0;

        String sql = "SELECT PURCHASE_COST AS COST FROM PRODUCT WHERE PRODUCT_ID = ?";
        try (Connection myConnection = myDataSource.getConnection();
                PreparedStatement statement = myConnection.prepareStatement(sql)) {
            statement.setInt(1, product); // On fixe le 1° paramètre de la requête
            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    // est-ce qu'il y a un résultat ? (pas besoin de "while", 
                    // il y a au plus un enregistrement)
                    // On récupère les champs de l'enregistrement courant
                    result = rs.getInt("COST");
                }
            }
        }
        return result;
    }

    public int maxOrderNum() throws SQLException {
        int result = 0;

        String sql = "SELECT MAX(ORDER_NUM) AS MAXI FROM PURCHASE_ORDER";
        try (Connection connection = myDataSource.getConnection();
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            if (rs.next()) { // Tant qu'il y a des enregistrements
                result = rs.getInt("MAXI");
            }

        } catch (SQLException ex) {
            Logger.getLogger("DAO").log(Level.SEVERE, null, ex);
            throw new SQLException(ex.getMessage());
        }
        return result;
    }


    public void insertOrder(int ordernum, int c_id, int p_id, int quantity, float shipping, String sale_d, String shipping_d, String Company) throws SQLException {
        // Une requête SQL paramétrée
        String sql = "INSERT INTO PURCHASE_ORDER VALUES(?, ?, ?,?,?,?,?,?)";
        try (Connection connection = myDataSource.getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)) {
            // Définir la valeur du paramètre
            stmt.setInt(1, ordernum);
            stmt.setInt(2, c_id);
            stmt.setInt(3, p_id);
            stmt.setInt(4, quantity);
            stmt.setFloat(5, shipping);
            stmt.setString(6, sale_d);
            stmt.setString(7, shipping_d);
            stmt.setString(8, Company);

            stmt.executeUpdate();
        }
    }
}
