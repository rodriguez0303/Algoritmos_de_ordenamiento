
package Experimentos;

/*
 * Se importa la clase RadixSort para utilizar
 * su método ordenar() durante las pruebas.
 *
 * También se importan las clases necesarias para
 * generar los arreglos y guardar los resultados.
 */

import Algoritmos.RadixSort;

import java.util.Random;
import java.util.Arrays;
import java.util.Locale;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.io.OutputStream;
import java.io.BufferedWriter;
import java.io.FileWriter;

import java.nio.charset.StandardCharsets;

import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * Clase: PruebaEspecialRadix

 * Se mantiene fijo el tamaño del arreglo en 100000 elementos
 * y se modifica la cantidad de dígitos de los números utilizados.

 * Se realizan tres pruebas:
 * 3 dígitos, 6 dígitos y 9 dígitos.

 * Para medir el tiempo se utiliza MedidorTiempos,
 * que realiza cinco mediciones y obtiene la mediana.

 * También se generan archivos TXT y CSV con los resultados.
 */

public class PruebaEspecialRadix {

    // Se guardan las referencias necesarias para mostrar
    // los resultados en consola y escribirlos en el TXT.

    private static PrintStream consolaOriginal;
    private static PrintStream archivoTXT;
    private static PrintStream salidaCompartida;

    // Se utiliza el BufferedWriter para guardar las mediciones en CSV.
    private static BufferedWriter archivoCSV;

    public static void main(String[] args) throws IOException {

        // Se establece el tamaño fijo para las tres pruebas.
        int tamano = 100000;

        // Se crea la carpeta Resultados si todavía no existe para guardar el CSV.
        File carpeta = new File("Resultados");

        if (!carpeta.exists() && !carpeta.mkdirs()) {
            throw new IOException("No se pudo crear la carpeta Resultados.");
        }

        // Se genera una fecha para identificar los dos archivos.
        String fecha = new SimpleDateFormat(
                "yyyy-MM-dd_HH-mm-ss_SSS").format(new Date());

        // Se definen los nombres del TXT y CSV.
        File resultadoTXT = new File(
                carpeta, "PruebaEspecialRadix_" + fecha + ".txt");

        File resultadoCSV = new File(
                carpeta, "PruebaEspecialRadix_" + fecha + ".csv");

        // Se conserva la consola original.
        consolaOriginal = System.out;

        try {


            // Se abre el archivo TXT.
            archivoTXT = new PrintStream(
                    resultadoTXT, StandardCharsets.UTF_8.name());

            // Se abre el archivo CSV.
            archivoCSV = new BufferedWriter(
                    new FileWriter(
                            resultadoCSV, StandardCharsets.UTF_8));

            // Se escribe el encabezado del CSV.
            archivoCSV.write(
                    "Algoritmo;Tamaño;Dígitos;Repetición;Tiempo (ms)");
            archivoCSV.newLine();

            /*
             * Se crea una salida compartida.

             * Todo lo que se imprima con System.out
             * aparecerá tanto en la consola como en el TXT.

             * Esto permite guardar también las cinco
             * mediciones que imprime MedidorTiempos.
             */

            salidaCompartida = new PrintStream(
                    new OutputStream() {

                        @Override
                        public void write(int dato) throws IOException {
                            consolaOriginal.write(dato);
                            archivoTXT.write(dato);
                        }

                        @Override
                        public void write(
                                byte[] datos,
                                int inicio,
                                int cantidad) throws IOException {

                            consolaOriginal.write(
                                    datos, inicio, cantidad);

                            archivoTXT.write(
                                    datos, inicio, cantidad);
                        }

                        @Override
                        public void flush() throws IOException {
                            consolaOriginal.flush();
                            archivoTXT.flush();
                        }

                    },
                    true,
                    StandardCharsets.UTF_8.name());

            // Se activa la salida compartida.
            System.setOut(salidaCompartida);

            /*
             * Se ejecutan las tres pruebas con diferentes
             * cantidades de dígitos.
             *
             * El tamaño del arreglo no cambia.
             */

            ejecutarPrueba(tamano, 3, 999);
            ejecutarPrueba(tamano, 6, 999999);
            ejecutarPrueba(tamano, 9, 999999999);

        } finally {

            // AQUÍ ESTÁ EL CAMBIO:
            // Se restaura la consola original.
            System.setOut(consolaOriginal);

            // Se cierran los archivos utilizados.
            if (salidaCompartida != null) {
                salidaCompartida.flush();
            }

            if (archivoTXT != null) {
                archivoTXT.close();
            }

            if (archivoCSV != null) {
                archivoCSV.close();
            }
        }

        // Se indica dónde quedaron guardados los resultados.
        System.out.println("\nArchivos generados correctamente:");
        System.out.println("TXT: " + resultadoTXT.getAbsolutePath());
        System.out.println("CSV: " + resultadoCSV.getAbsolutePath());
    }

