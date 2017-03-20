package DataCleaner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
         


	/**
	 * @param args
	 */
	public static  void main(String[] args) {
            Statement stmt = null;
            Connection conn = null;
	    ResultSet rs = null;

             

		
		try {
			//Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			//String connectionString = "jdbc:sqlserver://ABDOU-PC\\SQLEXPRESS;database=data;user=abdou;password=hiphop";
			//conn = DriverManager.getConnection(connectionString);



                        // Chargement du driver ODBC

                        //Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

                        // Connexion à la base

                        //String connectionString = "jdbc:odbc:DRIVER={Microsoft Access Driver (*.mdb)}; DBQ=D:\\flach\\pt\\Dep780\\Dep780.mdb" ;

                        //conn = DriverManager.getConnection(connectionString, "", "");
                        //stmt=conn.createStatement();
                        //rs = stmt.executeQuery("SELECT COD_PERMIS FROM  SRP_USAGER");
                        table tab=new table();


			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			//e.p;
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (Exception e) {
				}

			if (stmt != null)
				try {
                                        
					stmt.close();
				} catch (Exception e) {
				}

			if (conn != null)
				try {
					conn.close();
				} catch (Exception e) {
				}
		}


	}


		// TODO Auto-generated method stub
  

	

}
