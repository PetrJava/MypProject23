package myProject;

import myProject.dao.ClientDao;
import myProject.entity.ClientEntity;

import java.time.LocalDateTime;

public class DaoRunner {

    public static void main(String[] args) {
        var clients = ClientDao.getInstance().findById(3);
        System.out.println(clients);
    }

    private static void updateTest() {
        var clientDao = ClientDao.getInstance();
        var mayBeClient = clientDao.findById(15);
        System.out.println(mayBeClient);

        mayBeClient.ifPresent(clientEntity -> {
            clientEntity.setFirstName("Ivan");
            clientDao.update(clientEntity);
        });
    }

    private static final void deleteTest() {
        var clientDao = ClientDao.getInstance();
        var deleteResult = clientDao.delete(1);
        System.out.println(deleteResult);

    }

    private static void saveTest() {
        var clientDao = ClientDao.getInstance();
        var client = new ClientEntity();
        client.setClientId(1);
        client.setFirstName("Petr");
        client.setLastName("Petrov");
//        client.setBank_account(99);
        client.setCreatedTime(LocalDateTime.now());
        var savedClient = clientDao.save(client);
        System.out.println(savedClient);
    }
}
