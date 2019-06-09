package com.example.demo.counterthings.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.counterthings.entity.User;
import com.example.demo.counterthings.service.UserService;

@Controller
@RequestMapping("/user/web")
public class UserWebController {
	@Autowired
	private UserService userService;

	@GetMapping("/")
	public String getUsers(Model model) {
		System.out.println("USERWEBCONTROLLER /");
		model.addAttribute("users", userService.getAllUsers());
		return "pages/userlogin";
	}
	
	@GetMapping("/usercreation")
	public String createUsers(Model model) {
		System.out.println("USERWEBCONTROLLER /usercreation");
		return "pages/usercreate";
	}
	
	@RequestMapping(method = {
			RequestMethod.GET,
			RequestMethod.POST
	},
			value="/create" )
	public void insertUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("USERWEBCONTROLLER /usercreation/../create");
		
    	String nom = request.getParameter("nom");
    	String prenom = request.getParameter("prenom");
    	String username = request.getParameter("username");
    	String password = request.getParameter("password");
    	User u1= new User(nom, prenom, username, password);
		//System.out.println("CREATING USER " + nom + prenom + username + password);    		
    	userService.insertUser(u1);
		//System.out.println("USERWEBCONTROLLER going to " + request.getContextPath() + "/counter/web/");    		
		response.sendRedirect(request.getContextPath() + "/user/web/");
    	//return "redirect:/user/web";
	}
	



	@RequestMapping(method = {
			RequestMethod.GET,
			RequestMethod.POST
	},
			value="/login" )
	public String loginUser(HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirAttrs, Model model ) throws Exception {
		
		System.out.println("USERWEBCONTROLLER /login");
		String message = request.getParameter("message");
		String username = request.getParameter("username");
    	String password = request.getParameter("password");
    	User user = userService.checkUser(username, password);
    	if (user != null) {
    		//out.println("{\"success\": true}");
    		//System.out.println("USERWEBCONTROLLER going to " + request.getContextPath() + "/counter/web/");    		
    		//response.sendRedirect(request.getContextPath() + "/counter/web/");
    		//return "pages/counterlist";
    		return "redirect:/counter/web/";
    	}
    	else {
    		//out.println("{\"success\": false}");
    		//System.out.println("USERWEBCONTROLLER going to " + request.getContextPath() + "/user/web/usercreation/");
    		model.addAttribute("message", "Username or Password not recognized!");
    		redirAttrs.addFlashAttribute("message", "Username or Password not recognized!");
			//response.sendRedirect(request.getContextPath() + "/user/web/");
			//return "pages/userlogin";
    		return "redirect:/user/web/";
			}
    	
	}
    


    	public String failedLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
            //response.sendRedirect(request.getContextPath() + "/fail.jsp");
    		return "{\"success\": false}";
        }
    	
    	public Boolean successLogin(HttpServletRequest request, HttpServletResponse response, User user) throws IOException {
            HttpSession session = request.getSession(true);
            session.setAttribute("USER", user);
            //response.sendRedirect("MainServlet");

/*            try (PrintWriter out = response.getWriter()) {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>User Login</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Welcome " + user.getPrenom() + " " + user.getNom() +"</h1>");
                out.println("<p>POST</p>");
                out.println("<p> Username : " + user.getUsername() + "</p>");
                out.println("<p> Password : "+ user.getPassword()+"</p>");
                out.println("</body>");
                out.println("</html>");
            }
            catch (IOException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
*/
    		return true;
        }

	
}

