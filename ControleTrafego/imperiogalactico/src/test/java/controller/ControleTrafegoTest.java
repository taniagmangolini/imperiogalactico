package controller;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.TreeSet;

import model.Nave;
import model.Planeta;
import model.PlanoVoo;
import model.Tripulante;

import org.junit.Test;
import org.primefaces.model.DualListModel;

import client.SwapiClient;

public class ControleTrafegoTest {

	@Test
	public void testValidaPlanoVoo() {
		ControleTrafego controleTrafego = new ControleTrafego();
		Boolean result = controleTrafego.validaPlanoVoo(null);
		assertFalse(result);

		result = controleTrafego.validaPlanoVoo(new PlanoVoo());
		assertFalse(result);

		PlanoVoo planoVooIncompleto = new PlanoVoo();
		planoVooIncompleto.setNave(new Nave());
		planoVooIncompleto.setPlaneta(new Planeta());
		planoVooIncompleto.setTripulantes(new HashSet<Tripulante>());

		result = controleTrafego.validaPlanoVoo(planoVooIncompleto);
		assertFalse(result);

		planoVooIncompleto.getNave().setName("XXX");
		planoVooIncompleto.getNave().setCrew("");
		planoVooIncompleto.getNave().setPassengers("2");
		planoVooIncompleto.getPlaneta().setName("YYY");
		planoVooIncompleto.getTripulantes().add(new Tripulante());

		result = controleTrafego.validaPlanoVoo(planoVooIncompleto);
		assertFalse(result);

		planoVooIncompleto.getNave().setName("XXX");
		planoVooIncompleto.getNave().setCrew("2");
		planoVooIncompleto.getNave().setPassengers("");
		planoVooIncompleto.getPlaneta().setName("YYY");
		planoVooIncompleto.getTripulantes().add(new Tripulante());

		result = controleTrafego.validaPlanoVoo(planoVooIncompleto);
		assertFalse(result);

		planoVooIncompleto.getNave().setName("XXX");
		planoVooIncompleto.getNave().setCrew("2");
		planoVooIncompleto.getNave().setPassengers("1");
		planoVooIncompleto.getNave().setUrl("bbb");
		planoVooIncompleto.getPlaneta().setName("YYY");
		planoVooIncompleto.getTripulantes().add(new Tripulante());

		result = controleTrafego.validaPlanoVoo(planoVooIncompleto);
		assertFalse(result);

		PlanoVoo planoVooCompleto = new PlanoVoo();
		planoVooCompleto.setNave(new Nave());
		planoVooCompleto.setPlaneta(new Planeta());
		planoVooCompleto.setTripulantes(new HashSet<Tripulante>());
		planoVooCompleto.getNave().setName("XXX");
		planoVooCompleto.getNave().setCrew("2");
		planoVooCompleto.getNave().setPassengers("1");
		planoVooCompleto.getNave().setUrl("bbb");
		planoVooCompleto.getPlaneta().setName("YYY");
		planoVooCompleto.getPlaneta().setUrl("aaaa");
		planoVooCompleto.getTripulantes().add(new Tripulante());

		result = controleTrafego.validaPlanoVoo(planoVooCompleto);
		assertTrue(result);
	}

	@Test
	public void testSalvar() {

		ControleTrafego controleTrafego = new ControleTrafego();
		 controleTrafego.setSwapiClient(new SwapiClient());
		 controleTrafego.setPlanosVoo(new TreeSet<PlanoVoo>());
		 System.out.println("xxxxxxxxxxxx " + controleTrafego.getSwapiClient());
		String result = "";

		// Tripulantes null
		controleTrafego.setPlanetaSelecionado("http://swapi.co/api/planets/3/");
		controleTrafego.setNaveSelecionada("http://swapi.co/api/starship/3/");
		result = controleTrafego.salvar();
		assertTrue("erro".equals(result));

		controleTrafego.setPlanetaSelecionado("http://swapi.co/api/planets/3/");
		controleTrafego.setNaveSelecionada("http://swapi.co/api/starships/3/");
		controleTrafego.setTripulantes(new DualListModel<Tripulante>(
				new ArrayList<Tripulante>(), new ArrayList<Tripulante>()));
		controleTrafego.getTripulantes().getTarget().add(new Tripulante());
		result = controleTrafego.salvar();
		
		System.out.println("RESULTADO " + result);
		assertTrue("sucesso".equals(result));
	}

}
