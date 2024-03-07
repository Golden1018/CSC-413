package main.java.com.example;

import java.util.ArrayList;
import java.util.List;

public class AccountDAOImpl implements AccountDAO {
    private List<AccountDTO> accounts = new ArrayList<>();

    @Override
    public void create(AccountDTO account) {
        accounts.add(account);
    }

    @Override
    public AccountDTO get(int accountId) {
        // Implementation of get method will be added later
        return null;
    }

    @Override
    public List<AccountDTO> getAll() {
        return accounts;
    }

    @Override
    public void update(AccountDTO account) {
        // Implementation of update method will be added later
    }

    @Override
    public void delete(int accountId) {
        // Implementation of delete method will be added later
    }
}
