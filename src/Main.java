import java.util.Arrays;
import java.util.Random;

public class Main {

    private static final int TAMANIO_GRANDE = 10_000;

    public static void main(String[] args) {
        Random random = new Random(42); // Misma secuencia de datos en cada ejecución

        int[] arregloChico = {5, 2, 9, 1, 5, 6};
        int[] arregloGrande = generarArreglo(TAMANIO_GRANDE, random);

        System.out.println("========================================");
        System.out.println("PRUEBA CON ARREGLO PEQUEÑO");
        System.out.println("Cantidad de elementos: " + arregloChico.length);
        probarOrdenamientos(arregloChico);
        probarBusquedas(arregloChico);

        System.out.println("\n========================================");
        System.out.println("PRUEBA CON ARREGLO GRANDE");
        System.out.println("Cantidad de elementos: " + arregloGrande.length);
        probarOrdenamientos(arregloGrande);
        probarBusquedas(arregloGrande);
    }

    private static int[] generarArreglo(int tamanio, Random random) {
        int[] arreglo = new int[tamanio];
        for (int i = 0; i < arreglo.length; i++) {
            arreglo[i] = random.nextInt(1_000_000);
        }
        return arreglo;
    }

    private static void probarOrdenamientos(int[] arregloOriginal) {
        System.out.println("\n--- Algoritmos básicos ---");

        int[] copia = arregloOriginal.clone();
        long inicio = System.nanoTime();
        AlgoritmosBasicos.exchangeSort(copia);
        imprimirTiempo("Exchange Sort", inicio);
        comprobarOrden(copia);

        copia = arregloOriginal.clone();
        inicio = System.nanoTime();
        AlgoritmosBasicos.selectionSort(copia);
        imprimirTiempo("Selection Sort", inicio);
        comprobarOrden(copia);

        copia = arregloOriginal.clone();
        inicio = System.nanoTime();
        AlgoritmosBasicos.insertionSort(copia);
        imprimirTiempo("Insertion Sort", inicio);
        comprobarOrden(copia);

        copia = arregloOriginal.clone();
        inicio = System.nanoTime();
        AlgoritmosBasicos.bubbleSort(copia);
        imprimirTiempo("Bubble Sort", inicio);
        comprobarOrden(copia);

        copia = arregloOriginal.clone();
        inicio = System.nanoTime();
        AlgoritmosBasicos.shellSort(copia);
        imprimirTiempo("Shell Sort", inicio);
        comprobarOrden(copia);

        System.out.println("\n--- Algoritmos avanzados ---");

        copia = arregloOriginal.clone();
        inicio = System.nanoTime();
        AlgoritmosAvanzados.mergeSort(copia, 0, copia.length - 1);
        imprimirTiempo("Merge Sort", inicio);
        comprobarOrden(copia);

        copia = arregloOriginal.clone();
        inicio = System.nanoTime();
        AlgoritmosAvanzados.quickSortFirstPivot(copia, 0, copia.length - 1);
        imprimirTiempo("Quick Sort (pivote inicial)", inicio);
        comprobarOrden(copia);

        copia = arregloOriginal.clone();
        inicio = System.nanoTime();
        AlgoritmosAvanzados.quickSortCentralPivot(copia, 0, copia.length - 1);
        imprimirTiempo("Quick Sort (pivote central)", inicio);
        comprobarOrden(copia);

        copia = arregloOriginal.clone();
        inicio = System.nanoTime();
        AlgoritmosAvanzados.binSort(copia);
        imprimirTiempo("Bin Sort", inicio);
        comprobarOrden(copia);

        copia = arregloOriginal.clone();
        inicio = System.nanoTime();
        AlgoritmosAvanzados.radixSort(copia);
        imprimirTiempo("Radix Sort", inicio);
        comprobarOrden(copia);
    }

    private static void probarBusquedas(int[] arregloOriginal) {
        System.out.println("\n--- Algoritmos de búsqueda ---");

        // Búsqueda binaria e interpolada requieren que el arreglo esté ordenado.
        int[] arregloOrdenado = arregloOriginal.clone();
        Arrays.sort(arregloOrdenado);
        int objetivo = arregloOrdenado[arregloOrdenado.length / 2];
        System.out.println("Valor buscado: " + objetivo);

        long inicio = System.nanoTime();
        int indice = AlgoritmosBusqueda.linearSearch(arregloOrdenado, objetivo);
        imprimirTiempo("Búsqueda lineal", inicio);
        System.out.println("  Índice encontrado: " + indice);

        inicio = System.nanoTime();
        indice = AlgoritmosBusqueda.binarySearch(arregloOrdenado, objetivo);
        imprimirTiempo("Búsqueda binaria", inicio);
        System.out.println("  Índice encontrado: " + indice);

        inicio = System.nanoTime();
        indice = AlgoritmosBusqueda.interpolationSearch(arregloOrdenado, objetivo);
        imprimirTiempo("Búsqueda por interpolación", inicio);
        System.out.println("  Índice encontrado: " + indice);
    }

    private static void imprimirTiempo(String nombre, long inicio) {
        long fin = System.nanoTime();
        double milisegundos = (fin - inicio) / 1_000_000.0;
        System.out.printf("%-32s %10.3f ms%n", nombre + ":", milisegundos);
    }

    private static void comprobarOrden(int[] arreglo) {
        for (int i = 1; i < arreglo.length; i++) {
            if (arreglo[i - 1] > arreglo[i]) {
                System.out.println("  ADVERTENCIA: el arreglo no quedó ordenado.");
                return;
            }
        }
    }
}