    //**********************************************************************
    //**********************************************************************

    /*
     * Método: ejecutarPrueba
     *
     * Se recibe el tamaño del arreglo, la cantidad
     * de dígitos y el valor máximo permitido.

     * Genera los números y mide el tiempo
     * que tarda Radix Sort en ordenarlos.

     * También registra las mediciones individuales en CSV.
     */

    public static void ejecutarPrueba(
            int tamano,
            int digitos,
            int valorMaximo) throws IOException {

        // Se genera el arreglo antes de medir el tiempo.
        int[] arreglo = generarArreglo(tamano, valorMaximo);

        // Se muestra la información antes de iniciar las mediciones.
        System.out.println("\n======================================");
        System.out.println("PRUEBA ESPECIAL: RADIX SORT");
        System.out.println("======================================");

        System.out.println("Tamaño del arreglo: " + tamano);
        System.out.println("Cantidad de dígitos: " + digitos);
        System.out.println("Valores: 0 a " + valorMaximo);

        /*

         * Se utiliza un arreglo auxiliar para obtener
         * las cinco mediciones individuales que se
         * guardarán en el CSV.

         * La generación de los datos no forma parte
         * del tiempo de ordenamiento.
         */

        // Se ejecuta una prueba inicial de calentamiento.
        int[] calentamiento = Arrays.copyOf(
                arreglo, arreglo.length);

        RadixSort.ordenar(calentamiento);

        // Se crea un arreglo para guardar los cinco tiempos.
        double[] tiempos = new double[5];

        // Se realizan las cinco mediciones.
        for (int repeticion = 0; repeticion < 5; repeticion++) {

            // Se copia el arreglo para ordenar siempre
            // los mismos valores originales.
            int[] copia = Arrays.copyOf(
                    arreglo, arreglo.length);

            // Se registra el instante inicial.
            long inicio = System.nanoTime();

            // Se ordena el arreglo.
            RadixSort.ordenar(copia);

            // Se registra el instante final.
            long fin = System.nanoTime();

            // Se convierte el tiempo de nanosegundos a milisegundos.
            double tiempo = (fin - inicio) / 1000000.0;

            // Se guarda el tiempo obtenido.
            tiempos[repeticion] = tiempo;

            // Se muestra la medición en consola y TXT.
            System.out.printf(
                    Locale.US,
                    "Repetición %d: %.4f ms%n",
                    repeticion + 1,
                    tiempo);

            // Se guarda la medición individual en CSV.
            archivoCSV.write(String.format(
                    Locale.US,
                    "Radix Sort;%d;%d;%d;%.4f",
                    tamano,
                    digitos,
                    repeticion + 1,
                    tiempo));

            archivoCSV.newLine();
        }

        /*
         * Se ordenan los cinco tiempos para obtener
         * el valor que se encuentra en la posición central.

         * Como hay cinco mediciones, la mediana
         * corresponde a la tercera posición del
         * arreglo ordenado, cuyo índice es 2.
         */

        Arrays.sort(tiempos);

        double mediana = tiempos[2];

        // Se muestra la mediana en consola y TXT.
        // No se agrega al CSV.
        System.out.printf(
                Locale.US,
                "Mediana: %.4f ms%n",
                mediana);
    }

    //**********************************************************************
    //**********************************************************************

    /*
     * Método: generarArreglo
     *
     * Recibe el tamaño del arreglo y el valor máximo
     * que pueden tener sus elementos.
     *
     * Se generan números enteros aleatorios desde 0
     * hasta el valor máximo indicado.
     *
     * Devuelve el arreglo con los números generados.
     */

    public static int[] generarArreglo(
            int tamano,
            int valorMaximo) {

        // Se crea un arreglo con la cantidad de elementos indicada.
        int[] arreglo = new int[tamano];

        // Se crea el objeto que genera números aleatorios.
        Random random = new Random();

        // Se recorren todas las posiciones del arreglo.
        for (int i = 0; i < arreglo.length; i++) {

            // Se genera un número dentro del rango establecido.
            arreglo[i] = random.nextInt(valorMaximo + 1);
        }

        // Se devuelve el arreglo generado.
        return arreglo;
    }
}
