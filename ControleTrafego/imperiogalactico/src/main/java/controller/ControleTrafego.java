package controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

import model.Nave;
import model.Planeta;
import model.PlanoVoo;
import model.Tripulante;

import org.primefaces.model.DualListModel;

import util.Mensagem;
import client.SwapiClient;

@SessionScoped
@ManagedBean
public class ControleTrafego {

	private List<SelectItem> planetas;

	private List<Planeta> listaPlanetas;

	private DualListModel<Tripulante> tripulantes;

	private List<SelectItem> naves;

	private List<Nave> listaNaves;

	@ManagedProperty(value = "#{swapiClient}")
	private SwapiClient swapiClient;

	private String planetaSelecionado;

	private String naveSelecionada;

	List<Tripulante> tripulantesSource;

	List<Tripulante> tripulantesTarget;

	private Set<PlanoVoo> planosVoo;

	@PostConstruct
	public void init() {
		planosVoo = new TreeSet<PlanoVoo>();
		// obtem dados do rest service para preenchimento dos componentes do
		// form
		tripulantesSource = swapiClient.getTripulantes();
		tripulantesTarget = new ArrayList<Tripulante>();
		tripulantes = new DualListModel<Tripulante>(tripulantesSource,
				tripulantesTarget);
		listaPlanetas = swapiClient.getPlanetas();
		listaNaves = swapiClient.getNaves();
	}

	public Set<PlanoVoo> getPlanosVoo() {
		return planosVoo;
	}

	public void setPlanosVoo(Set<PlanoVoo> planosVoo) {
		this.planosVoo = planosVoo;
	}

	public String getNaveSelecionada() {
		return naveSelecionada;
	}

	public void setNaveSelecionada(String naveSelecionada) {
		this.naveSelecionada = naveSelecionada;
	}

	public String getPlanetaSelecionado() {
		return planetaSelecionado;
	}

	public void setPlanetaSelecionado(String planetaSelecionado) {
		this.planetaSelecionado = planetaSelecionado;
	}

	public void setPlanetas(List<SelectItem> planetas) {
		this.planetas = planetas;
	}

	public SwapiClient getSwapiClient() {
		return swapiClient;
	}

	public void setSwapiClient(SwapiClient swapiClient) {
		this.swapiClient = swapiClient;
	}

	public List<SelectItem> getPlanetas() {
		planetas = new ArrayList<SelectItem>();
		if (listaPlanetas != null) {
			for (Planeta planeta : listaPlanetas) {
				planetas.add(new SelectItem(planeta.getUrl(), planeta.getName()));
			}
		}
		return planetas;
	}

	public void setTripulantes(DualListModel<Tripulante> tripulantes) {
		this.tripulantes = tripulantes;
	}

	public DualListModel<Tripulante> getTripulantes() {

		return tripulantes;
	}

	public List<SelectItem> getNaves() {
		naves = new ArrayList<SelectItem>();
		if (listaNaves != null) {
			for (Nave nave : listaNaves) {
				naves.add(new SelectItem(nave.getUrl(), nave.getName()));
			}
		}
		return naves;
	}

	public void setNaves(List<SelectItem> naves) {
		this.naves = naves;
	}

