package com.vchauhan.security;

import com.vchauhan.domain.User;
import com.vchauhan.repository.UserRepository;
import com.vchauhan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by Vineet on 9/15/16.
 */
@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    @Autowired
    private UserRepository userRepo;

    private final AccountStatusUserDetailsChecker detailsChecker = new AccountStatusUserDetailsChecker();

    @Override
    public final TokenUser loadUserByUsername(String username) throws UsernameNotFoundException {
        final User user = userRepo.findOneByUsername(username).orElseThrow(() -> new UsernameNotFoundException(""));

        TokenUser currentUser = new TokenUser(user);
        detailsChecker.check(currentUser);

        return currentUser;
    }
}
