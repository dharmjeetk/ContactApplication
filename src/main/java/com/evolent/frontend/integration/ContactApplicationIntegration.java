package com.evolent.frontend.integration;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMethod;

import com.evolent.frontend.exceptions.ApplicationIntegrationException;

/**
 * This is back-end integration class of front end for calling back-end REST
 * application and getting valid data for rendering in view
 * 
 * @author dharmjeet.kumar
 *
 */
public class ContactApplicationIntegration {
	private static final Logger logger = Logger.getLogger(ContactApplicationIntegration.class);
	private static final String APPLICATION_PROPERTIES = "frontend.properties";

	private ContactApplicationIntegration() {
		// private constructor as we don't want to make any new instance
	}

	public static String getContactApplicationManagerResponse(RequestMethod requestType, Integer contact,
			String contactObjJson) {
		StringBuilder response = new StringBuilder();
		String output = "";
		try {

			Properties applicationProperties = readContactApplicationBackEndProperties();
			String applicationUrl = applicationProperties.getProperty("contactApplication.url");
			String urlStr = (contact != null && contact.intValue() != 0) ? applicationUrl + "/" + contact
					: applicationUrl;
			logger.debug("URL final is " + urlStr);
			URL url = new URL(urlStr);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod(requestType.name());
			conn.setRequestProperty("Content-Type", "application/json; utf-8");
			conn.setRequestProperty("Accept", "application/json");
			conn.setDoOutput(true);

			if (StringUtils.isNotBlank(contactObjJson)) {
				logger.trace("contact Obj -> " + contactObjJson);
				try (OutputStream os = conn.getOutputStream()) {
					byte[] input = contactObjJson.getBytes("utf-8");
					os.write(input, 0, input.length);
				}
			}

			if (conn.getResponseCode() != HttpStatus.OK.value()) {
				logger.error("Failed : HTTP error code : " + conn.getResponseCode() + ", HTTP error message : "
						+ conn.getResponseMessage());
				throw new ApplicationIntegrationException("Failed : HTTP error code : " + conn.getResponseCode()
						+ ", HTTP error message : " + conn.getResponseMessage());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

			while ((output = br.readLine()) != null) {
				response.append(output);
			}
			conn.disconnect();
		} catch (MalformedURLException e) {
			logger.error("Back-end Application URL has some issues" + e.getMessage());
			throw new ApplicationIntegrationException("Back-end Application URL has some issues", e);
		} catch (IOException e) {
			logger.error("Some IO exception occurred while calling back-end application" + e.getMessage());
			throw new ApplicationIntegrationException("Some IO exception occurred while calling back-end application",
					e);
		}

		return response.toString();
	}

	private static Properties readContactApplicationBackEndProperties() throws IOException {
		Properties properties = new Properties();
		properties.load(new DefaultResourceLoader().getResource(APPLICATION_PROPERTIES).getInputStream());
		return properties;
	}
}