	public boolean validaPlanoVoo(PlanoVoo planoVoo) {

		if (planoVoo == null || planoVoo.getNave() == null
				|| planoVoo.getPlaneta() == null
				|| planoVoo.getTripulantes() == null
				|| planoVoo.getTripulantes().isEmpty()) {
			Mensagem.addMensagemErroFacesContext("erro.obrigatorio");
			return false;
		}

		// A informacao da capacidade da nave precisa existir pois sera
		// necessaria adiante
		if (planoVoo.getNave().getCrew() == null
				|| planoVoo.getNave().getCrew().equalsIgnoreCase("")
				|| planoVoo.getNave().getPassengers() == null
				|| planoVoo.getNave().getPassengers().equalsIgnoreCase("")) {
			Mensagem.addMensagemErroFacesContext("erro.tripulantes.info");
			return false;
		}

		// As seguintes informacoes precisam estar presentes Url do planeta e
		// Url da Nave
		if (planoVoo.getNave().getUrl() == null
				|| planoVoo.getNave().getUrl().equalsIgnoreCase("")
				|| planoVoo.getPlaneta().getUrl() == null
				|| planoVoo.getNave().getUrl().equalsIgnoreCase("")) {
			Mensagem.addMensagemErroFacesContext("erro.url.info");
			return false;
		}

		Integer numeroTripulantes = planoVoo.getTripulantes().size();
		Integer numeroCrew = Integer.parseInt(planoVoo.getNave().getCrew());
		Integer numeroPassengers = Integer.parseInt(planoVoo.getNave()
				.getPassengers());

		/*
		 * a quantidade de tripulantes nao pode ser maior que a capacidade da
		 * aeronave. Sendo que esta capacidade e dada pela soma dos pilotos e
		 * dos passageiros
		 */
		if (numeroTripulantes > (numeroCrew + numeroPassengers)) {
			Integer quantidadeMaxima = numeroCrew + numeroPassengers;
			Mensagem.addMensagemErroFacesContext("erro.quantidade",
					quantidadeMaxima.toString());
			return false;
		}

		/*
		 * O planeta de destino nao pode ser igual ao do voo anterior
		 */
		if (planosVoo != null && !planosVoo.isEmpty()) {
			Iterator<PlanoVoo> itr = planosVoo.iterator();

			itr = planosVoo.iterator();
			if (itr.hasNext()) {
				PlanoVoo anterior = itr.next();
				if (anterior.getPlaneta().getName()
						.equalsIgnoreCase(planoVoo.getPlaneta().getName())) {
					Mensagem.addMensagemErroFacesContext("erro.anterior");
					return false;
				}
			}
		}
		return true;
	}

	/* Adiciona novo plano de voo */
	public String salvar() {
		try {

			Planeta planeta = (Planeta) swapiClient.getObjetoByUrl(
					planetaSelecionado, "Planeta");
			Nave nave = (Nave) swapiClient.getObjetoByUrl(naveSelecionada,
					"Nave");

			PlanoVoo novoPlanoVoo = new PlanoVoo();
			novoPlanoVoo.setDataCadastro(new Date());
			novoPlanoVoo.setNave(nave);
			novoPlanoVoo.setPlaneta(planeta);
			novoPlanoVoo.setTripulantes(new HashSet<Tripulante>(tripulantes
					.getTarget()));

			if (validaPlanoVoo(novoPlanoVoo)) {
				planosVoo.add(novoPlanoVoo);
			} else {
				return "erro";
			}

			return "sucesso";

		} catch (RuntimeException e) {
			Mensagem.addMensagemErroFacesContext("erro.salvar");
			return "erro";
		}
	}

	/* abre formulario para inclusao de novo plano de voo */
	public String abrirFormNovoPlano() {
		boolean erro = false;
		planetaSelecionado = null;
		naveSelecionada = null;
		tripulantes = new DualListModel<Tripulante>(tripulantesSource,
				tripulantesTarget);
		if (tripulantesSource == null || tripulantesSource.isEmpty()) {
			Mensagem.addMensagemErroFacesContext("erro.service.tripulantes");
			erro = true;
		}
		if (listaNaves == null || listaNaves.isEmpty()) {
			Mensagem.addMensagemErroFacesContext("erro.service.naves");
			erro = true;
		}
		if (listaPlanetas == null || listaPlanetas.isEmpty()) {
			Mensagem.addMensagemErroFacesContext("erro.service.planeta");
			erro = true;
		}
		if (erro) {
			return "erro";
		} else {
			return "novoPlanoVoo";
		}
	}

}
