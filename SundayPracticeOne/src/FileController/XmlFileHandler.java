package FileController;

import Collection.MyCollection;
import EmployeeClass.Employye;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class XmlFileHandler implements FileHandler {
    MyCollection myCollection =MyCollection.createEmployee() ;

    @Override
    public void readFunction() {
        try {
            File file = new File(
                    "/Users/vijaysainag/Downloads/SundayPracticeOne/src/Files/FilesToBeRead/employee.xml");

            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(file);
            doc.getDocumentElement().normalize();
            System.out.println("Root element: " + doc.getDocumentElement().getNodeName());

            NodeList nodeList = doc.getElementsByTagName("employee");

            for (int i = 0; i < nodeList.getLength(); ++i) {
                String fName="",lName="";
                Date DOB = null;
                double exp=0;
                Node node = nodeList.item(i);
                if (node.getNodeType()
                        == Node.ELEMENT_NODE) {
                    Element tElement = (Element) node;
                    fName= (tElement.getElementsByTagName("firstName").item(0).getTextContent()) + " ";
                    lName= (tElement.getElementsByTagName("lastName").item(0).getTextContent()) + " ";
                    DOB = new SimpleDateFormat("dd/MM/YYY").parse(tElement.getElementsByTagName("dateOfBirth").item(0).getTextContent());
                    exp = Double.parseDouble(tElement.getElementsByTagName("experience").item(0).getTextContent());
                }
                myCollection.addEmployee(fName,lName, String.valueOf(DOB),exp);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void WriteFunction() {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        for(int i=0;i<100;i++) {
            try {
                Employye employye = myCollection.getEmployee();
                dBuilder = dbFactory.newDocumentBuilder();
                Document doc = dBuilder.newDocument();
                Element rootElement = doc.createElementNS("", "Employees");
                doc.appendChild(rootElement);
                rootElement.appendChild(getEmployee(doc, "employee", employye.getFirstName(), employye.getLastName(), employye.getDateOfBirth(), String.valueOf(employye.getExperience())));
                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                javax.xml.transform.Transformer transformer = transformerFactory.newTransformer();
                transformer.setOutputProperty(OutputKeys.INDENT, "yes");
                DOMSource source = new DOMSource(doc);
                StreamResult file = new StreamResult(new FileOutputStream("/Users/vijaysainag/Downloads/SundayPracticeOne/src/Files/FilesThatAreWrittenByProgram/newEmployee.xml", true));
                transformer.transform(source, file);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static Node getEmployee(Document doc, String id, String firstName, String lastName, String dateOfBirth, String exp) {
        Element employee = doc.createElement("Employee");
        employee.setAttribute("id", id);
        employee.appendChild(getEmployeeElements(doc, employee, "firstName",firstName ));
        employee.appendChild(getEmployeeElements(doc, employee, "lastName", lastName));
        employee.appendChild(getEmployeeElements(doc, employee, "dateOfBirth", dateOfBirth));
        employee.appendChild(getEmployeeElements(doc,employee,"experience",exp));
        return employee;

    }

    private static Node getEmployeeElements(Document doc, Element element, String name, String value) {
        Element node = doc.createElement(name);
        node.appendChild(doc.createTextNode(value));
        return node;
    }
}
