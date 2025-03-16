package vn.com.t3h.dao;

import vn.com.t3h.entity.IdentityCardEntity;
import vn.com.t3h.entity.UserEntity;

public interface IdentityCardRepository {
    IdentityCardEntity find(String fullName , String address,String identityNumber);
    public Integer save(IdentityCardEntity identityCardEntity);

}
