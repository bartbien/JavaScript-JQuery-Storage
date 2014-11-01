package servlet.liveSearchLinks.jdbc;

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

@WebServlet("/servlet/liveSearchLinksJdbc/linkSearchServlet")
public class Links extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	private final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private final String DB_URL = "jdbc:mysql://localhost/webapisamples";
	private final String USER = "root";
	private final String PASS = "";

	public Links()
	{
		super();

		try
		{
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch (ClassNotFoundException e1)
		{
			e1.printStackTrace();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		Connection conn = null;
		Statement stmt = null;
		try
		{
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = conn.createStatement();

			String q = request.getParameter("q");

			if (!q.equals("printAll"))
			{
				getSpecifyLink(stmt, q, response);
			}
			else
			{
				getAllLinks(stmt, q, response);
			}

			stmt.close();
			conn.close();
		}
		catch (SQLException se)
		{
			se.printStackTrace();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				conn.close();
				stmt.close();
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
	}

	private void getSpecifyLink(Statement stmt, String searchKey, HttpServletResponse response)
	{
		// String sql = "SELECT * FROM links Where linkAddress Like '" + stringBuilder + "%'";

		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM links Where linkAddress Like '" + searchKey + "%'");
		sql.append(" or linkAddress Like 'http://www." + searchKey + "%'");
		sql.append(" or linkAddress Like 'http://" + searchKey + "%'");
		sql.append(" or linkID Like '" + searchKey + "%'");
		sql.append(" or linkDescription REGEXP '^" + searchKey + "';");

		System.out.println(sql);

		response.setContentType("application/text");

		try
		{
			ResultSet rs = stmt.executeQuery(sql.toString());

			PrintWriter writer = new PrintWriter(response.getOutputStream());

			String linkId = null;
			String linkAddress = null;
			String linkDescription = null;
			String responseSet = null;

			while (rs.next())
			{
				linkId = rs.getString("linkID");
				linkAddress = rs.getString("linkAddress");
				linkDescription = rs.getString("linkDescription");
				responseSet = linkId + " " + linkAddress + " " + linkDescription + "<br>";

				writer.write(responseSet);

			}

			writer.close();

			rs.close();
		}
		catch (SQLException | IOException e)
		{
			e.printStackTrace();
		}

	}

	private void getAllLinks(Statement stmt, String q, HttpServletResponse response)
	{
		response.setContentType("application/text");
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("http://www." + q);

		String sql = "SELECT * FROM links LIMIT 10";

		System.out.println(sql);

		try
		{
			ResultSet rs = stmt.executeQuery(sql);

			PrintWriter writer = new PrintWriter(response.getOutputStream());

			String linkId = null;
			String linkAddress = null;
			String linkDescription = null;
			String responseSet = null;

			while (rs.next())
			{
				linkId = rs.getString("linkID");
				linkAddress = rs.getString("linkAddress");
				linkDescription = rs.getString("linkDescription");
				responseSet = linkId + " " + linkAddress + " " + linkDescription + "<br>";

				writer.write(responseSet);

			}

			writer.close();

			rs.close();
		}
		catch (SQLException | IOException e)
		{
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{

	}
}
