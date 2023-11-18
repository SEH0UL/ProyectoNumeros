package EjercicioClase;

import java.util.Scanner;

public class JuegoNumero2 {
	static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {
		int usuario, contadorPartidas = 0;

		do {
			// Le damos al usuario las opciones de menu
			System.out.println("Quieres jugar? ");
			System.out.println("Si la respuesta es si. Pulsa 1");
			System.out.println("Si la respuesta es no. Pulsa 2");
			System.out.println("Cuantas partidas llevas jugadas. Pulsa 3");
			System.out.println("¿Cúal es el número aleatorio? Pulsa 4");
			usuario = teclado.nextInt();
			// Las leemos y ejecutamos lo que pide
			switch (usuario) {
			case 1:
				System.out.println("Bienvenido al Juego");
				contadorPartidas++;
				juego();
				break;
			case 2:
				System.out.println("Gracias por jugar ");
				break;
			case 3:
				System.out.println("Llevas jugadas " + contadorPartidas + " partidas");
				break;
			case 4:
				System.out.println("El numero aleatorio sera " + generarAleatorio());
				System.out.println("Pero esto es hacer trampas eeee :/ ");
			}

		} while (usuario != 2);

	}

	// metodo para generar un num aleatorio entre 1-100
	public static int generarAleatorio() {
		int resultado = 0;
		resultado = (int) (Math.random() * 100 + 1);
		return resultado;
	}

	public static void juego() {
		int numUsuario, contadorVidas = 5;
		int numAleatorio = generarAleatorio();
		System.out.println("Tienes 5 vidas para resolverlo ");
		System.out.println(numAleatorio);
		do {
			System.out.println("Intenta adivinar el numero del 1-100: ");
			numUsuario = teclado.nextInt();
			contadorVidas--;
			// Si exceses el numero de intentos entonces eliminado
			if (contadorVidas == 0) {
				System.out.println("Te quedan " + contadorVidas + " vidas");
				System.out.println("Te has quedado sin vidas, GAME OVER");
				System.out.println("El numero era " + generarAleatorio());
				// Si el usuario no entra dentro de los numeros
			} else if (numUsuario < 0 || numUsuario >= 100) {
				System.out.println("LEE EL ENUNCIADO MERLUZO ");
				System.out.println("Encima vas y pierdes una vida ");
			}
			// Controlamos el numUsuario para darle una pista
			else if (numUsuario > numAleatorio || numUsuario >= 100) {
				System.out.println("Es mas bajo el numero");
				System.out.println("Te quedan " + contadorVidas + " vidas");
			} else if (numUsuario < numAleatorio || numUsuario < 0) {
				System.out.println("Es mas alto el numero");
				System.out.println("Te quedan " + contadorVidas + " vidas");
				// Si Acierta el numero entonces...
			} else if (numUsuario == numAleatorio) {
				System.out.println("FELICIDADES HAS ACERTADO");
			}
		} while (numUsuario != numAleatorio);
	}

}
