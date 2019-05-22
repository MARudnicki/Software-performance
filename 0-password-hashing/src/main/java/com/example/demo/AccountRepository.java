package com.example.demo;

import org.springframework.data.repository.CrudRepository;

interface AccountRepository extends CrudRepository<Account, Long> {
}
