package com.kwin.db.service;

import org.apache.axis2.AxisFault;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.rpc.client.RPCServiceClient;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author JYP
 * @date 2020/10/27
 **/

@Service
//@Transactional
public class CurrentdtService {

    public List<Double> getCurrentdtList(String logo) {
        String userName="starShine";
        String pasword = "qwert54321";
        //String url="http://202.85.216.67:8080/services/iotDataService";
        String url="http://iot.klha.net:8080/services/iotDataService?wsdl";
        //String logo="1100201204180162";
        //String logo="1100201808081001"; //网关号 另有sensor_name设备号 channel_name通道号，可以将这些设为参数，来请求不同设备数据
        String method="GatewayData";
        String xml = sendService(userName,pasword,url,method,logo);
        List<Double> paramList = new ArrayList<>();
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = dbf.newDocumentBuilder();
            InputStream inputStream = new ByteArrayInputStream(xml.getBytes("utf-8"));
            Document doc = builder.parse(inputStream);
            Element root = (Element) doc.getDocumentElement();
            String rootName = root.getNodeName();
            NodeList nodelist = root.getChildNodes();
            int size = nodelist.getLength();
            for(int i=0;i<4;i++){
                Node node = nodelist.item(i);
                if(node.getNodeType()==Node.ELEMENT_NODE){
                    Element elementNode = (Element)node;
                    String name=elementNode.getNodeName();
                    String content=elementNode.getTextContent();
                    paramList.add(Double.parseDouble(content.split("value")[1]));
                    //System.out.println(name+"-------------------------"+content);
                }
            }

        } catch (ParserConfigurationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SAXException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return paramList;
    }

    public Map<String,Object> getCurrentdt(String type,String logo){
        Double value = 0.0;
        switch (type) {
            case "temperature":
                value = getCurrentdtList(logo).get(0);
                break;
            case "humidity":
                value = getCurrentdtList(logo).get(1);
                break;
            case "soil_temperature":
                value = getCurrentdtList(logo).get(2);
                break;
            case "soil_humidity":
                value = getCurrentdtList(logo).get(3);
                break;
            default:
                break;
        }
        Map<String,Object> map = new HashMap<>();
        map.put(type,value);
        return map;
    }


    /**
     * @param userName
     * @param password
     * @param url       ַ
     * @param method
     * @param logo
     * @return
     */
    public static String sendService(String userName,String password,String url,String method,String logo) {
        String xml =null;
        RPCServiceClient serviceClient = null ;
        try {
            serviceClient = new RPCServiceClient();
        } catch (AxisFault e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Options options = serviceClient.getOptions();
        EndpointReference targetEPR = new EndpointReference(url);
        options.setTo(targetEPR);
        QName opAddEntry = new QName("http://action.web.iot_data_service.com",method);
        Object[] opAddEntryArgs = new Object[] {userName,password,logo};

        Class[] classes = new Class[] { String.class };
        try {
            xml=(String) serviceClient.invokeBlocking(opAddEntry,opAddEntryArgs, classes)[0];
        } catch (AxisFault e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return xml;
    }

}
