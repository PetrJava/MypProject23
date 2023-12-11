package myProject;

import myProject.dao.ClientDao;
import myProject.dto.ClientFilter;
import myProject.entity.Client;

import java.time.LocalDateTime;

public class DaoRunner {

    public static void main(String[] args) {
        var clientFilter = new ClientFilter(3, 0, null);
        var clients = ClientDao.getInstance().findAll(clientFilter);
        System.out.println(clients);
    }

    private static void updateTest() {
        var clientDao = ClientDao.getInstance();
        var mayBeClient = clientDao.findById(15);
        System.out.println(mayBeClient);

        mayBeClient.ifPresent(client -> {
            client.setFirst_name("Ivan");
            clientDao.update(client);
        });
    }

    private static final void deleteTest() {
        var clientDao = ClientDao.getInstance();
        var deleteResult = clientDao.delete(1);
        System.out.println(deleteResult);

    }

    private static void saveTest() {
        var clientDao = ClientDao.getInstance();
        var client = new Client();
        client.setClient_id(1);
        client.setFirst_name("Petr");
        client.setLast_name("Petrov");
//        client.setBank_account(99);
        client.setCreated_time(LocalDateTime.now());
        var savedClient = clientDao.save(client);
        System.out.println(savedClient);
    }
}
