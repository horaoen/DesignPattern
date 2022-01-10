package DAO;

import java.io.IOException;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Text;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class ConnectionProperty {

	private String dbms = "";
	private String driverClassName = "";
	private static ConnectionProperty instance = new ConnectionProperty();
	private String jndiName = "";
	private static Logger log = Logger.getLogger("ConnectionProperty");
	private String password = "";
	private String providerType = "";
	private String url = "";
	private String user = "";
	private static final String XML_FILE = "/dbconfig.xml";

	private ConnectionProperty(){
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = null;
		Document doc = null;
	
		try {
			String xmlFile = this.getClass().getResource(XML_FILE).getPath();
			builder = factory.newDocumentBuilder();
			doc = builder.parse(xmlFile);
		} catch (ParserConfigurationException e) {
			log.warning(e.getMessage());
		} catch (SAXException e) {
			log.warning(e.getMessage());
		} catch (IOException e) {
			log.warning(e.getMessage());
		}finally{
			//doc.close();
		}
	
		Element root = doc.getDocumentElement();
		providerType = root.getAttribute("type");
		dbms = root.getAttribute("dbms");
		System.out.println("\n\n******DAO从dbconfig.xml访问的DBMS为："+dbms +" ******\n");
		if( providerType.equals("connection_pool") ){
		   jndiName = root.getAttribute("jndi");
		}
		else if( providerType.equals("default") ){
		  driverClassName = value( root, "driver_class_name" );
		  url = value( root, "url" );
		  user = value( root, "user" );
		  password = value( root, "password" );
		}
	}

	public String getDBMS(){
		return dbms;
	}

	public String getDriverClassName(){
		return driverClassName;
	}


	public static ConnectionProperty getInstance(){
		if( instance == null ){
			instance = new ConnectionProperty();
		}
		return instance;
	}

	public String getJndiName(){
		return jndiName;
	}

	public String getPassword(){
		return password;
	}

	public String getProviderType(){
		return providerType;
	}

	public String getUrl(){
		return url;
	}

	public String getUser(){
		return user;
	}

	private String value(Element element, String tagName){
		Element e = (Element)element.getElementsByTagName(tagName).item(0);
		Text text = (Text) e.getFirstChild();
		return text.getNodeValue();
	}
}//end ConnectionProperty