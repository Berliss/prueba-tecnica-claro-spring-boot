
package com.bersoft.crudapplication.client.soap.generated;

import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.bersoft.crudapplication.client.soap.generated package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.bersoft.crudapplication.client.soap.generated
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link NumberToWords }
     * 
     * @return
     *     the new instance of {@link NumberToWords }
     */
    public NumberToWords createNumberToWords() {
        return new NumberToWords();
    }

    /**
     * Create an instance of {@link NumberToWordsResponse }
     * 
     * @return
     *     the new instance of {@link NumberToWordsResponse }
     */
    public NumberToWordsResponse createNumberToWordsResponse() {
        return new NumberToWordsResponse();
    }

    /**
     * Create an instance of {@link NumberToDollars }
     * 
     * @return
     *     the new instance of {@link NumberToDollars }
     */
    public NumberToDollars createNumberToDollars() {
        return new NumberToDollars();
    }

    /**
     * Create an instance of {@link NumberToDollarsResponse }
     * 
     * @return
     *     the new instance of {@link NumberToDollarsResponse }
     */
    public NumberToDollarsResponse createNumberToDollarsResponse() {
        return new NumberToDollarsResponse();
    }

}
