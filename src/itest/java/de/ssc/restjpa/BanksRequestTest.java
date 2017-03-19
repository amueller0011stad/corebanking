package de.ssc.restjpa;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.junit.Test;

import de.ssc.restjpa.model.Bank;

/**
 * Testklasse um den Servicecall mit create und list auszuprobieren.
 * .\gradlew.bat -Dcorebanking.base.url="http://localhost:8080/corebanking" itest
 * 
 * @author ufreise
 *
 */
public class BanksRequestTest
{
	private static final String DEFAULT_BASE_URL = "http://localhost:8080/corebanking";
	private static final String BASE_URL_PROPERTY = "corebanking.base.url";
	
	@Test
	public void testServiceCall()
	{
		listBanks();
		createBank();
		listBanks();
	}
	
	private void listBanks()
	{
		ClientConfig clientConfig = new ClientConfig();
		clientConfig.register(JacksonFeature.class);
		
		Client client = ClientBuilder.newClient(clientConfig);

		WebTarget webTarget = client.target(getBaseUrl() + "/corebanking/banks/list");

		Builder request = webTarget.request();
		request.header("Content-type", MediaType.APPLICATION_JSON);

		List<Bank> banks = request.buildGet().invoke(new GenericType<List<Bank>>() {});
		
		System.out.println("Found " + banks.size() + " banks");
		for (Bank bank : banks) {
			System.out.println("  " + bank.getId() + ", " + bank.getBankNumber() + ", " + bank.getDescription() + ", " + bank.getServerAdress());
		}
	}
	
	private void createBank()
	{
		Bank bank = new Bank();
		bank.setBankNumber(4713);
		bank.setDescription("Deutsche Kartoffelbank");
		bank.setServerAdress("http://dkb.com/");
		
		ClientConfig clientConfig = new ClientConfig();
		clientConfig.register(JacksonFeature.class);
		
		Client client = ClientBuilder.newClient(clientConfig);

		Builder request = client.target(getBaseUrl() + "/corebanking/banks/create").request();
		request.header("Content-type", MediaType.APPLICATION_JSON);
		Bank createdBank = request.buildPut(Entity.json(bank)).invoke(new GenericType<Bank>() {});

		assertThat(createdBank, is(notNullValue()));

		System.out.println("Bank with id " + createdBank.getId() + " created");
	}
	
	private String getBaseUrl()
	{
		System.out.println(System.getProperty(BASE_URL_PROPERTY, DEFAULT_BASE_URL));
		return System.getProperty(BASE_URL_PROPERTY, DEFAULT_BASE_URL);
	}
	
	public static void main(String[] args) {
		new BanksRequestTest().testServiceCall();
	}
}
