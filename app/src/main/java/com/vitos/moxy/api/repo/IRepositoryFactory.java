package com.vitos.moxy.api.repo;

import com.vitos.moxy.mvp.models.repo.IUserRepository;

/**
 * Created by Victor on 28.05.2017.
 */

public interface IRepositoryFactory {

    IUserRepository getUserRepository();
}
