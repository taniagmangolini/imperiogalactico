package util;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.io.InputStream;

import org.junit.Test;

public class RestfulServiceUtilTest {

	String jsonPlaneta = "{\"name\":\"Yavin IV\",\"rotation_period\":\"24\",\"orbital_period\":\"4818\",\"diameter\":\"10200\",\"climate\":\"temperate, tropical\",\"gravity\":\"1 standard\",\"terrain\":\"jungle, rainforests\",\"surface_water\":\"8\",\"population\":\"1000\",\"residents\":[],\"films\":[\"http://swapi.co/api/films/1/\"],\"created\":\"2014-12-10T11:37:19.144000Z\",\"edited\":\"2014-12-20T20:58:18.421000Z\",\"url\":\"http://swapi.co/api/planets/3/\"}";

			
	@Test
	public void testObterJson() {
		String result = RestfulServiceUtil.obterJson(null);
		assertNull(result);
	}


	 @Test public void testObterElementJson() {
		//json sem o elemento results 
		 Object result =  RestfulServiceUtil.obterElementJson(jsonPlaneta, "results");
		 assertNull(result);
	 }
	

	@Test
	public void testRealizaRequest() {
		InputStream result = RestfulServiceUtil.realizaRequest(null);
		assertNull(result);

		result = RestfulServiceUtil.realizaRequest("http://urlerrada.com/api");
		assertNull(result);

		result = RestfulServiceUtil
				.realizaRequest("http://swapi.co/api/planets/3/?format=json");
		assertNotNull(result);
	}

}
