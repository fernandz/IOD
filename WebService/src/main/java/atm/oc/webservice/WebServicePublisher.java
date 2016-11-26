package atm.oc.webservice;

import javax.xml.ws.Endpoint;

class WebServicePublisher {

	public static void main(String[] args) {

		Endpoint.publish("http://0.0.0.0:54321/hello", new WebServiceImpl());

	}

}
