package com.Anilber.controlador;

import java.io.Console;
import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import com.Anilber.Dao.ConsultaDao;
import com.Anilber.model.Consultass;
import com.Anilber.model.Usuarioparcial;
import com.google.gson.Gson;

import javafx.scene.control.Alert;

/**
 * Servlet implementation class ServeletController
 */
public class ServeletController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServeletController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		
		
		ConsultaDao conD = new ConsultaDao();
		Consultass cld= new Consultass();
		
		String id =null;
		String nombreu =null;
		String apellidou =null;
		
		try {
			id	= request.getParameter("Id");
			nombreu = request.getParameter("Nusuario");
			apellidou = request.getParameter("Ausuario");
		
		
			
			cld.setId(Integer.parseInt(id));
			cld.setNombre(nombreu);
			cld.setApellido(apellidou);
				
		} catch (Exception e) {
			// TODO: handle exception
		
		}
		
	
		
		
		
		String action = request.getParameter("btn");
		
		HttpSession seccion =(HttpSession)request.getSession();
		String usuvariable = (String)seccion.getAttribute("usuarioo");
		

	if (action.equals("ACTUALIZAR")) {
			
		if(usuvariable ==null) {
		JOptionPane.showMessageDialog(null, "¡¡¡Error No tiene autorizacion!!! Inicie sesion.");
		}else {
		cld.setId(Integer.parseInt(id));
		cld.setNombre(nombreu);
		cld.setApellido(apellidou);
		conD.actualizarDatos(cld);
		}
		
	}else if (action.equals("ELIMINAR")) {
		
		if(usuvariable ==null) {
		JOptionPane.showMessageDialog(null, "¡¡¡Error No tiene autorizacion!!! Inicie sesion.");
			
		}else {
		cld.setId(Integer.parseInt(id));
		conD.eliminarDatos(cld);
		}
	}
		response.sendRedirect("index.jsp");
	
	
	

	}

	
	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
			
		
   ConsultaDao consu= new ConsultaDao();
		
		Gson json= new Gson();
		
		
		try {
			
			response.getWriter().append(json.toJson(consu.consultaLista()));
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
		
		
		String usuario = request.getParameter("usuario");
		String contraseña = request.getParameter("contrasenia");
		String cerrarsesion = request.getParameter("btncerrar");
		
		if(cerrarsesion!=null) {
			
			if(cerrarsesion.equals("cerrar seesion")) {
				
			HttpSession cerrarsesiones = (HttpSession) request.getSession();
			cerrarsesiones.invalidate();
			
			response.sendRedirect("index.jsp");
				
			}
			
			
		}else {
		
		Usuarioparcial usup = new Usuarioparcial();
		ConsultaDao Cdao= new ConsultaDao();
		
		
		usup.setNombre(usuario);
		usup.setContrasenia(contraseña);
		
		int verificaion= Cdao.consultaUsu(usup).size();
		
		if (verificaion ==1) {
		
		
			
			HttpSession sesion = request.getSession(true);
			sesion.setAttribute("usuarioo", usuario); 
			response.sendRedirect("index.jsp");
			
		}else {
			System.out.println("¡Error Usuario o Contraseña equivocada!");
			
		}
		
		
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	

}
