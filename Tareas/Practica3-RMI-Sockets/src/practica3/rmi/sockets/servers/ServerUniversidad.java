package practica3.rmi.sockets.servers;


import practica3.rmi.sockets.clients.ClienteSEDUCA;
import practica3.rmi.sockets.clients.ClienteSERECI;
import practica3.rmi.sockets.classes.RespuestaSEGIP;
import practica3.rmi.sockets.classes.Diploma;
import practica3.rmi.sockets.interfaces.IServerSEGIP;
import practica3.rmi.sockets.interfaces.IServerUniversidad;
import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class ServerUniversidad extends UnicastRemoteObject implements IServerUniversidad{
    public ServerUniversidad() throws RemoteException {
        super();
    }

    @Override
    public Diploma emitirDiploma(String ci, String nombres, String primerApellido,
                                 String segundoApellido, String fechaNacimiento, String carrera)
            throws RemoteException {

        StringBuilder mensajesError = new StringBuilder();
        String nombreCompleto = nombres + " " + primerApellido + " " + segundoApellido;

        // 1. Verificar con SEGIP (RMI)
        try {
            IServerSEGIP segip = (IServerSEGIP) Naming.lookup("rmi://localhost:1100/ServidorSEGIP");
            RespuestaSEGIP respuestaSEGIP = segip.verificarDatos(ci, nombres, primerApellido + " " + segundoApellido);

            if (!respuestaSEGIP.isEstado()) {
                mensajesError.append("SEGIP: ").append(respuestaSEGIP.getMensaje()).append("\n");
            }
        } catch (Exception e) {
            mensajesError.append("Error al conectar con SEGIP: ").append(e.getMessage()).append("\n");
        }

        // 2. Verificar con SEDUCA (Socket TCP) - Bachillerato
        try {
            String rude = generarRUDE(nombres, primerApellido, segundoApellido, fechaNacimiento);
            String respuestaSEDUCA = ClienteSEDUCA.verificarBachiller(rude);

            if (!respuestaSEDUCA.startsWith("si:")) {
                mensajesError.append("SEDUCA: ").append(respuestaSEDUCA.split(":")[1]).append("\n");
            }
        } catch (Exception e) {
            mensajesError.append("Error al verificar bachillerato: ").append(e.getMessage()).append("\n");
        }

        // 3. Verificar con SERECI (Socket UDP) - Fecha nacimiento
        try {
            String datosFecha = "Ver-fecha:" + nombres + "," + primerApellido + " " + segundoApellido + "," + fechaNacimiento;
            String respuestaSERECI = ClienteSERECI.verificarFecha(datosFecha);

            if (!respuestaSERECI.startsWith("si:")) {
                mensajesError.append("SERECI: ").append(respuestaSERECI.split(":")[1]).append("\n");
            }
        } catch (Exception e) {
            mensajesError.append("Error al verificar fecha: ").append(e.getMessage()).append("\n");
        }

        // 4. Devolver diploma con resultado
        if (mensajesError.length() == 0) {
            // Todo correcto - emitir diploma
            return new Diploma(nombreCompleto, carrera, java.time.LocalDate.now().toString(), "");
        } else {
            // Hay errores - devolver mensajes
            return new Diploma("", "", "", mensajesError.toString());
        }
    }

    private String generarRUDE(String nombres, String primerApellido, String segundoApellido, String fechaNacimiento) {
        // Extraer primeras 2 letras del nombre (ej: "Walter" -> "Wa")
        String iniNombre = nombres.length() >= 2 ? nombres.substring(0, 2) : nombres;

        // Extraer primeras 2 letras de cada apellido
        String iniPrimerApellido = primerApellido.length() >= 2 ? primerApellido.substring(0, 2) : primerApellido;
        String iniSegundoApellido = segundoApellido.length() >= 2 ? segundoApellido.substring(0, 2) : segundoApellido;

        // Formatear fecha (eliminar guiones)
        String fechaFormateada = fechaNacimiento.replace("-", "");

        return iniNombre + iniPrimerApellido + iniSegundoApellido + fechaFormateada;
    }

    public static void main(String[] args) {
        try {
            // Crear e instanciar el servidor
            ServerUniversidad servidorUniversidad = new ServerUniversidad();

            // Crear registro RMI en puerto 1099
            LocateRegistry.createRegistry(1099);

            // Registrar el servidor
            Naming.bind("ServidorUniversidad", servidorUniversidad);

            System.out.println("Servidor Universidad RMI listo...");

        } catch (RemoteException ex) {
            System.err.println("Error de comunicación: " + ex.getMessage());
        } catch (AlreadyBoundException ex) {
            System.err.println("Servidor ya registrado: " + ex.getMessage());
        } catch (MalformedURLException ex) {
            System.err.println("URL mal formada: " + ex.getMessage());
        } catch (Exception ex) {
            System.err.println("Error general: " + ex.getMessage());
        }
    }
}
