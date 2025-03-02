package org.ToTXT;

//...PPTFile、WordFile跟PdfFile类似，这里就省略了...
public interface Visitor {
    void visit(PdfFile pdfFile);
    void visit(WordFile wordFile);
    void visit(PPTFile pptFile);

    class Compressor implements Visitor {
        @Override
        public void visit(PPTFile pptFile) {
            //...
            System.out.println("Compress PPT.");
        }

        @Override
        public void visit(PdfFile pdfFile) {
            //...
            System.out.println("Compress PDF.");
        }

        @Override
        public void visit(WordFile wordFile) {
            //...
            System.out.println("Compress WORD.");
        }
    }

    class Extractor implements Visitor {
        @Override
        public void visit(PPTFile pptFile) {
            System.out.println("Extract PPT.");
        }

        @Override
        public void visit(PdfFile pdfFile) {
            //...
            System.out.println("Extract PDF.");
        }

        @Override
        public void visit(WordFile wordFile) {
            //...
            System.out.println("Extract WORD.");
        }
    }
}
