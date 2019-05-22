package com.example.demo;

import lombok.Data;
import org.springframework.boot.CommandLineRunner;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RestController
public class AccountAndProfilesController implements CommandLineRunner {

    List<Account> accounts = new ArrayList<>();
    List<Profile> profiles = new ArrayList<>();

    @GetMapping("/**")
    public String getAccounts() {

        long start = System.currentTimeMillis();


        for (Account account : accounts) {

            for (Profile profile : profiles) {

                if (profile.getAccountId() == account.getId()) {
                    account.setProfile(profile);
                }

            }

        }

//        Map<Long, Profile> profileMap = profiles.stream().collect(Collectors.toMap(p->p.getAccountId(), p->p));
//
//        for(Account account : accounts){
//            account.setProfile(profileMap.get(account.getId()));
//            if(account.getProfile() == null){
//                throw new RuntimeException();
//            }
//        }

        long stop = System.currentTimeMillis();

        return "Operation took " + (stop - start);
    }


    @Override
    public void run(String... args) throws Exception {

        IntStream.range(0, 30_000)
                .forEach(
                        n -> {
                            accounts.add(new Account(n));
                            profiles.add(new Profile(n));
                        }
                );
        Collections.shuffle(accounts);
        Collections.shuffle(profiles);
        System.out.println("added "+accounts.size()+ " accounts");
        System.out.println("added "+profiles.size()+ " profiles");
    }
}

@Data
class Account {
    private long id;
    private String data = "....";
    private Profile profile;

    public Account(long id) {
        this.id = id;
    }
}

@Data
class Profile {

    private final String id = UUID.randomUUID().toString();
    private long accountId;
    private String data = "...";

    public Profile(long accountId) {
        this.accountId = accountId;
    }
}
