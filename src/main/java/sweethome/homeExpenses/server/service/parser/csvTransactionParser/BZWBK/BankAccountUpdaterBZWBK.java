package sweethome.homeExpenses.server.service.parser.csvTransactionParser.BZWBK;

import sweethome.homeExpenses.server.domain.BZWBK.HistoricalTransactionDocumentBZWBK;
import sweethome.homeExpenses.server.domain.BankAccount;
import sweethome.homeExpenses.server.domain.HistoricalTransactionDocument;
import sweethome.homeExpenses.server.domain.Transaction;
import sweethome.homeExpenses.server.service.parser.csvTransactionParser.IBankAccountUpdater;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: Barteus
 * Date: 01.05.12
 * Time: 00:35
 */


public class BankAccountUpdaterBZWBK implements IBankAccountUpdater {
    @Override
    public BankAccount importHTDToBankAccount(BankAccount bankAccount, HistoricalTransactionDocument htd) {
        BankAccount ba = bankAccount;
        Set<Transaction> transactionsToInsert = new HashSet<Transaction>();
        
        //init bank account from HTD 
        if(bankAccount.getAccountNumber() == null){
            ba = this.initBankAccountFromHTD((HistoricalTransactionDocumentBZWBK)htd);
        }

        //eliminate inapropate htd-ba pairs
        if(ba.getAccountNumber() != ((HistoricalTransactionDocumentBZWBK)htd).getAccountNumber() &&
                ba.getCurrency().equals(((HistoricalTransactionDocumentBZWBK) htd).getCurrency()))
            return bankAccount;

        //filter not added transaction to account history
        for(int i=0;i<htd.getHistoricalTransactions().size();i++){
            Transaction transaction = htd.getHistoricalTransactions().get(i);
            if(!ba.getHistory().contains(transaction)){
                transactionsToInsert.add(transaction);
            }
        }

        //adding selected transactions to history, sorting
        ba.getHistory().addAll(transactionsToInsert);
        ba.setValue(((HistoricalTransactionDocumentBZWBK) htd).getEndValue());
//        Collections.sort(ba.getHistory());
        return ba;
    }

    /*
        Init Bank Account from HistoricalTransactionDocument.
     */
    private BankAccount initBankAccountFromHTD(HistoricalTransactionDocumentBZWBK htd){
        BankAccount bankAccount = new BankAccount();
        bankAccount.setAccountNumber(htd.getAccountNumber());
        bankAccount.setCurrency(htd.getCurrency());
        bankAccount.setValue(htd.getEndValue());
        return bankAccount;
    }
}
