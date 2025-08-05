package bibliotecafacultad.Menu;

public class MenuInitial implements IMenu{

    @Override
    public void mostrarMenu() {
        System.out.println("1.- Bibliotecas");
        System.out.println("2.- Armarios");
        System.out.println("3.- Publicaciones");
    }
}
