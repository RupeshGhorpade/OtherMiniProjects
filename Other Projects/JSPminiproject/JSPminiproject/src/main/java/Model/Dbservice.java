package Model;

import java.sql.Connection;
import java.sql.SQLException;

public interface Dbservice 
{
public Connection getConnection() throws ClassNotFoundException,SQLException;
}
