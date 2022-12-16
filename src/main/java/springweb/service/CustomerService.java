package springweb.service;

import springweb.dto.Login;

public interface CustomerService {
    boolean checkLogin(final Login login);
}
