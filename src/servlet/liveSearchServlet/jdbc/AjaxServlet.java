package servlet.liveSearchServlet.jdbc;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AjaxServlet
 */
@WebServlet("/servlet/liveSearchServletJdbc/liveSearchServlet")
public class AjaxServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AjaxServlet()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{

		databaseConnection(request, response);
		
		

		// response.getWriter().print("tesssst ajax");

//		String q = request.getParameter("q");
//
//		Writer writer = new PrintWriter(response.getOutputStream());
//
//		writer.write("test+" + q);
//		writer.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.getWriter().print("from post ");
	}
	
	
	public static void databaseConnection(HttpServletRequest request, HttpServletResponse response)
	{
		// JDBC driver name and database URL
		final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
		final String DB_URL = "jdbc:mysql://localhost/webapisamples";

		// Database credentials
		final String USER = "root";
		final String PASS = "";
		
		
		Connection conn = null;
		Statement stmt = null;
		try
		{
			// STEP 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");

			// STEP 3: Open a connection
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			// STEP 4: Execute a query
			System.out.println("Creating statement...");
			stmt = conn.createStatement();
			String sql;
			
			String q = request.getParameter("q");
			sql = "SELECT ajax_user FROM ajaxonkeyup Where ajax_user Like '" + q + "%'";
			
			System.out.println(sql);
			
			ResultSet rs = stmt.executeQuery(sql);

			// SELECT roleName FROM `user_role` Where rolename Like 'u%';

			Writer writer = new PrintWriter(response.getOutputStream());

			while (rs.next())
			{
				writer.write(rs.getString("ajax_user") + "<br>");
				System.out.println("user: " + rs.getString("ajax_user"));
			}
			
			writer.close();
			
			rs.close();
			stmt.close();
			conn.close();
		}
		catch (SQLException se)
		{
			// Handle errors for JDBC
			se.printStackTrace();
		}
		catch (Exception e)
		{
			// Handle errors for Class.forName
			e.printStackTrace();
		}
		finally
		{
			// finally block used to close resources
			try
			{
				if (stmt != null)
					stmt.close();
			}
			catch (SQLException se2)
			{
			}// nothing we can do
			try
			{
				if (conn != null)
					conn.close();
			}
			catch (SQLException se)
			{
				se.printStackTrace();
			}// end finally try
		}// end try
		System.out.println("Goodbye!");
	}// end main
	

}
