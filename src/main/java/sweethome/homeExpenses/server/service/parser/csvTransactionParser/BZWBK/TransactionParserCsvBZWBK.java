package sweethome.homeExpenses.server.service.parser.csvTransactionParser.BZWBK;

import sweethome.homeExpenses.server.domain.BZWBK.HistoricalTransactionDocumentBZWBK;
import sweethome.homeExpenses.server.domain.BankAccount;
import sweethome.homeExpenses.server.domain.HistoricalTransactionDocument;
import sweethome.homeExpenses.server.domain.Transaction;
import sweethome.homeExpenses.server.service.parser.csvTransactionParser.ITransactionParser;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Barteus
 * Date: 22.04.12
 * Time: 22:39
 */

public class TransactionParserCsvBZWBK implements ITransactionParser {

    private String fileName;
    private String separator;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getSeparator() {
        return separator;
    }

    public void setSeparator(String separator) {
        this.separator = separator;
    }

    @Override
    public HistoricalTransactionDocument parseDocument() {
        HistoricalTransactionDocumentBZWBK document = new HistoricalTransactionDocumentBZWBK();
        try {
            List<String> documentInLines = readFileIntoStringArray();
            if (documentInLines.isEmpty())
                return null;
            //Processing header of document
            document = this.lineIntoDocumentHeader(documentInLines.get(0));
            if (document == null)
                return null;
            //Processing transactions
            for (int i = 1; i < documentInLines.size(); i++) {
                document.getHistoricalTransactions().add(lineIntoTransaction(documentInLines.get(i)));
            }
        } catch (IOException e) {
            //Change to log/spring error handling
            e.printStackTrace();
        }
        return document.getHistoricalTransactions().size()==document.getNumberOfTransactions()?document:null;
    }

    private Transaction lineIntoTransaction(String line) {
        Transaction transaction = new Transaction();
        if (line.isEmpty())
            return null;

        String[] separatedData = line.split("[" + separator + "]+");
        if (separatedData.length != 6) {
            return null;
        }

        try {
            transaction.setPostingDate(new SimpleDateFormat("dd-MM-yyyy").parse(separatedData[0]));
        } catch (ParseException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        try {
            transaction.setTransactionDate(new SimpleDateFormat("dd-MM-yyyy").parse(separatedData[1]));
        } catch (ParseException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        transaction.setTitle(separatedData[2]);
        transaction.setValue(Double.valueOf(separatedData[3].replace(",",".")));
        transaction.setValueAfterOperation(Double.valueOf(separatedData[4].replace(",",".")));
        transaction.setTransactionNumber(Integer.valueOf(separatedData[5]));

        return transaction;
    }

    private HistoricalTransactionDocumentBZWBK lineIntoDocumentHeader(String line) {
        HistoricalTransactionDocumentBZWBK historicalTransactionDocumentBZWBK = new HistoricalTransactionDocumentBZWBK();
        if (line.isEmpty())
            return null;

        String[] separatedData = line.split("[" + separator + "]+");

        //specific for every CSV
        if (separatedData.length != 8)
            return null;

        historicalTransactionDocumentBZWBK.setAccountNumber(separatedData[2].substring(1));
        historicalTransactionDocumentBZWBK.setPersonalData(separatedData[3]);
        historicalTransactionDocumentBZWBK.setCurrency(separatedData[4]);
        historicalTransactionDocumentBZWBK.setEndValue(Double.valueOf(separatedData[6].replace(",", ".")));
        historicalTransactionDocumentBZWBK.setBeginValue(Double.valueOf(separatedData[5].replace(",", ".")));
        //Control value to validate number of transactions
        historicalTransactionDocumentBZWBK.setNumberOfTransactions(Integer.valueOf(separatedData[7]));

        return historicalTransactionDocumentBZWBK;
    }

    private List<String> readFileIntoStringArray() throws IOException {
        List<String> fileLines = new LinkedList<String>();
        FileInputStream fstream = new FileInputStream(fileName);
        DataInputStream in = new DataInputStream(fstream);
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String strLine;
        while ((strLine = br.readLine()) != null) {
            fileLines.add(strLine);
        }
        in.close();

        return fileLines;
    }
}
