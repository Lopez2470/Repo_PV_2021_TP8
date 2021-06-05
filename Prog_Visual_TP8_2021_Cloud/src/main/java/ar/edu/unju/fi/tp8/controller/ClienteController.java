package ar.edu.unju.fi.tp8.controller;

import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.tp8.model.Cliente;
import ar.edu.unju.fi.tp8.service.IClienteService;
import ar.edu.unju.fi.tp8.service.ICuentaService;

@Controller
public class ClienteController {
	
	//@Autowired
	//private Cliente cliente;
	
	@Autowired
	@Qualifier("clienteServiceMysql")
	private IClienteService clienteService;
	
	//@Autowired
	//@Qualifier("cuentaServiceMysql")
	//private ICuentaService cuentaService;	
		
	@GetMapping("/cliente/nuevo")
	public String getNuevoClientePage(Model model) {
		/*model.addAttribute("cliente", cliente);*/
		model.addAttribute("cliente", clienteService.getCliente());
		//model.addAttribute("cuenta", cuentaService.getCuenta());
		return "cliente-nuevo";
	}
			
	@PostMapping("/cliente/guardar")
	public ModelAndView guardarCliente(@ModelAttribute("cliente") Cliente cliente){
		ModelAndView modelView = new ModelAndView("clientes");
		cliente.setEdad(cliente.calcularEdad(cliente.getFechaNacimiento()));
		clienteService.guardarCliente(cliente);
		modelView.addObject("clientes", clienteService.obtenerClientes());
		return modelView;
	}
		
	@GetMapping("/cliente/listado")
	public ModelAndView getClientesPage() {
		ModelAndView modelView = new ModelAndView("clientes");
		if (clienteService.obtenerClientes()==null) {
			clienteService.generarTablaCliente();
		}
		modelView.addObject("clientes", clienteService.obtenerClientes());
		return modelView;
	}
			
	@GetMapping("/cliente/editar/{id}")
	public ModelAndView getEditClientePage(@PathVariable(value = "id")Long id) {
		ModelAndView modelView = new ModelAndView("cliente-nuevo");
		Optional<Cliente> cliente = clienteService.getClientePorId(id);
		modelView.addObject("cliente", cliente);
		return modelView;
	}
	
	@GetMapping("/cliente/eliminar/{id}")
	public ModelAndView getProductoEliminar(@PathVariable(value = "id")Long id) {
		ModelAndView modelView = new ModelAndView("redirect:/cliente/listado");
		clienteService.eliminarCliente(id);
		return modelView;
	}
}
