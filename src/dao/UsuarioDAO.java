package dao;

import com.amazonaws.services.cognitoidp.AWSCognitoIdentityProvider;
import com.amazonaws.services.cognitoidp.model.*;
import model.Usuario;

import java.util.HashMap;
import java.util.Map;

public class UsuarioDAO {

    public void cadastrarUsuarioCognito(Usuario usuario) {
        try {
            AWSCognitoIdentityProvider conexao = ConexaoCognito.getCognitoClient();

            AdminCreateUserRequest createUserRequest = new AdminCreateUserRequest()
                    .withUserPoolId(ConexaoCognito.USER_POOL_ID)
                    .withUsername(usuario.getEmail())
                    .withUserAttributes(new AttributeType().withName("email").withValue(usuario.getEmail()))
                    .withTemporaryPassword(usuario.getSenha());


            AdminCreateUserResult createUserResult = conexao.adminCreateUser(createUserRequest);

            AdminSetUserPasswordRequest setUserPasswordRequest = new AdminSetUserPasswordRequest()
                    .withUserPoolId(ConexaoCognito.USER_POOL_ID)
                    .withUsername(usuario.getEmail())
                    .withPassword(usuario.getSenha())
                    .withPermanent(true);

            AdminSetUserPasswordResult setUserPasswordResult = conexao.adminSetUserPassword(setUserPasswordRequest);

        } catch (Exception e) {
            e.getMessage();
        }

    }


    public AuthenticationResultType autenticarCognito(String email, String password) {
        try {
            AWSCognitoIdentityProvider conexao = ConexaoCognito.getCognitoClient();

            Map<String, String> authParams = new HashMap<>();
            authParams.put("USERNAME", email);
            authParams.put("PASSWORD", password);

            System.out.println("Tentando autenticar usuário: " + email);

            InitiateAuthRequest authRequest = new InitiateAuthRequest()
                    .withAuthFlow(AuthFlowType.USER_PASSWORD_AUTH)
                    .withClientId(ConexaoCognito.CLIENT_ID)
                    .withAuthParameters(authParams);

            InitiateAuthResult result = conexao.initiateAuth(authRequest);

            if (result == null) {
                System.out.println("Resultado de autenticação é nulo.");
            } else {
                System.out.println("Autenticação bem-sucedida para usuário: " + email);
            }

            return result.getAuthenticationResult();
        } catch (UserNotFoundException e) {
            System.out.println("Erro: Usuário não encontrado - " + e.getErrorMessage());
            return null;
        } catch (NotAuthorizedException e) {
            System.out.println("Erro: Não autorizado - " + e.getErrorMessage());
            return null;
        } catch (Exception e) {
            System.out.println("Erro geral: " + e.getMessage());
            return null;
        }
    }
    
    
    public AuthenticationResultType autenticarCognita(String email, String password) {
            AWSCognitoIdentityProvider conexao = ConexaoCognito.getCognitoClient();

            Map<String, String> authParams = new HashMap<>();
            authParams.put("USERNAME", email);
            authParams.put("PASSWORD", password);

            InitiateAuthRequest authRequest = new InitiateAuthRequest()
                    .withAuthFlow(AuthFlowType.USER_PASSWORD_AUTH)
                    .withClientId(ConexaoCognito.CLIENT_ID)
                    .withAuthParameters(authParams);
            InitiateAuthResult result = conexao.initiateAuth(authRequest);
            return result.getAuthenticationResult();



    }}
