/**
 * Programa de registro de estudiantes que utiliza HashMaps para almacenar información sobre los estudiantes, con sus códigos, nombres y el número de asistencias que han tenido.
 * El programa permite al usuario realizar varias acciones a través de un menú.
 *
 * Se crean dos HashMaps:
 * nombres_estudiantes: Almacena los códigos de los estudiantes como claves y sus nombres como valores.
 * asistencias_estudiantes: Almacena los códigos de los estudiantes como claves y el número de asistencias como valores.
 * Se crea un objeto "lector" de la clase Scanner para leer la entrada del usuario.
 *
 * Se inicializa la variable "opcion" a -1 para que el programa entre en un bucle while.
 *
 * Se inicia un bucle while que se ejecuta hasta que el usuario seleccione la opción 0 (Salir).
 *
 * Dentro del bucle while, se muestra un menú de opciones al usuario y se lee la elección del usuario usando el objeto "lector."
 *
 * Se utilizan variables locales para almacenar el código, nombre y número de asistencias de un estudiante según la opción seleccionada por el usuario.
 *
 * Se utiliza una estructura "switch" para manejar las diferentes opciones del menú:
 *
 * Opción 1: Registrar estudiante, donde se pide al usuario ingresar el código y el nombre del estudiante, y se almacenan en los HashMaps.
 * Opción 2: Modificar nombre del estudiante, donde se permite al usuario cambiar el nombre de un estudiante existente.
 * Opción 3: Eliminar estudiante, que permite al usuario eliminar a un estudiante por su código.
 * Opción 4: Consultar estudiante, que muestra el nombre y el número de asistencias de un estudiante dado su código.
 * Opción 5: Consultar todos los estudiantes, que muestra la información de todos los estudiantes registrados.
 * Opción 6: Tomar asistencia, que permite al usuario registrar la asistencia de un estudiante existente, incrementando el contador de asistencias.
 * Opción 0: Salir del programa.
 * El bucle continúa hasta que el usuario selecciona la opción 0 (Salir), momento en el que se muestra un mensaje de despedida y el programa termina.
 *
 */

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class Registro {
    public static void main(String[] args) {
        // Parámetros
        HashMap<String, String> nombres_estudiantes = new HashMap<>();
        HashMap<String, Integer> asistencias_estudiantes = new HashMap<>();

        Scanner lector = new Scanner(System.in);

        int opcion = -1;

        while (opcion != 0){
            System.out.println("Ingresa la opción:");
            System.out.println("1. Registrar estudiante");
            System.out.println("2. Modificar nombre del estudiante");
            System.out.println("3. Eliminar estudiante");
            System.out.println("4. Consultar estudiante");
            System.out.println("5. Consultar todos los estudiantes");
            System.out.println("6. Tomar asistencia");
            System.out.println("0. Salir");

            opcion = lector.nextInt();

            String codigo;
            String nombre;
            int asistencias;

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el código del estudiante");
                    codigo = lector.next();
                    lector.nextLine();
                    System.out.println("Ingrese el nombre del estudiante");
                    nombre = lector.nextLine();
                    asistencias = 0;
                    nombres_estudiantes.put(codigo, nombre);
                    asistencias_estudiantes.put(codigo, asistencias);
                    break;
                case 2:
                    System.out.println("Ingrese el código del estudiante");
                    codigo = lector.next();
                    if (nombres_estudiantes.containsKey(codigo)) {
                        lector.nextLine();
                        System.out.println("Ingresa el nuevo nombre del estudiante");
                        nombre = lector.nextLine();
                        nombres_estudiantes.put(codigo, nombre);
                    } else {
                        System.out.println("NO existe un estudiante con el código " + codigo);
                    }
                    break;
                case 3:
                    System.out.println("Ingrese el código del estudiante");
                    codigo = lector.next();
                    nombres_estudiantes.remove(codigo);
                    break;
                case 4:
                    System.out.println("Ingrese el código del estudiante");
                    codigo = lector.next();
                    if (nombres_estudiantes.containsKey(codigo)) {
                        nombre = nombres_estudiantes.get(codigo);
                        asistencias = asistencias_estudiantes.get(codigo);
                        System.out.println("Los datos del estudiante con código: " + codigo);
                        System.out.println("Nombre: " + nombre);
                        System.out.println("asistencias: " + asistencias);
                    }
                    else
                        System.out.println("NO existe un estudiante con el código " + codigo);
                    break;
                case 5:
                    Set<String> codigos = nombres_estudiantes.keySet();
                    System.out.println();
                    System.out.println("Estudiantes registrados: " + codigos.size());
                    for(String cod: codigos){
                        nombre = nombres_estudiantes.get(cod);
                        asistencias = asistencias_estudiantes.get(cod);
                        System.out.println("Estudiante con Código: " + cod);
                        System.out.println("Nombre: " + nombre);
                        System.out.println("asistencias: " + asistencias);
                        System.out.println();
                    }
                    break;
                case 6:
                    System.out.println("Ingrese el código del estudiante");
                    codigo = lector.next();
                    if (nombres_estudiantes.containsKey(codigo)) {
                        asistencias = asistencias_estudiantes.get(codigo);
                        asistencias_estudiantes.put(codigo, asistencias + 1);
                    }
                    else
                        System.out.println("NO existe un estudiante con el código " + codigo);
                    break;
                case 0:
                    System.out.println("Chao!!!!");
                    break;
                default:
                    System.out.println("Opción invaálida");
            }
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
        }
    }
}
