package org;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;
import org.apache.pdfbox.util.TextPosition;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

/**
 * This is an example on how to extract text line by line from pdf document
 */
public class GetLinesFromPDF extends PDFTextStripper {

    static List<String> lines = new ArrayList<String>();

    public GetLinesFromPDF() throws IOException {
    }

    /**
     * @throws IOException If there is an error parsing the document.
     */
    public static void main( String[] args ) throws IOException {
        PDDocument document = null;
        String fileName = "C:\\Users\\konno\\Desktop\\Java Core\\Threads\\ThreadsExample\\src\\main\\resources\\sample.pdf";
        try {
            document = PDDocument.load( new File(fileName) );
            PDFTextStripper stripper = new GetLinesFromPDF();
            stripper.setSortByPosition( true );
            stripper.setStartPage( 0 );
            stripper.setEndPage( document.getNumberOfPages() );

            Writer dummy = new OutputStreamWriter(new ByteArrayOutputStream());
            stripper.writeText(document, dummy);

            // print lines
            for(String line:lines){
                System.out.println(line);
            }
        }
        finally {
            if( document != null ) {
                document.close();
            }
        }
    }

    /**
     * Override the default functionality of PDFTextStripper.writeString()
     */
    @Override
    protected void writeString(String str, List<TextPosition> textPositions) throws IOException {
        lines.add(str);
        // you may process the line here itself, as and when it is obtained
    }
}