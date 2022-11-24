package cz.burios.ux.cancel.security;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import cz.burios.ux.cancel.resources.ResourcesUtils;
import cz.burios.ux.cancel.security.models.UserModel;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

@Service
public class LoginUserServiceImpl implements LoginUserService {
	
	@Override
	public UserModel getLoginUser(String userName) {
		List<UserModel> allUserModels = loadAllAvailableUsers("/UserInfo.txt");

		UserModel retVal = null;
		if (!StringUtils.isEmpty(userName)) {
			if (allUserModels != null && allUserModels.size() > 0) {
				for (UserModel userModel : allUserModels) {
					if (userName.equals(userModel.getUserName())) {
						retVal = userModel;
					}
				}
			}
		}
		return retVal;
	}

	@SuppressWarnings("unchecked")
	private List<UserModel> loadAllAvailableUsers(String resourceName) {
		List<UserModel> retVal = new ArrayList<UserModel>();
		String userInfoAsText = ResourcesUtils.getResourceAsText(resourceName);
		if (!StringUtils.isEmpty(userInfoAsText)) {
			Gson gson = new Gson();
			retVal = (ArrayList<UserModel>) gson.fromJson(userInfoAsText, new TypeToken<ArrayList<UserModel>>() {
			}.getType());
		}
		return retVal;
	}
}
