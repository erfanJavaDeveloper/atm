package com.payeshgaran.service;

import com.payeshgaran.dto.transaction.TransactionInDto;
import com.payeshgaran.entity.Account;
import com.payeshgaran.entity.Transaction;
import com.payeshgaran.repository.TransactionRepository;
import com.payeshgaran.exception.exNew.AccountNullPointException;
import com.payeshgaran.exception.exNew.TransactionNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final AccountService accountService;


    public Transaction save(TransactionInDto transactionInDto, Long id) {
        Transaction save = transactionRepository.save(TransactionInDto.convertDtoToEntity(transactionInDto));

        if (accountService.findById(id) != null && accountService.findByAccountNumber(transactionInDto.getAccountNumberReceiver()) != null) {
            Account account = accountService.findById(id);
            account.setTransaction(List.of(save));

            Account sender = accountService.findById(id);
            sender.setBalance(sender.getBalance().min(save.getAmount()));

            Account receiver = accountService.findByAccountNumber(save.getAccountNumberReceiver());
            receiver.setBalance(receiver.getBalance().add(save.getAmount()));

        } else {
            throw new AccountNullPointException();
        }
//        accountService.saveWithOutDto(account);


//        accountService.saveWithOutDto(sender);


//        accountService.saveWithOutDto(receiver);
        return save;
    }

    public Transaction findById(Long id) {
        if (transactionRepository.findById(id).get() !=null ) {
            return transactionRepository.findById(id).orElseThrow(RuntimeException::new);
        }else {
            throw new TransactionNotFoundException();
        }
    }

    public void delete(Long id) {
        transactionRepository.delete(findById(id));
    }

    public List<Transaction> findTheLastThenTransactions(String accountNumber) {
        return transactionRepository.findTransactionThen(accountNumber);

    }


}
