import java.util.Arrays;
import java.util.Comparator;

/**
 * Exercise 2: E-commerce Platform Search Function.
 *
 * Implements and compares Linear Search and Binary Search over a product catalog.
 *
 * Big O summary:
 *   Linear Search  -> O(n)      : scans every element; works on unsorted data.
 *   Binary Search  -> O(log n)  : repeatedly halves a SORTED array.
 *   Sorting (once) -> O(n log n): required before binary search can be used.
 *
 * Best/avg/worst:
 *   Linear  : best O(1) (first element), avg O(n/2), worst O(n) (last/absent).
 *   Binary  : best O(1) (middle), avg & worst O(log n).
 *
 * For a large catalog searched many times, binary search wins because the one-time
 * sort cost is amortized across many fast O(log n) lookups.
 *
 * Run inside this folder:  javac *.java  &&  java ProductSearch
 */
class Product {
    int productId;
    String productName;
    String category;

    Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    public String toString() {
        return "Product{id=" + productId + ", name='" + productName + "', category='" + category + "'}";
    }
}

public class ProductSearch {

    /** Linear search by product name. O(n). */
    static Product linearSearch(Product[] products, String targetName) {
        for (Product p : products) {
            if (p.productName.equalsIgnoreCase(targetName)) {
                return p;
            }
        }
        return null;
    }

    /** Binary search by product name. Requires the array sorted by name. O(log n). */
    static Product binarySearch(Product[] sortedByName, String targetName) {
        int low = 0, high = sortedByName.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int cmp = sortedByName[mid].productName.compareToIgnoreCase(targetName);
            if (cmp == 0) {
                return sortedByName[mid];
            } else if (cmp < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Product[] products = {
            new Product(101, "Laptop",     "Electronics"),
            new Product(102, "Headphones", "Electronics"),
            new Product(103, "Coffee Mug", "Kitchen"),
            new Product(104, "Notebook",   "Stationery"),
            new Product(105, "Backpack",   "Travel")
        };

        // ---- Linear search (unsorted array) ----
        System.out.println("Linear search for 'Notebook':");
        System.out.println("  " + linearSearch(products, "Notebook"));
        System.out.println("  " + linearSearch(products, "Television") + " (not found)");

        // ---- Binary search (needs sorted array) ----
        Product[] sorted = Arrays.copyOf(products, products.length);
        Arrays.sort(sorted, Comparator.comparing(p -> p.productName.toLowerCase()));
        System.out.println("\nCatalog sorted by name: " + Arrays.toString(sorted));

        System.out.println("\nBinary search for 'Coffee Mug':");
        System.out.println("  " + binarySearch(sorted, "Coffee Mug"));
        System.out.println("  " + binarySearch(sorted, "Television") + " (not found)");
    }
}
