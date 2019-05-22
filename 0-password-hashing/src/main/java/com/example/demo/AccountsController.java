package com.example.demo;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/accounts")
class AccountsController {

    private final AccountRepository accountRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(20);

    @PostMapping
    String createAccount(@RequestBody Account account) throws Exception {
        System.out.println("Start processing");

        long start = System.currentTimeMillis();

        System.out.println(account.getPassword().length());
        account.setPassword(bCryptPasswordEncoder.encode(account.getPassword()));

        accountRepository.save(account);

        long stop = System.currentTimeMillis();

        System.out.println("Operation took " + (stop - start));

        return "Operation took " + (stop - start) + " miliseconds";
    }
}
