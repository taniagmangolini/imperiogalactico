package client;

import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import model.Nave;
import model.Planeta;
import model.Tripulante;
import util.Mensagem;
import util.RestfulServiceUtil;

import com.google.gson.Gson;

//@Named

@ApplicationScoped
@ManagedBean(name="swapiClient")
public class SwapiClient {

	private static String BASE_URL = "http://swapi.co/api";
	private static String PLANETS = "/planets";
	private static String PEOPLE = "/people";
	private static String STARSHIPS = "/starships";
	private static String JSON_FORMAT = "/?format=json";
	private static String JSON_FORMAT_WITHOUT_SLASH = "?format=json";
	
	/* obtem a lista de planetas */
	public List<Planeta> getPlanetas() {

		String url = BASE_URL + PLANETS + JSON_FORMAT;
		try {
			List<Planeta> planetas = RestfulServiceUtil.consultaRestService(
					url, "results", "Planeta");
			
			return planetas;

		} catch (Exception e) {
			Mensagem.addMensagemErroFacesContext("erro.servico.planetas");
			return null;
		}
	}

	/* obtem a lista de naves */
	public List<Nave> getNaves() {

		String url = BASE_URL + STARSHIPS + JSON_FORMAT;
		try {
			List<Nave> naves = RestfulServiceUtil.consultaRestService(url,
					"results", "Nave");

			return naves;

		} catch (Exception e) {
			Mensagem.addMensagemErroFacesContext("erro.servico.naves");
			return null;
		}
	}

	/* obtem a lista de pessoas */
	public List<Tripulante> getTripulantes() {

		String url = BASE_URL + PEOPLE + JSON_FORMAT;
		try {
			List<Tripulante> tripulantes = RestfulServiceUtil
					.consultaRestService(url, "results", "Tripulante");

			return tripulantes;
			
		} catch (Exception e) {
			Mensagem.addMensagemErroFacesContext("erro.servico.tripulantes");
			return null;
		}
	}
	
	/*obtem objeto especifico pela url dele*/
	public Object getObjetoByUrl(String url, String classe) {

		try {
			String json = RestfulServiceUtil.consultaRestService(url + JSON_FORMAT_WITHOUT_SLASH);

			Gson gson = new Gson();
			
			if (classe.equalsIgnoreCase("Planeta")) {
				return gson.fromJson(json, Planeta.class);
			} else if (classe.equalsIgnoreCase("Nave")) {
				return gson.fromJson(json, Nave.class);

			} else {
				return null;
			}
		} catch (Exception e) {
			Mensagem.addMensagemErroFacesContext("erro.servico.url", classe);
			return null;
		}
	}
}
