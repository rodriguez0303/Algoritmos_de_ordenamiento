package Experimentos;

//*****************
// Permite crear y manejar la carpeta y los archivos donde se guardarán los resultados.
import java.io.File;

// Permite crear el archivo TXT y escribir los resultados dentro de él.
import java.io.FileOutputStream;

// Permite manejar los errores que pueden ocurrir al crear o escribir un archivo.
import java.io.IOException;

// Permite enviar los resultados tanto a la consola como al archivo TXT.
import java.io.PrintStream;

// Permite obtener la fecha y hora en que se ejecuta el programa.
import java.time.LocalDateTime;

// Permite establecer el formato de la fecha y hora que se utilizará en el nombre del archivo.
import java.time.format.DateTimeFormatter;

// Permite guardar el texto utilizando la codificación UTF-8.
import java.nio.charset.StandardCharsets;

// Permite leer las líneas del archivo TXT.
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

// Permite escribir las mediciones en un archivo CSV.
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
//*****************


/*
 * Se importan las siete clases de algoritmos de ordenamiento
 * que se encuentran dentro del paquete Algoritmos.
 *
 * Esto permite utilizar sus métodos ordenar() desde esta clase,
 * sin necesidad de aplicar herencia mediante extends.
 *
 * De esta manera, se puede ejecutar cada algoritmo para medir
 * y comparar sus tiempos de ordenamiento.
 */

import Algoritmos.SelectionSort;
import Algoritmos.BubbleSort;
import Algoritmos.InsertionSort;
import Algoritmos.ShellSort;
import Algoritmos.MergeSort;
import Algoritmos.QuickSort;
import Algoritmos.RadixSort;

import java.util.function.Consumer;

/*
 * Clase: BenchmarkOrdenamiento

 * Esta clase ejecuta los experimentos de rendimiento
 * de los siete algoritmos de ordenamiento.
 *
 * Para cada algoritmo se utilizan cuatro tipos de arreglos:
 * aleatorio, ascendente, descendente y duplicados.
 *
 * Los tamaños comienzan en 1000 elementos y se duplican
 * hasta alcanzar el límite correspondiente al algoritmo.
 *
 * Los tiempos se obtienen mediante MedidorTiempos,
 * que realiza cinco mediciones y calcula la mediana.
 */

public class BenchmarkOrdenamiento {

    private static PrintStream consolaOriginal;

    // Permite escribir los resultados de las pruebas en el archivo TXT.
    private static PrintStream archivoTXT;

    // Permite mostrar los resultados en la consola y guardarlos en el TXT al mismo tiempo.
    private static PrintStream salidaCompartida;

