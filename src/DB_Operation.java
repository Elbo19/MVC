import java.sql.*;
public class DB_Operation {
    private Connection conn;
    private Statement st;
    private ResultSet rs;
     
    public Connection getConnection(){
        try{
            String url="jdbc:mysql://localhost/java";
            String user="root";
            String pass="";
            Class.forName("com.mysql.jdbc.Driver");
            conn= DriverManager.getConnection(url,user,pass);
           
        }
        catch(SQLException ex){
            System.out.println("Error"+ex.getMessage());
        }
        catch(ClassNotFoundException ex){
            System.out.println("Error"+ex.getMessage());
            
        }
    finally{
            return conn;
        }
    }
    public ResultSet searchQuery(String sql){
        try{
            getConnection();
            st=conn.createStatement();
            rs=st.executeQuery(sql);
        }
        catch(SQLException ex){
            System.out.println("Error"+ex.getMessage());            
        }
        return rs;
    }
}
