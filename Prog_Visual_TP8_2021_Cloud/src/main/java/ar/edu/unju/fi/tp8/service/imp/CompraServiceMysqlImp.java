package ar.edu.unju.fi.tp8.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tp8.model.Compra;
import ar.edu.unju.fi.tp8.repository.ICompraRepository;
import ar.edu.unju.fi.tp8.service.ICompraService;

@Service("compraServiceMysql")
public class CompraServiceMysqlImp implements ICompraService{

	@Autowired
	private ICompraRepository compraRepository;
	
	@Override
	public void generarTablaCompra() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void guardarCompra(Compra compra) {
		compraRepository.save(compra);	
	}

	@Override
	public List<Compra> obtenerCompras() {
		List<Compra> compras = (List<Compra>) compraRepository.findAll();
		return compras;
	}
}
