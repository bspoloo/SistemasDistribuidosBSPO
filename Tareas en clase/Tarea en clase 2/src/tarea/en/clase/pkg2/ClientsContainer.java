package tarea.en.clase.pkg2;

public class ClientsContainer {
    private final ClientsContainer instance = new ClientsContainer();

    private ClientsContainer() {

    }

    public ClientsContainer getClientesContainer() {
        return this.instance;
    }
}
