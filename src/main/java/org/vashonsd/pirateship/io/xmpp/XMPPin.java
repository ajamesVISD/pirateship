package org.vashonsd.pirateship.io.xmpp;

import javax.naming.AuthenticationException;

import rocks.xmpp.core.XmppException;
import rocks.xmpp.core.session.TcpConnectionConfiguration;
import rocks.xmpp.core.session.XmppClient;
import rocks.xmpp.core.session.XmppSessionConfiguration;
import rocks.xmpp.core.session.debug.ConsoleDebugger;

public class XMPPin {
	private XmppClient client;

	public XMPPin() {
		super();
		XmppSessionConfiguration config = XmppSessionConfiguration.builder()
			    .debugger(ConsoleDebugger.class)
			    .build();
		client = XmppClient.create("xmpp.pirateship.vashonsd.org", config);
	}
	
	public void Run() {
		try {
			   client.connect();
			} catch (XmppException e) {
			   System.out.println("Here's the error: " + e);
			}
		
		try {
			   client.login("pirateship@xmpp.pirateship.vashonsd.org", "mauvian59", "server");
			} catch (XmppException e) {
			   System.out.println("Failure of type " + e);
			}
	}
	
}
