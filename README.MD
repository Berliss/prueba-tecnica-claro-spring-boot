# CRUD APPLICATION CLARO

### Requerimientos

1.	Que el servicio sea tipo REST en el lenguaje Java (preferiblemente utilizando Spring).
2.	Que el servicio desarrollado tenga integración con otro servicio REST público.
3.	Que las respuestas se reciban en formato JSON.
4.	Que tenga manejo de excepciones.
5.	Que tenga pruebas unitarias
6.	Que el servicio desarrollado tenga integración con otro servicio SOAP público.
7.	Deben utlizar jersey
8.	Por favor subirlo a un repositorio y cuando lo tengas listo nos envías el link


### Como consumir
En la carpeta **collection** podras encontrar un collection que podras exportar a postman para consumir el servicio, una vez este se encuentre online

### Recursos utilizados

https://www.baeldung.com/spring-soap-web-service

https://blog.payara.fish/returning-beautiful-validation-error-messages-in-jakarta-rest-with-exception-mappers

https://stackoverflow.com/questions/38681986/how-to-override-a-built-in-exception-mapper-in-jersey-2-23

https://eclipse-ee4j.github.io/jersey.github.io/documentation/latest/getting-started.html

https://www.baeldung.com/jersey-bean-validation

https://www.baeldung.com/jax-rs-response

https://medium.com/@theopendle/creating-a-jersey-api-with-spring-boot-87a1af0512e5

### Configuracion de plugin para generar clases de cliente SOAP

```xml
<plugin>
    <groupId>com.sun.xml.ws</groupId>
    <artifactId>jaxws-maven-plugin</artifactId>
    <version>4.0.2</version>
    <executions>
        <execution>
            <goals>
                <goal>wsimport</goal>
            </goals>
            <configuration>
                <wsdlUrls>
                    <wsdlUrl>https://www.dataaccess.com/webservicesserver/NumberConversion.wso?WSDL</wsdlUrl>
                </wsdlUrls>
                <packageName>com.bersoft.crudapplication.client.soap.generated</packageName>
                <sourceDestDir>${project.basedir}/src/main/java</sourceDestDir>
            </configuration>
        </execution>
    </executions>
</plugin>
```