/**
 * Exercise 2: Factory Method Pattern.
 *
 * A document management system that creates different document types
 * (Word, PDF, Excel) without the client code knowing the concrete classes.
 *
 * Roles:
 *   Document              -> product interface
 *   Word/Pdf/ExcelDocument-> concrete products
 *   DocumentFactory       -> creator with abstract factory method createDocument()
 *   *DocumentFactory      -> concrete creators, each builds one product type
 *
 * Run inside this folder:  javac *.java  &&  java FactoryMethodDemo
 */

// ---------- Product interface ----------
interface Document {
    void open();
}

// ---------- Concrete products ----------
class WordDocument implements Document {
    public void open() { System.out.println("Opening a Word document (.docx)"); }
}

class PdfDocument implements Document {
    public void open() { System.out.println("Opening a PDF document (.pdf)"); }
}

class ExcelDocument implements Document {
    public void open() { System.out.println("Opening an Excel document (.xlsx)"); }
}

// ---------- Creator (declares the factory method) ----------
abstract class DocumentFactory {
    // The Factory Method: subclasses decide which concrete Document to create.
    public abstract Document createDocument();
}

// ---------- Concrete creators ----------
class WordDocumentFactory extends DocumentFactory {
    public Document createDocument() { return new WordDocument(); }
}

class PdfDocumentFactory extends DocumentFactory {
    public Document createDocument() { return new PdfDocument(); }
}

class ExcelDocumentFactory extends DocumentFactory {
    public Document createDocument() { return new ExcelDocument(); }
}

// ---------- Client / test ----------
public class FactoryMethodDemo {
    public static void main(String[] args) {
        DocumentFactory wordFactory  = new WordDocumentFactory();
        DocumentFactory pdfFactory   = new PdfDocumentFactory();
        DocumentFactory excelFactory = new ExcelDocumentFactory();

        // Client works only with the abstract types.
        Document word  = wordFactory.createDocument();
        Document pdf   = pdfFactory.createDocument();
        Document excel = excelFactory.createDocument();

        word.open();
        pdf.open();
        excel.open();
    }
}
