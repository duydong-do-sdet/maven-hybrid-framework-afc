package dataConfig;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import commons.GlobalConstants;

import java.io.File;

public class UserDataJSONManager {

    public static UserDataJSONManager getDataJSON() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            return mapper.readValue(new File(GlobalConstants.DATA_JSON_PATH + "PortalData.json"), UserDataJSONManager.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static class UserInfo {
        @JsonProperty("firstName")
        private String firstName;

        @JsonProperty("lastName")
        private String lastName;


        @JsonProperty("emailUsername")
        private String emailUsername;

        @JsonProperty("emailDomain")
        private String emailDomain;

        @JsonProperty("password")
        private String password;
    }

    @JsonProperty("UserInfo")
    private UserInfo userInfo;

    public String getFirstName() {
        return userInfo.firstName;
    }

    public String getLastName() {
        return userInfo.lastName;
    }

    public String getEmailUsername() {
        return userInfo.emailUsername;
    }

    public String getEmailDomain() {
        return userInfo.emailDomain;
    }

    public String getPassword() {
        return userInfo.password;
    }

}
