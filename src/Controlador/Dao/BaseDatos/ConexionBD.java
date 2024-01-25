
package Controlador.Dao.BaseDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Victor
 */
public class ConexionBD {
    
    private Connection connection;
    
    //Intento de conexion con oracle xe 21 y sql developer
    public String driver = "oracle.jdbc.OracleDriver";
    public String database = "XE";
    public String hostname = "localhost";
    public String port = "1521";
    public String url = "jdbc:oracle:thin:@" + hostname + ":" + port + ":" + database;

    
    //Conexion con mysql
    
    /*//https://www.codejava.net/java-se/jdbc/connect-to-oracle-database-via-jdbc
    
    // Librería de MySQL
    public String driver = "com.mysql.cj.jdbc.Driver";//oracle.jdbc.driver.OracleDriver

    // Nombre de la base de datos
    public String database = "pelidb";

    // Host
    public String hostname = "localhost";

    // Puerto
    public String port = "3306";//1521

    // Ruta de nuestra base de datos (desactivamos el uso de SSL con "?useSSL=false")
    //String aux = "jdbc:oracle:thin:@"+hostname+":"+port+":"+database;
    public String url = "jdbc:mysql://" + hostname + ":" + port + "/" + database + "?useSSL=false";//"jdbc:oracle:thin:@"+hostname+":"+port+":"+database;*/

    // Nombre de usuario
    public String username = "desarrollo";

    // Clave de usuario
    public String password = "desarrollo";

    private Connection conectar() throws SQLException {
        Connection conn = null;

        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("Conected!");
        } 
        catch (ClassNotFoundException e) {
            throw new SQLException("Error al cargar el driver: " + e.getMessage());
        } 
        catch (SQLException e) {
            throw new SQLException("Error al establecer la conexión: " + e.getMessage());
        }


        return conn;
    }

    public Connection getConnection() throws SQLException {
        if (connection == null) {
            connection = conectar();
        }
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

//    public static void main(String[] args) {
//        new Conexion().conectar();
//    }

    /*private XStream xstream;
    public static String URL = "data/";
    private void conectar() {         
        xstream = new XStream(new JettisonMappedXmlDriver());        
         xstream.setMode(XStream.NO_REFERENCES);
         xstream.addPermission(AnyTypePermission.ANY);
    }
    public XStream getXstream() {
        if(xstream == null)
            conectar();
        return xstream;
    }
    public void setXstream(XStream xstream) {
        this.xstream = xstream;
    }*/
    
}
