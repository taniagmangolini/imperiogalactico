package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.List;

import model.Nave;
import model.Planeta;
import model.Tripulante;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

public class RestfulServiceUtil {

	/* obter json */
	public static String obterJson(InputStream inputStream) {

		try {
			BufferedReader rd = new BufferedReader(new InputStreamReader(
					inputStream, Charset.forName("UTF-8")));

			// obtendo o json
			StringBuilder sb = new StringBuilder();

			int cp;
			while ((cp = rd.read()) != -1) {
				sb.append((char) cp);
			}

			String jsonText = sb.toString();

			return jsonText;

		} catch (Exception e) {
			Mensagem.addMensagemErroFacesContext("erro.servico.json");
			return null;
		}
	}

	/* obter elemento de um json */
	public static JsonElement obterElementJson(String json, String element) {

		try {
			JsonParser parser = new JsonParser();
			JsonObject obj = parser.parse(json).getAsJsonObject();

			return obj.getAsJsonObject().get(element);

		} catch (RuntimeException e) {
			Mensagem.addMensagemErroFacesContext("erro.servico.elemento.json");
			return null;
		}
	}
	
	/* requisicao a um rest Service
	 *   return: elemento array do json */
	public static InputStream realizaRequest(String address) {

		URLConnection uc;

		try {
			URL url = new URL(address);
			uc = url.openConnection();
			uc.connect();
			uc = url.openConnection();
			uc.addRequestProperty("User-Agent",
					"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.0)");

			return uc.getInputStream();

		} catch (IOException e) {
			Mensagem.addMensagemErroFacesContext("erro.servico.io.request");
			return null;
		}catch (RuntimeException e) {
			Mensagem.addMensagemErroFacesContext("erro.servico.request");
			return null;
		}
	}

	/* requisicao a um rest Service
	 *   return: elemento array do json */
	public static String consultaRestService(String address) {
		try {

			return obterJson(realizaRequest(address));

		} catch (RuntimeException e) {
			Mensagem.addMensagemErroFacesContext("erro.servico.consultar");
			return null;
		}
	}

	/* requisicao a um rest Service
	 *   retorna elemento array do json */
	public static <T> List<T> consultaRestService(String address,
			String elemento, String classe) {

		Type projectListType;
		List<T> resultado;

		try {
			// obtem o elemento  do JSON
			JsonElement results = obterElementJson(
					obterJson(realizaRequest(address)), elemento);
			
			if (classe.equalsIgnoreCase("Planeta")) {
				projectListType = new TypeToken<List<Planeta>>() {
				}.getType();

			} else if (classe.equalsIgnoreCase("Nave")) {
				projectListType = new TypeToken<List<Nave>>() {
				}.getType();

			} else {
				projectListType = new TypeToken<List<Tripulante>>() {
				}.getType();
			}

			Gson gson = new Gson();
			resultado = gson.fromJson(results, projectListType);

			return resultado;

		} catch (RuntimeException e) {
			Mensagem.addMensagemErroFacesContext("erro.servico.consultar");
			return null;
		}
	}
}