    public static void main(String[] args) throws IOException {

        // Estas variables permiten controlar si Quick Sort puede
        // continuar evaluando cada tipo de arreglo.
        // Si ocurre un StackOverflowError, cambian a false.

        boolean quickAleatorio = true;
        boolean quickAscendente = true;
        boolean quickDescendente = true;
        boolean quickDuplicados = true;


        // Crea el archivo TXT y guarda su ubicación
            // para convertirlo posteriormente a CSV.
        File archivoResultados = guardarResultadosEnTXT();

        /*
         * Se recorre primero los tamaños de los arreglos.
         * De esta manera, los cuatro arreglos se generan
         * una sola vez y se utilizan para todos los algoritmos.
         */

        for (int tamano = 1000; tamano <= 1024000; tamano = tamano * 2) {

            /*
             * Se generan los cuatro tipos de arreglos.
             * Esta generación se realiza antes de medir los tiempos de ordenamiento.
             */

            int[] aleatorio = GeneradorArreglos.generarAleatorio(tamano);
            int[] ascendente = GeneradorArreglos.generarAscendente(tamano);
            int[] descendente = GeneradorArreglos.generarDescendente(tamano);
            int[] duplicados = GeneradorArreglos.generarDuplicados(tamano);

            /*
             * ALGORITMOS CON LÍMITE DE 16000 ELEMENTOS
             */
            // Estos tres algoritmos se ejecutan solamente
            // cuando el tamaño es igual o menor a 16000.

            if (tamano <= 16000) {

                ejecutarAlgoritmo("Selection Sort",
                        SelectionSort::ordenar,
                        tamano, aleatorio, ascendente, descendente, duplicados);

                ejecutarAlgoritmo("Bubble Sort",
                        BubbleSort::ordenar,
                        tamano, aleatorio, ascendente, descendente, duplicados);

                ejecutarAlgoritmo("Insertion Sort",
                        InsertionSort::ordenar,
                        tamano, aleatorio, ascendente, descendente, duplicados);
            }

            //***********************************************************************
            //***********************************************************************
            /*
             * ALGORITMOS CON LÍMITE DE 1024000 ELEMENTOS
             */

            ejecutarAlgoritmo("Shell Sort",
                    ShellSort::ordenar,
                    tamano, aleatorio, ascendente, descendente, duplicados);

            ejecutarAlgoritmo("Merge Sort",
                    MergeSort::ordenar,
                    tamano, aleatorio, ascendente, descendente, duplicados);


            // Quick Sort se evalúa por separado para evitar ejecutar
            // tamaños mayores cuando un tipo de arreglo presente errores.

            System.out.println("\n======================================");
            System.out.println("ALGORITMO: Quick Sort");
            System.out.println("======================================");
            System.out.println("\nTamaño: " + tamano);

            // Se Evalúa el arreglo aleatorio mientras no haya presentado errores.
            if (quickAleatorio) {
                quickAleatorio = medirYMostrar(
                        "Aleatorio", aleatorio, QuickSort::ordenar);
            }

            // Se evalúa el arreglo ascendente mientras no haya presentado errores.
            if (quickAscendente) {
                quickAscendente = medirYMostrar(
                        "Ascendente", ascendente, QuickSort::ordenar);
            }

            // Se evalúa el arreglo descendente mientras no haya presentado errores.
            if (quickDescendente) {
                quickDescendente = medirYMostrar(
                        "Descendente", descendente, QuickSort::ordenar);
            }

            // Se evalúa el arreglo con duplicados mientras no haya presentado errores.
            if (quickDuplicados) {
                quickDuplicados = medirYMostrar(
                        "Duplicados", duplicados, QuickSort::ordenar);
            }

            ejecutarAlgoritmo("Radix Sort",
                    RadixSort::ordenar,
                    tamano, aleatorio, ascendente, descendente, duplicados);
        }
        // Se cierra el TXT después de finalizar todas las mediciones.
        cerrarArchivoTXT();

        // Se convierte el TXT a CSV sin incluir las medianas.
        convertirTXTaCSV(archivoResultados);
    }

    //**************************************************************************
    //**************************************************************************

    /*
     * Método: ejecutarAlgoritmo
     *
     * Recibe el nombre del algoritmo, el método que
     * realiza el ordenamiento y su tamaño máximo.
     */

    // AQUÍ ESTÁ EL CAMBIO:
    // Ahora recibe los cuatro arreglos ya generados
    // para que todos los algoritmos utilicen los mismos números.

    public static void ejecutarAlgoritmo(String nombreAlgoritmo,
                                         Consumer<int[]> algoritmo,
                                         int tamano,
                                         int[] aleatorio,
                                         int[] ascendente,
                                         int[] descendente,
                                         int[] duplicados) {

        // Muestra el nombre del algoritmo que se va a evaluar.
        System.out.println("\n======================================");
        System.out.println("ALGORITMO: " + nombreAlgoritmo);
        System.out.println("======================================");

        // Se comienza con 1000 elementos y se duplica el tamaño
        // en cada vuelta hasta alcanzar el límite indicado.

        // El recorrido de los tamaños ahora se realiza en main().
        // Este método recibe directamente el tamaño que se evaluará.

        System.out.println("\nTamaño: " + tamano);

        /*
         * Se mide el tiempo de cada tipo de arreglo.
         * Cada medición utiliza cinco repeticiones
         * y devuelve la mediana en milisegundos.
         */

        medirYMostrar("Aleatorio", aleatorio, algoritmo);
        medirYMostrar("Ascendente", ascendente, algoritmo);
        medirYMostrar("Descendente", descendente, algoritmo);
        medirYMostrar("Duplicados", duplicados, algoritmo);
    }

