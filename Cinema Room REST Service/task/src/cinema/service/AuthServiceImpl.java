package cinema.service;

import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService{
    @Override
    public boolean userAuthenticated(String password) {
        return "super_secret".equals(password);
    }
}
