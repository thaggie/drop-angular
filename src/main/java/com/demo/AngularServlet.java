package com.demo;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;

public class AngularServlet extends HttpServlet {
	
	public static final String URL = "url";
	
	private static final long serialVersionUID = 1L;

	private String staticPage;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		
		String staticContentUrl = config.getInitParameter(URL);
		if (staticContentUrl == null || staticContentUrl.length() == 0) {
			throw new ServletException("Missing \"url\" init parameter");
		}
		try (InputStream is = AngularServlet.class.getClassLoader().getResourceAsStream("angular.html")) {
			String template = IOUtils.toString(is);
			staticPage = template.replace("{url}", staticContentUrl);
		} catch (IOException e) {
			throw new ServletException("Unable to load \"angular.html\" resource", e);
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {		
		try (PrintWriter pw = resp.getWriter()) {
			pw.print(staticPage);
		}
	}
}