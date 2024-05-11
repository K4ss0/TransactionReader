package com.codercampus.Assignment11.service;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codercampus.Assignment11.domain.Transaction;
import com.codercampus.Assignment11.repository.TransactionRepository;

@Service
public class TransactionService {

	@Autowired
	private TransactionRepository transactionRepository;

	public List<Transaction> getAllTransactionsSortedByDate() {
		List<Transaction> transactions = transactionRepository.findAll();
		transactions.sort(Comparator.comparing(Transaction::getDate));
		return transactions;
	}

	public Transaction getTransactionById(Long id) {
		return transactionRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Transaction not found with id:" + id));
	}

}