    //**************************************************************************
    //**************************************************************************

    /*
     * Método: medirYMostrar
     *
     * Recibe el tipo de arreglo, los números generados
     * y el algoritmo que se desea evaluar.
     *
     * Muestra la mediana del tiempo de ordenamiento
     * expresada en milisegundos.
     */

    public static boolean medirYMostrar(String tipoArreglo,
                                        int[] arreglo,
                                        Consumer<int[]> algoritmo)  {

        try {

            // Identifica el tipo de arreglo que se está evaluando.
            System.out.println("\nTipo de arreglo: " + tipoArreglo);

            // Se ejecuta las mediciones y obtiene la mediana.
            double mediana = MedidorTiempos.medirTiempo(arreglo, algoritmo);

            // Muestra la mediana de las cinco repeticiones en milisegundos.
            System.out.printf("Mediana: %.4f ms%n", mediana);

            return true;

        } catch (StackOverflowError error) {

            // Si el algoritmo supera el límite de llamadas
            // recursivas de la computadora, informa el problema.
            // Esto puede ocurrir con Quicksort en ciertos arreglos.
            System.out.println(tipoArreglo
                    + ": No se pudo completar (StackOverflowError)");

            return false;
        }
    }
    //**************************************************************************
    //**************************************************************************

    /*
     * Método: guardarResultadosEnTXT
     *
     * Crea un archivo TXT para guardar los resultados
     * y permite mostrarlos también en la consola.
     *
     * También, devuelve la ubicación del archivo generado.
     */

    //**************************************************************************
    //**************************************************************************
    public static File guardarResultadosEnTXT() throws IOException {

        // Crea una carpeta para almacenar los archivos de resultados.
        File carpetaResultados = new File("Resultados");

        if (!carpetaResultados.exists() && !carpetaResultados.mkdirs()) {
            throw new IOException("No se pudo crear la carpeta Resultados.");
        }

        // Obtiene la fecha y hora actual para identificar cada ejecución.
        LocalDateTime fechaActual = LocalDateTime.now();

        DateTimeFormatter formatoFecha =
                DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss_SSS");

        String nombreArchivo = "Benchmark_" +
                fechaActual.format(formatoFecha) + ".txt";

        // Define la ubicación del archivo dentro de la carpeta Resultados.
        File archivoResultados = new File(carpetaResultados, nombreArchivo);

        // Conserva la consola original de IntelliJ.
        consolaOriginal = System.out;

        // Crea el archivo TXT donde se guardarán los resultados.
        archivoTXT = new PrintStream(
                new FileOutputStream(archivoResultados),
                true,
                StandardCharsets.UTF_8
        );

        // Envía los resultados tanto a la consola como al archivo TXT.
        salidaCompartida = new PrintStream(
                new java.io.OutputStream() {

                    @Override
                    public void write(int dato) throws IOException {
                        consolaOriginal.write(dato);
                        archivoTXT.write(dato);
                    }

                    @Override
                    public void write(byte[] datos, int inicio, int cantidad)
                            throws IOException {

                        consolaOriginal.write(datos, inicio, cantidad);
                        archivoTXT.write(datos, inicio, cantidad);
                    }

                    @Override
                    public void flush() throws IOException {
                        consolaOriginal.flush();
                        archivoTXT.flush();
                    }
                },
                true,
                StandardCharsets.UTF_8
        );

        System.setOut(salidaCompartida);

        System.out.println("Archivo de resultados: "
                + archivoResultados.getAbsolutePath());

        // Devuelve el archivo para utilizarlo al generar el CSV.
        return archivoResultados;
    }

