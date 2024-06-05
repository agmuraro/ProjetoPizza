package dao;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.cognitoidp.AWSCognitoIdentityProvider;
import com.amazonaws.services.cognitoidp.AWSCognitoIdentityProviderClientBuilder;

import java.io.InputStream;
import java.util.Properties;

public class ConexaoCognito {

    private static final Properties configCognito = new Properties();

    static {
        try (InputStream input = ConexaoCognito.class.getClassLoader().getResourceAsStream("configCognito.properties")) {
            if (input == null) {
                System.out.println("Não foi possível carregar suas configuraçóes.");
            } else {
                configCognito.load(input);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static final String ACCESS_KEY = configCognito.getProperty("aws.accessKey");
    public static final String SECRET_KEY = configCognito.getProperty("aws.secretKey");
    public static final String USER_POOL_ID = configCognito.getProperty("aws.userPoolId");
    public static final String CLIENT_ID = configCognito.getProperty("aws.clientId");

    public static AWSCognitoIdentityProvider getCognitoClient() {
        BasicAWSCredentials credenciais = new BasicAWSCredentials(ACCESS_KEY, SECRET_KEY);
        return AWSCognitoIdentityProviderClientBuilder.standard()
                .withCredentials(new AWSStaticCredentialsProvider(credenciais))
                .withRegion(Regions.US_EAST_2)
                .build();
    }
}
