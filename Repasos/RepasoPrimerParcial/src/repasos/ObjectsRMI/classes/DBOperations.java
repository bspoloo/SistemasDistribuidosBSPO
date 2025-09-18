/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repasos.ObjectsRMI.classes;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import repasos.ObjectsRMI.Database.PersonDAO;
import repasos.ObjectsRMI.interfaces.IDBOperations;
import repasos.RMI.interfaces.IOperation;

/**
 *
 * @author Animetx
 */
public class DBOperations extends UnicastRemoteObject implements IDBOperations {

    private PersonDAO dbPersons;

    public DBOperations() throws RemoteException {
        super();
        this.dbPersons = new PersonDAO("jdbc:mysql://localhost:3306/personas_bd", "root", "");
    }

    @Override
    public Response insert(Person person) throws RemoteException {
        boolean result = this.dbPersons.insert(person);
        String[] messages = new String[1];
        messages[0] = "Persona insertada correctamente";
        return new Response(result, messages, new Person[]{person});
    }

    @Override
    public Response update(Person person) throws RemoteException {
        boolean result = this.dbPersons.update(person);
        String[] messages = new String[1];
        messages[0] = "Persona actualizada correctamente";
        return new Response(result, messages, new Person[]{person});
    }

    @Override
    public Response getAll() throws RemoteException {
        List<Person> persons = this.dbPersons.getAll();
        boolean result = (persons.isEmpty()) ? false : true;
        String[] messages = new String[1];
        messages[0] = "Traido todas las personas correctamente";
        return new Response(result, messages, persons.toArray(new Person[0]));
    }

    @Override
    public Response getById(int id) throws RemoteException {
        Person person = this.dbPersons.getById(id);
        boolean result = person.equals(null) ? false : true;
        String[] messages = new String[1];
        messages[0] = "Persona traida correctamente";
        return new Response(result, messages, new Person[]{person});
    }

    @Override
    public Response deleteById(int id) throws RemoteException {
        boolean result = this.dbPersons.deleteById(id);
        String[] messages = new String[1];
        messages[0] = "Persona borrada correctamente";
        return new Response(result, messages, null);
    }
}
