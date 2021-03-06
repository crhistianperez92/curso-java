import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Main main = new Main();
		main.imprimirMenu();
	}

	public void imprimirMenu() {
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("Bienvenido al sistema de registro y consulta del padrón del seguro social, a continuación aparecen las opciones disponibles:");
		System.out.println("");
		System.out.println("1. Agregar asegurado");
		System.out.println("2. Consultar asegurado");
		System.out.println("3. Eliminar asegurado");
		System.out.println("4. Salir");
		System.out.println("");
		System.out.print("Ingrese el número de la opción deseada y presione enter: ");

		Scanner scanner = new Scanner(System.in);
		int opcion = scanner.nextInt();
		
		ejecutarOpcion(opcion);
	}

	public void ejecutarOpcion(int opcion) {
		switch (opcion) {
			case 1:
				System.out.print("Haz seleccionado la opción 1. Presione enter para continuar.");
			break;
			case 2:
				System.out.print("Haz seleccionado la opcioón 2. Presione enter para continuar.");
			break;
			case 3:
				System.out.print("Haz seleccionado la opción 3. Presione enter para continuar.");
			break;
			case 4:
				System.out.print("¡Gracias por utilizar el sistema!");
				System.exit(0);
			break;
			default:
				System.out.print("La opción seleccionada no es válida. Presione enter para continuar.");
			break;
		}

		new Scanner(System.in).nextLine();
		imprimirMenu();
	}

}