package com.mkyong;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.guacamole.GuacamoleException;
import org.apache.guacamole.net.GuacamoleSocket;
import org.apache.guacamole.net.GuacamoleTunnel;
import org.apache.guacamole.net.InetGuacamoleSocket;
import org.apache.guacamole.net.SimpleGuacamoleTunnel;
import org.apache.guacamole.protocol.ConfiguredGuacamoleSocket;
import org.apache.guacamole.protocol.GuacamoleConfiguration;
import org.apache.guacamole.servlet.GuacamoleHTTPTunnelServlet;

/**
 * Servlet implementation class TutorialGuacamoleTunnelServlet
 */
public class TutorialGuacamoleTunnelServlet extends GuacamoleHTTPTunnelServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected GuacamoleTunnel doConnect(HttpServletRequest request) throws GuacamoleException {
		 // Create our configuration
       // GuacamoleConfiguration config = new GuacamoleConfiguration();
        
        System.out.println("ip=========="+request.getParameter("ip"));
		System.out.println("protocol=========="+request.getParameter("protocol"));
		
		String protocol=request.getParameter("protocol");
		 GuacamoleConfiguration config = new GuacamoleConfiguration();
	        config.setProtocol(request.getParameter("protocol"));
	        config.setParameter("hostname", request.getParameter("ip"));
	        if(protocol.equals("rdp")){
	        	  config.setParameter("port", "3389");
	       
	        }
	        else if(protocol.equals("ssh")){
	        	  config.setParameter("port", "22");
	       
	        }
	        else if(protocol.equals("vnc")) {
	        	  config.setParameter("port", "5900");
	       
	        }
      //  config.setProtocol("rdp");
       // config.setParameter("hostname", "192.168.0.86");
     //  config.setParameter("port", "3389");
   //     config.setParameter("password", "********");

        // Connect to guacd - everything is hard-coded here.
       try {
       	System.out.println("before socket connection ===");
       // Connect to guacd - everything is hard-coded here.
       GuacamoleSocket socket = new ConfiguredGuacamoleSocket(
               new InetGuacamoleSocket("<GUACAMOLE SERVER IP>", 4822),config);

       System.out.println("socket==="+socket);
       // Return a new tunnel which uses the connected socket
       return new SimpleGuacamoleTunnel(socket);
}catch (Exception e) {
e.printStackTrace();
throw new GuacamoleException(e);
}
	}
       
  

}
