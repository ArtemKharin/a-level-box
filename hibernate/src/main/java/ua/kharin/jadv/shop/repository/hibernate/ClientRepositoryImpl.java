package ua.kharin.jadv.shop.repository.hibernate;

import ua.kharin.jadv.shop.entity.Client;
import ua.kharin.jadv.shop.repository.ClientRepository;

public class ClientRepositoryImpl extends AbstractHibernateRepository<Client> implements ClientRepository {
    protected void init() {
        aClass = Client.class;
    }
}
