/**
* OWASP Benchmark Project v1.2beta
*
* This file is part of the Open Web Application Security Project (OWASP)
* Benchmark Project. For details, please see
* <a href="https://www.owasp.org/index.php/Benchmark">https://www.owasp.org/index.php/Benchmark</a>.
*
* The OWASP Benchmark is free software: you can redistribute it and/or modify it under the terms
* of the GNU General Public License as published by the Free Software Foundation, version 2.
*
* The OWASP Benchmark is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
* even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
* GNU General Public License for more details.
*
* @author Nick Sanidas <a href="https://www.aspectsecurity.com">Aspect Security</a>
* @created 2015
*/

package org.owasp.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest02174")
public class BenchmarkTest02174 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");

		String param = request.getParameter("vector");
		if (param == null) param = "";

		String bar = doSomething(param);
		
		Object[] obj = { "a", bar };
		java.io.PrintWriter out = response.getWriter();
		out.write("<!DOCTYPE html>\n<html>\n<body>\n<p>");
		out.format(java.util.Locale.US,"Formatted like: %1$s and %2$s.",obj);
	    out.write("\n</p>\n</body>\n</html>");
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a85935 = param; //assign
		StringBuilder b85935 = new StringBuilder(a85935);  // stick in stringbuilder
		b85935.append(" SafeStuff"); // append some safe content
		b85935.replace(b85935.length()-"Chars".length(),b85935.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map85935 = new java.util.HashMap<String,Object>();
		map85935.put("key85935", b85935.toString()); // put in a collection
		String c85935 = (String)map85935.get("key85935"); // get it back out
		String d85935 = c85935.substring(0,c85935.length()-1); // extract most of it
		String e85935 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d85935.getBytes() ) )); // B64 encode and decode it
		String f85935 = e85935.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f85935); // reflection
	
		return bar;	
	}
}
