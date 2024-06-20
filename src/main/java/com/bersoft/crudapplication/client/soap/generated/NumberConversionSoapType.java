
package com.bersoft.crudapplication.client.soap.generated;

import java.math.BigDecimal;
import java.math.BigInteger;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.ws.RequestWrapper;
import jakarta.xml.ws.ResponseWrapper;


/**
 * This class was generated by the XML-WS Tools.
 * XML-WS Tools 4.0.1
 * Generated source version: 3.0
 * 
 */
@WebService(name = "NumberConversionSoapType", targetNamespace = "http://www.dataaccess.com/webservicesserver/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface NumberConversionSoapType {


    /**
     * Returns the word corresponding to the positive number passed as parameter. Limited to quadrillions.
     * 
     * @param ubiNum
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "NumberToWords")
    @WebResult(name = "NumberToWordsResult", targetNamespace = "http://www.dataaccess.com/webservicesserver/")
    @RequestWrapper(localName = "NumberToWords", targetNamespace = "http://www.dataaccess.com/webservicesserver/", className = "com.bersoft.crudapplication.client.soap.generated.NumberToWords")
    @ResponseWrapper(localName = "NumberToWordsResponse", targetNamespace = "http://www.dataaccess.com/webservicesserver/", className = "com.bersoft.crudapplication.client.soap.generated.NumberToWordsResponse")
    public String numberToWords(
        @WebParam(name = "ubiNum", targetNamespace = "http://www.dataaccess.com/webservicesserver/")
        BigInteger ubiNum);

    /**
     * Returns the non-zero dollar amount of the passed number.
     * 
     * @param dNum
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "NumberToDollars")
    @WebResult(name = "NumberToDollarsResult", targetNamespace = "http://www.dataaccess.com/webservicesserver/")
    @RequestWrapper(localName = "NumberToDollars", targetNamespace = "http://www.dataaccess.com/webservicesserver/", className = "com.bersoft.crudapplication.client.soap.generated.NumberToDollars")
    @ResponseWrapper(localName = "NumberToDollarsResponse", targetNamespace = "http://www.dataaccess.com/webservicesserver/", className = "com.bersoft.crudapplication.client.soap.generated.NumberToDollarsResponse")
    public String numberToDollars(
        @WebParam(name = "dNum", targetNamespace = "http://www.dataaccess.com/webservicesserver/")
        BigDecimal dNum);

}
