package Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class test {
	private static Connection con;
	private static PreparedStatement statemen;
	public static void main(String[] args) throws SQLException {
		Conexion cone=new Conexion();
		con=cone.getConnection();
		
		if(con!=null) {
			System.out.println("se conectó");
		}else {
			System.out.print("fue pe");
		}
	//************************AGREGAR *****************+	
		con.setAutoCommit(false);
		String sql="INSERT INTO persona VALUES(?,?,?)";
		statemen=con.prepareStatement(sql);
		statemen.setString(1, null);
		statemen.setString(2, "Ducke");
		statemen.setString(3, "ducke@santanderconsumer.com.pe");
		statemen.executeUpdate();
		con.commit();
		// ******************+MOSTRAR DATOS ************************
		String sql1="SELECT * FROM persona";
		statemen=con.prepareStatement(sql1);
		ResultSet rs=statemen.executeQuery(sql1);
		while(rs.next()) 
		{
			System.out.println(rs.getInt(1)+" || "+rs.getString(2)+" || "+rs.getString(3));
		}
		//****************ACTUALIZAR DATOS*********************
		
		con.setAutoCommit(false);
		String sql2="UPDATE persona SET nombre=?,correo=? WHERE idPersona=?";
		statemen=con.prepareStatement(sql2);
		statemen.setString(1,"Duck");
		statemen.setString(2,"duck@gmail.com");
		statemen.setInt(3, 8);
		boolean res=statemen.executeUpdate()>0;
		if(res) {
			System.out.print("funciona");
		}else {
			System.out.print("no funciona");
		}
		con.commit();
		
		//**********************ELIMINAR **********************
		con.setAutoCommit(false);
		String sql3="DELETE FROM persona WHERE idPersona=?";
		statemen=con.prepareStatement(sql3);
		statemen.setInt(1, 8);
		statemen.executeUpdate();
		con.commit();
		
		//********************OBTENER POR ID ********************
		String sql4="SELECT * FROM persona WHERE idPersona=?";
		statemen=con.prepareStatement(sql4);
		statemen.setInt(1, 4);
		ResultSet rs1=statemen.executeQuery();
		while(rs1.next()) {
			System.out.println(rs.getInt(1)+"|| "+rs.getString(2)+" || "+rs.getString(3));
		}
		
		/*Agregar el con.setAutoCommit(false) antes del String siempre y cuando es insertar, eliminar o actualizar
		 * execute update, executQuery solo usar en consulta como obtener o mostrar todo
		 */
		
	}
/*	private Connection obtenerConexion() throws SQLException {
		Conexion cone=new Conexion();
		return cone.getConnection();
	}¨*/
}
