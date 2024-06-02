package dao;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.cognitoidp.AWSCognitoIdentityProvider;
import com.amazonaws.services.cognitoidp.AWSCognitoIdentityProviderClientBuilder;

public class ConexaoCognito {

    public static final String ACCESS_KEY = "AKIA6GBMG63LMTC3RYN5";
    public static final String SECRET_KEY = "";
    public static final String USER_POOL_ID = "us-east-2_OlLMO3r7a";
    public static final String CLIENT_ID = "2clabuec7sgupmu0jg52vcpo77";

    public static AWSCognitoIdentityProvider getCognitoClient() {
        BasicAWSCredentials credenciais = new BasicAWSCredentials(ACCESS_KEY, SECRET_KEY);
        return AWSCognitoIdentityProviderClientBuilder.standard()
                .withCredentials(new AWSStaticCredentialsProvider(credenciais))
                .withRegion(Regions.US_EAST_2)
                .build();
    }
}

