<%@page import="java.io.Writer"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%
	
	Writer writer = response.getWriter();
	
	String queryLowCase = new String();
	String subString = new String();

	// names stored at array could be xml, json or db
	String[] array = new String[6];
	array[0] = "ann";
	array[1] = "johnathan";
	array[2] = "seth";
	array[3] = "summer";
	array[4] = "kris";
	array[5] = "seth";

	//get the q parameter from URL
	String query = new String();
	query = request.getParameter("q");
	

	//lookup all hints from array if length of q>0
	if (query.length() > 0) 
	{
		// suggestions that'll be displayed
		String hint = new String("");

		for (int i = 0; i < array.length; i++) 
		{
			queryLowCase = query.toLowerCase();
			
			if(query.length() > array[i].length())
			{
				writer.write("no suggestion");
				return;
			}
			
				subString = array[i].toLowerCase().substring(0, query.length());
				
			if (queryLowCase.equals(subString)) 
			{
				if (hint == "") 
				{
					hint = array[i];
				} 
				else 
				{
					hint = hint + " , " + array[i];
				}
				System.out.println("hint = " + hint);
			}
		}
		
		if (hint.equals("")) 
		{
			writer.write("no suggestion");
		}
		else
		{
			writer.write(hint);
		}
	}

	System.out.println(query);
%>
