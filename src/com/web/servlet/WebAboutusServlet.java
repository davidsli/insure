package com.web.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.db.DbUtils;
import com.web.util.JsonUtils;
import com.web.util.Putil;
import com.web.util.StringUtils;

public class WebAboutusServlet extends Dispatcher {

	private static final long serialVersionUID = 8459048427979079912L;

	public void dispatcher(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
			
		index(request, response);
		
	}
		
	private void index(HttpServletRequest request, HttpServletResponse response) {
		try {
			HashMap<String, Object> user = LoginManager.getUser(request);
			if(user!=null && Putil.getInt(user.get("userid"))>0) {
				request.setAttribute("user", user);
				request.setAttribute("islogin", "1");
	      	} else {
	    		request.setAttribute("islogin", "0");
			}
        	forward(request,response,"/web/aboutus.jsp") ;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	
}
