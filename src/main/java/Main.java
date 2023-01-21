import com.google.gson.Gson;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.PropertyException;

import java.io.File;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, JAXBException {
        DBConn db = new DBConn("flights.db");

        //Obtenemos el objeto desde la base de datos y lo imprimimos con formato Json
        String json = db.getObjectFromDb();
        System.out.println(json);

        //Serializamos el objeto de clase Flight
        Gson gson = new Gson();
        Flight flight = gson.fromJson(json, Flight.class);
        System.out.println(flight);

        //Deserializamos el objeto en un fichero xml
        JAXBContext jaxbContext = JAXBContext.newInstance(Flight.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        /* set this flag to true to format the output */
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        /* marshaling of java objects in xml (output to file and standard output) */
        jaxbMarshaller.marshal(flight, new File("flight.xml"));
        jaxbMarshaller.marshal(flight, System.out);


    }
}
