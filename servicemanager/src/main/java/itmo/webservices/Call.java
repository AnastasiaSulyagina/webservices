/*
 * Copyright 2001-2010 The Apache Software Foundation.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package itmo.webservices;

import java.net.URL;
import java.util.Map;

import javax.xml.ws.BindingProvider;

import itmo.webservices.samples.HelloWorld;
import itmo.webservices.samples.HelloWorld_Service;
import org.apache.juddi.v3.client.config.UDDIClerk;
import org.apache.juddi.v3.client.config.UDDIClient;
import org.apache.juddi.v3.client.mapping.ServiceLocator;

public class Call {
	
	public static void call() {
		try {
			UDDIClient uddiClient = new UDDIClient("META-INF/wsdl2uddi-uddi.xml");
			UDDIClerk clerk = uddiClient.getClerk("clerk");
        	
        	//find the service in the UDDI registry
        	System.out.println("The clientside of a runtime lookup usually knows the serviceKey.");
        	System.out.println("To get updated binding information you should use the ServiceLocator with a live cache.");
        	String helloWorldServiceKey = "uddi:uddi.mypublisher.com:service_helloworld";

        	ServiceLocator serviceLocator = new ServiceLocator(clerk);
        	String endpoint = serviceLocator.lookupEndpoint(helloWorldServiceKey);
        	

        	HelloWorld_Service helloWorldService = new HelloWorld_Service();
        	HelloWorld helloWorld = helloWorldService.getHelloWorldImplPort();
        	Map<String, Object> requestContext = ((BindingProvider) helloWorld).getRequestContext();
			requestContext.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, endpoint);
			String reply = helloWorld.sayHi("Judy");
        	System.out.println("*************** Service reply: " + reply);
			//need to call shutdown to take down the LiveCache Callback Endpoint.
        	Thread.sleep(10l);
        	serviceLocator.shutdown();
			
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}		

	public static void main (String args[]) {
		Call sp = new Call();
		sp.call();	
	}
}
