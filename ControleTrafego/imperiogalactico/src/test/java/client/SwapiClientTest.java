package client;

import static org.junit.Assert.*;

import java.util.ArrayList;

import model.Tripulante;

import org.junit.Test;
import org.primefaces.model.DualListModel;

import client.SwapiClient;

public class SwapiClientTest {

	@Test
	public void testGetObjetoByUrl() {
		SwapiClient swapiClient = new SwapiClient();

		Object obj = swapiClient.getPlanetas();
		assertNotNull(obj);
		
		String url2 = ("http://swapi.co/api/starships/3/");
		Object obj2 = swapiClient.getObjetoByUrl(url2, "Nave");
		assertNotNull(obj2);
		
		Object obj3 = swapiClient.getObjetoByUrl(null, "Nave");
		assertNull(obj3);
		
		//url errada
		String url3 = ("http://swapi.co/api/starships//");
		Object obj4 = swapiClient.getObjetoByUrl(url3, "Nave");
		assertNull(obj4);

	}

}
