package com.vitos.moxy.api.repo;

import com.vitos.moxy.mvp.models.repo.IUserRepository;
import com.vitos.moxy.mvp.models.repo.RemoteUserRepository;

/**
 * Created by Victor on 28.05.2017.
 */

public class RepositoryFactory implements IRepositoryFactory {


    @Override
    public IUserRepository getUserRepository() {
        return new RemoteUserRepository();
    }
}

