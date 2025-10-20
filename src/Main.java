public class Main {

    public static void main(String[] args) {
        int[] arr = {5, 2, 9, 1, 5, 6};

        // ===================================================
        // Algoritmos básicos
        // ===================================================
        System.out.println("Algoritmos básicos:");

        int[] copyBasic = arr.clone();
        AlgoritmosBasicos.exchangeSort(copyBasic);
        System.out.print("ExchangeSort: ");
        printArray(copyBasic);

        copyBasic = arr.clone();
        AlgoritmosBasicos.selectionSort(copyBasic);
        System.out.print("SelectionSort: ");
        printArray(copyBasic);

        copyBasic = arr.clone();
        AlgoritmosBasicos.insertionSort(copyBasic);
        System.out.print("InsertionSort: ");
        printArray(copyBasic);

        copyBasic = arr.clone();
        AlgoritmosBasicos.bubbleSort(copyBasic);
        System.out.print("BubbleSort: ");
        printArray(copyBasic);

        copyBasic = arr.clone();
        AlgoritmosBasicos.shellSort(copyBasic);
        System.out.print("ShellSort: ");
        printArray(copyBasic);

        System.out.println();

        // ===================================================
        // Algoritmos avanzados
        // ===================================================
        System.out.println("Algoritmos avanzados:");

        int[] copyAdvanced = arr.clone();
        AlgoritmosAvanzados.mergeSort(copyAdvanced, 0, copyAdvanced.length - 1);
        System.out.print("MergeSort: ");
        printArray(copyAdvanced);

        copyAdvanced = arr.clone();
        AlgoritmosAvanzados.quickSortFirstPivot(copyAdvanced, 0, copyAdvanced.length - 1);
        System.out.print("QuickSort (pivote inicial): ");
        printArray(copyAdvanced);

        copyAdvanced = arr.clone();
        AlgoritmosAvanzados.quickSortCentralPivot(copyAdvanced, 0, copyAdvanced.length - 1);
        System.out.print("QuickSort (pivote central): ");
        printArray(copyAdvanced);

        copyAdvanced = arr.clone();
        AlgoritmosAvanzados.binSort(copyAdvanced);
        System.out.print("BinSort: ");
        printArray(copyAdvanced);

        copyAdvanced = arr.clone();
        AlgoritmosAvanzados.radixSort(copyAdvanced);
        System.out.print("RadixSort: ");
        printArray(copyAdvanced);

        System.out.println();

        // ===================================================
        // Algoritmos de búsqueda
        // ===================================================
        System.out.println("Algoritmos de búsqueda:");

        int target = 5;

        int index = AlgoritmosBusqueda.linearSearch(arr, target);
        System.out.println("Búsqueda lineal: índice " + index);

        index = AlgoritmosBusqueda.binarySearch(arr, target);
        System.out.println("Búsqueda binaria: índice " + index);

        index = AlgoritmosBusqueda.interpolationSearch(arr, target);
        System.out.println("Búsqueda por interpolación: índice " + index);
    }

    private static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

}