package main.java.com.example;

import java.util.List;

public interface AccountDAO {
    void create(AccountDTO account);

    AccountDTO get(int accountId);  // Method stub

    List<AccountDTO> getAll();

    void update(AccountDTO account);

    void delete(int accountId);
}
