package cz.burios.ux.cancel.security;

import cz.burios.ux.cancel.security.models.UserModel;

public interface LoginUserService {
	
	UserModel getLoginUser(String userName);
}
