package biz.ax0.yamapjs;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

/**
 * Created by ivan on 03.12.14.
 */
public class Main {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

        String req = "";
        for (String arg : args) {
            req+=arg + " ";
        }

        YaAdress yaAdress = getAdress(req);
        System.out.println(yaAdress.toString());


    }

    private static YaAdress getAdress(String req) throws ParserConfigurationException, SAXException, IOException {
        boolean allOkFlag = true;
        boolean posOkFlag = true;
        YaAdress yaAdress = new YaAdress();

        Document response = getYandexRequest(req);

        try {
            yaAdress.setFullAdress(response.getElementsByTagName("text").item(0).getTextContent());
        } catch (NullPointerException e) {
            allOkFlag = false;
        }
        try {
            yaAdress.setAddressLine(response.getElementsByTagName("AddressLine").item(0).getTextContent());
        } catch (NullPointerException e) {
            allOkFlag = false;
        }
        try {
            yaAdress.setAdministrativeAreaName(response.getElementsByTagName("AdministrativeAreaName").item(0).getTextContent());
        } catch (Exception e) {
            allOkFlag = false;
        }
        try {
            yaAdress.setSubAdministrativeAreaName(response.getElementsByTagName("SubAdministrativeAreaName").item(0).getTextContent());
        } catch (Exception e) {
            allOkFlag = false;
        }
        try {
            yaAdress.setLocalityName(response.getElementsByTagName("LocalityName").item(0).getTextContent());
        } catch (Exception e) {
            allOkFlag = false;
        }
        try {
            yaAdress.setThoroughfareName(response.getElementsByTagName("ThoroughfareName").item(0).getTextContent());
        } catch (Exception e) {
            allOkFlag = false;
        }
        try {
            yaAdress.setPremiseNumber(response.getElementsByTagName("PremiseNumber").item(0).getTextContent());
        } catch (Exception e) {
            allOkFlag = false;
        }
        try {
            yaAdress.setPos(response.getElementsByTagName("pos").item(0).getTextContent());
        } catch (Exception e) {
            posOkFlag = false;
        }

        yaAdress.setAllOk(allOkFlag);
        yaAdress.setPosOk(posOkFlag);


        return yaAdress;
    }

    private static Document getYandexRequest(String req) throws IOException, ParserConfigurationException, SAXException {
        URL url = new URL("http://geocode-maps.yandex.ru/1.x/?geocode=" + URLEncoder.encode(req, "UTF-8"));
        URLConnection uc = url.openConnection();
        HttpURLConnection httpConnection = (HttpURLConnection) uc;
        InputStream stream = httpConnection.getInputStream();
        InputStreamReader isReader = new InputStreamReader(stream);
        BufferedReader br = new BufferedReader(isReader);
        String result = "";
        String line;
        while ((line = br.readLine()) != null) {
            result += line;
        }
        httpConnection.disconnect();
        br.close();
        return stringToDom(result);
    }

    private static Document stringToDom(String xmlSource) throws SAXException, ParserConfigurationException, IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        return builder.parse(new InputSource(new StringReader(xmlSource)));
    }

}