    //**************************************************************************
    //**************************************************************************
    /*
     * Método: cerrarArchivoTXT
     *
     * Finaliza la escritura de los resultados en el TXT
     * y restablece la consola original de IntelliJ.
     */

    public static void cerrarArchivoTXT() {

        // Guarda los resultados que puedan estar pendientes de escritura.
        salidaCompartida.flush();

        // Restablece la salida original de la consola.
        System.setOut(consolaOriginal);

        // Cierra el archivo TXT.
        archivoTXT.close();
    }

    //**************************************************************************
    //**************************************************************************
    /*
     * Método: convertirTXTaCSV
     *
     * Método que lee el archivo TXT generado durante las pruebas
     * y crea un archivo CSV con los cinco tiempos
     * individuales de cada medición.

     */

    public static void convertirTXTaCSV(File archivoTXT) throws IOException {

        // Obtiene el nombre del TXT y cambia su extensión por CSV.
        String nombreCSV = archivoTXT.getName().replace(".txt", ".csv");

        // Guarda el CSV en la misma carpeta del TXT.
        File archivoCSV = new File(archivoTXT.getParentFile(), nombreCSV);

        // Variables para identificar cada medición.
        String algoritmo = "";
        String tamano = "";
        String tipoArreglo = "";

        // Se abre el TXT para leerlo y el CSV para escribir los resultados.
        try (
                BufferedReader lector = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream(archivoTXT),
                                StandardCharsets.UTF_8));

                BufferedWriter escritor = new BufferedWriter(
                        new OutputStreamWriter(
                                new FileOutputStream(archivoCSV),
                                StandardCharsets.UTF_8))
        ) {

            // Se escribe los encabezados del CSV.
            escritor.write("Algoritmo;Tamaño;Tipo de arreglo;Repetición;Tiempo (ms)");
            escritor.newLine();

            String linea;

            // Recorre cada línea del archivo TXT.
            while ((linea = lector.readLine()) != null) {

                // Se identifica el algoritmo evaluado.
                if (linea.startsWith("ALGORITMO: ")) {
                    algoritmo = linea.substring("ALGORITMO: ".length()).trim();
                }

                // Se identifica el tamaño del arreglo.
                else if (linea.startsWith("Tamaño: ")) {
                    tamano = linea.substring("Tamaño: ".length()).trim();
                }

                // Se identifica el tipo de arreglo.
                else if (linea.startsWith("Tipo de arreglo: ")) {
                    tipoArreglo = linea.substring("Tipo de arreglo: ".length()).trim();
                }

                // Se guarda únicamente las cinco repeticiones individuales.
                else if (linea.startsWith("Repetición ")) {

                    // Se separa el número de repetición del tiempo registrado.
                    String[] partes = linea.split(": ");

                    String repeticion = partes[0].replace("Repetición ", "").trim();

                    String tiempo = partes[1].replace(" ms", "").trim();

                    // Se verifica que el tiempo conserve la coma y los cuatro decimales del TXT.
                    if (!tiempo.matches("\\d+,\\d{4}")) {
                        throw new IOException("Formato de tiempo incorrecto: " + tiempo);
                    }

                    // Se escribe una fila con los datos de la medición.
                    escritor.write(algoritmo + ";" +
                            tamano + ";" +
                            tipoArreglo + ";" +
                            repeticion + ";" +
                            tiempo);

                    escritor.newLine();
                }
            }
        }

        // Se confirma dónde se guardó el archivo CSV.
        System.out.println("Archivo CSV generado: "
                + archivoCSV.getAbsolutePath());
    }
}
